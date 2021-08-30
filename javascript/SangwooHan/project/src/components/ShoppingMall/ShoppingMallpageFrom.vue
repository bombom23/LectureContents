<template>
<div>

   <v-container>
        <ul>
            <li  v-for="product in ProductList" :key="product.productName">
                <img width="300px" v-if="product.productName =='산란목'" src="@/assets/상우/산란목.jpg"/>
                <img width="300px" v-if="product.productName =='발효톱밥5L'" src="@/assets/상우/발효톱밥.jpg"/>
                <p>제품명:{{product.productName}}</p>
                <p>제품가격:{{product.productPrice}}원</p>
                <v-btn @click="Buy(product.boardNo)"> 구매</v-btn>
                <v-btn v-if="User !=null" @click="Basket(product)">장바구니</v-btn>
                <v-btn v-if="User ==null" @click="plzlogin">장바구니</v-btn>
            </li>
        </ul>
        
    </v-container>
        
    </div>
</template>
<script>
import cookies from 'vue-cookies'
import Vue from 'vue'
import axios from 'axios'
import { mapActions, mapState } from 'vuex'

Vue.use(cookies)
export default {
    name: 'ShoppingMallPageForm',
    props:{
        ProductList:{
            type: Array
        }
    },
    data(){
            return{
                productNum: 1
            }
    },
    methods: {
        plzlogin(){alert('로그인후에 이용해주세요!')},
        ...mapActions(['fetchBasketList','fetchMember']),
        
        Buy(boardNo){
               this.$router.push({name: 'ProductReadPage', params:{boardNo}})
        },
        Basket(product){
           
            //현재 로그인된 아이디와 포문을돌려 회원db에 같은 아이디가 나온다면, 그 회원의 memberNo를 가져온다.
            // 즉 현재 로그인된 유저의 memberNo를 가져와서 장바구니에 활용한다.
            /*
             for(var i = 0 ; i <this.members.length ; i++){
           if(this.$store.state.User == this.members[i].userid){
                 this.$store.state.loginMemberNo = this.members[i].memberNo
            }
             }*/
            const { productName, productPrice} = product
            const {productNum} =this
            axios.post(`http://localhost:9999/jpamemberManage/addBasket/${this.$store.state.loginMemberNo}`,{ productName, productPrice,productNum})
            .then( ()=> {
                alert('장바구니에 추가되었습니다.')
               this.$router.go()
            }).catch(err=>{alert(err.response.data.message)})
         
            
        
    },
    here(members){
        console.log(members)
    }
    
        
    },
    computed:{
        ...mapState(['members','User','loginMemberNo'])

    },
    
    
}
</script>

<style scoped>
ul{
    list-style: none;
}
li {
    float: left;
}
table{
    position: absolute;
}
tr{
    border: hidden;
}
</style>