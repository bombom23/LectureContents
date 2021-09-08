<template>
    <div>
         <v-btn class="blue" @click="start('society')">최신정보받아오기</v-btn>
     
            <v-simple-table>
                <template v-slot:default>
                    
                    <thead>
                        <tr>
                            <p>검색</p>
                            <input v-model="search"/>
                        </tr>
                        <tr>
                            <th class="text-left">No.</th>
                            <th class="text-left">제목</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="list of lists" :key="list.title">
                            <td  v-if="list.title.includes(search)" style="color: gray">{{ list.newsNo }}</td>
                            <!-- <td><a @click="clickNews(list.newsNo)">{{ list.title }}</a></td> -->
                            <td  v-if="list.title.includes(search)" >{{ list.title }}</td>
                        </tr>
                    </tbody>
                </template>
            </v-simple-table>
       
    </div>
</template>

<script>

import {  mapState } from 'vuex'
export default {
    data(){
        return{
                search: ''
        }
    },
    computed: {
        ...mapState ({
            lists: state => state.lists
        })
    },
    methods: {
        start (category) {
            // action 수동 호출
            this.$store.dispatch('crawlFind', category)
        }
        
    },

}
</script>