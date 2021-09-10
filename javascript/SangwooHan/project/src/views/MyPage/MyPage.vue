<template>
    <div>
        <v-container>

        <my-information/>
        </v-container>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import MyInformation from '../../components/MyPage/MyInformation.vue'


export default {
  components: { MyInformation,  },
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