<template>
    <div>
      <insect-museum-bar/>
        <butterfly-list-form v-if="ButterflyList" :ButterflyList="ButterflyList"/>
        <p v-else>공사중입니다</p>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import ButterflyListForm from '../../../components/InsectMuseum/Butterfly/ButterflyListForm.vue'
import InsectMuseumBar from '../../NavigationVar/InsectMuseumBar.vue'

export default {
    name: 'InsectMuseumButterfly',
    components: {
        ButterflyListForm,
        InsectMuseumBar

    },
    computed: {
    ...mapState(['ButterflyList'])
    },
    methods: {
        ...mapActions(['fetchButterflyList']),
     
        
    },
    mounted() {
        this.fetchButterflyList()
    },
}
</script>