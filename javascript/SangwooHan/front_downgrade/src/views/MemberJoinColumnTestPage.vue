<template>
    <div align="center">
        <member-join-column-test-form @submit="onSubmut"/>
        <v-spacer></v-spacer>   
       <v-btn tile color="teal" @click="onJPATest">
            <v-icon left>
                ads_click
            </v-icon>
            클릭하세요!
        </v-btn>

    </div>
    
</template>

<script>
import MemberJoinColumnTestForm from '../components/member/MemberJoinColumnTestForm.vue'
import axios from 'axios'
export default {
    name: 'JpaDbSignupPage',
    components: {
        MemberJoinColumnTestForm
    },
    methods: {
        onSubmut(payload) {
                const {userId, password ,auth} = payload
                axios.post('http://localhost:9999/jpamember/register',{userId, password, auth})
                .then(res => {
                    alert('회원가입 성공' + res)
                    this.$router.push({
                            name: 'Home'
                    })
                }).catch(res =>{
                    alert(res.response.data.message)
                })
        },
       onJPATest () {
            axios.post('http://localhost:9999/jpamember/test', {
                        userId: null, password: null, auth: null
                    })
                    .then(res => {
                        alert('테스트 성공! - ' + res)
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        }
    }

}
</script>