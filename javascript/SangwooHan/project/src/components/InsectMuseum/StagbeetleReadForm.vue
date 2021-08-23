<template>
    <div>
        <v-container >
             <form @submit.prevent="OnSubmit">
           <v-text-field label="id" v-model="id"  readonly type="text" append-icon="mid-account">
           </v-text-field> 
            <v-text-field label="title" v-model="title" readonly type="text" append-icon="mid-account">
           </v-text-field>
             <img v-if="boardNo == 1" src="@/assets/상우/박물관[왕사슴벌레].jpg"/>
             <img v-if="boardNo == 2" src="@/assets/상우/박물관[톱사슴벌레].jpg"/>

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
                    :items="(StagbeetleCommentList)" :key="StagbeetleCommentList.id"
                    :items-per-page="10"
                    class="elevation-1" >
         </v-data-table>
         
         </v-container>
    </div>
</template>

<script>
import axios from 'axios'
import { mapActions, mapState } from 'vuex'
export default {
    name: 'StagbeetleReadForm',
    props: {
        Stagbeetle : {
            type: Object
        }
    },
    data() {
        return {
            id: this.Stagbeetle.id,
            title: this.Stagbeetle.title,
            text: this.Stagbeetle.text,
            ui: this.$store.state.loginUser,
            comments: '',
            boardNo: this.Stagbeetle.boardNo,

            headerTitle: [
                {text: '작성자', value: 'ui', width: '100px'},
                {text: '댓글', value: 'comments', width: '150px'},
              
            ]
        }
    },
    methods: {
        OnSubmit () {
            const {ui , comments} =this
            axios.post(`http://localhost:9999/stagbeetle/comments/${this.boardNo}`, {ui, comments})
            .then(res =>{
                alert('등록성공' + res)
            })
        },
        ...mapActions(['fetchStagbeetleCommentList'])
    },
    computed: {
    ...mapState(['StagbeetleCommentList'])
    },
    created(){
        this.fetchStagbeetleCommentList(this.boardNo)
    }
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