import {
//멤버 리스트
FETCH_MEMBER_LIST,

} from './mutation-types'

import axios from 'axios'
export default {
    fetchMemberList({ commit }) {
        return axios.get('http://localhost:9999/vuesignup/lists')
        .then((res) => {
            commit(FETCH_MEMBER_LIST, res.data)
        })
    }
}