<template>
    <div>
        <v-container>
            <h3>공지사항</h3>
        <v-data-table :headers="headerTitle"  
                    :items="(notices)" :key="notices.id"
                    :items-per-page="10"
                    
                    class="elevation-10" @click:row="handleClick">
         </v-data-table>
        </v-container>
    </div>
</template>

<script>
import axios from 'axios'
export default {
    name: 'NoticeListForm',
    props: {
        notices: {
            type: Array
        }
    },
    data(){
        return {
            headerTitle: [
              {text: '공지번호' , value: 'boardNo' , width: '25px'}, 
              {text: '분류', value: 'type1', width: '100px'},
                    {text: '제목', value: 'title', width: '180px'},
                    {text: '작성자', value: 'id' , width: '100px'},
                     {text: '조회수' , value: 'vuecount' , width: '25px'}, 
            ]
        }
    },
    methods: {
        handleClick(value) {
            console.log(value)
            this.$router.push({ name:'NoticeReadPage' , params:{ boardNo: value.boardNo.toString() }})

            
           axios.post(`http://localhost:9999/jpaNotice/vuecount/${value.boardNo}`)
           .then(() => {
               
           })
        }
    }
}
</script>