<template>
   <form @submit.prevent="OnSubmit">
            <div>
              
                <v-container>
                    <h3>사슴벌레 작성란</h3>
           <input v-model="id" readonly/>
            <v-text-field label="title" v-model="title" type="text" append-icon="mid-account" flat solo>
           </v-text-field>
           <p>내용</p>
          <textarea name="contentText" id="contentText" cols="30" rows="10" v-model="text"></textarea>
           
                </v-container>
                 
            </div>
                <v-btn type="submit" class="blue">작성하기</v-btn>
         
        </form>
</template>

<script>
import { mapState } from 'vuex'
export default {
    name: 'NoticeRegisterForm',
    data() {
        return{
            id: this.User,
            title: '',
            text: '',
            
        }
    },
    computed:{
        ...mapState(['User'])
    },
    mounted() {
        this.id =this.$store.state.User
    },
    methods: {
        OnSubmit() {
            const  {id , title, text } = this
            this.$emit('submit', {id, title, text })
        }
    }

}
</script>

<style scoped>
#contentText{width:1000px; height:200px; border: 1px;
border-style:solid;
/*   resize:none; */
/*   resize: horizontal; */
 resize: vertical;
}

</style>