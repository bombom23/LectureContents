import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import About from '../views/About.vue'
import SignupPage from '../views/SignupPage.vue'
import MemberList from '../views/Manage/MemberList.vue'
//로그인
//import LoginPage from '../views/login/LoginPage.vue'

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

//곤충박물관
//사슴벌레
import InsectMuseumStagbeetle from '../views/InsectMuseum/Stagbeetle/InsectMuseumStagbeetle.vue'
import StagbeetleRegister from '../views/InsectMuseum/Stagbeetle/StagbeetleRegister'
import StagbeetleReadPage from '../views/InsectMuseum/Stagbeetle/StagbeetleReadPage'
//장수풍뎅이
import InsectMuseumbeetle from '../views/InsectMuseum/Beetle/InsectMuseumBeetle.vue'
import BeetleRegister from '../views/InsectMuseum/Beetle/BeetleRegister'
import BeetleReadPage from '../views/InsectMuseum/Beetle/BeetleReadPage'
//잠자리
import InsectMuseumDragonfly from '../views/InsectMuseum/Dragonfly/InsectMuseumDragonfly'
import DragonflyRegister from '../views/InsectMuseum/Dragonfly/DragonflyRegister'
import DragonflyReadPage from '../views/InsectMuseum/Dragonfly/DragonflyReadPage'
//하늘소
import InsectMuseumSkycow from '../views/InsectMuseum/Skycow/InsectMuseumSkycow'
import SkycowRegister from '../views/InsectMuseum/Skycow/SkycowRegister'
import SkycowReadPage from '../views/InsectMuseum/Skycow/SkycowReadPage'

//나비/나방
import ButterflyRegister from '../views/InsectMuseum/Butterfly/ButterflyRegister'
import InsectMuseumButterfly from '../views/InsectMuseum/Butterfly/InsectMuseumButterfly'
import ButterflyReadPage from '../views/InsectMuseum/Butterfly/ButterflyReadPage'
//페이지 리스팅
//쇼핑몰
import ProductRegister from '../views/ShoppingMall/ProductRegister'
import ShoppingMallpage from '../views/ShoppingMall/ShoppingMallpage'
import ProductReadPage from '../views/ShoppingMall/ProductReadPage'
import BasketReadPage from '../views/ShoppingMall/BasketReadPage'
import OrderListPage from '../views/ShoppingMall/OrderListPage'

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
    path: '/communityReadPage:boardNo',
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
    path: '/noticeReadPage/:boardNo',
    name: 'NoticeReadPage',
    components: {
      default: NoticeReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/insectMuseumStagbeetle',
    name: 'InsectMuseumStagbeetle',
    components: {
      default: InsectMuseumStagbeetle
    }
  },
  {
    path: '/insectMuseumbeetle',
    name: 'InsectMuseumbeetle',
    components: {
      default: InsectMuseumbeetle
    }
  },
  {
    path: '/insectMuseumDragonfly',
    name: 'InsectMuseumDragonfly',
    components: {
      default: InsectMuseumDragonfly
    }
  },
  {
    path: '/dragonflyRegister',
    name: 'DragonflyRegister',
    components: {
      default: DragonflyRegister
    }
  },
  {
    path: '/beetleRegister',
    name: 'BeetleRegister',
    components: {
      default: BeetleRegister
    }
  },
  {
    path: '/stagbeetleRegister',
    name: 'StagbeetleRegister',
    components: {
      default: StagbeetleRegister
    }
  },
  {
    path: '/stagbeetleReadPage/:boardNo/',
    name: 'StagbeetleReadPage',
    components: {
      default: StagbeetleReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/beetleReadPage/:boardNo/',
    name: 'BeetleReadPage',
    components: {
      default: BeetleReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/dragonflyReadPage/:boardNo/',
    name: 'DragonflyReadPage',
    components: {
      default: DragonflyReadPage
    },
    props: {
      default: true
    }
  },
  //하늘소----------------------------------------
  {
    path: '/insectMuseumSkycow',
    name: 'InsectMuseumSkycow',
    components: {
      default: InsectMuseumSkycow
    }
  },
  {
    path: '/skycowRegister',
    name: 'SkycowRegister',
    components: {
      default: SkycowRegister
    }
  },
  {
    path: '/skycowReadPage/:boardNo/',
    name: 'SkycowReadPage',
    components: {
      default: SkycowReadPage
    },
    props: {
      default: true
    }
  },
  //나비나방=====================================
  {
    path: '/butterflyRegister',
    name: 'ButterflyRegister',
    components: {
      default: ButterflyRegister
    }
  },
  {
    path: '/insectMuseumButterfly',
    name: 'InsectMuseumButterfly',
    components: {
      default: InsectMuseumButterfly
    }
  },
  {
    path: '/butterflyReadPage/:boardNo/',
    name: 'ButterflyReadPage',
    components: {
      default: ButterflyReadPage
    },
    props: {
      default: true
    }
  },
  //쇼핑몰
  {
    path: '/productRegister',
    name: 'ProductRegister',
    components: {
      default: ProductRegister
    },
  },
  {
    path: '/shoppingMallpage',
    name: 'ShoppingMallpage',
    components: {
      default: ShoppingMallpage
    },
  },
  {
    path: '/productReadPage/:boardNo',
    name: 'ProductReadPage',
    components: {
      default: ProductReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/basketReadPage/:memberNo',
    name: 'BasketReadPage',
    components: {
      default: BasketReadPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/orderListPage',
    name: 'OrderListPage',
    components: {
      default: OrderListPage
    },
  },
  
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
