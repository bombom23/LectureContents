  
<template>
<v-app>
    <top-nav-bar/>
    <header align="center" id="header"><img id="homebtn" @click="handleClick" src="@/assets/상우/홈로고.png"/></header>
    <div id="main">
    <nav-bar/>
<div>
<section>
 <router-view/>
</section>
<aside>
  
</aside>
</div>
 <div class="footer" >
   <v-btn v-if="this.$store.state.isLogin == true " @click="removeSession" width="20" align="left" >logout</v-btn>
  <p>&copy; 곤충박사위원회</p>

   </div>
  
    </div>

</v-app>
</template>

<script>
import axios from 'axios'
import NavBar from './views/NavigationVar/NavBar.vue'
import TopNavBar from './views/NavigationVar/TopNavBar.vue'

export default {
  name: 'App',
      components: {
       NavBar,
    TopNavBar  
    },
   
                
    methods: {
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
removeSession () {
            axios.post('http://localhost:9999/jpamemberManage/removeSession')
                    .then(res => {
                        this.$store.state.isLogin = res.data

                        alert('로그아웃되셧습니다.')
                    })
        },
    }
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
section{
    width: 2200px;
    height: 2000px;
   
    
    
}
.footer {
    border: 1px;

    position: absolute;

    left: 0%;

    bottom: 0%;

    width: 100%;

	padding: 15px 0;

	text-align: center;



	

}



</style>
