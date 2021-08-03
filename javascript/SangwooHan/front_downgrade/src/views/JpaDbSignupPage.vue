<template>
    <div align="center">
        <jpa-db-register-form @submit="onSubmut"/>
    </div>
</template>

<script>
import JpaDbRegisterForm from '../components/jpa/JpaDbRegisterForm.vue'
import axios from 'axios'
export default {
    name: 'JpaDbSignupPage',
    components: {
        JpaDbRegisterForm
    },
    methods: {
        onSubmut(payload) {
                const {id, pw } = payload
                axios.post('http://localhost:9999/vueJpaTest/register',{id, pw})
                .then(res => {
                    alert('회원가입 성공' + res)
                    this.$router.push({
                            name: 'Home'
                    })
                }).catch(res =>{
                    alert(res.response.data.message)
                })
        }
    }

}
</script>