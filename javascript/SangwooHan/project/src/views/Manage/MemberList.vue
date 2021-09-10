<template>
<v-container>
    <div id="board">
       
       <member-list-form v-if="this.$store.state.User =='관리자'" :members="members"/> 
      <!-- <member-list-form v-if="members" :members="members"/>  -->
        <p v-else >권한이 없습니다.</p>
    </div>
</v-container>
</template>

<script>
import MemberListForm from '../../components/Management/MemberListForm.vue'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'MemberList',
  components: { 
      MemberListForm
 
      },
      computed: {
          ...mapState(['members','User'])
      },
      mounted () {
          this.fetchMemberList()
      },
      methods: {
          ...mapActions(['fetchMemberList'])
      }
    
}
</script>