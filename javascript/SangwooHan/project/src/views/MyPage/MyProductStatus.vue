<template>
    <div>
        <my-information-menu/>
    <my-product-status-form v-if="OrderList" :OrderList="OrderList"/>
    <p v-else> 메인홈으로 이동해주세요</p>
    </div>
</template>

<script>
import MyProductStatusForm from '../../components/MyPage/MyProductStatusForm.vue'
import { mapActions, mapState } from 'vuex'
import MyInformationMenu from '../../components/MyPage/MyInformationMenu.vue'
export default {
    name: 'MyProductStatus',
    components:{
        MyProductStatusForm,
        MyInformationMenu
    },
    computed:{
        ...mapState(['OrderList'])
    },
    methods:{
        ...mapActions(['fetchOrderList'])
    },
    created(){
        this.fetchOrderList()
    }


}
</script>