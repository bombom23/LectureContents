<template>
    <div>
        
        <insect-menu/>
        <img   id="stagtitle" src="@/assets/상우/한국사슴벌레.jpg"/>
       <stagbeetle-list-form :StagbeetleList="StagbeetleList"/>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import StagbeetleListForm from '../../components/InsectMuseum/StagbeetleListForm.vue'
import InsectMenu from '../../components/MuseumMenu/InsectMenu.vue'
export default {
    name: 'InsectMuseumStagbeetle',
    components: {
        InsectMenu,
        StagbeetleListForm
    },
    computed: {
        ...mapState(['StagbeetleList'])
    },
    methods: {
        ...mapActions(['fetchStagbeetleList'])
    },
    mounted() {
       this.fetchStagbeetleList() 
    },
}
</script>

<style scoped>
img{
    margin-left: 550px;
}

</style>