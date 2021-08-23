<template>
    <notice-list-form :notices="notices"/>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import NoticeListForm from '../../components/Notice/NoticeListForm.vue'
export default {
    name: 'NoticeListPage',
  components: { NoticeListForm },
    methods:{
        ...mapActions(['fetchNoticeList'])
    },
    computed: {
        ...mapState(['notices'])
    },
    mounted() {
        this.fetchNoticeList()
    },
}
</script>