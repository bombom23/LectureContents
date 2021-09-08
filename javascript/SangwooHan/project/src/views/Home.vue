<template>
<div>
   <!--<coverflow :coverList="coverList" :coverWidth="260" :index="2" id="coverflow" @click="handleClick"></coverflow> -->
   <!--
   <a @click="goMuseum"><img src="@/assets/상우/곤충박물관배너1.jpg"/></a>
   <v-container style="max-width:800px" id="vueMuseum"> 
        <v-row>
            <v-col v-for="(image,i) in images" :key="i" class="d-flex child-flex" cols="4">
                
            <a @click="InsectDetail(i)"><v-img :src="image" aspect-ratio="1" class="gery lighten-2">
              
                <template v-slot:placeholder>
                    
                <v-row class="fill-height ma-0" align="center" justify="center">
                    
                <v-progress-circular indeterminate color="grey lighten-5">
                    
                </v-progress-circular>
               
                </v-row>
                </template>
            </v-img></a>
            </v-col>
        </v-row>
    </v-container>
    <v-container style="max-width:680px" id="VueNoitice">
        <notice-list-new-form :listArray="PageArray"/>
    </v-container>
    <a @click="goShop"><img src="@/assets/상우/쇼핑몰배너다시1.png"/></a>
    <v-container style="max-width:800px" id="vueProduct">
        <v-row>
            <v-col v-for="(image,i) in products" :key="i" class="d-flex child-flex" cols="4">
                
            <a @click="ProductDetail(i)"><v-img :src="image" aspect-ratio="1" class="gery lighten-2">
              <span>추천!</span>
                <template v-slot:placeholder>
                    
                <v-row class="fill-height ma-0" align="center" justify="center">
                    
                <v-progress-circular indeterminate color="grey lighten-5">
                    
                </v-progress-circular>
               
                </v-row>665 475
                </template>
            </v-img></a>
            </v-col>        
        </v-row>
    </v-container>
  -->
<v-parallax height="700" src="@/assets/상우/똥구리.jpg"></v-parallax>
   
</div>
</template>

<script>
//import coverflow from 'vue-coverflow'

import axios from 'axios'
//import NoticeListNewForm from '../components/Notice/NoticeListNewForm.vue'




  export default {
    name: 'Home',

    components: {
     //   NoticeListNewForm
   //  coverflow
    
       
    },
    data(){
        return{
          bgImage: require('@/assets/상우/박물관/박물관[왕사슴벌레].jpg'),

          images:[
                require('@/assets/상우/박물관/박물관[왕사슴벌레].jpg'),
                require('@/assets/상우/박물관/박물관[장수풍뎅이].jpg'),
                require('@/assets/상우/박물관/박물관[나비잠자리1].jpg'),
                require('@/assets/상우/박물관/박물관[사향제비나비].jpg'),
                require('@/assets/상우/박물관/박물관[노란팔점긴하늘소1].jpg'),
                require('@/assets/상우/박물관/박물관[넓적사슴벌레].jpg'),
          ],
          products:[
              require('@/assets/상우/장수풍뎅이세트.jpg'),
              require('@/assets/상우/왕사슴벌레세트.jpg'),
              require('@/assets/상우/발효톱밥.jpg'),
              require('@/assets/상우/균사.jpg'),
              require('@/assets/상우/수액젤리.jpg'),
              require('@/assets/상우/유산균젤리.jpg')
          ],
          PageArray:[],






          /*
          coverList: [
                {
                   cover: require('@/assets/상우/나비.jpg'),
                    title: '나비',
                    route: '/SignupPage',
                    
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
                {
                    cover: require('@/assets/상우/박물관/박물관[왕사슴벌레].jpg'),
                    title: '하늘소',
                    
                },
            ],*/
        
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
        goMuseum(){
            this.$router.push({name:'InsectMuseumPage'})
        },
        goShop(){
            this.$router.replace({name: 'ShoppingMallpage'})
        },
        
        
        InsectDetail(pictureNo){
            console.log(pictureNo)
            if(pictureNo == 0){
                this.$router.push({name:"StagbeetleReadPage", params:{boardNo: 3}})
            }
            if(pictureNo == 1){
                 this.$router.push({name:"BeetleReadPage", params:{boardNo: 1}})
            }if(pictureNo == 2){
                 this.$router.push({name:"DragonflyReadPage", params:{boardNo: 5}})
            }
            if(pictureNo == 3){
                 this.$router.push({name:"ButterflyReadPage", params:{boardNo: 9}})
            }
            if(pictureNo == 4){
                 this.$router.push({name:"SkycowReadPage", params:{boardNo: 6}})
            }
             if(pictureNo == 5){
                 this.$router.push({name:"StagbeetleReadPage", params:{boardNo: 4}})
            }
        },
        ProductDetail(pictureNo){
            console.log(pictureNo)
            if(pictureNo == 0){
                this.$router.push({name:"ProductReadPage", params:{boardNo: 4}})
            }
            if(pictureNo == 1){
                 this.$router.push({name:"ProductReadPage", params:{boardNo: 5}})
            }if(pictureNo == 2){
                 this.$router.push({name:"ProductReadPage", params:{boardNo: 28}})
            }if(pictureNo ==3) {
                 this.$router.push({name:"ProductReadPage", params:{boardNo: 3}})
            }
            if(pictureNo ==4) {
                 this.$router.push({name:"ProductReadPage", params:{boardNo: 6}})
            }
            if(pictureNo ==5) {
                 this.$router.push({name:"ProductReadPage", params:{boardNo: 25}})
            }
           
        }
      
    },
    created(){
        axios.get('http://localhost:9999/jpaNotice/noticelist')
        .then( (res)=>{
            this.PageArray = res.data
        })
    }
   
    
    
    }
    

  
</script>

<style scoped>

#coverflow{
  margin-left: 100px;
}
h3{
    font-family:fantasy ;
}
span{
    background-color: red;
    font-size: 2.5em;
}
#vueMuseum{
    float: left;
}
#VueNoitice{
    float: right;
    margin-right: 20px;
}
#vueProduct{
     float: left;
}
#vueVideo{
    position: absolute;
    margin-left: 800px;
    
}


</style>
