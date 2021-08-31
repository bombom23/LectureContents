<template>
<div>
    <shopping-mall-menu-bar :ProductList="ProductList"/>
    검색<input type="text" v-model="search"/>
   <v-container>
        <ul>
            <li  v-for="product in ProductList" :key="product.productName">
                <img width="300px" v-if="product.productName =='[사슴벌레용]발효톱밥5L'&&product.productName.includes(search)&&product.productType =='발효톱밥'" src="@/assets/상우/발효톱밥.jpg"/>
                <img width="300px" v-if="product.productName =='[장수풍뎅이]발효톱밥5L'&&product.productName.includes(search)&&product.productType =='발효톱밥'" src="@/assets/상우/발효톱밥.jpg"/>
                <img width="300px" v-if="product.productName =='[사슴벌레용]발효톱밥5L묶음6개'&&product.productName.includes(search)&&product.productType =='발효톱밥'" src="@/assets/상우/발효톱밥묶음.jpg"/>
                <img width="300px" v-if="product.productName =='[장수풍뎅이]발효톱밥5L묶음6개'&&product.productName.includes(search)&&product.productType =='발효톱밥'" src="@/assets/상우/발효톱밥묶음.jpg"/>
                <p v-if="product.productName.includes(search)&&product.productType =='발효톱밥'" >제품명:{{product.productName}}</p>
                <p v-if="product.productName.includes(search)&&product.productType =='발효톱밥'" >제품가격:{{product.productPrice}}원</p>
                <v-btn v-if="product.productName.includes(search)&&product.productType =='발효톱밥'" @click="Buy(product.boardNo)"> 구매</v-btn>
                <v-btn  v-if="User !=null&&product.productName.includes(search)&&product.productType =='발효톱밥'" @click="Basket(product)">장바구니</v-btn>
                <v-btn v-if="User ==null&&product.productName.includes(search)&&product.productType =='발효톱밥'" @click="plzlogin">장바구니</v-btn>
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
import ShoppingMallMenuBar from '../../../components/ShoppingMall/ShoppingMallMenuBar.vue'


Vue.use(cookies)
export default {
  components: { ShoppingMallMenuBar },
    name: 'InsectMallEggtree',
    props:{
        ProductList:{
            type: Array,
            required: true
        }
    },
    data(){
            return{
                productNum: 1,
                search: '',
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
              //  this.$cookies.set('ProductList', this.ProductList, '5m')
               
            }).catch(err=>{alert(err.response.data.message)})
         
            
        
    },
    here(members){
        console.log(members)
    }
    
        
    },
    computed:{
        ...mapState(['members','User','loginMemberNo'])

    },
  //  mounted(){
  //         if(this.ProductList == null){
  //              this.ProductList = this.$cookies.get('ProductList')
  //          }
 //   }
    
    
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