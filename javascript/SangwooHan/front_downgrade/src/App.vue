<template>
<v-app>
  <v-main>
    <nav-bar-component/>
    <v-btn @click="check">세션확인</v-btn>
<router-view/>
  </v-main>
</v-app>
</template>


<script>
import NavBarComponent from './views/NavBarComponent.vue'

export default {
    name: 'App',
    components: {
        NavBarComponent
     
    },
    methods: {
      check(){
        console.log(this.$store.state.session)
      }
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
*/
</style>