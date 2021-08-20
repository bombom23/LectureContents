import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import About from '../views/About.vue'
import SignupPage from '../views/SignupPage.vue'
import MemberList from '../views/Manage/MemberList.vue'
//로그인
//import LoginPage from '../views/login/LoginPage.vue'
import NewLoginPage from '../views/login/NewLoginPage.vue'
//  커뮤니티 페이지
import CommunityRegisterPage from '../views/Community/CommunityRegisterPage.vue'

//params 활용 
import Test from '../views/Test.vue'
// 멤버 리드 페이지입니다.

//다음뉴스
import DaumNewsCrawlerPage  from '../views/DaumNews/DaumNewsCrawlerPage.vue'

//곤충박물관
import InsectMuseumPage from '../views/InsectMuseum/InsectMuseumPage.vue'
//커뮤니티
import CommunityListPage from '../views/Community/CommunityListPage'
import CommunityReadPage from '../views/Community/CommunityReadPage.vue'
import CommunityModifyPage from '../views/Community/CommunityModifyPage.vue'

//멤버리스트읽기페이지
import MemberListReadPage from '../views/Manage/MemberListReadPage.vue'
//멤버리스트 수정하기
import MemberModifyPage from '../views/Manage/MemberModifyPage.vue'

//공지판
import NoticeRegisterPage from '../views/Notice/NoticeRegisterPage.vue'
import NoticeListPage from '../views/Notice/NoticeListPage.vue'
import NoticeReadPage from '../views/Notice/NoticeReadPage.vue'
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/aboutpage',
    name: 'About',
    component: About
  },
  {
    path: '/signuppage',
    name: 'SignupPage',
    component: SignupPage
  },
  {
    path: '/memberlist',
    name: 'MemberList',
    component: MemberList
  },
  {
    path: '/loginpage',
    name: 'NewLoginPage',
    component: NewLoginPage
  },

  {
    path: '/communityregisterpage',
    name: 'CommunityRegisterPage',
    component: CommunityRegisterPage
  },
  {
    path: '/test/:UserId',
    name: 'Test',
    component: Test
  },
  {
    path: '/daumNewsCrawler',
    name: 'DaumNewsCrawlerPage',
    components: {
      default: DaumNewsCrawlerPage
    }
  },
  {
    path: '/insectmuseumpage',
    name: 'InsectMuseumPage',
    components: {
      default: InsectMuseumPage
    }
  },
  {
    path: '/communityListpage',
    name: 'CommunityListPage',
    components: {
      default: CommunityListPage
    }
  },
  {
    path: '/communityListreadpage',
    name: 'CommunityReadPage',
    components: {
      default: CommunityReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/memberListRead:memberNo',
    name: 'MemberListReadPage',
    components: {
      default: MemberListReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/membermodifypage',
    name: 'MemberModifyPage',
    components: {
      default: MemberModifyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/communitymodifyPage/',
    name: 'CommunityModifyPage',
    components: {
      default: CommunityModifyPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/noticeRegisterPage',
    name: 'NoticeRegisterPage',
    components: {
      default: NoticeRegisterPage
    }
  },
  {
    path: '/noticeListPage',
    name: 'NoticeListPage',
    components: {
      default: NoticeListPage
    }
  },
  {
    path: '/noticeReadPage/',
    name: 'NoticeReadPage',
    components: {
      default: NoticeReadPage
    },
    props: {
      default: true
    }
  },
 
  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
