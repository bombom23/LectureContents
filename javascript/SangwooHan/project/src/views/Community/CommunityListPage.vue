<template>
    <div>
        
        <v-container>
         <v-btn v-if="this.$store.state.isLogin == true" route :to="{name: 'CommunityRegisterPage'}">글쓰기</v-btn>
        </v-container>
       <community-list-form v-if="boards" :boards="boards"/>
       <p v-else > 로딩중</p>
     
    </div>
</template>

<script>
import CommunityListForm from '../../components/Community/CommunityListForm.vue'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'CommunityLissPage',

    components: {
        CommunityListForm,
        
    },
    computed: {
          ...mapState(['boards'])
      },
      mounted () {
          this.fetchBoardList()
      },
      methods: {
          ...mapActions(['fetchBoardList'])
      }
}
</script>