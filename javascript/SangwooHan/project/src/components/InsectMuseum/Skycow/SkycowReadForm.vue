<template>
  <div>
        <v-container>
       <v-btn @click="checking">확인</v-btn>
        <table>
            <tr>
                <th align="center">제목[{{Skycow.title}}]</th>
            </tr>
            <tr>
                <th aligen="center">작성자:{{Skycow.id}}</th>
            </tr>
        </table>
        <img v-if="Skycow.title == '루리하늘소'" src="@/assets/상우/박물관/박물관[루리하늘소].jpg"/>
        <img v-if="Skycow.title == '고운산하늘소'" src="@/assets/상우/박물관/박물관[고운산하늘소].jpg"/>
        <img v-if="Skycow.title == '무늬소주홍하늘소'" src="@/assets/상우/박물관/박물관[무늬소주홍하늘소].jpg"/>
        <img v-if="Skycow.title == '애호랑하늘소'" src="@/assets/상우/박물관/박물관[애호랑하늘소].jpg"/>
        <img v-if="Skycow.title == '우리목하늘소'" src="@/assets/상우/박물관/박물관[우리목하늘소].jpg"/>
        <img v-if="Skycow.title == '노란팔점긴하늘소'" src="@/assets/상우/박물관/박물관[노란팔점긴하늘소1].jpg"/>
        <img v-if="Skycow.title == '노란팔점긴하늘소'" src="@/assets/상우/박물관/박물관[노란팔점긴하늘소2].jpg"/>
        <img v-if="Skycow.title == '봄산하늘소'" src="@/assets/상우/박물관/박물관[봄산하늘소].jpg"/>
        <img v-if="Skycow.title == '장수하늘소'" src="@/assets/상우/박물관/박물관[장수하늘소1].jpg"/>
        <img v-if="Skycow.title == '장수하늘소'" src="@/assets/상우/박물관/박물관[장수하늘소2].jpg"/>
        <p>{{Skycow.text}}</p>
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

              <tr v-for="(item, index) in Skycow.authList" :key="Skycow.authList[index].id">
                  
                  <th width="150px">{{ item.ui}}</th>
                  
                  <td>{{item.comments}}</td>
                   <td v-if="Modify == item.skycowCommentsNo">
                    <textarea  v-model="comments" cols="1" rows="1"/><v-btn depressed @click="CommemtsModify(item)">수정완료</v-btn><v-btn depressed @click="ModifyOFF">취소</v-btn>
                </td>
        <td>
        <v-btn width="10px" depressed v-if="item.ui == User"  @click="deleteComment(item.skycowCommentsNo)">
            <v-icon>mdi-alpha-x-box-outline</v-icon>
        </v-btn>
        <v-btn depressed v-if="item.ui == User"   @click="ModifyOn(item.skycowCommentsNo)">
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
    name: 'SkycowReadForm',
    props:{
        Skycow: {
            type: Object
        }
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
        ModifyOn(skycowCommentsNo){
                this.commentBox = 0
                this.Modify = skycowCommentsNo
        },
        ModifyOFF(){
                this.commentBox = 1
                this.Modify = null
        },

                                CommemtsModify(item){

            console.log(item)
            const {skycowCommentsNo, ui, regDate} = item
                const {comments} =this
            axios.post(`http://localhost:9999/skycow/ModifyComments/${this.Skycow.boardNo}`,{ui,skycowCommentsNo,comments,regDate})
            .then(res =>{
                alert('수정성공'+ res) 
                this.$router.go()
                this.commentBox = 1
            }).catch(err=>{alert(err.response.data.message)})
            

                              },

                              deleteComment(skycowCommentsNo){
            
           
            axios.delete(`http://localhost:9999/skycow/deleteComment/${skycowCommentsNo}`)
            .then( res => {
                alert('삭제성공'+ res)
                this.$router.go()
                         }).catch(err=>{alert(err.response.data.message)})

                                     },



        checking(){
                console.log(this.Skycow)
        },
        OnSubmit() {
            const {ui , comments} = this

            axios.post(`http://localhost:9999/skycow/comments/${this.Skycow.boardNo}`, {ui, comments})
            .then(res => {
                alert('등록성공' + res)
                this.$router.go()
            }).catch(err => {alert(err.response.data.message)})
        },
        
    }
}
</script>