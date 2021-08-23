<template>
    <div>
        <h3>회원가입</h3>
        <form @submit.prevent="Onsubmit">
            <table>
                <v-text-field label="아디" v-model="id">
                </v-text-field>
                    <v-text-field label="비번" v-model="pw">
                    </v-text-field>
            </table>
            <v-btn type="submit">제출</v-btn>
        </form>
    </div>
</template>


<script>
export default {
    name: 'TestSignupPage',

    data () {
        return {
            id: '',
            pw: '',
        }
    },
    methods: {
        Onsubmit () {
            const { id , pw} = this
            this.$emit('submit' , { id , pw })
        }
    },
}
</script>