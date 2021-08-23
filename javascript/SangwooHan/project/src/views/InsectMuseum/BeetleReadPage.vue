<template>
    <div>
        <beetle-read-form v-if="Beetle" :Beetle="Beetle"/>
        <p v-else>공사중입니다.</p>
    </div>
</template>


<script>
import { mapActions,mapState } from 'vuex'
import BeetleReadForm from '../../components/InsectMuseum/BeetleReadForm.vue'

export default {
    name: 'StagbeetleReadPage',
  components: {BeetleReadForm  },
    props: {
        boardNo: {
            type: String,
            require: true
        },
        
    },
    computed:{
        ...mapState(['Beetle'])
    },
    methods: {
        ...mapActions(['fetchBeetle'])
    },
    created() {
        this.fetchBeetle(this.boardNo)
    },
    
}
</script>