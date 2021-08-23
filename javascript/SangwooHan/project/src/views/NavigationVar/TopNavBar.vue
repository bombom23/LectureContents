<template>
<div>
    <!--로그아웃일때-->
   
    <v-toolbar  flat  v-if="this.$store.state.isLogin == false"  >
    <v-toolbar-title>
     
    </v-toolbar-title>
    <v-spacer></v-spacer>
    <v-toolbar-items>
        <v-btn text v-for="link in LogOutlinks" :key="link.icon" :to="link.route">
            {{ link.text }}
        </v-btn>
    </v-toolbar-items>
    </v-toolbar>
    <!--로그인일때-->
    <v-toolbar  flat  v-if="this.$store.state.isLogin == true" >
    <v-toolbar-title>
     
    </v-toolbar-title>
    <v-spacer></v-spacer>
    <v-toolbar-items>
        <v-btn text v-for="link in LogInlinks" :key="link.icon" :to="link.route">
            {{ link.text }}
        </v-btn>
    </v-toolbar-items>
    </v-toolbar>
  
        </div>
</template>

<script>
export default {
    data () {
        return {
            nav_drawer: false,
            group: false,

            LogOutlinks: [
                {
                    text: 'ㅣ로그인ㅣ',
                    name: '로그인',
                    route: '/loginpage',
                },
                {
                    text: 'ㅣ회원가입ㅣ',
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