<template>
    <div>
      <v-container align="center" id="CommunityListField">
          <h3>게시판</h3>
         <v-data-table :headers="headerTitle"
                    :items="(boards)" :key="boards.id"
                    :items-per-page="10"
                    class="elevation-1" @click:row="handleClick">
         </v-data-table>
        </v-container>
        <v-btn class="blue" @click="checking">조회수체크</v-btn>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    name: 'CommunityListForm',
    data() {
        return {
            headerTitle: [
                {text: '게시물번호' , value: 'boardNo' , width: '25px'}, 
                    {text: '제목', value: 'title', width: '180px'},
                    {text: '작성자', value: 'id' , width: '100px'},
                     {text: '조회수' , value: 'vuecount' , width: '25px'}, 
                  
                    
            ],
            
        }
    },
    props:{
        boards:{
            type: Array,
            required: true
        }
    },
    methods: {
       handleClick(value) {
           console.log(value.boardNo)
            this.$router.push({ name: 'CommunityReadPage', params:{ boardNo: value.boardNo.toString() } })
             
            
            axios.post(`http://localhost:9999/jpaBoard/vuecount/${value.boardNo}`, )
            .then(() => {
                
            })
       },
       checking(){
        console.log(this.boards)     
    },
    }
}
</script>

<style scoped>

#CommunityListField{
    margin-right: 30%;
}

</style>