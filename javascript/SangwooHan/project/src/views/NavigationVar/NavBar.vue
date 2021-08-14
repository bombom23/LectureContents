<template>
<div>
    <!--로그아웃일때-->
    <v-container>
    <v-toolbar dense dark v-if="this.$store.state.isLogin == false" >
    <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer">
    </v-app-bar-nav-icon>
    <v-toolbar-title>
        <span class="font-weight-light"></span>
    </v-toolbar-title>
    <v-toolbar-items>
        <v-btn text v-for="link in LogOutlinks" :key="link.icon" :to="link.route">
            {{ link.text }}
        </v-btn>
    </v-toolbar-items>
    </v-toolbar>
    <!--로그인일때-->
    <v-toolbar dense dark v-if="this.$store.state.isLogin == true" >
    <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer">
    </v-app-bar-nav-icon>
    <v-toolbar-title>
        <span class="font-weight-light"></span>
    </v-toolbar-title>
    <v-toolbar-items>
        <v-btn text v-for="link in LogInlinks" :key="link.icon" :to="link.route">
            {{ link.text }}
        </v-btn>
    </v-toolbar-items>
    </v-toolbar>
    </v-container>
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
                    icon: 'home',
                    text: 'Home',
                    name: 'Home',
                    route: '/',
                },
                 {
                     icon: 'mdi-check',
                    text: '커뮤글쓰기',  
                    name: '커뮤니티글올리기(수정예정)',
                    route: '/communityregisterpage',
                },
                 {
                     
                    text: '커뮤니티게시판',  
                    name: '커뮤니티글올리기(수정예정)',
                    route: '/communityListpage',
                },
                   {
                     
                    text: '곤충갤러리',  
                    name: '커뮤니티글올리기(수정예정)',
                    route: '/Test/:Id',
                },
                {
                     
                    text: '곤충박물관',  
                    name: '커뮤니티글올리기(수정예정)',
                    route: '/insectmuseumpage',
                }
            ],
             LogInlinks: [
                {
                    icon: 'home',
                    text: 'Home',
                    name: 'Home',
                    route: '/',
                },
                 {
                     icon: 'mdi-check',
                    text: '커뮤니티',  
                    name: '커뮤니티글올리기(수정예정)',
                    route: '/communityregisterpage',
                },
                   {
                     
                    text: '곤충갤러리',  
                    name: '커뮤니티글올리기(수정예정)',
                    route: '/Test/:Id',
                },
                {
                     
                    text: '곤충박물관',  
                    name: '커뮤니티글올리기(수정예정)',
                    route: '/insectmuseumpage',
                }
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
                     icon: 'mdi-format-list-bulleted-type',
                    text: '회원리스트',
                    name: '회원리스트',
                    route: '/memberlist',
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
                     icon: 'mdi-format-list-bulleted-type',
                    text: '회원리스트',
                    name: '회원리스트',
                    route: '/memberlist',
                },
                {
                     icon: 'mdi-newspaper',
                    text: '다음뉴스',
                    name: '다음뉴스',
                    route: '/daumNewsCrawler',
                }
            ],

        }
    },
   watch: {
       group () {
           this.nav_drawer =false
       }
   }
}
</script>