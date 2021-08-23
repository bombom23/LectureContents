import {
    FETCH_MEMBER_LIST,
    FETCH_MEMBER,
    DAUM_NEWS,
    FETCH_BOARD_LIST,
    FETCH_BOARD,
    FETCH_COMMENTS_LIST,
    FETCH_NOTICE_LIST,
    FETCH_NOTICE,
    FETCH_NOTICE_COMMENT_LIST,
    FECTH_STAGBEETLES_LIST,
    FECTH_STAGBEETLES,
    FECTH_STAGBEETLES_COMMENT_LIST,
    FETCH_BEETLE_LIST,
    FETCH_BEETLE,
    FETCH_BEETLE_COMMENT_LIST,
    

    
} from './mutation-types'

export default {
    [FETCH_MEMBER_LIST] (state, members){
        state.members = members
    },
    [DAUM_NEWS] (state, payload) {
        state.lists = payload
    },
    [FETCH_BOARD_LIST] (state, boards){
        state.boards = boards
    },
    [FETCH_MEMBER] (state, member){
        state.member = member 
        console.log(member)
    },
    [FETCH_BOARD] (state, board ) {
        state.board = board
    },
    [FETCH_COMMENTS_LIST] (state, commentsList) {
        state.commentsList = commentsList
    },
    [FETCH_NOTICE_LIST] (state, notices) {
        state.notices = notices
    },
    [FETCH_NOTICE] (state, notice) {
        state.notice = notice
    },
    [FETCH_NOTICE_COMMENT_LIST] (state,NoticeCommentList) {
        state.NoticeCommentList = NoticeCommentList
    },
    [FECTH_STAGBEETLES_LIST] (state,StagbeetleList) {
        state.StagbeetleList = StagbeetleList
    },
    [FECTH_STAGBEETLES] (state,Stagbeetle) {
        state.Stagbeetle = Stagbeetle 
    },
    [FECTH_STAGBEETLES_COMMENT_LIST] (state, StagbeetleCommentList) {
        state.StagbeetleCommentList = StagbeetleCommentList 
    },
    [FETCH_BEETLE_LIST] (state, BeetleList) {
        state.BeetleList = BeetleList 
    },
    [FETCH_BEETLE] (state, Beetle) {
        state.Beetle = Beetle
    },
    [FETCH_BEETLE_COMMENT_LIST] (state,BeetleCommentList) {
        state.BeetleCommentList = BeetleCommentList
    }
   

}

