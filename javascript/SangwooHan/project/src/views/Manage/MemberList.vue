<template>
    <div id="board">
        <member-list-form :members="members"/> 
    </div>
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
          ...mapState(['members'])
      },
      mounted () {
          this.fetchMemberList()
      },
      methods: {
          ...mapActions(['fetchMemberList'])
      }
    
}
</script>