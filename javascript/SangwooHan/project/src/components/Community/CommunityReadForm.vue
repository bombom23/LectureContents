<template>
    <div>
        <v-container>
        <v-btn @click="check">체크</v-btn>
        <table>
            <tr>
                <th align="center">제목[{{board.title}}]</th>
            </tr>
            <tr>
                <th aligen="center">작성자:{{board.id}}</th>
            </tr>
        </table>
       
        <h4>{{board.text}}</h4>
        <form v-if="commentBox ==1 && this.$store.state.User !=null" @submit.prevent="OnSubmit">
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

              <tr v-for="(item, index) in board.authList" :key="board.authList[index].id">
                  
                  <th width="150px">{{ item.ui}}</th>
                  
                  <td>{{item.comments}}</td>
                  <td>{{item.boardCommentNo}}</td>
                <td v-if="Modify == item.boardCommentNo">
                    <textarea  v-model="comments" cols="1" rows="1"/><v-btn depressed @click="CommemtsModify(item)">수정완료</v-btn><v-btn depressed @click="ModifyOFF">취소</v-btn>
                </td>
        <td>
        <v-btn width="10px" depressed v-if="item.ui == User"  @click="deleteComment(item.boardCommentNo)">
            <v-icon>mdi-alpha-x-box-outline</v-icon>
        </v-btn>
        <v-btn depressed v-if="item.ui == User"   @click="ModifyOn(item.boardCommentNo)">
             <v-icon>mdi-eraser</v-icon>
        </v-btn>
        </td>
        <!--
        <td>
         <v-btn @click="checkingman(item.boardCommentNo)">
             체크
        </v-btn>
        </td>
        -->
              </tr>
              
           
          </table>
        </v-container>
    </div>
</template>

<script>
import axios from 'axios'
import { mapState } from 'vuex'
export default {
    name: 'CommunityReadForm',
    props:{
        board: {
            type: Object
        }
    },
    computed:{
       ...mapState(['User'])
    },
    methods: {
        check() {
            console.log(this.board)
           },

        ModifyOn(boardCommentNo){

                this.commentBox = 0
                this.Modify = boardCommentNo

                                },

        ModifyOFF(){

                this.commentBox = 1
                this.Modify = null

                   },

        OnSubmit() {

                const {ui , comments } = this
                axios.post(`http://localhost:9999/jpaBoard/comment/${this.board.boardNo}`, {ui, comments})
                .then( res => {
                    alert('등록성공' +res) 
                    this.$router.go()
                }).catch(err => {
                    alert(err.response.data.message)
                })

                  },

        CommemtsModify(item){

            console.log(item)
            const {boardCommentNo, ui, regDate} = item
                const {comments} =this
            axios.post(`http://localhost:9999/jpaBoard/ModifyComments/${this.board.boardNo}`,{ui,boardCommentNo,comments,regDate})
            .then(res =>{
                alert('수정성공'+ res) 
                this.$router.go()
                this.commentBox = 1
            }).catch(err=>{alert(err.response.data.message)})
            

                            },
        
        deleteComment(boardCommentNo){
            
               console.log(boardCommentNo)
            axios.delete(`http://localhost:9999/jpaBoard/deleteComment/${boardCommentNo}`)
            .then( res => {
                alert('삭제성공'+ res)
                this.$router.go()
                         }).catch(err=>{alert(err.response.data.message)})

                                     },

        checkingman(value) {
                console.log(value)
                          }
    },
    data() {

        return {

            comments: '',
            ui: this.$store.state.User,
            Modify: '',
            commentBox: 1

               }
           },

    
  
}
</script>

<style scoped>
h4{
    width: 1000px;
    height: 700px;
}
</style>