<template>
    <div>
        <img src="@/assets/상우/마이페이지로고.png"/>
        <my-information/>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import MyInformation from '../../components/MyPage/MyInformation.vue'

export default {
  components: { MyInformation },
    name: 'MyPage',
  
    computed: {
        ...mapState(['member','loginMemberNo'])
    },
    methods:{
        ...mapActions(['fetchMember'])
    },
    created() {
        this.fetchMember(this.$store.state.loginMemberNo)
    },
}
</script>