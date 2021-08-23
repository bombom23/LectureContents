<template>
    <div>
    <notice-read-form v-if="notice" :notice="notice"/>  
    <p v-else> 공사중입니다</p> 
        <p>{{boardNo}}</p>
  
    </div>
     
</template>

<script>
import { mapActions, mapState } from 'vuex'
import NoticeReadForm from '../../components/Notice/NoticeReadForm.vue'
export default {
  components: { NoticeReadForm },
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    
    computed: {
        ...mapState(['notice'])
    },
    methods: {
        ...mapActions(['fetchNotice'])
    },
    created() {
        console.log('created가 액션에게 넘겨준번호 ='+this.boardNo )
        this.fetchNotice(this.boardNo)
    },
    
}
</script>