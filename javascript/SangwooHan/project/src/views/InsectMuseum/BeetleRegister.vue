<template>
    <div>
        <insect-museum-menu/>
        <beetle-register-form @submit="OnSubmit"/>
    </div>
</template>

<script>
import axios from 'axios'
import BeetleRegisterForm from '../../components/InsectMuseum/BeetleRegisterForm.vue'
import InsectMuseumMenu from '../../components/InsectMuseum/InsectMuseumMenu.vue'
export default {
    name: 'BeetleRegister',
    components: {
        BeetleRegisterForm,
        InsectMuseumMenu

    },
    methods: {
        OnSubmit (payload) {
                const {id , text , title} = payload
                axios.post('http://localhost:9999/beetle/register', {id, text,title})
                .then( res => {
                    alert('등록성공' + res) 
                }).catch(err=>{alert(err.response.data.message)})
        }
    }
}
</script>