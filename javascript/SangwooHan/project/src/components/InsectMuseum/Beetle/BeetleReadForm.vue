<template>
    <div>
        <v-container>
        <v-btn @click="check">체크</v-btn>
        <table>
            <tr>
                <th align="center">제목[{{Beetle.title}}]</th>
            </tr>
            <tr>
                <th aligen="center">작성자:{{Beetle.id}}</th>
            </tr>
        </table>
       
        <h4>{{Beetle.text}}</h4>
        <form @submit.prevent="OnSubmit" v-if="this.$store.state.isLogin ==true">
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

              <tr v-for="(item, index) in Beetle.authList" :key="Beetle.authList[index].id">
                  
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
    name: 'BeetleReadForm',
    props: {
        Beetle: {
            type: Object
        }
    },
    data(){
        return{
            ui: this.$store.state.loginUser,
            comments: '',
        }
    },
    methods: {
        OnSubmit() {
                const {ui ,comments } = this
                axios.post(`http://localhost:9999/beetle/comments/${this.Beetle.boardNo}`, {ui, comments})
                .then( res=> {
                    alert('등록성공'+ res)
                }).catch(err=> {
                    alert(err.response.data.message)
                })
        }
    }
}
</script>

<style scoped>
h4{
    height: 1000px;
}
</style>