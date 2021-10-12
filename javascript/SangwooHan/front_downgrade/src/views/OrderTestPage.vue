<template>
    <v-container>
        <table border="1">
            <tr v-for="(board, idx) in boards" v-bind:key="idx">
                <td align="center">
                    <img :src="require(`@/assets/img/${board.img}`)">
                </td>
            </tr>
        </table>

        <form @submit.prevent="onSubmit">
            <h3>구매하기</h3>
            <table>
                <tr>
                    <td>구매자 이름</td>
                    <td><input type="text" v-model="name"></td>
                </tr>
                <tr>
                    <td>가격</td>
                    <td><input type="number" v-model="cost" readonly></td>
                </tr>
            </table>

            <div>
                <button type="submit">구매하기</button>
                <router-link :to="{ name: 'Home' }">
                    취소
                </router-link>
            </div>
        </form>
    </v-container>
</template>

<script>
import axios from 'axios'


export default {
    name: 'ImgTestPage',
    data () {
        return {
            info: 'Spyder.jpg',
            boards: [
                {
                    img: 'Spyder.jpg'
                }
            ],
            name: '',
            cost: 1000000000,
           // imgPath: '',

        }
    },
    methods: {
        onSubmit () {

            const { name, cost,  } = this
            axios.post('http://localhost:9999/ordertest/order', { name,cost })
            .then( () => {
                alert ('주문성공')
            })
           
           
        },
    }
}
</script>