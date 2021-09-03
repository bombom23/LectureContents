<template>
    <div>
       
                <table style="max-width: 500px">
            <tr>
                <td>회원번호</td>
                <td><input type="number" :value="member.memberNo" readonly></td>
            </tr>

            <tr>
                  <td>아이디</td>
                <td><input type="text" :value="member.userid" readonly></td>
            </tr>
             <tr>
                <td>비밀번호</td>
                <td><input type="text" :value="member.password" readonly></td>
            </tr>

            <tr>
                  <td>이름</td>
                <td><input type="text" :value="member.name" readonly></td>
            </tr>

            <tr>
                  <td>이메일</td>
                <td><input type="text" :value="member.email" readonly></td>
            </tr>

            <tr>
                  <td>생년월일</td>
                <td><input type="text" :value="member.birthday" readonly></td>
            </tr>

            <tr>
                  <td>휴대전화</td>
                <td><input type="text" :value="member.phoneNo" readonly></td>
            </tr>

            <tr>
                  <td>성별</td>
                <td><input type="text" :value="member.gender" readonly></td>
            </tr>

            <tr>
                  <td>주소</td>
                <td><input type="text" :value="member.address" readonly></td>
            </tr>

            <tr>
                  <td>생성일자</td>
                <td><input type="text" :value="member.createDate" readonly></td>
            </tr>
        </table>
        <h3>하하</h3>
       
    </div>
</template>

<script>
export default {
    name: 'MemberListReadForm',
    props:{
        member:{
            type: Object,
            require: true
            
        }
    },
    methods: {
       
    }
}
</script>
<style scoped>

table{
    margin-right: 500px;
    float: left;
}
</style>