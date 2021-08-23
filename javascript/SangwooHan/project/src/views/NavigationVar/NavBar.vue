<template>
<div>
    <!--로그아웃일때-->
 
    <v-toolbar  dark  flat  v-if="this.$store.state.isLogin == false" >
    <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer">
    </v-app-bar-nav-icon>
    <v-toolbar-title>
    
    </v-toolbar-title>
    <v-spacer></v-spacer>
    <v-toolbar-items >
        <v-btn text v-for="link in LogOutlinks" :key="link.icon" :to="link.route">
            {{ link.text }}
        </v-btn>
      
    </v-toolbar-items>
    <v-spacer></v-spacer>
    </v-toolbar>
    <!--로그인일때-->
    <v-toolbar  flat  v-if="this.$store.state.isLogin == true" >
    <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer">
    </v-app-bar-nav-icon>
    <v-toolbar-title>
        <span class="font-weight-light"></span>
    </v-toolbar-title>
     <v-spacer></v-spacer>
    <v-toolbar-items>
        <v-btn text v-for="link in LogInlinks" :key="link.icon" :to="link.route">
            {{ link.text }}
        </v-btn>
    </v-toolbar-items>
      <v-spacer></v-spacer>
    </v-toolbar>
   
   
    
<!--로그인일때-->
    <v-navigation-drawer v-if="this.$store.state.isLogin == false" app v-model="nav_drawer" temporary >
        <v-list nav dense>
            <v-list-item-group v-model="group" active-class="deep-purple--text text--accent-4">
            <v-list-item v-for="link  in LogInlinks2" :key="link.name" router :to="link.route">
            <v-list-item-action>
                <v-icon left>{{ link.icon}}</v-icon>
            </v-list-item-action>
            <v-list-item-content>
                <v-list-item-title>{{ link.text }}</v-list-item-title>
            </v-list-item-content>
            </v-list-item>
            </v-list-item-group>
        </v-list>
    </v-navigation-drawer>
<!--로그아웃일때-->
     <v-navigation-drawer v-if="this.$store.state.isLogin == true" app v-model="nav_drawer" temporary >
        <v-list nav dense>
            <v-list-item-group v-model="group" active-class="deep-purple--text text--accent-4">
            <v-list-item v-for="link  in LogOutlinks2" :key="link.name" router :to="link.route">
            <v-list-item-action>
                <v-icon left>{{ link.icon}}</v-icon>
            </v-list-item-action>
            <v-list-item-content>
                <v-list-item-title>{{ link.text }}</v-list-item-title>
            </v-list-item-content>
            </v-list-item>
            </v-list-item-group>
        </v-list>
    </v-navigation-drawer>
    <!--관리자일때-->
    <v-navigation-drawer v-if="this.$store.state.isLogin == true && this.$store.state.loginUser == '관리자'" app v-model="nav_drawer" temporary >
        <v-list nav dense>
            <v-list-item-group v-model="group" active-class="deep-purple--text text--accent-4">
            <v-list-item v-for="link  in ManageLinks" :key="link.name" router :to="link.route">
            <v-list-item-action>
                <v-icon left>{{ link.icon}}</v-icon>
            </v-list-item-action>
            <v-list-item-content>
                <v-list-item-title>{{ link.text }}</v-list-item-title>
            </v-list-item-content>
            </v-list-item>
            </v-list-item-group>
        </v-list>
    </v-navigation-drawer>
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
                     
                    text: 'ㅣ커뮤니티ㅣ',  
                    name: '커뮤니티글올리기(수정예정)',
                    route: '/communityListpage',
                },
                   {
                     
                    text: 'ㅣ곤충갤러리ㅣ',  
                    name: '커뮤니티글올리기(수정예정)',
                    route: '/Test/:Id',
                },
                {
                     
                    text: 'ㅣ곤충박물관ㅣ',  
                    name: '커뮤니티글올리기(수정예정)',
                    route: '/insectmuseumpage',
                }
            ],
             LogInlinks: [
               
                   {
                     
                    text: 'ㅣ곤충갤러리ㅣ',  
                    name: 'ㅣ곤충갤러리ㅣ',
                    route: '/Test/:Id',
                },
                {
                     
                    text: 'ㅣ곤충박물관ㅣ',  
                    name: '곤충박물관',
                    route: '/insectmuseumpage',
                },
                 {
                     
                    text: 'ㅣ커뮤니티게시판ㅣ',  
                    name: '커뮤니티글올리기(수정예정)',
                    route: '/communityListpage',
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
                     
                    text: '박물관게시물작성',
                    name: '박물관게시물작성',
                    route: '/stagbeetleRegister',
                },
                {
                     icon: 'mdi-format-list-bulleted-type',
                    text: '회원리스트',
                    name: '회원리스트',
                    route: '/memberlist',
                },
                {
                     
                    text: '공지게시',
                    name: '공지게시',
                    route: '/noticeRegisterPage',
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