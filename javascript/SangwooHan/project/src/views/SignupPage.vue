<template>
    <div align="center">

        <signup-register-form @submit="onSubmit"/>
    </div>
</template>

<script>
import SignupRegisterForm from '../components/Signup/SignpupRegisterForm.vue'

import axios from 'axios'
export default {
    name: 'SignupPage',
    components: {
        SignupRegisterForm,
     
    },
    methods: {
        onSubmit(payload){
                const {userid, password, name, email, birthday, gender, address, phoneNo, auth} = payload
                axios.post('http://localhost:9999/jpamemberManage/register', {userid, password, name, email, birthday, gender, address, phoneNo, auth})
                .then(res =>{
                    alert('회원가입 성공' + res)
                    this.$router.push({
                        name: 'Home'
                    }) 
                }).catch(res => {
                    alert(res.response.data.message)
                })
                
        }
    }
}
</script>

<style scoped>

</style>