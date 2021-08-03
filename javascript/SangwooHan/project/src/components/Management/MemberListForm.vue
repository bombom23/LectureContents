<template>
    <div>
        <table border="1">
            <tr>
                 <th align="center" width="50">번호</th>
                 <th align="center" width="100">아이디</th>
                 <th align="center" width="70">비밀번호</th>
                 <th align="center" width="80">이름</th>
                 <th align="center" width="150">메일</th>
                 <th align="center" width="100">생일</th>
                 <th align="center" width="50">성별</th>
                  <th align="center" width="50">휴대전화</th>
                 <th align="center" width="300">주소</th>
                 <th align="center" width="60">가입일자</th>                           
            </tr>
           <tr v-if="!members || (Array.isArray(members) && members.length === 0)">
                <td colspan="10">
                    등록된 회원이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="member in members" :key="member.bulletinNo">
                        <td align="center">{{ member.bulletinNo}}</td>
                        <td align="center">{{ member.userid}}</td>
                        <td align="center">{{ member.password}}</td>
                        <td align="center">{{ member.name}}</td>
                        <td align="center">{{ member.email}}</td>
                        <td align="center">{{ member.birthday}}</td>
                        <td align="center">{{ member.gender}}</td>
                        <td align="center">{{ member.phoneNo}}</td>
                        <td align="center">{{ member.address}}</td>
                        <td align="center">{{ member.regdate}}</td>


            </tr>
        </table>
    </div>
</template>

<script>
export default {
    name: 'MemberListForm',
    props:{
        members: {
            type: Array
        }
    }
}
</script>