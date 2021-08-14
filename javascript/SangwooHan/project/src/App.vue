  
<template>
<v-app>
  <div id="main">
    <header align="center" >
    <img id="homebtn"  @click="Redirect" src="@/assets/상우/홈버튼.png"/>

        <p v-if="this.$store.state.isLogin == true"> {{ this.$store.state.loginUser }}님 안녕하세요</p>
       
    </header>
  </div>
  <div id="nav">
    <nav-bar/>
  </div>
 <router-view/>
    
   
 <div>

 </div>
</v-app>
</template>


<script>
import NavBar from './views/NavigationVar/NavBar.vue'

export default {
  name: 'App',
      components: {
       NavBar
    },
    methods: {
      Redirect(){
        
        this.$router.push({name: 'Home'}).catch( alert('홈페이지입니다.'))
      }
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
*/
header {
 
  background-image: url('./assets/상우/타이틀수정.png');
}
#homebtn{
  margin-right: 50%
}
#nav{
  background-color: rgb(32, 32, 32);
}
</style>
