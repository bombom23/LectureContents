<template>
    <div>
    <table class="type02">
        <tr>
            <th>
            <v-btn depressed route :to="{name: 'BasketReadPage', params:{memberNo: this.$store.state.loginMemberNo}}">
                장바구니
            </v-btn>
            </th>
        </tr>
        <tr>
           <th>
            <v-btn depressed route :to="{name: 'MyInformationDetail'}">
                내정보
            </v-btn>
            </th>
        </tr>
        <tr>
            <th>
            <v-btn depressed route :to="{name: 'MyProductStatus',params:{User: this.$store.state.User} }">
                주문현황
            </v-btn>
            </th>
        </tr>
        <tr>
            <th>
            <v-btn depressed route :to="{name: 'CustomerSoundPage' }">
                고객센터
            </v-btn>
            </th>
        </tr>
    </table>
    </div>
</template>

<script>
export default {
    name: 'MyInformation',

    props: {
        member: {
            type:Object
        }
    },
    methods:{
        /*
        BasketDetail(){
            this.$router.replace({name: 'BasketReadPage', params:{memberNo: this.$store.state.loginMemberNo}})
        },
        myinformationDetail() {
            this.$router.replace({ name: 'MyInformationDetail'})
        },
        MyProductStatusDetail() {
            this.$router.replace({name: 'MyProductStatus'})
        }
        */
    }
}
</script>

<style scoped>
table.type02 {
  border-collapse: separate;
  border-spacing: 0;
  text-align: left;
  line-height: 1.5;
  border-top: 1px solid #ccc;
  border-left: 1px solid #ccc;
  margin : 20px 10px;
  max-width: 130px;
  position: absolute;
  margin-right: 400px;
}
table.type02 th {
  width: 150px;
  padding: 10px;
  font-weight: bold;
  vertical-align: top;
  border-right: 1px solid #ccc;
  border-bottom: 1px solid #ccc;
  border-top: 1px solid #fff;
  border-left: 1px solid #fff;
  background: #eee;
}
table.type02 td {
  width: 350px;
  padding: 10px;
  vertical-align: top;
  border-right: 1px solid #ccc;
  border-bottom: 1px solid #ccc;
}
</style>