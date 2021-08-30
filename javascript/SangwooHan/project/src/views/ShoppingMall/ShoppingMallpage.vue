<template>
    <div>
        <shopping-mallpage-from v-if="ProductList" :ProductList="ProductList"/>
    </div>
</template>
<script>
import {mapActions, mapState} from 'vuex'
import ShoppingMallpageFrom from '../../components/ShoppingMall/ShoppingMallpageFrom.vue'
export default {
  components: { ShoppingMallpageFrom },
    name: 'ShoppingMallpage',
    computed: {
        ...mapState(['ProductList'])
    },
    methods: {
        ...mapActions(['fetchProductList'])
    },
    mounted() {
        this.fetchProductList()
    },
}
</script>