<template>
    <div>
        <insect-museum-menu/>
        <dragonfly-register-form/>
    </div>
</template>

<script>
import DragonflyRegisterForm from '../../components/InsectMuseum/DragonflyRegisterForm.vue'
import InsectMuseumMenu from '../../components/InsectMuseum/InsectMuseumMenu.vue'
export default {
    name: 'DragonflyRegister',
    components: {
        DragonflyRegisterForm,
        InsectMuseumMenu
    }
}
</script>
        