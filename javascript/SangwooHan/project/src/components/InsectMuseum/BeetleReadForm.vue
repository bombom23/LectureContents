<template>
    <div>
        <v-container>
          <v-text-field label="id" v-model="id"  readonly type="text" append-icon="mid-account">
           </v-text-field> 
            <v-text-field label="title" v-model="title" readonly type="text" append-icon="mid-account">
               
           </v-text-field>
            <img v-if="boardNo == 1" src="@/assets/상우/박물관[장수풍뎅이].jpg"/>
           <p>내용</p>
          <textarea name="contentText" id="contentText"  v-model="text" readonly></textarea>
            <form @submit.prevent="OnSubmit">
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
                 <v-data-table :headers="headerTitle"
                    :items="(BeetleCommentList)" :key="BeetleCommentList.id"
                    :items-per-page="10"
                    class="elevation-1" >
         </v-data-table>
            </form>
        </v-container>
    </div>
</template>

<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
export default {
    name: 'beetbleReadForm',
    props: {
        Beetle:{
            type: Object,
            required: true
        }
    },
    data() {
        return{
                id: this.Beetle.id,
                title: this.Beetle.title,
                text: this.Beetle.text,
                boardNo: this.Beetle.boardNo,
                ui: this.$store.state.loginUser,
                comments: '',

                headerTitle: [
                     {text: '작성자', value: 'ui', width: '100px'},
                {text: '댓글', value: 'comments', width: '150px'},
                ]

        }
    },
    methods: {
        OnSubmit() {

                const {ui , comments } = this
                
                axios.post(`http://localhost:9999/beetle/comments/${this.boardNo}`, {ui ,comments })
                .then(res => {
                    alert('동작성공' + res)
                }).catch(err => {alert(err.response.data.message)})
            
        },
        ...mapActions(['fetchBeetleCommentList'])
    },
    computed: {
        ...mapState(['BeetleCommentList'])
    },
    created(){
        this.fetchBeetleCommentList(this.boardNo)
    }
    
}
</script>

<style scoped>
#contentText{width:1300px; height:1000px; border: 1px;
border-style:solid;
/*   resize:none; */
/*   resize: horizontal; */
 resize: vertical;
}
</style>