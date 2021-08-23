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
//공지글
FETCH_NOTICE_LIST,
FETCH_NOTICE,
FETCH_NOTICE_COMMENT_LIST,
//곤충박물관
FECTH_STAGBEETLES_LIST,
FECTH_STAGBEETLES,
FECTH_STAGBEETLES_COMMENT_LIST,
FETCH_BEETLE_LIST,
FETCH_BEETLE,
FETCH_BEETLE_COMMENT_LIST


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
    },
    fetchNoticeList({ commit }) {
        return axios.get('http://localhost:9999/jpaNotice/noticelist')
        .then((res) => {
            commit(FETCH_NOTICE_LIST, res.data)
        })
    },
    fetchNotice({ commit }, boardNo) {
        return axios.get(`http://localhost:9999/jpaNotice/${boardNo}`)
        .then((res) => {
            commit( FETCH_NOTICE, res.data)
        }).catch(err => {
                alert(err.response.data.message)
        })
    },
    fetchNoticeCommentList({ commit }, boardNo ) {
        return axios.get(`http://localhost:9999/jpaNotice/NoticeCommentList/${boardNo}`)
        .then((res) => {
            commit(FETCH_NOTICE_COMMENT_LIST, res.data)
        })
        .catch(err => {
            alert(err.response.data.message)
        })
    },
    fetchStagbeetleList({ commit } ) {
        return axios.get('http://localhost:9999/stagbeetle/stagbeetleList')
        .then((res) => {
            commit(FECTH_STAGBEETLES_LIST, res.data)
        })
    },
    fetchStagbeetle( { commit },boardNo ) {
        return axios.get(`http://localhost:9999/stagbeetle/stagbeetle/${boardNo}`)
        .then((res) => {
            commit(FECTH_STAGBEETLES, res.data)
        })
        .catch(err => { err.response.data.message})
    },
    fetchStagbeetleCommentList( {commit}, boardNo) {

        return axios.get(`http://localhost:9999/stagbeetle/stagbeetleComment/${boardNo}`)
        .then((res) => {
            commit(FECTH_STAGBEETLES_COMMENT_LIST, res.data) 
        }).catch(err => {alert(err.response.data.message)})

    },
    fetchBeetleList({ commit }) {

        return axios.get('http://localhost:9999/beetle/beetlelist')
        .then((res) => {
            commit(FETCH_BEETLE_LIST, res.data)
        })
        .catch(err =>{
            alert(err.response.data.message)
        })
    },
    fetchBeetle({ commit }, boardNo ) {
        return axios.get(`http://localhost:9999/beetle/beetle/${boardNo}`)
        .then((res) => {
            commit(FETCH_BEETLE, res.data)
        }).catch(err => {
            alert(err.response.data.message)
        })
    },
    fetchBeetleCommentList({ commit }, boardNo) {

        return axios.get(`http://localhost:9999/beetle/beetleCommentList/${boardNo}`)
        .then((res)=> {
            commit(FETCH_BEETLE_COMMENT_LIST, res.data)
        }).catch(err => {
            alert(err.response.data.message)
        })
    }


    
  

}