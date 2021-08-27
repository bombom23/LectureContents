<template>
    <div>
        <v-container>
        <v-btn @click="check">체크</v-btn>
        
        <table>
            <tr>
                <th align="center">제목[{{notice.title}}]</th>
            </tr>
            <tr>
                <th aligen="center">작성자:{{notice.id}}</th>
            </tr>
            <tr>
                <th aligen="center">분류:{{notice.type1}}</th>
            </tr>
        </table>
       
        <h4>{{notice.text}}</h4>
        <form @submit.prevent="OnSubmit" v-if="this.$store.state.isLogin == true">
         <table >
             <tr>
                 <th>작성자</th>
                 <input v-model="ui" readonly/>
             </tr>
            <tr><th>댓글</th>
                <textarea v-model="comments"/>
                <button type="submit">등록</button>
            </tr>
        </table>
        </form>
         <table >

              <tr v-for="(item, index) in notice.authList" :key="notice.authList[index].id">
                  
                  <th width="150px">{{ item.ui}}</th>
                  
                  <td>{{item.comments}}</td>
              </tr>
              
           
          </table>
        </v-container>
    </div>
</template>

<script>
import axios from 'axios'
export default {
    name: 'NoticeReadForm',
    props: {
        notice: {
            type: Object
        }
    },
    methods:{
        check(){
            console.log(this.notice)
        },
        OnSubmit() {
             
             const {ui ,comments} =this
             axios.post(`http://localhost:9999/jpaNotice/noticeComments/${this.notice.boardNo}`, {ui , comments})
             .then( res => {
                 alert('등록성공' + res)
             }).catch( err => {
                 alert('에러' +  err.response.data.message)
             })
        }
    },
    data() {

        return{
             ui: this.$store.state.loginUser,
             comments: '',
             
        }
    }
}
</script>

<style scoped>
h4{
    height: 1000px;
}
</style>