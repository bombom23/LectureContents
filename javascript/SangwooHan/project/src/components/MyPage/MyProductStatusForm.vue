<template>
    <div>
        <table>
            <tr>
               <th>주문번호</th>
               <th>아이디</th>
               <th>주소</th>
               <th>성함</th>
               <th>연락처</th>
               <th>물품이름</th>
               <th>개수</th>
               <th>가격</th>
               <th>상태</th>
               
           </tr>
           <tr v-for="item in OrderList" :key="item.orderNo">
               <th v-if="User == item.userid" >{{item.orderNo}}</th>
                  <th v-if="User == item.userid" >{{item.userid}}</th>
                  <th v-if="User == item.userid" width="150px">{{ item.address}}</th>
                  <td v-if="User == item.userid">{{item.buyUserName}}</td>
                  <td v-if="User == item.userid">{{item.phoneNo}}</td>
                  <td v-if="User == item.userid">{{item.productName}}</td>
                  <td v-if="User == item.userid">{{item.productNum}}</td>
                  <td v-if="User == item.userid">{{item.productPrice}}</td>
                  <td v-if="User == item.userid">{{item.state}}</td>
                  <td  v-if="User == item.userid && item.state =='입금확인중' && Modify !=item.orderNo" > <v-btn  @click="QuantityChange(item.orderNo)" v-if="User == item.userid && item.state =='입금확인중' && Modify !=item.orderNo">수량변경</v-btn> 
                    <input style="max-width: 40px" v-if="User == item.userid && item.state =='입금확인중' && Modify ==item.orderNo" v-model="quantity" />
                    <v-btn v-if="User == item.userid && item.state =='입금확인중' && Modify ==item.orderNo "  @click="QuantityChangeGo(quantity,item.orderNo)">확인</v-btn>
                    <v-btn v-if="User == item.userid && item.state =='입금확인중' && Modify ==item.orderNo"  @click="Modifycancel">취소</v-btn>
                 </td>
                 <td v-if="User == item.userid && item.state =='입금확인중'" ><v-btn @click="deleteOrder(item.orderNo)" >주문취소</v-btn></td>            
           </tr>
        </table>
    </div>
</template>

<script>
import axios from 'axios'
import { mapState } from 'vuex'
export default {
    
    props:{
        OrderList: {
            type:Array
        }
    },
    computed:{
        ...mapState(['User'])
    },
    methods:{
        QuantityChange(orderNo){
            this.Modify =orderNo
            
        },
        Modifycancel(){
            this.Modify =null
        },
        QuantityChangeGo(quantity,orderNo){
            console.log('Quantity:'+quantity+',orderNo:'+orderNo)
            
            if(quantity < 1 ){
                alert('수량을 1개 이상으로 설정해주세요')
            }else{
                    axios.post(`http://localhost:9999/jpaOrder/QuantityChange/${orderNo}`,{quantity})
                    .then(()=>{
                        alert('수량이변경되었습니다')
                        this.$router.go()
                    })
            }
            
        },
        deleteOrder(orderNo){
             axios.delete(`http://localhost:9999/jpaOrder/deleteOrder/${orderNo}`)
             .then( () =>{
                 alert('주문이 최소되었습니다.')
                 this.$router.go()
             })
        }
    },
    data(){
        return{
            Modify: null,
            quantity: 1
        }
    }
}
</script>
<style scoped>
table{
    margin-left: 200px;
    position: absolute;
}

</style>