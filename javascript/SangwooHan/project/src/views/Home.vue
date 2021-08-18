<template>

  <div id="main">

    

   <v-container>
     
<section align="left" >
  <div>
  <article >
    
    
   <coverflow :coverList="coverList" :coverWidth="260" :index="2" id="coverflow" @click="handleClick"></coverflow>
   
  </article>
  </div>
</section>
   </v-container>

  


   
  </div>
     
</template>

<script>
import coverflow from 'vue-coverflow'
import axios from 'axios'
import { mapState } from 'vuex'


  export default {
    name: 'Home',

    components: {
     coverflow
   
    },
    data(){
        return{
          bgImage: require('@/assets/상우/꿀벌.jpg'),
          coverList: [
                {
                   cover: require('@/assets/상우/나비.jpg'),
                    title: '나비',
                    route: '/SignupPage',
                    onclick
                },

                 {
                    cover: require('@/assets/상우/매미.jpg'),
                    title: '매미'
                },

                {
                    cover: require('@/assets/상우/사슴벌레.jpg'),
                    title: '사슴벌레'
                },

                 {
                    cover: require('@/assets/상우/장수풍뎅이.jpg'),
                    title: '장수풍뎅이'
                },

                 {
                   cover: require('@/assets/상우/잠자리.jpg'),
                    title: '잠자리'
                },
                {
                    cover: require('@/assets/상우/하늘소.jpg'),
                    title: '하늘소',
                    
                },
            ]
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
        handleClick(value) {
            console.log(value)
        }
      
    },
    onclick(){
      alert('ㅎㅇㅎㅇ')
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
#coverflow{
  margin-left: 100px;
}


</style>
