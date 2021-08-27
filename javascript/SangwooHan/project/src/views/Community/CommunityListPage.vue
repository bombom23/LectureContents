<template>
    <div>
        <community-list-form :boards="boards"/>
    </div>
</template>

<script>
import { mapActions ,mapState} from 'vuex'
import CommunityListForm from '../../components/Community/CommunityListForm.vue'
export default {
    name: 'CommunityListPage',
  components: { CommunityListForm },
    computed:{
        ...mapState(['boards'])
    },
    methods: {
        ...mapActions(['fetchBoardList'])
    },
    mounted() {
        this.fetchBoardList()
    },
    
}
</script>