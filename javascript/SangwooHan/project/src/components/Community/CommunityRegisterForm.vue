<template>
    
        <form @submit.prevent="OnSubmit">
            <div>
               
                <v-container >
                    <h3>게시물작성</h3>
           <v-text-field label="id" v-model="id"  readonly type="text" append-icon="mid-account">
           </v-text-field>
           
            <v-text-field label="title" v-model="title" type="text" append-icon="mid-account">
           </v-text-field>
           <p>내용</p>
          <textarea name="contentText" id="contentText" cols="30" rows="10" v-model="text"></textarea>
     
                </v-container>
            </div>
              
            <v-btn class="blue" type="submit">등록</v-btn>
        </form>
    
</template>

<script>
import {mapState } from 'vuex'
export default {
        name: 'CommunityRegisterForm',
        props: {
                members: {
                    type: Array
                }
        },

        data () {
            return {
                id: this.$store.state.loginUser,
               
                title: '',
                text: '',
            }
        },

        methods: {
            OnSubmit() {
                const { id, title, text} = this
                this.$emit('submit', {id , title, text})
            },
            ...mapState[('loginUser')],
           
            
        }
        
    
}
</script>

<style scoped>
textarea{width:1000px; height:500px; border: 1px;
border-style:solid;
/*   resize:none; */
/*   resize: horizontal; */
 resize: vertical;
}
</style>