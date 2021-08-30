<template>
<v-container>
    <div>
       
       <table>
           <tr>
               <td>제품명:{{Product.productName}}</td>
           </tr>
           <tr>
               <td>제품가격:{{Product.productPrice}}원</td>
           </tr>
           <tr>
               <textarea id="textarea" :value="Product.productDesc" readonly/>
           </tr>
           
           <tr>
               
               <v-btn @click="plusProduct">
                   <v-icon>
                       mdi-plus-thick
                   </v-icon>
               </v-btn>
               <v-btn @click="minusProduct">
                   <v-icon>
                       mdi-minus-thick
                   </v-icon>
               </v-btn>
           </tr>
           <tr>
               <td>수량{{productNum}}</td>
               
           </tr>
           <tr>
               <td>총가격(택배비3000원):{{Product.productPrice * productNum +3000}}</td>
           </tr>
           <tr>
               
                <v-btn @click="Basket(Product)" align="center" width="200"  height="80">장바구니</v-btn>

               <v-btn @click="InitiatingPerchase" width="200" class="red" height="80">구매</v-btn>
           </tr>
           <tr v-if="perchaseBox ==1"><p>주소</p>
               <textarea v-model="address"/>
           </tr>
           <tr v-if="perchaseBox ==1"><p>휴대전화(-빼고기입)</p>
              <textarea v-model="phoneNo"/>
           </tr>
           <tr v-if="perchaseBox ==1">
               <v-btn class="red">최종구매</v-btn>
               <v-btn @click="prerchasecancle">취소</v-btn>
           </tr>
       </table>
       
        <img width="600px" v-if="Product.productName == '산란목'" src="@/assets/상우/산란목.jpg"/>
        <img width="600px" v-if="Product.productName == '발효톱밥5L'" src="@/assets/상우/발효톱밥.jpg"/>
        <h3>후기</h3>
        
    </div>
</v-container>
</template>
<script>
import axios from 'axios'
import {mapState} from 'vuex'

export default {
    name: 'ProduvtReadForm',
    props:{
        Product:{
            type:Object
        }
    },
    computed:{
        ...mapState(['members','User','loginMemberNo'])

    },
    data(){
        return{
            productNum: 0,
            perchaseBox: 0,
            address: '',
            phoneNo: '',
        }
    },
    methods:{
        plusProduct(){
                this.productNum +=1
        },
        minusProduct(){
            
            if(this.productNum < 1){
                    alert('수량이 0보다 낮을순없습니다. 감사합니다.')
            }else{
                this.productNum -=1
            }
        },
        InitiatingPerchase(){
            this.perchaseBox =1
        },
        prerchasecancle(){
            this.perchaseBox= 0
        },
        Basket(Product){
            for(var i = 0 ; i <this.members.length ; i++){
           if(this.$store.state.User == this.members[i].userid){
                 this.$store.state.loginMemberNo = this.members[i].memberNo
            }
             }
                const { productName, productPrice} = Product
            const {productNum} =this
            axios.post(`http://localhost:9999/jpamemberManage/addBasket/${this.$store.state.loginMemberNo}`,{ productName, productPrice,productNum})
            .then( ()=> {
                alert('장바구니에 추가되었습니다.')
               
            }).catch(err=>{alert(err.response.data.message)})
        }
    }
}
</script>

<style scoped>

table{
    margin-left: 600px;
    position: absolute;
    font-family: 'Courier New', Courier, monospace;
    font-size: 2.5em;
}
#textarea{
    width:970px;
    height: 230px;
}

</style>