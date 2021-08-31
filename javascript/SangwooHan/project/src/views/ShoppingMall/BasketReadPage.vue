<template>
    <div>
        <basket-read-form v-if="this.$store.state.User !=null" :BasketList="BasketList"/>
        <p v-else>로그인후 이용해주세요!</p>
    </div>
</template>

<script>
import {mapActions,mapState} from 'vuex'
import BasketReadForm from '../../components/ShoppingMall/BasketReadForm.vue'
export default {
  components: { BasketReadForm },
    name: 'BasketReadPage',
    props:{
        memberNo:{
            type:String,
            required: true
        }
    },
    computed:{
        ...mapState(['BasketList'])
    },
    methods: {
        ...mapActions(['fetchBasketList'])
    },
    created() {
        this.fetchBasketList(this.memberNo)
    },
}
</script>