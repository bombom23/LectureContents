<template>
  <div>
        <v-container>
        <v-btn @click="check">체크</v-btn>
        <table>
            <tr>
                <th align="center">제목[{{Skycow.title}}]</th>
            </tr>
            <tr>
                <th aligen="center">작성자:{{Skycow.id}}</th>
            </tr>
        </table>
       
        <h4>{{Skycow.text}}</h4>
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

              <tr v-for="(item, index) in Skycow.authList" :key="Skycow.authList[index].id">
                  
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
    name: 'SkycowReadForm',
    props:{
        Skycow: {
            type: Object
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

            axios.post(`http://localhost:9999/skycow/comments/${this.Skycow.boardNo}`, {ui, comments})
            .then(res => {
                alert('등록성공' + res)
            }).catch(err => {alert(err.response.data.message)})
        }
    }
}
</script>