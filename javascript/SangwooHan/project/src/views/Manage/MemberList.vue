<template>
    <div id="board">
        <manage-nav-bar/>
        <member-list-form :members="members"/> 
    </div>
</template>

<script>
import MemberListForm from '../../components/Management/MemberListForm.vue'
import { mapState, mapActions } from 'vuex'
import ManageNavBar from '../NavigationVar/ManageNavBar.vue'
export default {
    name: 'MemberList',
  components: { 
      MemberListForm,
    ManageNavBar 
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