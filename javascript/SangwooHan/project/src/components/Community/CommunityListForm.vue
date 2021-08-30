<template>
    <div>
        <h3 align="center">게시물 목록</h3>
        <body>
     
        <v-container>
            <!--
        <table border="2">
            <tr >
                <th align="center" width="50">번호</th>
                 <th align="center" width="100">제목</th>
                 <th align="center" width="150">작성자</th>
                 <th align="center" width="80">조회수</th>
                 <th align="center" width="150">시간</th>
                 
            </tr>
            <tr v-if="!boards || (Array.isArray(boards) && boards.length === 0)">
                <td colspan="7">
                    등록된글이없습니다.
                </td>
            </tr>
            
            <tr v-else v-for="board in boards" :key="board.boardNo" >
                <td align="center">{{ board.boardNo }}</td>
            
               
                <td align="left">
                    <router-link  @click.native="checking(board.boardNo)" :to="{ name: 'CommunityReadPage', 
                                    params: { boardNo: board.boardNo.toString() } }"
                                    > 
                        {{ board.title }}
                    </router-link>
                </td>
                <td align="center">{{ board.id}}</td>  
                <td align="center">{{ board.vuecount}}</td>
                <td align="center">{{ board.createDate}}</td>
            </tr>
           
        </table>
        -->
             <v-data-table :headers="headerTitle"  
                    :items="(boards)" :key="boards.id"
                    :items-per-page="10"
                    
                
                   class="elevation-10" @click:row="handleClick"> 
         </v-data-table>
        <v-btn v-if="this.$store.state.isLogin ==true" id="btn" route :to="{name: 'CommunityRegisterPage'}"><v-icon>mdi-lead-pencil</v-icon></v-btn>
        </v-container>
        </body>
    </div>
</template>

<script>
import axios from 'axios'
export default {
    name: 'CommunityListForm',
    props: {
        boards: {
            type: Array
        }
    },
    methods: {
        handleClick(value) {
            this.$router.push({ name:'CommunityReadPage' , params:{ boardNo: value.boardNo.toString() }})
            

            axios.post(`http://localhost:9999/jpaBoard/vuecount/${value.boardNo}`)
         .then(() => {
               
        })
      
        }
    },
    data() {
        return{
            headerTitle: [
                {text: '번호' , value: 'boardNo' , width: '25px'}, 
                    {text: '제목', value: 'title', width: '180px'},
                    {text: '작성자', value: 'id' , width: '100px'},
                     {text: '조회수' , value: 'vuecount' , width: '25px'}, 
            ]
        }
    }
    
    
}
</script>

<style scoped>

</style>