<template>
    <div>
        
         <v-container >
             <form @submit.prevent="OnSubmit">
           <v-text-field label="id" v-model="id"  readonly type="text" append-icon="mid-account">
           </v-text-field>
           <v-text-field label="분류" v-model="type1"  readonly type="text" append-icon="mid-account">
           </v-text-field>
            
            <v-text-field label="title" v-model="title" readonly type="text" append-icon="mid-account">
           </v-text-field>
           <p>내용</p>
          <textarea name="contentText" id="contentText"  v-model="text" readonly></textarea>
           
              
                 <table v-if="this.$store.state.isLogin == true" id="commentsTable">
                    <tr>
                    <td>회원이름</td>
                    <td><input type="text" v-model="ui" readonly/></td>
                    </tr>
                    <tr>
                        <td>댓글 내용</td>
                        <textarea id="Comments" cols="30" rows="10" v-model="comments"/>
                    </tr>
                    <v-btn  type="submit">댓글달기</v-btn>
                 </table>
               </form>

            <v-data-table :headers="headerTitle"
                    :items="(NoticeCommentList)" :key="NoticeCommentList.id"
                    :items-per-page="10"
                    class="elevation-1" @click:row="handleClick">
         </v-data-table>
         </v-container>
            </div>
      
</template>

<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'

export default {
    name: 'NoticeReadForm',
    props: {
        notice: {
            type: Object
        }
    },
    data() {
            return {
                id: this.notice.id,
                type1: this.notice.type1,
                title: this.notice.title,
                text: this.notice.text,
                ui: this.notice.id,
                comments: '',
                boardNo: this.notice.boardNo,

                headerTitle: [
                    {text:'작성자' , value: 'ui', width: '50px' },
                     {text:'댓글' , value: 'comments', width: '200px' }
                ]
            }
    },
    methods: {
        OnSubmit() {
                    const {ui , comments } =this
                axios.put(`http://localhost:9999/jpaNotice/noticeComments/${this.boardNo}` , {ui , comments})
                .then(res => {
                    alert('등록성공' + res)
                }).catch(err => {alert(err.response.data.message)})
        },
        ...mapActions(['fetchNoticeCommentList'])
    },
    computed: {
        ...mapState(['NoticeCommentList'])
    },
    created() {
        this.fetchNoticeCommentList(this.boardNo)
    },
}
</script>









<style scoped>
#contentText{width:1000px; height:500px; border: 1px;
border-style:solid;
/*   resize:none; */
/*   resize: horizontal; */
 resize: vertical;
}
</style>