<template>
    <div>
         <v-data-table :headers="headerTitle"  
                    :items="(notices)" item-key="boardNo"
                    :items-per-page="10"
                    
                
                   class="elevation-10" @click:row="handleClick"> 
         </v-data-table>
    </div>
</template>

<script>
import axios from 'axios'
export default {
    name: 'NoticeListForm',
    props: {
        notices:{
            type: Array
        }
    },
    data() {
        return{ 
            headerTitle: [
                 {text: '번호' , value: 'boardNo' , width: '25px'}, 
                 {text: '분류' , value: 'boardNo' , width: '70px'}, 
                    {text: '제목', value: 'title', width: '180px'},
                    {text: '작성자', value: 'id' , width: '100px'},
                     {text: '조회수' , value: 'vuecount' , width: '25px'}, 
            ]
        }
    },
    methods: {
        handleClick(value){
                
            this.$router.push({name: 'NoticeReadPage' , params: { boardNo: value.boardNo.toString()}})

            axios.post(`http://localhost:9999/jpaNotice/vuecount/${value.boardNo}`)
            .then( () => {
                
            })
        }
    }
}
</script>