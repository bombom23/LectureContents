<template>
    <div>
        <v-container>
     <member-list-read-form v-if="member" :member="member"/>  
     <p v-else> 로딩중</p>
     <v-btn route :to="{ name: 'MemberModifyPage', params: {memberNo}}">수정하기</v-btn>
        </v-container>
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