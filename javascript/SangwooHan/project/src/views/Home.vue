<template>

  <div id="main">
     
    

   <v-container>
     
<section align="left" >
  <div>
  <article >
    
    
    <ul>
     <li><img src="@/assets/충우/앱광고.jpg" width="600"/> <img src="@/assets/충우/앱광고.jpg" width="500"/></li> 
       <li></li>
       
    </ul>
   
  </article>
  </div>
</section>
   </v-container>
<footer align="center">
   <v-btn v-if="this.$store.state.isLogin == true " @click="removeSession" width="20" align="left" >logout</v-btn>
  <p>&copy; 곤충박사위원회</p>
</footer>
  


   
  </div>
     
</template>

<script>

import axios from 'axios'
import { mapState } from 'vuex'


  export default {
    name: 'Home',

    components: {
     
   
    },
    data(){
        return{
          bgImage: require('@/assets/상우/타이틀.jpg')
        }
    },
    methods: {
      removeSession () {
            axios.post('http://localhost:9999/jpamemberManage/removeSession')
                    .then(res => {
                        this.$store.state.isLogin = res.data

                        alert('로그아웃되셧습니다.')
                    })
        },
        ...mapState(['isLogin','loginUser']),
        Redirect() {
      this.$router.push({name: 'Home'})
   .catch(err =>{console.log('홈페이지입니다.'+err.response.data.message)})
    },
    
    }
    

  }
</script>

<style scoped>
#main{
  background-color: rgb(32, 32, 32);
}
section{
  background-color: rgb(32, 32, 32);
}
footer{
  background-color: rgb(32, 32, 32);
}
p{
  color: chartreuse;
}


</style>
