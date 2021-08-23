<template>
    <div>
     <member-list-read-form v-if="member" :member="member"/>  
     <p v-else> 로딩중</p>
     <v-btn route :to="{ name: 'MemberModifyPage', params: {memberNo}}">수정하기</v-btn>
     <v-dialog v-model="dialog" persistent max-width="400">
               <template v-slot:activator="{ on }">
               <v-btn color="primary" dark v-on="on">삭제</v-btn>
               </template>
               <v-card>
               <v-card-title class="headline">
                   회원 정보삭제
               </v-card-title>
               <v-card-text>
                  정말 삭제하시겠습니까?
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
    </div>
</template>

<script>
import axios from 'axios'
import { mapState, mapActions} from 'vuex'
//import router from '@/router'
import MemberListReadForm from '../../components/Management/MemberListReadForm.vue'
export default {
    name: 'MemberListReadPage',
    components: {
      MemberListReadForm
    },
    props:{
        memberNo:{
            type: String,
            required: true
        }
    },
    computed: {
        ...mapState(['member'])
        
    },
    created () {
        this.fetchMember(this.memberNo)
                .catch(err => {
                    alert(err.response.data.message)
                    this.$router.push()
                })
    },
    methods: {
        ...mapActions(['fetchMember']),
        //여백
       btn_click ($event){
                if($event.target.innerHTML == " 확인 ") {
                    alert('삭제시작...')
                    
                    const { memberNo} = this
                    axios.delete(`http://localhost:9999/jpamemberManage/${memberNo}`)
                    .then(() => {
                        alert('삭제완료')
                        this.$router.push({ name: 'MemberList'})
                    }).catch(err =>{ alert(err.response.data.message)})
                   
                }
                else{
                    alert('취소합니다.')
                    this.dialog = false;
                }
        },

        
        
    },
    data(){

        return{
            dialog: false,
           
        }
    }
}
</script>