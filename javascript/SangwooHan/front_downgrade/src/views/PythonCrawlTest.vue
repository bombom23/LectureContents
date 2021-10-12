<template>
    <v-container>
        <form @submit.prevent="onSubmit">
            <h3>검색</h3>
            <table>
                <tr>
                    <td>검색 키워드</td>
                    <td><input type="text" v-model="search_keyword"></td>
                </tr>
            </table>

            <div>
                <button type="submit">검색하기</button>
                <router-link :to="{ name: 'Home' }">
                    취소
                </router-link>
            </div>
        </form>

       <v-simple-table>
                <template v-slot:default>
                    <thead>
                        <tr>
                            <th class="text-left">제목</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="pylist of searchResList" :key="pylist">           
                            <td>{{ pylist }}</td>
                        </tr>
                    </tbody>
                </template>
            </v-simple-table>
    </v-container>
</template>

<script>
import axios from 'axios'
import {mapState} from 'vuex'
export default {
    name: 'ImgTestPage',
    data () {
        return {
         search_keyword: '',
         searchResList: []
        }
    },
    methods: {
        onSubmit () {

            const {search_keyword } = this
            console.log('search_keyword:' ,search_keyword)
            axios.post('http://localhost:5000/vue2pythonCrawlRequest', { search_keyword })
            .then( (res) => {
                this.searchResList = res.data
                alert ('주문성공')
            })
           
           
        },

    },
    computed: {
     ...mapState({pyLists: state => state.pyLists}) 
    },
}
</script>