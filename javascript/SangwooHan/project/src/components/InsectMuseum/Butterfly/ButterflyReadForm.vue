<template>
    <div>
        <v-container>
        <v-btn @click="check">체크</v-btn>
        <table>
            <tr>
                <th align="center">제목[{{Butterfly.title}}]</th>
            </tr>
            <tr>
                <th aligen="center">작성자:{{Butterfly.id}}</th>
            </tr>
        </table>
       
        <h4>{{Butterfly.text}}</h4>
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

              <tr v-for="(item, index) in Butterfly.authList" :key="Butterfly.authList[index].id">
                  
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
    name: 'ButterflyReadPage',
    props: {
        Butterfly: {
            type: Object,

        }
    },
    data() {
        return{
            ui: this.$store.state.loginUser,
            comments: '',

        }
    },
    methods:{
        OnSubmit() {
            const {ui , comments} = this

            axios.post(`http://localhost:9999/butterfly/comments/${this.Butterfly.boardNo}`, {ui, comments})
            .then(res => {
                alert('등록성공' + res)
            }).catch(err => {alert(err.response.data.message)})
        }
    }
}
</script>