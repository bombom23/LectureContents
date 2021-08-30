<template>
    <div>
        <v-container>
        <v-btn @click="check">체크</v-btn>
        <table>
            <tr>
                <th align="center">제목[{{Dragonfly.title}}]</th>
            </tr>
            <tr>
                <th aligen="center">작성자:{{Dragonfly.id}}</th>
            </tr>
        </table>
        <img v-if="Dragonfly.title == '도깨비왕잠자리'" src="@/assets/상우/박물관/박물관[도깨비왕잠자리].jpg"/>
        <img v-if="Dragonfly.title == '고추잠자리'" src="@/assets/상우/박물관/박물관[고추잠자리].jpg"/>
        <img v-if="Dragonfly.title == '측범잠자리'" src="@/assets/상우/박물관/박물관[측범잠자리1].jpg"/>
        <img v-if="Dragonfly.title == '측범잠자리'" src="@/assets/상우/박물관/박물관[측범잠자리2].jpg"/>
        <img v-if="Dragonfly.title == '측범잠자리'" src="@/assets/상우/박물관/박물관[측범잠자리3].jpg"/>
        <img v-if="Dragonfly.title == '배치레잠자리'" src="@/assets/상우/박물관/박물관[배치레잠자리1].jpg"/>
        <img v-if="Dragonfly.title == '배치레잠자리'" src="@/assets/상우/박물관/박물관[배치레잠자리2].jpg"/>
        <img v-if="Dragonfly.title == '나비잠자리'" src="@/assets/상우/박물관/박물관[나비잠자리1].jpg"/>
        <img v-if="Dragonfly.title == '나비잠자리'" src="@/assets/상우/박물관/박물관[나비잠자리2].jpg"/>
        <img v-if="Dragonfly.title == '나비잠자리'" src="@/assets/상우/박물관/박물관[나비잠자리3].jpg"/>
        <img v-if="Dragonfly.title == '장수잠자리'" src="@/assets/상우/박물관/박물관[장수잠자리].jpg"/>
        <p>{{Dragonfly.text}}</p>
        <form @submit.prevent="OnSubmit" v-if="commentBox ==1 && this.$store.state.User !=null">
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

              <tr v-for="(item, index) in Dragonfly.authList" :key="Dragonfly.authList[index].id">
                  
                  <th width="150px">{{ item.ui}}</th>
                  
                  <td>{{item.comments}}</td>
                   <td v-if="Modify == item.dragonflyCommentNo">
                    <textarea  v-model="comments" cols="1" rows="1"/><v-btn depressed @click="CommemtsModify(item)">수정완료</v-btn><v-btn depressed @click="ModifyOFF">취소</v-btn>
                </td>
        <td>
        <v-btn width="10px" depressed v-if="item.ui == User"  @click="deleteComment(item.dragonflyCommentNo)">
            <v-icon>mdi-alpha-x-box-outline</v-icon>
        </v-btn>
        <v-btn depressed v-if="item.ui == User"   @click="ModifyOn(item.dragonflyCommentNo)">
             <v-icon>mdi-eraser</v-icon>
        </v-btn>
        </td>
              </tr>
              
           
          </table>
        </v-container>
    </div>
</template>

<script>
import axios from 'axios'
import { mapState } from 'vuex'
export default {
    name: 'DragonflyReadPage',
    props: {
        Dragonfly: {
            type: Object,

        },
        
    },
    computed:{
            ...mapState(['User'])
        },
    data() {
        return{
            ui: this.$store.state.User,
            comments: '',
            Modify: '',
            commentBox: 1

        }
    },
    methods:{
        check(){console.log(this.Dragonfly)},
        ModifyOn(dragonflyCommentNo){
                    this.commentBox = 0
                this.Modify = dragonflyCommentNo
        },
        ModifyOFF(){
                this.commentBox = 1
                this.Modify = null
        },

                        CommemtsModify(item){

            console.log(item)
            const {dragonflyCommentNo, ui, regDate} = item
                const {comments} =this
            axios.post(`http://localhost:9999/dragonfly/ModifyComments/${this.Dragonfly.boardNo}`,{ui,dragonflyCommentNo,comments,regDate})
            .then(res =>{
                alert('수정성공'+ res) 
                this.$router.go()
                this.commentBox = 1
            }).catch(err=>{alert(err.response.data.message)})
            

                              },

                              deleteComment(dragonflyCommentNo){
            
             
            axios.delete(`http://localhost:9999/dragonfly/deleteComment/${dragonflyCommentNo}`)
            .then( res => {
                alert('삭제성공'+ res)
                this.$router.go()
                         }).catch(err=>{alert(err.response.data.message)})

                                     },




        OnSubmit() {
            const {ui , comments} = this

            axios.post(`http://localhost:9999/dragonfly/comments/${this.Dragonfly.boardNo}`, {ui, comments})
            .then(res => {
                alert('등록성공' + res)
                this.$router.go()
            }).catch(err => {alert(err.response.data.message)})
        }
    }
}
</script>