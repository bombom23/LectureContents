<template>
    <div>
        <insect-museum-register-bar/>
      <stagbeetle-read-form v-if="Stagbeetle" :Stagbeetle="Stagbeetle"/>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import StagbeetleReadForm from '../../../components/InsectMuseum/Stagbeelte/StagbeetleReadForm.vue'
import InsectMuseumRegisterBar from '../../NavigationVar/InsectMuseumRegisterBar.vue'

export default {
  components: {StagbeetleReadForm, InsectMuseumRegisterBar  },
    name: 'StagbeetleReadPage',
    props: {
        boardNo: {
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['Stagbeetle'])
    },
    methods: {
        ...mapActions(['fetchStagbeetle'])
    },
    created() {
        this.fetchStagbeetle(this.boardNo)
    }
}
</script>