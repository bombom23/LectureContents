<template>
    <div>
        <insect-museum-bar/>
        <dragonfly-list-form :DragonflyList="DragonflyList" />
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex'
import DragonflyListForm from '../../../components/InsectMuseum/Dragonfly/DragonflyListForm'
import InsectMuseumBar from '../../NavigationVar/InsectMuseumBar.vue'
export default {
  components: { DragonflyListForm,InsectMuseumBar },
    name: 'InsectMuseumDragonfly',

    computed: {
        ...mapState(['DragonflyList'])
    },
    methods:{
        ...mapActions(['fetchDragonflyList'])
    },
    mounted() {
        this.fetchDragonflyList()
    },

}
</script>