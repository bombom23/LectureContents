
<template>
<div>
    <v-toolbar dense dark>
             <v-app-bar-nav-icon @click="nav_drawer = !nav_drawer">
             </v-app-bar-nav-icon>
             <v-toolbar-title>
                 <span class="font-weight-light">쵝오의여행</span>
                 <span>최고의꿀팁</span>
             </v-toolbar-title>
             <v-toolbar-items>
                 <v-btn text v-for="link in links" :key="link.icon" :to="link.route">
                     {{ link.text }}
                 </v-btn>
             </v-toolbar-items>
         </v-toolbar>
         <v-navigation-drawer app v-model="nav_drawer" temporary >
             <v-list nav dense>
                 <v-list-item-group v-model="group" active-class="deep-purple--text text--accent-4">
                     <v-list-item v-for="link in links" :key="link.name" router :to="link.route">
                     <v-list-item-action>
                         <v-icon left>{{ link.icon }}</v-icon>
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
    methods: {

        btn_click ($event){
                if($event.target.innerHTML == " 결제승인 ") {
                    alert('결제가 완료되었습니다')
                    this.dialog = false;
                }else{
                    alert('그럼 꺼져 ㅋ')
                    this.dialog = false;
                }
        },
        roundBtnClick(){
            alert('데헷?')
        },
        operation(){
            alert('데헷데헷~~')
        },
        orangeBluetooth(){
            alert('오렌지 파란이빨 작동..')
        },

        btnLoginClick ($event) {
            if($event.target.innerHTML == " 확인 " ) {
                alert('로그인이 완료되었습니다.')
                console.log('입력된 정보 - 이메일:' + this.userInfo.email + // 여기에 console.log 가 아닌 axios를 붙여 Spring과 연동하여 db처리를 하도록 할수있다
                '비밀번호:' + this.userInfo.password)
                this.loging = false;
            }
            else{
                alert('취소를 하겠습니다람쥐')
                this.loging = false ;
            }
            this.userInfo.email = '',
            this.userInfo.password = ''
        }
    },
    data(){
        return{
            nav_drawer: false,
            group: false,
            message: '환장',
            dialog: false,
            loging: false,
            service: {
                name: '7박8일 여행코스~'
            },
            userInfo: {
                email: '',
                password: '',

            },
            links: [
                {
                    icon: 'home',
                    text: 'Home',
                    name: 'Home',
                    route: '/'
                },
                {
                    icon: 'credit_card',
                    text: '법인카드',
                    name: '법인카드로 다긁어주쇼',
                    route: '/product'
                },
                {
                    icon: 'ev_station',
                    text: '충전소',
                    name: '충전소',
                    route: '/materialize'
                }
            ]
        }
    },
    watch: {
        group () {
            this.nav_drawer = false
        }
    }
}
</script>

<style scoped>
h1 {
    margin: 10px;
}
p {
    padding: 10px;
    margin: 5px 10px;
}
</style>