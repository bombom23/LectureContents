<template>
    <div>
        <img src="@/assets/상우/마이페이지로고.png"/>
        <my-information-menu/>
        <customer-sound-read-page-form v-if="CustomerSound" :CustomerSound="CustomerSound"/>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import CustomerSoundReadPageForm from '../../components/MyPage/CustomerSoundReadPageForm.vue'
import MyInformationMenu from '../../components/MyPage/MyInformationMenu.vue'
export default {
    name: 'CustomerSoundReadPage',
  components: { CustomerSoundReadPageForm, MyInformationMenu },
  props: {
      boardNo: {
          type: Number,
          required :true
      }
  },
  computed: {
      ...mapState(['CustomerSound'])
  },
  methods:{
      ...mapActions(['fetchCustomerSound'])
  },
  created(){
      this.fetchCustomerSound(this.boardNo)
  }

    
}
</script>