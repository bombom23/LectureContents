<template>
    <div>
    
        <community-read-form v-if="board" :board="board"/>
        <p v-else>공사중입니다 잠시만기다려주세요</p>
    </div>
</template>

<script>

import { mapActions, mapState } from 'vuex'
import CommunityReadForm from '../../components/Community/CommunityReadForm.vue'
export default {
    name: 'CommunityReadPage',
        props: {
            boardNo: {
                type: String,
                required: true
            }
        },
        components: {
            CommunityReadForm
               
        },
        created() {
            this.fetchBoard(this.boardNo)
            .catch(err => {
                alert(err.response.data.message)
            })
        },
        methods: {
           
            ...mapActions(['fetchBoard']) 
        },
        computed: {
            ...mapState(['board'])
        }

}
</script>