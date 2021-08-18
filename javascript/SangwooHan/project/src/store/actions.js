import {
//다음뉴스
DAUM_NEWS,
//멤버 리스트
FETCH_MEMBER_LIST,
FETCH_MEMBER,
//게시판
FETCH_BOARD,
FETCH_BOARD_LIST,
//댓글
FETCH_COMMENTS_LIST,



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
            console.log('memberNo =' + memberNo)
        return axios.get(`http://localhost:9999/jpamemberManage/${memberNo}`)
        .then((res) => { 
                commit(FETCH_MEMBER, res.data ) 
                
        })
    },
    fetchBoard ({commit}, boardNo) {
        return axios.get(`http://localhost:9999/jpaBoard/${boardNo}`)
        .then((res) => {
                commit(FETCH_BOARD, res.data)
        })
    } ,

    fetchCommentsList( { commit }, boardNo ){
                    console.log('action의 작동 그리고 boardNo =' + boardNo )
        return axios.get(`http://localhost:9999/jpaBoard/Commentslist/${boardNo}`)
        .then((res) => { console.log("Spring에서 넘어온 comments정보 =" +res.data )
                commit(FETCH_COMMENTS_LIST, res.data)
        }).catch(err => {
            alert(err.response.data.message)
        })
    }

    
  

}