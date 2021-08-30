<template>
    <div>
        <img src="@/assets/상우/한국장수풍뎅이.jpg"/>
            <v-data-table
            :headers="headerTitles"
            :items="BeetleList"
            :items-per-page="10"
             @click:row="handleClick">
            </v-data-table>
            
    </div>
</template>

<script>
import axios from 'axios'
export default {
    name: 'BeetleListForm',
    props: {
        BeetleList: {
            tpye: Object
        }
    },
    data() {
        return{
            headerTitles: [
                {text: '번호', value: 'boardNo', width: '80px'},
                {text: '제목', value: 'title', width: '200px'},
                {text: '작성자', value: 'id', width: '150px'},
                {text: '조회수', value: 'vuecount', width: '100'},
                {text: '등록일시', value: 'createDate', width: '100'},
            ]
        }
    },
    methods: {
        handleClick(value){
            this.$router.push({ name: 'BeetleReadPage', params: { boardNo: value.boardNo.toString()}})

            axios.post(`http://localhost:9999/beetle/vuecount/${value.boardNo}`)
            .then( () => {

            })
        }
    }
}
</script>