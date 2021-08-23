<template>
    <div class="slide-3d">
        <v-spacer></v-spacer>
        
            <swiper class="swiper" :options="swiperOption" >
                <swiper-slide><img src="@/assets/상우/장수풍뎅이홈화면.jpg"/></swiper-slide>
                <swiper-slide><img src="@/assets/상우/톱사슴벌레.jpg"/></swiper-slide>
                <swiper-slide><img src="@/assets/상우/자연사진1.jpg"/></swiper-slide>
                <swiper-slide><img src="@/assets/상우/나비유충1.jpg"/></swiper-slide>
                
               
                
                
                <div class="swiper-pagination" slot="pagination">
                </div>
            </swiper>
       
    </div>
</template>

<script>
import { Swiper, SwiperSlide } from 'vue-awesome-swiper'
import 'swiper/css/swiper.css'
export default {
    name: 'AwesomeSwiperTestPage',
    components: {
        Swiper,
        SwiperSlide
    },
    data () {
        return {
            swiperOption: {
                loop: true,
                
                grabCursor: true,
                centeredSlides: true,
                slidesPerView: 'auto',
                
                coverflowEffect: {
                    rotate: 0,
                    stretch: 0,
                    depth: 0,
                    modifier: 0,
                    slideShadows: false
                },
                pagination: {
                    el: '.swiper-pagination',
                    dynamicBullets: true
                },
                autoplay: {
                    delay: 3000
                }
            },
           
        
        }
    }
}
</script>

<style lang="scss" scoped>
.slide-3d {
    width: 100%;
    height: 710px;
    padding-top: 50px;
    padding-bottom: 50px;
}
.swiper-slide {
        display: flex;
        justify-content: center;
        align-items: center;
        width: 700px;
        height: 700px;
       
        
        background-position: center;
        background-size: cover;
    }
</style>
