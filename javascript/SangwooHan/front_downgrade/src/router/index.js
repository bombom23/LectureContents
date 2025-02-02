import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Test from '../views/Test.vue'
import Todo from '../views/Todo.vue'
import Homework from '../views/Homework.vue'

// board
import BoardListPage from '@/views/BoardListPage.vue'
import BoardRegisterPage from '@/views/BoardRegisterPage.vue'
import BoardReadPage from '@/views/BoardReadPage.vue'
import BoardModifyPage from '@/views/BoardModifyPage.vue'

// game
import GameMemberRegisterPage from '@/views/GameMemberRegisterPage.vue'

//개인플젝 연동
import MarketRegisterPage from '@/views/MarketRegisterPage.vue'

// 삼목
import Concave from '@/views/Concave.vue'
// product
import ProductListPage from '@/views/ProductListPage.vue'
import ProductRegisterPage from '@/views/ProductRegisterPage.vue'
import ProductReadPage from '@/views/ProductReadPage.vue'
import ProductModifyPage from '@/views/ProductModifyPage.vue'

// monster
import MonsterListPage from '@/views/MonsterListPage.vue'
import MonsterRegisterPage from '@/views/MonsterRegisterPage.vue'
import MonsterReadPage from '@/views/MonsterReadPage.vue'
import MonsterModifyPage from  '@/views/MonsterModifyPage.vue'

//EventBus
import EventBusTestPage from '@/views/EventBusTestPage.vue'

//던전 페이지
import DungeonListPage from '@/views/DungeonListPage.vue'


//숙제 페이지
import prob89Page from '../views/prob89Page.vue'
import springCon from '../views/springCon.vue'


// 성적관리
import  ScoreManagePage from '../views/ScoreManagePage.vue'

//크롤링

import DaumNewsCrawlerPage from '@/views/DaumNewsCrawlerPage.vue'

//  언네임드 슬롯 페이지
import UnNamedSlotTestPage from '@/views/UnNamedSlotTestPage.vue'
// 네임드 슬롯 페이지
import NamedSlotTestPage from '@/views/NamedSlotTestPage.vue'
// 스코프드 
import ScopedSlotTestPage from '@/views/ScopedSlotTestPage.vue'
// v-slot
import RecentSlotTestPage from '@/views/RecentSlotTestPage.vue'


// Materialize
import MaterialzeTestPage from '@/views/MaterialzeTestPage.vue'
import MaterializeGridTestPage from '@/views/MaterializeGridTestPage.vue'
import VuetifyAllInOneTestPage from '@/views/VuetifyAllInOneTestPage.vue'

// jpaDB 연동 회원가입 테스트
import JpaDbSignupPage from '@/views/JpaDbSignupPage.vue'

//coverflow
import CoverflowTestPage from '@/views/CoverflowTestPage.vue'
import AwesomeSwiperTestPage from '@/views/AwesomeSwiperTestPage.vue'

//likesFacebook
//import LikesFacebookPage from '@/views/LikesFacebookPage.vue'
//이미지 갤러리
import ImageGalleryTestPage from '@/views/ImageGalleryTestPage.vue'
//캘린더
import CalendarTestPage from '@/views/CalendarTestPage.vue'

//JPA Test Page
import MemberJoinColumnTestPage from '@/views/MemberJoinColumnTestPage.vue'

// 암호화 비밀번호 로그인
import VuetifyMemberLoinPage from '@/views/VuetifyMemberLoinPage.vue'

// test
import TestSignupPage from '@/views/TestSignupPage.vue'

//파일업로드 
import FileUploadPage from '@/views/FileUploadPage.vue'

// 파이썬 

import PythonLoginTestPage from '@/views/PythonLoginTestPage'

// 카카오 로그인
import kakaoLoginPage from  '@/views/kakaoLoginPage'
//오더 테스트 페이지

import OrderTestPage from '@/views/OrderTestPage'
//파이선 크롤링
import PythonCrawlTest from '@/views/PythonCrawlTest'
Vue.use(VueRouter)




