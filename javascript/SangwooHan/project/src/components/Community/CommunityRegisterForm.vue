<template>
<div>
        <v-btn @click="check">
            작성자체크
        </v-btn>
        <section>
        <form @submit.prevent="OnSubmit">
                <v-container >
            <!--<p>작성자{{User}}</p>-->
            <p>제목</p>
            <textarea name="contentTitle" id="contentTitle" cols="30" rows="10" v-model="title"></textarea>
            <p>내용</p>
              <textarea name="contentText" id="contentText" cols="30" rows="10" v-model="text"></textarea>
           
           <v-btn id="btn" class="green" type="submit">등록</v-btn>
                </v-container>
            
        </form>
        </section>
          <aside>
              <h3>광고</h3>
          </aside>
</div>
        
    
</template>

<script>
import {mapState } from 'vuex'
export default {
        name: 'CommunityRegisterForm',
        props: {
            
        },
        computed:{
            ...mapState(['User'])
        },

        data () {
            return {
                id: this.$store.state.User,
               
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
           
            check() {
            console.log(this.$store.state.User)
        }
        },
        
        
    
}
</script>

<style scoped>
#contentText{width:1000px; height:500px; border: 1px;
border-style:solid;
/*   resize:none; */
/*   resize: horizontal; */
padding: 10px;
			box-sizing: border-box;
			border: solid 2px green;
			border-radius: 5px;
			font-size: 16px;
			resize: both;

}
#contentTitle{width:1000px; height:50px; border: 1px;
border-style:solid;
/*   resize:none; */
/*   resize: horizontal; */
 padding: 10px;
			box-sizing: border-box;
			border: solid 2px green;
			border-radius: 5px;
			font-size: 16px;
			resize: both;
           
}
#btn{
    margin-left: 74.5%;
}
p{
    font-family:'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;

    font-size: 3em;
}
</style>

