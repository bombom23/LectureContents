<template>
    <div>
        <insect-museum-menu/>
        <stagbeetle-register-form @submit="OnSubmit"/>
    </div>
</template>

<script>
import axios from 'axios'
import InsectMuseumMenu from '../../components/InsectMuseum/InsectMuseumMenu.vue'
import StagbeetleRegisterForm from '../../components/InsectMuseum/StagbeetleRegisterForm.vue'
export default {
    name: 'StagbeetleRegister',
    components:{
        StagbeetleRegisterForm,
        InsectMuseumMenu
    },
    methods: {
        OnSubmit(payload){
            const {id , title, text } = payload
            axios.post('http://localhost:9999/stagbeetle/register', {id, title, text })
            .then(res => {
                alert('등록성공' +res)
            })
            .catch( err => { 
                alert(err.response.data.message)
            })
        }
    }
}
</script>