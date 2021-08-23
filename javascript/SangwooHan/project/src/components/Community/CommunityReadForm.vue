<template>
        <div>
            <v-container>
                <form @submit.prevent="onSubmit">
                <table>
                    <tr>
                        <td>게시글번호</td>
                        <td><input type="text" v-model="boardNo"/></td>
                    </tr>
                    <tr>
                        <td>작성자</td>
                        <td><input type="text" v-model="id" readonly/></td> 
                    </tr>
                    <tr>
                        <td>제목</td>
                        <td><input type="text" v-model="title" readonly/></td> 
                    </tr>
                     <tr>
                        <td>내용</td>
                      <textarea  id="contentText" cols="30" rows="10" v-model="text" readonly></textarea>
                    </tr>
                </table>
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
                    <!--v 카드-->
                      <v-dialog v-model="dialog" persistent max-width="400">
               <template v-if="this.$store.state.loginUser == this.id" v-slot:activator="{ on }">
               <v-btn  color="primary" dark v-on="on">삭제</v-btn>
               </template>
               <v-card>
               <v-card-title class="headline">
                   게시글 삭제
               </v-card-title>
               <v-card-text>
                  한번삭제하면 되돌릴방법이 없습니다 그래도 삭제하시겠습니까?
               </v-card-text>
               <v-card-actions>
                   <v-spacer></v-spacer>
                   <v-btn color="teal darken-1" text @click.native="btn_click($event)">
                       취소
                   </v-btn>
                    <v-btn color="teal darken-1" text @click.native="btn_click($event)">
                     확인
                   </v-btn>
               </v-card-actions>
               </v-card>
           </v-dialog>
           <!-- v카드 끝나는곳-->
                    <v-btn v-if="this.$store.state.loginUser == this.id" route :to="{name: 'CommunityModifyPage', params:{ board }}" >글수정하기</v-btn>
                   
                </table>
                </form>
                <v-data-table :headers="CommentsHeader"
                    :items="commentsList" 
                    :items-per-page="10"
                    class="elevation-1" >
         </v-data-table>
       
         <!--// -->
            </v-container>

               
        </div>
        
</template>

<script>

import axios from 'axios'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'CommunityReadForm',
    props:  {
        board: {
            type: Object,
            required: true
               },
            },
    
    data(){
            return{
                ui: this.$store.state.loginUser,
                comments: '',
                id: this.board.id,
                title: this.board.title,
                text: this.board.text,
                boardNo: this.board.boardNo,
                createDate: this.board.createDate,
                //구분
                CommentsHeader: [
                    {text: '작성자' , value: 'ui' , width: '25px'},
                    {text: '댓글' , value: 'comments' , width: '25px'}
                                ],
                //구분                
                dialog: false
                 }
          },
    
    
   
      
    computed: {
          ...mapState(['commentsList'])
      },
      
    methods: {
            ...mapActions(['fetchCommentsList']),

        onSubmit () {
            const {id, title, text , ui, comments,createDate } = this
            axios.put(`http://localhost:9999/jpaBoard/${this.boardNo}`,{ id, title, text , ui, comments,createDate})
            .then(res => {
                alert('동작성공'+ res)   
                this.$router.push({ name: 'CommunityListPage'})
                        })

            .catch(err =>{
                alert(err.response.data.message)
                         })
                    },
                    
    Delete(){
        console.log(this.board)
            },

    btn_click ($event){
                if($event.target.innerHTML == " 확인 ") {
                    alert('삭제시작...')
                    const { boardNo} = this
                    axios.delete(`http://localhost:9999/jpaBoard/${boardNo}`)
                    .then(() => {
                        alert('삭제완료')
                        this.$router.push({ name: 'CommunityListPage'})
                    })
                    .catch(err =>{ alert(err.response.data.message)})
                                                    }
                else{
                    alert('취소합니다.')
                    this.dialog = false;
                    }

                     },
           },
           
          created() {
              console.log('리드페이지에서 보내는 boardNo: ' +this.boardNo)
              this.fetchCommentsList(this.boardNo)
              .catch(err => {
                  alert(err.response.data.message)
              })
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
#Comments{
    width: 500px; height: 50px;

    resize: vertical;
}
#commentsTable{
    border: 1px;
border-style:solid;
}
</style>