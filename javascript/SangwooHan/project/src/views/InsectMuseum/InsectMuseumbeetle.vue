<template>
    <div>
        <insect-menu/>
        <beetle-list-form :BeetleList="BeetleList"/>
    </div>
</template>

<script>
import { mapActions,mapState } from 'vuex'
import BeetleListForm from '../../components/InsectMuseum/BeetleListForm.vue'
import InsectMenu from '../../components/MuseumMenu/InsectMenu.vue'
export default {
    name: 'InsectMuseumStagbeetle',
    components: {
        InsectMenu,
        BeetleListForm
    },
    computed: {
        ...mapState(['BeetleList'])
    },
    methods:{
        ...mapActions(['fetchBeetleList'])
    },
    mounted() {
        this.fetchBeetleList()
    },
}
</script>