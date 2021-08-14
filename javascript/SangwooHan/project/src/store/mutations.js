import {
    FETCH_MEMBER_LIST,
    FETCH_MEMBER,
    DAUM_NEWS,
    FETCH_BOARD_LIST,

    
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
    }
   

}

