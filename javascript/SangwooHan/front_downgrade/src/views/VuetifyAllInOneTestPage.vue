<template>
    <div>
        <p class="blue lighten-5 red--text">Test</p>
        <p class="blue white--text">Test</p>
        <p class="blue darken-3">Test</p>
    <v-btn class="teal" rounded @click="roundBtnClick">Round 버튼</v-btn>
    <v-btn class="indigo" white--text @click="roundBtnClick">Round 버튼</v-btn>
     <v-btn class="indigo" dark @click="roundBtnClick">
         <v-icon>bluetooth</v-icon>
         <span>bluetooth</span>
     </v-btn>
     <v-btn fab color="orange" dark @click="orangeBluetooth">
         <v-icon>bluetooth</v-icon>
     </v-btn>
     <v-btn color="blue" class="hidden-xs-only" @click="operation">Visibliliy -xs -only</v-btn>
      <v-btn color="red" class="hidden-sm-only" @click="operation">Visibliliy -sm -only</v-btn>
       <v-btn color="green" class="hidden-md-only" @click="operation">Visibliliy -md -only</v-btn>
       <v-btn color="green" class="hidden-lg-only" @click="operation">Visibliliy -l -only</v-btn>


       <!--
           앞서서 살펴봤던 conatainer의 역할을 수행하며

       -->
       <v-container fluid>
           <!-- Grid 시스템의 한행을 정의함-->
           <v-layout row wrap>
               <!-- 12개의 컬럼으로 이뤄져 한행에서 제일작은것을이 12개가 만들어지면 다음으로 자동넘김 처리-->
               <v-flex xs12 md6 class="primary white--text">
                   <div>{{ message}}</div>
               </v-flex>
                <v-flex xs4 md2 class="green white--text">
                   <div>{{ message}}</div>
               </v-flex>
                <v-flex xs4 md2 class="green white--text">
                   <div>{{ message}}</div>
               </v-flex>
                <v-flex xs4 md2 class="green white--text">
                   <div>{{ message}}</div>
               </v-flex>
           </v-layout>
            <v-layout row wrap>
               <!-- 12개의 컬럼으로 이뤄져 한행에서 제일작은것을이 12개가 만들어지면 다음으로 자동넘김 처리-->
               <v-flex xs6 md6 class="primary white--text">
                   <div>{{ message}}</div>
               </v-flex>
                <v-flex xs6 md6 class="green white--text">
                   <div>{{ message}}</div>
               </v-flex>
              
           </v-layout>
       </v-container>

       <v-layout row justify-center>
           <!--사용자에게 알림을 제공하거나 중요 정보를 포함해 의사 결정을 하도록 유도하는데 활용
           대화상자가 뜨면서 결제할것인지 아닌지 등등 활용하기가 좋음
           v-dialog에 template를 넣고 v-btn으로 아래와 같은 형식을 만들면
           무조건 버튼 클릭시 v-card가 동작하게 된다.
           단 주의할점이라면 v-model에 dialgo를 겹치게 만들면 안된다.
           여러 대화상자(Dialog)를 사용한다면, 이부분을 여러개로 분리하거나 배열로 관리해야한다.-->
           <v-dialog v-model="dialog" persistent max-width="400">
               <template v-slot:activator="{ on }">
               <v-btn color="primary" dark v-on="on">결제</v-btn>
               </template>
               <v-card>
               <v-card-title class="headline">
                   {{ service.name }}
               </v-card-title>
               <v-card-text>
                   5성급 호텔이 30% 할인! {{service.name}} 결제 하시겠습니까?
               </v-card-text>
               <v-card-actions>
                   <v-spacer></v-spacer>
                   <v-btn color="teal darken-1" text @click.native="btn_click($event)">
                       취소
                   </v-btn>
                    <v-btn color="teal darken-1" text @click.native="btn_click($event)">
                     결제승인
                   </v-btn>
               </v-card-actions>
               </v-card>
           </v-dialog>
       </v-layout>
        <v-dialog v-model="loging" persistent max-width="500">
              <template v-slot:activator="{ on }">
               <v-btn color="primary" dark v-on="on">로그인</v-btn>
               </template>
               <v-card>
               <v-card-title>
                  <span class="headline">
                      Log ing
                  </span>
               </v-card-title>
               <v-card-text>
               <v-container grid-list-md>
                   <v-layout wrap>
                       <v-flex xs12>
                           <v-text-field label="Email" v-model="userInfo.email" required>
                           </v-text-field>
                       </v-flex>
                       <v-flex xs12>
                           <v-text-field label="Password" v-model="userInfo.password"
                                                            type="password" required>
                           </v-text-field>
                       </v-flex>
                   </v-layout>
               </v-container>
               </v-card-text>
               <v-card-actions>
                   <v-spacer></v-spacer>
                   <v-btn color="teal darken-1" text @click.native="btnLoginClick($event)">
                       취소
                   </v-btn>
                    <v-btn color="teal darken-1" text @click.native="btnLoginClick($event)">
                     확인
                   </v-btn>
               </v-card-actions>
               </v-card>
        </v-dialog>

         <v-toolbar>
             <v-toolbar-items v-if="$vuetify.breakpoint.smAndUp">
                <v-btn text>First Test</v-btn>
                <v-btn text>Second Test</v-btn>
                <v-btn text>Third Test</v-btn>
             </v-toolbar-items>
         </v-toolbar>
         <v-toolbar>
             <v-toolbar-items class="hidden-sm-and-down">
                <v-btn text>Home</v-btn>
                <v-btn text>집에 갈래요</v-btn>
                <v-btn text>드루와</v-btn>
             </v-toolbar-items>
         </v-toolbar>
         <!--
         <v-navigation-drawer app permanent>
             <v-list nav dense>
                 <v-list-item-group v-model="group" active-class="deep-purple--text text--accent-4">
                     <v-list-item v-for="link in links" :key="link.name" router :to="link.route">
                     <v-list-item-action>
                         <v-icon left @click="addNum">{{ link.icon }}</v-icon>
                     </v-list-item-action>
                     <v-list-item-content>
                         <v-list-item-title>{{ link.text }}</v-list-item-title>
                     </v-list-item-content>
                     </v-list-item>
                 </v-list-item-group>
             </v-list>
         </v-navigation-drawer>
         -->
     
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
         <div>
             <v-menu offset-y>
                <template v-slot:activator="{ on }">
                <v-btn color="teal darken-1"
                        class="white--text ma-5"
                            v-on="on">
                            Drop Down Test Button
                </v-btn>
                    </template>
                <v-list>
                    <v-list-item v-for="(dropItem, index) in dropItems"
                                    :key="index"
                                    link>
                                    <v-list-item-title>{{ dropItem.title}}</v-list-item-title>
                    </v-list-item>
                </v-list>
             </v-menu>
            
         </div>
        <v-container>
         <v-data-table :headers="headerTitle"
                    :items="contents" 
                    :items-per-page="10"
                    class="elevation-1">
         </v-data-table>
        </v-container>
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
                headerTitle: [
                    {text: '게시물번호' , value: 'boardNo' , width: '25px'}, 
                    {text: '제목', value: 'title', width: '180px'},
                    {text: '작성자', value: 'writer' , width: '100px'},
                    {text: '내용' , value: 'content', width: '200px'}
                ],
                contents: [
                        {boardNo: 1, title: '김치' , writer: '김치워리어', content: '김치는 맛나다'},
                        {boardNo: 2, title: '클릭하지마시오' , writer: '클릭맨', content: '클릭 ㄴㄴ'},
                        {boardNo: 3, title: 'ㅋㅋ' , writer: '매맨', content: '???? '},
                        {boardNo: 4, title: '김치' , writer: '김치워리어', content: '김치는 맛나다'},
                        {boardNo: 5, title: '김치' , writer: '김치워리어', content: '김치는 맛나다'},
                        {boardNo: 6, title: '김치' , writer: '김치워리어', content: '김치는 맛나다'},
                        {boardNo: 7, title: '클릭하지마시오' , writer: '클릭맨', content: '클릭 ㄴㄴ'},
                        {boardNo: 8, title: 'ㅋㅋ' , writer: '매맨', content: '???? '},
                        {boardNo: 9, title: '김치' , writer: '김치워리어', content: '김치는 맛나다'},
                        {boardNo: 10, title: '김치' , writer: '김치워리어', content: '김치는 맛나다'},
                        {boardNo: 11, title: '김치' , writer: '김치워리어', content: '김치는 맛나다'},
                        {boardNo: 12, title: '클릭하지마시오' , writer: '클릭맨', content: '클릭 ㄴㄴ'},
                        {boardNo: 13, title: 'ㅋㅋ' , writer: '매맨', content: '???? '},
                        {boardNo: 14, title: '김치' , writer: '김치워리어', content: '김치는 맛나다'},
                        {boardNo: 15, title: '김치' , writer: '김치워리어', content: '김치는 맛나다'},
                        {boardNo: 16, title: '김치' , writer: '김치워리어', content: '김치는 맛나다'},
                        {boardNo: 17, title: '클릭하지마시오' , writer: '클릭맨', content: '클릭 ㄴㄴ'},
                        {boardNo: 18, title: 'ㅋㅋ' , writer: '매맨', content: '???? '},
                        {boardNo: 19, title: '김치' , writer: '김치워리어', content: '김치는 맛나다'},
                        {boardNo: 20, title: '김치' , writer: '김치워리어', content: '김치는 맛나다'},
                ],
                

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
            ],
            dropItems: [
                {title: 'ㅎㅇ',},
                {title: 'ㅂㅇ',},
                {title: 'ㅇㅇ',}
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