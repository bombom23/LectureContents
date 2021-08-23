<template>
    <div>
        <stagbeetle-read-form v-if="Stagbeetle" :Stagbeetle="Stagbeetle" />
        <p v-else>공사중입니다</p>
    </div>
</template>


<script>
import { mapActions,mapState } from 'vuex'
import StagbeetleReadForm from '../../components/InsectMuseum/StagbeetleReadForm.vue'
export default {
    name: 'StagbeetleReadPage',
  components: { StagbeetleReadForm },
    props: {
        boardNo: {
            type: String,
            
        }
    },
    computed:{
        ...mapState(['Stagbeetle'])
    },
    methods: {
        ...mapActions(['fetchStagbeetle'])
    },
    created() {
        this.fetchStagbeetle(this.boardNo)
    },
    
}
</script>