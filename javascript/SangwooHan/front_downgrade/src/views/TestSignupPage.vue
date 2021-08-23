<template>
    <test-signup-form @submit="Onsubmit"/>
</template>


<script>
import axios from 'axios'
import TestSignupForm from '@/components/Test/TestSignupForm'

export default {
  components: { 
      TestSignupForm
  },
  methods: {
      Onsubmit (payload) {
            const {id , pw } = payload 
            axios.post('http://localhost:9999/sibal/register', {id, pw })
           .then(res => {
                        alert('등록 성공! - ' + res)
                     
                        this.$router.push({
                            name: 'Home'
                       
                        })
                    })
                    .catch(err => {
                        alert(err.response.data.message)
                    })
      }
  },    
    
}
</script>