<template>
    <v-container>
        <v-row>
            <v-col v-for="image in images" :key="image" class="d-flex child-flex" cols="4">
                
            <a @click="haha"><v-img :src="image" aspect-ratio="1" class="gery lighten-2">
               <span>sdsd</span>
                <template v-slot:placeholder>
                    
                <v-row class="fill-height ma-0" align="center" justify="center">
                    
                <v-progress-circular indeterminate color="grey lighten-5">
                    
                </v-progress-circular>
               
                </v-row>
                </template>
            </v-img></a>
            </v-col>
        </v-row>
    </v-container>
</template>

<script>
export default {
    name: 'ImageGalleryTestPage',
    data () {
        return {
            images: [
                'https://miro.medium.com/max/768/1*8nyFLuZUdtMqWyu7H8glOg.png',
                'https://flutter-kr.io/images/flutter-logo-sharing.png',
                'https://d2.naver.com/content/images/2020/12/1228.png',
                'https://media.vlpt.us/post-images/katanazero86/aba9c930-4af7-11ea-b431-d56bc1d096a4/vuejs-tutorial2d2a853c-aa2f-44b0-80df-933b495f77f8.png',
                'https://media.vlpt.us/images/devpark/post/3f691ef0-d5de-4fc2-81d0-951d8ed8a36d/Ekran-Resmi-2019-11-18-18.08.13.png'
            ]
        }
    }
}
</script>