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
        <form @submit.prevent="OnSubmit">
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
                 <v-dialog v-model="Modify" persistent max-width="500">
              <template v-slot:activator="{ on }">
               <v-btn color="primary" dark v-on="on">수정</v-btn>
               </template>
               <v-card>
               <v-card-title>
                  <span class="headline">
                      수정
                  </span>
               </v-card-title>
               <v-card-text>
               <v-container grid-list-md>
                   <v-layout wrap>
                       <v-flex xs12>
                           <v-text-field label="Comment" v-model="comments" required>
                           </v-text-field>
                       </v-flex>
                   </v-layout>
               </v-container>
               </v-card-text>
               <v-card-actions>
                   <v-spacer></v-spacer>
                   <v-btn color="teal darken-1" text @click.native="btnModifyCancleClick()">
                       취소
                   </v-btn>
                    <v-btn color="teal darken-1" text @click.native="CommemtsModify(item)">
                     확인
                   </v-btn>
               </v-card-actions>
               </v-card>
        </v-dialog>
        <v-btn @click="deleteComment(item.boardCommentNo)">
             삭제
        </v-btn>
         <v-btn @click="checkingman(item.boardCommentNo)">
             체크
        </v-btn>
              </tr>
              
           
          </table>
        </v-container>
    </div>
</template>

<script>
import axios from 'axios'
export default {
    name: 'CommunityReadForm',
    props:{
        board: {
            type: Object
        }
    },
    methods: {
        check() {
            console.log(this.board)
        },
        OnSubmit() {
                const {ui , comments } = this
                axios.post(`http://localhost:9999/jpaBoard/comment/${this.board.boardNo}`, {ui, comments})
                .then( res => {
                    alert('등록성공' +res) 
                }).catch(err => {
                    alert(err.response.data.message)
                })
        },
        CommemtsModify(item){
            const {boardCommentNo, ui} = item
                const {comments} =this
            axios.post(`http://localhost:9999/jpaBoard/ModifyComments/${this.board.boardNo}`,{ui,boardCommentNo,comments})
            .then(res =>{
                alert('수정성공'+ res) 
                this.Modify =false
            }).catch(err=>{alert(err.response.data.message)})
        },
        btnModifyCancleClick(){

            this.Modify =false
        },
        deleteComment(boardCommentNo){
               console.log(boardCommentNo)
            axios.delete(`http://localhost:9999/jpaBoard/deleteComment/${boardCommentNo}`)
            .then( res => {
                alert('삭제성공'+ res)
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
            Modify: false,
            email: '',
            password: ''
        }
    },

    
  
}
</script>

<style scoped>
h4{
    width: 1000px;
    height: 1000px;
}
</style>