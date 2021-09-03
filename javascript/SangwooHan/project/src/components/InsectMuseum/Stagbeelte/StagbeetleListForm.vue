<template>
    <div>
        <img src="@/assets/상우/한국사슴벌레.jpg"/>
  <v-data-table :headers="headerTitle"  
                    :items="(StagbeetleList)" item-key="boardNo"
                    :items-per-page="10"
                    
                
                    @click:row="handleClick"> 
         </v-data-table>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    name: 'StagbeetleListForm',
    props: {
        StagbeetleList : {
            type: Array
        }
    },
    data(){ 
        return{
            headerTitle: [
                 {text: '번호', value: 'boardNo', width: '80px'},
                {text: '제목', value: 'title', width: '200px'},
                {text: '작성자', value: 'id', width: '150px'},
                {text: '조회수', value: 'vuecount', width: '100'},
                {text: '등록일자', value: 'createDate', width: '100'},
            ]
        }
    },
    methods: {
        handleClick(value){
            console.log(value)
                    this.$router.push({ name: 'StagbeetleReadPage',params:{ boardNo: value.boardNo.toString()}})

                   axios.post(`http://localhost:9999/stagbeetle/vuecount/${value.boardNo}`)
                  .then( () => {

               })
        }
    }
}
</script>