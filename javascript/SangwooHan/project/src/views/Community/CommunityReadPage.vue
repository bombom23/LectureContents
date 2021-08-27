<template>
    <div>
        <community-read-form v-if="board" :board="board"/>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import CommunityReadForm from '../../components/Community/CommunityReadForm.vue'
export default {
  components: { CommunityReadForm },
    name: 'CommunityReadPage',
    props: {
        boardNo: {
            type: String,
            required : true
        }
    },
    computed: {
        ...mapState(['board'])
    },
    methods:{
        ...mapActions(['fetchBoard'])
    },
    created() {
        this.fetchBoard(this.boardNo)
    },
}
</script>