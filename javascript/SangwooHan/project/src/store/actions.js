import {
    
//멤버 리스트
FETCH_MEMBER_LIST,
//다음뉴스
DAUM_NEWS,
//게시판
FETCH_BOARD_LIST,
FETCH_MEMBER,



} from './mutation-types'

import axios from 'axios'
import router from '../router'
export default {
    fetchMemberList({ commit }) {
        return axios.get('http://localhost:9999/jpamemberManage/lists')
        .then((res) => {
            commit(FETCH_MEMBER_LIST, res.data)
        })
    },
    async crawlFind ({ commit }, category) {
        axios.get('http://localhost:9999/' + `${category}`)
                .then(({ data }) => {
                    commit(DAUM_NEWS, data)

                    if (window.location.pathname !== '/daumNewsCrawler') {
                        router.push('/daumNewsCrawler')
                    }
                })
    },
    fetchBoardList({ commit }) {
        return axios.get('http://localhost:9999/jpaBoard/boardlists')
        .then((res) => {
            commit(FETCH_BOARD_LIST, res.data)
        })
    },
    fetchMember ({commit}, memberNo) {
        return axios.get(`http://localhost:9999/jpamemberManage/${memberNo}`)
        .then((res) => { 
                commit(FETCH_MEMBER, res.data ) 
                
        })
    }
    
  

}