const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/test',
    name: 'Test',
    component: Test
  },
  {
    path: '/todo',
    name: 'Todo',
    component: Todo
  },
  {
    path: '/homework',
    name: 'Homework',
    component: Homework
  },
  {
    path: '/board',
    name: 'BoardListPage',
    components: {
      default: BoardListPage
    }
  },
  {
    path: '/board/create',
    name: 'BoardRegisterPage',
    components: {
      default: BoardRegisterPage
    }
  },
  {
    path: '/board/:boardNo',
    name: 'BoardReadPage',
    components: {
      default: BoardReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/member/create',
    name: 'GameMemberRegisterPage',
    components: {
      default: GameMemberRegisterPage
    }
  },
  {
    path: '/market/create',
    name: 'MarketRegisterPage',
    components: {
      default: MarketRegisterPage
    }
  },
  {
    path: '/board/:boardNo/edit',
    name: 'BoardModifyPage',
    components: {
      default: BoardModifyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/concave',
    name: 'Concave',
    components: {
      default: Concave
    }
  }, 
  {
    path: '/product',
    name: 'ProductListPage',
    components: {
      default: ProductListPage
    }
  },
  {
    path: '/product/create',
    name: 'ProductRegisterPage',
    components: {
      default: ProductRegisterPage
    }
  },
  {
    path: '/product/:productNo',
    name: 'ProductReadPage',
    components: {
      default: ProductReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/product/:productNo/edit',
    name: 'ProductModifyPage',
    components: {
      default: ProductModifyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/monster',
    name: 'MonsterListPage',
    components: {
      default: MonsterListPage
    }
  },
  {
    path: '/monster/create',
    name: 'MonsterRegisterPage',
    components: {
      default: MonsterRegisterPage
    }
  },
  {
    path: '/monster/:monsterNo',
    name: 'MonsterReadPage',
    components: {
      default: MonsterReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/monster/:monsterNo/edit',
    name: 'MonsterModifyPage',
    components: {
      default: MonsterModifyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/eventbusTest',
    name: 'EventBusTestPage',
    components: {
      default: EventBusTestPage
    }
  },
  {
    path: '/dungeon',
    name: 'DungeonListPage',
    components: {
      default: DungeonListPage
    }
  },
  {
    path: '/Prob89Page',
    name: 'prob89Page',
    components: {
      default: prob89Page
    }
  },
  {
    path: '/springcon',
    name: 'springCon',
    components: {
      default: springCon
    }
  },
  {
    path: '/scoreManagePage',
    name: 'ScoreManagePage',
    components: {
      default: ScoreManagePage
    }
  },
  {
    path: '/daumNewsCrawler',
    name: 'DaumNewsCrawlerPage',
    components: {
      default: DaumNewsCrawlerPage
    }
  },
  {
    path: '/unNameSlot',
    name: 'UnNamedSlotTestPage',
    components: {
      default: UnNamedSlotTestPage
    }
  },
  {
    path: '/NameSlot',
    name: 'NamedSlotTestPage',
    components: {
      default: NamedSlotTestPage
    }
  },{
    path: '/Scopedslot',
    name: 'ScopedSlotTestPage',
    components: {
      default: ScopedSlotTestPage
    }
  },
  {
    path: '/vSlot',
    name: 'RecentSlotTestPage',
    components: {
      default: RecentSlotTestPage
    }
  },
  { 
    path: '/materialize',
    name: 'MaterialzeTestPage',
    components: {
      default: MaterialzeTestPage
    }
  },
  { 
    path: '/materializeGrid',
    name: 'MaterializeGridTestPage',
    components: {
      default: MaterializeGridTestPage
    }
  },
  { 
    path: '/VuetifyTestPage',
    name: 'VuetifyAllInOneTestPage',
    components: {
      default: VuetifyAllInOneTestPage
    }
  },
  { 
    path: '/jpasignuppage',
    name: 'JpaDbSignupPage',
    components: {
      default: JpaDbSignupPage
    }
  },
  { 
    path: '/coverflowtestpage',
    name: 'CoverflowTestPage',
    components: {
      default: CoverflowTestPage
    }
  },
  { 
    path: '/awesomeswiperTest',
    name: 'AwesomeSwiperTestPage',
    components: {
      default: AwesomeSwiperTestPage
    }
  },
  { 
    path: '/imagegalleryTestPage',
    name: 'ImageGalleryTestPage',
    components: {
      default: ImageGalleryTestPage
    }
  },
  { 
    path: '/calendartestpage',
    name: 'CalendarTestPage',
    components: {
      default: CalendarTestPage
    }
  },
  { 
    path: '/memberjoincolumn',
    name: 'MemberJoinColumnTestPage',
    components: {
      default: MemberJoinColumnTestPage
    }
  },
  { 
    path: '/memberjoincolumn',
    name: 'VuetifyMemberLoinPage',
    components: {
      default: VuetifyMemberLoinPage
    }
  },
  { 
    path: '/testsignuppage',
    name: 'TestSignupPage',
    components: {
      default: TestSignupPage 
    }
  },
  { 
    path: '/testsignuppage',
    name: 'FileUploadPage',
    components: {
      default: FileUploadPage
    }         
  },
  { 
    path: '/pythonLoginTestPage', 
    name: 'PythonLoginTestPage',
    components: {
      default: PythonLoginTestPage 
    }
  },
  { 
    path: '/kakaologinpage', 
    name: 'kakaoLoginPage',
    components: {
      default: kakaoLoginPage  
    }
  },
  { 
    path: '/orderTestPage', 
    name: 'OrderTestPage',
    components: {
      default: OrderTestPage  
    }
  },
  { 
    path: '/pythonCrawlTest', 
    name: 'PythonCrawlTest',
    components: {
      default: PythonCrawlTest  
    }
  },
 
 
 
 


]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router