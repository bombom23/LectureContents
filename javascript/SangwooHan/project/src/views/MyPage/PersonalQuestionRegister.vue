<template>
    <div>
        <img src="@/assets/상우/마이페이지로고.png"/>
        <personal-question-register-form/>
    </div>
</template>

<script>
import PersonalQuestionRegisterForm from '../../components/MyPage/PersonalQuestionRegisterForm.vue'
export default {
    name: 'PersonalQuestionRegister',
  components: { PersonalQuestionRegisterForm },
    
}
</script>