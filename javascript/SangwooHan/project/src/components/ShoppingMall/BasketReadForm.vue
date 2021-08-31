<template>
    <div >
        <h1 v-if="BasketList.length == 0"> 장바구니가비었습니다.</h1>
        <div v-if="BasketList">
        <v-container >
        <table>
                
            <tr v-for="product in BasketList" :key="product.productName">
                 <img width="300px" v-if="product.productName =='[사슴벌레용]발효톱밥5L'" src="@/assets/상우/발효톱밥.jpg"/>
                <img width="300px" v-if="product.productName =='[장수풍뎅이]발효톱밥5L'" src="@/assets/상우/발효톱밥.jpg"/>
                <img width="300px" v-if="product.productName =='산란목'" src="@/assets/상우/산란목.jpg"/>
                <img width="300px" v-if="product.productName =='발효톱밥5L'" src="@/assets/상우/발효톱밥.jpg"/>
                <img width="300px" v-if="product.productName =='균사'" src="@/assets/상우/균사.jpg"/>
                <img width="300px" v-if="product.productName =='곤충젤리100개'" src="@/assets/상우/수액젤리.jpg"/>
                <img width="300px" v-if="product.productName =='곤충이끼'" src="@/assets/상우/곤충이끼.jpg"/>
                <img width="300px" v-if="product.productName =='오호히라균사'" src="@/assets/상우/균사.jpg"/>
                <img width="300px" v-if="product.productName =='레벤지균사'" src="@/assets/상우/균사.jpg"/>
                <img width="300px" v-if="product.productName =='놀이목'" src="@/assets/상우/놀이목.jpg"/>
                <img width="300px" v-if="product.productName =='광구병'" src="@/assets/상우/광구병.jpg"/>
                <img width="300px" v-if="product.productName =='오호히라균사묶음6개'" src="@/assets/상우/균사묶음.jpg"/>
                <img width="300px" v-if="product.productName =='균사스푼'" src="@/assets/상우/균사스푼.jpg"/>
                <img width="300px" v-if="product.productName =='일반균사묶음6개'" src="@/assets/상우/균사묶음.jpg"/>
                <img width="300px" v-if="product.productName =='사육케이스특대'" src="@/assets/상우/사육케이스.jpg"/>
                <img width="300px" v-if="product.productName =='사육케이스대'" src="@/assets/상우/사육케이스.jpg"/>
                <img width="300px" v-if="product.productName =='사육케이스중'" src="@/assets/상우/사육케이스.jpg"/>
                <img width="300px" v-if="product.productName =='사육케이스소'" src="@/assets/상우/사육케이스.jpg"/>
                <img width="300px" v-if="product.productName =='먹이접시1구'" src="@/assets/상우/먹이접시1구.jpg"/>
                <img width="300px" v-if="product.productName =='먹이접시2구'" src="@/assets/상우/먹이접시2구.jpg"/>
                <img width="300px" v-if="product.productName =='[사슴벌레용]발효톱밥5L묶음6개'" src="@/assets/상우/발효톱밥묶음.jpg"/>
                <img width="300px" v-if="product.productName =='[장수풍뎅이]발효톱밥5L묶음6개'" src="@/assets/상우/발효톱밥묶음.jpg"/>
                <img width="300px" v-if="product.productName =='유산균젤리100개'" src="@/assets/상우/유산균젤리.jpg"/>
                <img width="300px" v-if="product.productName =='유충병고급'" src="@/assets/상우/유충병고급.jpg"/>
                <img width="300px" v-if="product.productName =='온도계스티커'" src="@/assets/상우/온도계스티커.jpg"/>

                <img width="300px" v-if="product.productName =='장수풍뎅이세트'" src="@/assets/상우/장수풍뎅이세트.jpg"/>
                <img width="300px" v-if="product.productName =='왕사슴벌레세트'" src="@/assets/상우/왕사슴벌레세트.jpg"/>
                
                <td>제품명:{{product.productName}},가격:{{product.productPrice}},수량:{{product.productNum}}</td>
                <td v-if="Modify == product.memberBasketNo">
                    <input type="Number" v-model="productNum" cols="1" rows="1"/><v-btn depressed @click="ProductNumModify(product)">수정완료</v-btn><v-btn depressed @click="ModifyOFF">취소</v-btn>
                </td>
                <v-btn @click="deleteProduct(product.memberBasketNo)" >삭제</v-btn>
                <v-btn @click="ModifyOn(product.memberBasketNo)">수량변경</v-btn>
            </tr>
            <v-btn v-if="BasketList.length != 0 " @click="InitiatingPerchase" width="200" class="red" height="80">구매</v-btn>
             
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
               <v-btn  @click="finalBuybtn(BasketList)" class="red">최종구매</v-btn>
               <v-btn @click="prerchasecancle">취소</v-btn>
           </tr>
        </table>
        
        </v-container>
        </div>
        
        <v-btn  @click="check">체크</v-btn>
    </div>
    
</template>

<script>
import axios from 'axios';

export default {
    name: 'BasketReadForm',
    props:{
        BasketList: {
            type: Array
        },
        
    
    },
    methods: {check(){console.log(this.BasketList)},
            ModifyOn(memberBasketNo){
                this.Modify  =  memberBasketNo;
            },
            ModifyOFF(){
                this.Modify = null
            },
            ProductNumModify(product){
                console.log(product)
                const {memberBasketNo,productName, productPrice, regDate,memberNo} =product
                const {productNum} =this

                axios.post(`http://localhost:9999/jpamemberManage/ModifyProductNum/${memberNo}`,{memberBasketNo,productName,productPrice,regDate,productNum})
                .then( () =>{
                    alert('수량이변경되었습니다')
                    this.$router.go()
                }).catch(err=>{alert(err.response.data.message)})

            },
             deleteProduct(memberBasketNo){
                    
                    axios.post(`http://localhost:9999/jpamemberManage/deleteProduct/${memberBasketNo}`)
                    .then(() =>{
                        alert('삭제되었습니다.')
                        this.$router.go()
                    }).catch(err=>{alert(err.response.data.message)})
             },
             InitiatingPerchase(){
            this.perchaseBox =1
        },
        prerchasecancle(){
            this.perchaseBox =0
        },
        finalBuybtn(BasketList){

            for(var z = 0; z< BasketList.length; z++){
                const {productName,productPrice,productNum} =BasketList[z]
                const {address,phoneNo,buyUserName} =this

                    axios.post('http://localhost:9999/jpaOrder/register',{productName,productPrice,productNum,address,phoneNo,buyUserName})
                    .then( ()=>{
                        
                    
                    
                        
                }).catch(err=>{
                    alert(err.response.data.message)
                })
            }
            alert('구매감사드립니다. 국민205502-04-5946645(한상우) 로 입금해주세요 입금확인후 배송시작')
            this.$router.go()
        }
    },
    data(){
            return{
                productNum: 0,
                Modify: '',
                ProductNumBox: 1,
                perchaseBox: 0,
                address: '',
                phoneNo: 0,
                buyUserName: ''

            }
    },
    created() {
        for(var i = 0 ; i<this.BasketList.length; i++ ){
          this.totalPrice +=  (this.BasketList[i].productPrice *this.BasketList[i].productNum)
        }
    },
}
</script>