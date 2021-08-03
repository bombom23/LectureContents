<template>
    <form @submit.prevent="onSubmut">
        <div>
        <h3>jpaDB를이용한 회원가입 폼</h3>
        <v-text-field v-model="id"
        label="아이디" type="text" prepend-icon="mdi=account">
        </v-text-field>
          <v-text-field v-model="pw"
        label="비밀번호" type="password" prepend-icon="mdi=lock">
        </v-text-field>
            <v-btn class="blue" type="submut">회원가입</v-btn>
        </div>
    </form>
</template>

<script>
export default {
    name: 'JpaDbRegisterForm',
     data() {
         return {
             id: '',
             pw: '',
         }
     },
     methods: {
         onSubmut() {
             const { id , pw } = this
             this.$emit('submit', {id, pw })
         }
     }
}
</script>