<template>
    <div>
        <v-container id="BeetlesList">
           
        <v-data-table :headers="headerTitle"  
                    :items="(BeetleList)" :key="BeetleList.id"
                    :items-per-page="10"
                    
                
                   class="elevation-10" @click:row="handleClick"> 
         </v-data-table>
        </v-container>
    </div>
</template>

<script>
import axios from 'axios'
export default {
    name: 'BeetleListForm',
    props: {
        BeetleList: {
            type: Array
        }
    },
    data(){
        return {
            headerTitle: [
              {text: '번호' , value: 'boardNo' , width: '25px'}, 
                    {text: '제목', value: 'title', width: '180px'},
                    {text: '작성자', value: 'id' , width: '100px'},
                     {text: '조회수' , value: 'vuecount' , width: '25px'}, 
            ]
        }
    },
    methods: {
        
        handleClick(value) {
            console.log(value)
            this.$router.push({ name:'BeetleReadPage' , params:{ boardNo: value.boardNo.toString() }})

            
           axios.post(`http://localhost:9999/beetle/vuecount/${value.boardNo}`)
           .then(() => {
               
           })
        }
        
    }
}
</script>

<style scoped>
#BeetlesList{
    margin-right: 25%;
}
</style>