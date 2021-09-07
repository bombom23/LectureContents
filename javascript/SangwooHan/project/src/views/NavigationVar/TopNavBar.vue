<template>
<div>
    <!--로그아웃일때-->
   
    <v-toolbar  flat  v-if="this.$store.state.session == null">
    <v-toolbar-title>
     
    </v-toolbar-title>
    <v-spacer></v-spacer>
    <v-toolbar-items>
        <v-btn depressed route :to="{name: 'SignupPage'}">
            
            <v-icon>
                mdi-human-greeting
            </v-icon>
            회원가입
        </v-btn>
    </v-toolbar-items>
    </v-toolbar>
    <!--로그인일때-->
    <v-toolbar  flat  v-if="this.$store.state.session != null" >
    <v-toolbar-title>
     
    </v-toolbar-title>
    <v-spacer></v-spacer>
    <v-toolbar-items>
        <!--
        <v-btn depressed route :to="{name: 'BasketReadPage', params:{memberNo: this.$store.state.loginMemberNo}}" >
            장바구니
        </v-btn>
        -->
        <v-btn depressed @click="handleClick">
            <v-icon>mdi-logout</v-icon>
            로그아웃
        </v-btn>
        <v-btn depressed route :to="{name: 'MyPage'}">
            {{this.User}}님
        </v-btn>
        <v-btn depressed route :to="{name: 'NoticeListPage'}" >
            공지판
        </v-btn>
       
    </v-toolbar-items>
    </v-toolbar>
  
        </div>
</template>

<script>
import cookies from 'vue-cookies'
import Vue from 'vue'

Vue.use(cookies)
import { mapState } from 'vuex'

export default {
    computed: {
        ...mapState(['loginMemberNo','User'])
    },
    methods:{
            handleClick(value){
  this.$cookies.remove('user')
  this.$cookies.remove('memberNo')
  this.$cookies.remove('setter')
  this.$cookies.remove('coin')
            this.$store.state.isLogin = false
            this.$store.state.session =null
            this.$store.state.loginMemberNo =null
            console.log(value.srcElement.baseURI)
      if(value.srcElement.baseURI == 'http://localhost:8080/'){
        this.$router.go()
      }else{
        this.$router.push({name: 'Home'})
      }
                                }
    },
    data () {
        return {
            nav_drawer: false,
            group: false,

            LogOutlinks: [
                {  
                    text: '회원가입',
                    name: '회원가입',
                    route: '/signuppage',
                },
                {
                    text: 'ㅣ공지판ㅣ',
                    name: '공지판',
                    route: '/noticeListPage',
                },
            ],
             LogInlinks: [
               {
                    text: 'ㅣ장바구니ㅣ',
                    name: '장바구니',
                    
                },
                  {
                    text: 'ㅣ공지판ㅣ',
                    name: '공지판',
                    route: '/noticeListPage',
                },
               
            ],
            LogInlinks2: [
                {
                    icon: 'home',
                    text: 'Home',
                    name: 'Home',
                    route: '/',
                },
                {
                     icon: 'mdi-login',
                    text: '로그인',
                    name: '로그인',
                    route: '/loginpage',
                },
                {
                     icon: 'mdi-account-child',
                    text: '회원가입',
                    name: '회원가입',
                    route: '/signuppage',
                },
                {
                     icon: 'mdi-newspaper',
                    text: '다음뉴스',
                    name: '다음뉴스',
                    route: '/daumNewsCrawler',
                }
            ],
            LogOutlinks2: [
                {
                    icon: 'home',
                    text: 'Home',
                    name: 'Home',
                    route: '/',
                },
                 
                {
                     icon: 'mdi-newspaper',
                    text: '다음뉴스',
                    name: '다음뉴스',
                    route: '/daumNewsCrawler',
                }
            ],
            ManageLinks: [
                {
                    icon: 'home',
                    text: 'Home',
                    name: 'Home',
                    route: '/',
                },
                   {
                     
                    text: '곤충갤러리',  
                    name: '곤충갤러리(수정예정)',
                    route: '/Test/:Id',
                },
                {
                     
                    text: '곤충박물관',  
                    name: '곤충박물관(수정예정)',
                    route: '/insectmuseumpage',
                },
                 {
                     
                    text: '커뮤니티게시판',  
                    name: '커뮤니티글올리기(수정예정)',
                    route: '/communityListpage',
                },
                {
                     icon: 'mdi-format-list-bulleted-type',
                    text: '회원리스트',
                    name: '회원리스트',
                    route: '/memberlist',
                },
            ]
            

        }
    },
   watch: {
       group () {
           this.nav_drawer =false
       }
   }
}
</script>

<style scoped>
#toolbar{
    border-style: none;
}
</style>