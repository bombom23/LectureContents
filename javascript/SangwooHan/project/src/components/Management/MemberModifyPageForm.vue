<template>
    <div>
        <form @submit.prevent="onSubmit">
            <table>
                  <tr>
                <td>회원번호</td>
                <td><input type="text" v-model="memberNo" readonly></td>
            </tr>

            <tr>
                  <td>아이디</td>
                <td><input type="text" v-model="userid" ></td>
            </tr>
            <tr>
                  <td>비밀번호</td>
                <td><input type="text" v-model="password" ></td>
            </tr>

            <tr>
                  <td>이름</td>
                <td><input type="text" v-model="name" readonly></td>
            </tr>

            <tr>
                  <td>이메일</td>
                <td><input type="text" v-model="email"></td>
            </tr>

            <tr>
                  <td>생년월일</td>
                <td><input type="text" v-model="birthday" readonly></td>
            </tr>

            <tr>
                  <td>휴대전화</td>
                <td><input type="text" v-model="phoneNo"></td>
            </tr>

            <tr>
                  <td>성별</td>
                <td><input type="text" v-model="gender" readonly></td>
            </tr>

            <tr>
                  <td>주소</td>
                <td><input type="text" v-model="address"></td>
            </tr>

            <tr>
                  <td>생성일자</td>
                <td><input type="text" v-model="createDate" readonly></td>
            </tr>
            </table>
            <v-btn type="submit">정보변경하기</v-btn>
            <v-btn @click="check">정보확인하기</v-btn>
        </form>
    </div>
</template>

<script>
export default {
    name: 'MemberModifyPageForm',
    props: {
        member: {
            type: Object,
            require: true
        }
    },
    data(){
        return{
            memberNo: this.member.memberNo,
            userid: '',
            password: this.member.password,
            name: this.member.name,
            email: '',
            birthday: this.member.birthday,
            phoneNo: '',
            gender: this.member.gender,
            address: '',
            createDate: this.member.createDate
            

        }
    },
    methods: {
            onSubmit() {

                const {memberNo, userid,password ,name, email , birthday, phoneNo ,gender,address, createDate} = this
                this.$emit('submit', {memberNo, userid,password ,name, email , birthday, phoneNo ,gender,address, createDate})
            },
            check(){
                console.log(this.memberNo)
            }
    },
    created () {
     

    }
    

}
</script>