  
<template>
<v-app>
    
    <div class="header">
    <top-nav-bar/>
-  <header align="center" id="header"><img id="homebtn" @click="handleClick" src="@/assets/상우/홈로고.png"/></header> 
    </div>
    <nav-bar/>
    <v-btn width="80px" @click="check">로그인한사람</v-btn>
    
    <new-login-page-form v-if="this.$store.state.session ==null" @submit="onSubmit" :members="members"/>
    <v-btn v-else @click="logout" width="80px">로그아웃</v-btn>
    
    
<div class="section">
 <router-view/>
</div>

  <div class="footer" >
 <!-- <v-btn @click="logout" v-if="this.$store.state.session != null">로그아웃</v-btn> -->
                                              <p>&copy; 곤충박사위원회</p>
   </div>
  
    

</v-app>
</template>

<script>

import cookies from 'vue-cookies'
import Vue from 'vue'
import NavBar from './views/NavigationVar/NavBar.vue'
import TopNavBar from './views/NavigationVar/TopNavBar.vue'
import { mapActions, mapState } from 'vuex'
import axios from 'axios'
import NewLoginPageForm from '../src/components/Login/NewLoginPageForm.vue'
Vue.use(cookies)

export default {
  name: 'App',
      components: {
       NavBar,
    TopNavBar ,
    NewLoginPageForm
    },
    computed: {
      ...mapState(['members'])
    },
   
                
    methods: {
      ...mapActions(['fetchMemberList']),
     // 홈로고 동작 로직 .. value값을 받아내어 직접 console.log로 baseURI를 받아내어  
     // if문을통해 홈페이지가 아니면 동작하게끔 하는로직.
      handleClick(value){
        console.log(value.srcElement.baseURI)
      if(value.srcElement.baseURI == 'http://localhost:8080/'){
        alert('홈페이지입니다.')
      }else{
        this.$router.push({name: 'Home'})
      }
},
check(){
  console.log(this.$store.state.session)
   console.log('로그인유무정보'+this.$store.state.isLogin)
   console.log(this.$store.state.User)
},
onSubmit (payload) {
           if(this.$store.state.session ==null){
            const { id, pw } = payload
            axios.post('http://localhost:9999/jpamemberManage/login', { userid: id, password: pw, auth: null })
                    .then(res => {
                        if (res.data != "") {
                            
                            alert('로그인 성공! - ' + res.data)
                            
                            this.$store.state.isLogin = true;
                            this.$store.state.session = res.data;
                            this.$store.state.User = res.data.userid;
                            this.$cookies.set("user", res.data, '1h')
                            this.$router.go()
                     
                            
                        } else {
                            alert('비밀번호가 틀렸습니다. - ' + res.data)
                        }
                        /*
                        this.$router.push({
                            name: 'BoardReadPage',
                            params: { boardNo: res.data.boardNo.toString() }
                        })
                        */
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
           } else{
                alert('이미로그인이 되어있습니다.' +this.$store.state.session.userid)
           }
},
logout() {
  this.$cookies.remove('user')
            this.$store.state.isLogin = false
            this.$store.state.session =null
            this.$router.go()
}

    },
    mounted () {
          this.$store.state.session = this.$cookies.get('user')
          this.$store.state.loginUser = this.$cookies.get('user')
          if( this.$store.state.session != null) {
              this.$store.state.isLogin =true
          }
          if(this.$store.state.loginUser != null){
            this.$store.state.User = this.$store.state.loginUser.userid
          }
          this.fetchMemberList()
      },
}
</script>

<style>
/*
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
#nav {
  padding: 30px;
}
#nav a {
  font-weight: bold;
  color: #2c3e50;
}
#nav a.router-link-exact-active {
  color: #42b983;
}

#header {
 
  background-image: url('./assets/상우/타이틀수정.png');
}
#homebtn{
  margin-right: 50%
}
#nav{
  background-color: rgb(32, 32, 32);
}
footer{
  width: 1700px;
  height: 50px;
  position: bottom;
  background-color: rgb(170, 9, 9);
  text-align: center;
  
}
#HomeP{
   background-color: rgb(32, 32, 32);
   
}
*/
.section{
    margin-left:300px;
    margin-top: 300px;
    position:absolute;
    width: 1500px;
    height: 2000px;
   
    
    
}
.footer {
    border: 1px;


    margin-top: 2000px;

    left: 0%;

    bottom: 0%;

    width: 100%;

	padding: 15px 0;

	text-align: center;



	

}



</style>
