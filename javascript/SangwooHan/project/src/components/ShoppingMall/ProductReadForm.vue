<template>

    <div>
        <v-container style="max-width:300px">
        <table>
           
            </table>
        </v-container>
       <v-container>
       <table id="table">
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
               <td type="Number">수량{{productNum}}</td>
               
           </tr>
           <tr>
               <td>총가격(택배비3000원):{{Product.productPrice * productNum +3000}}</td>
           </tr>
           <tr>
               
                <v-btn v-if="this.$store.state.User !=null" @click="Basket(Product)" align="center" width="200"  height="80">장바구니</v-btn>
                <v-btn v-if="this.$store.state.User ==null" @click="plzlogin" align="center" width="200"  height="80">장바구니</v-btn>

               <v-btn v-if="this.$store.state.User !=null"  @click="InitiatingPerchase" width="200" class="red" height="80">구매</v-btn>
               <v-btn v-if="this.$store.state.User ==null"  @click="plzlogin" width="200" class="red" height="80">구매</v-btn>
           </tr>
           <tr v-if="perchaseBox ==1"><p>주소</p>
               <textarea v-model="address"/>
           </tr>
           <tr v-if="perchaseBox ==1"><p>휴대전화(-빼고기입)</p>
              <textarea v-model="phoneNo"/>
           </tr>
           <tr v-if="perchaseBox ==1"><p>주문자성함</p>
              <textarea v-model="buyUserName"/>
           </tr>
           <tr v-if="perchaseBox ==1">
               <v-btn @click="finalBuybtn(Product)" class="red">최종구매</v-btn>
               <v-btn @click="prerchasecancle">취소</v-btn>
           </tr>
            </table>
           
            
          
      
       
        <img width="600px" v-if="Product.productName == '산란목'" src="@/assets/상우/산란목.jpg"/>
        <img width="600px" v-if="Product.productName == '발효톱밥5L'" src="@/assets/상우/발효톱밥.jpg"/>
        <v-container id="commetTable" style="max-width:500px">
        <form  @submit.prevent="OnSubmit" v-if="commentBox ==1 && this.$store.state.User !=null">
         <table >
             <tr>
                 <th>작성자</th>
                 <input v-model="ui" readonly/>
             </tr>
            <tr><th>댓글</th>
                <textarea v-model="comments"/>
                <v-btn  type="submit">등록</v-btn>
            </tr>
        </table>
        </form>
        <table>
            <tr v-for="(item, index) in Product.authList" :key="Product.authList[index].id">
                  
                  <th width="150px">{{ item.ui}}</th>
                  
                  <td width="50px" >{{item.comments}}</td>

                   <td v-if="Modify == item.productCommentNo">
                    <textarea  v-model="comments" cols="1" rows="1"/><v-btn depressed @click="CommemtsModify(item)">수정완료</v-btn><v-btn depressed @click="ModifyOFF">취소</v-btn>
                </td>
        <td>
        <v-btn width="10px" depressed v-if="item.ui == User"  @click="deleteComment(item.productCommentNo)">
            <v-icon>mdi-alpha-x-box-outline</v-icon>
        </v-btn>
        <v-btn depressed v-if="item.ui == User"   @click="ModifyOn(item.productCommentNo)">
             <v-icon>mdi-eraser</v-icon>
        </v-btn>
        </td>
            </tr>
        </table>
        
        </v-container>
        </v-container>
    </div>

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
            productNum: 1,
            perchaseBox: 0,
            address: '',
            phoneNo: '',
            buyUserName: '',
            commentBox: 1,
            ui: this.$store.state.User,
            comments: '',
            Modify: '',

             
        }
    },
    methods:{
        plzlogin(){
                alert('로그인후이용해주세요!')
        },
        ModifyOn(productCommentNo){
            this.Modify =productCommentNo
            this.commentBox =0
        },
        ModifyOFF () {
                this.Modify =null
                 this.commentBox =1
        },
        plusProduct(){
                this.productNum +=1
        },
        minusProduct(){
            
            if(this.productNum < 2){
                    alert('수량이 1보다 낮을순없습니다. 감사합니다.')
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
        },
        
        finalBuybtn(Product){
               const {productName,productPrice } =Product
                const {productNum, buyUserName,address,phoneNo} =this

                axios.post('http://localhost:9999/jpaOrder/register',{productName,productPrice,productNum,buyUserName,address,phoneNo})
                .then( ()=>{
                    alert('구매감사드립니다. 국민205502-04-5946645(한상우) 로 입금해주세요 입금확인후 배송시작')
                    this.perchaseBox =0
                    this.$router.go()
                }).catch(err=>{
                    alert(err.response.data.message)
                })



        },
        OnSubmit(){
            const {ui ,comments} =this
            axios.post(`http://localhost:9999/jpaProduct/comment/${this.Product.boardNo}`,{ui,comments})
            .then(()=>{
                alert('댓글이등록되었습니다.')
                this.$router.go()
            }).catch(err=>{alert(err.response.data.message)})

        },
                     CommemtsModify(item){

            console.log(item)
            const {productCommentNo, ui, regDate} = item
                const {comments} =this
            axios.post(`http://localhost:9999/jpaProduct/ModifyComments/${this.Product.boardNo}`,{ui,productCommentNo,comments,regDate})
            .then(res =>{
                alert('수정성공'+ res) 
                this.$router.go()
                this.commentBox = 1
            }).catch(err=>{alert(err.response.data.message)})
            

                              },

                              deleteComment(productCommentNo){
            
               
            axios.delete(`http://localhost:9999/jpaProduct/deleteComment/${productCommentNo}`)
            .then( res => {
                alert('삭제성공'+ res)
                this.$router.go()
                         }).catch(err=>{alert(err.response.data.message)})

                                     },
        
    }
}
</script>

<style scoped>

#table{
    margin-left: 600px;
    position: absolute;
    font-family: 'Courier New', Courier, monospace;
    font-size: 2.5em;
    border-style: solid;
    border: 1px
}
#textarea{
    width:970px;
    height: 230px;
}
#commetTable{
    
    
    position: absolute;
}

</style>