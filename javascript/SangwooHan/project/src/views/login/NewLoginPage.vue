<template>
    <div>
     
        <div align="center">
           
        </div>
        <new-login-page-form @submit="onSubmit" :members="members"/>
        <v-spacer></v-spacer>
          <v-btn tile color="teal" @click="showSession">
            <v-icon left>
                ads_click
            </v-icon>
            세션 보기
        </v-btn>
        <v-spacer></v-spacer>
        <v-btn tile color="teal" @click="removeSession">
            <v-icon left>
                ads_click
            </v-icon>
            세션 끊기
        </v-btn>
    </div>
    
</template>

<script>

import axios from 'axios'
import NewLoginPageForm from '../../components/Login/NewLoginPageForm.vue'
import {mapState, mapActions} from 'vuex'

export default {
    name: 'VuetifyMemberLoginPage',
    components: {
        NewLoginPageForm,
      
    },
    
    methods: {
            
        onSubmit (payload) {
            
            const { id, pw } = payload
            axios.post('http://localhost:9999/jpamemberManage/login', { userid: id, password: pw, auth: null })
                    .then(res => {
                        if (res.data != "") {
                            alert('로그인 성공! - ' + res.data)

                            console.log(res.data)
                            alert('안녕하세요?' + res.data.userid + '님')
                            this.$store.state.loginUser = res.data.userid
                            console.log(this.$store.state.loginUser)
                            this.$router.push( {name: 'Home'})
                            this.$store.state.isLogin = true;
                        } else {
                            alert('비밀번호가 틀렸습니다. - ' + res.data)
                        }
                        /*
                        this.$router.push({
                            name: 'BoardReadPage',
                            params: { boardNo: res.data.boardNo.toString() }
                        })
                        */
                    })
                    .catch(res => {
                        alert(res.response.data.message)
                    })
        },
        ...mapActions(['fetchMemberList']),
        showSession () {
            if (this.$store.state.isLogin == true) {
                axios.post('http://localhost:9999/jpamemberManage/needSession')
                        .then(res => {
                            if (res.data == true) {
                                alert('세션 정보 유지! - ' + res.data)
                            } else {
                                alert('세션 정보 유지 안되는 중! - ' + res.data)
                            }
                            /*
                            this.$router.push({
                                name: 'BoardReadPage',
                                params: { boardNo: res.data.boardNo.toString() }
                            })
                            */
                        })
                        .catch(res => {
                            alert(res.response.data.message)
                        })
            } else {
                alert('먼저 로그인부터 하세요!')
            }
        },
        removeSession () {
            axios.post('http://localhost:9999/jpamemberManage/removeSession')
                    .then(res => {
                        this.$store.state.isLogin = res.data
                    })
        }



    },
    computed: {
          ...mapState(['members','isLogin'])
      },
      mounted () {
          this.fetchMemberList()
      },
}
</script>

<style scoped>

</style>