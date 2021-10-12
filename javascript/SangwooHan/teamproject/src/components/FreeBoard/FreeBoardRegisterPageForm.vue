<template>
    <div>
         <form @submit.prevent="OnSubmit">
             <table>
                 <tr>
                     <td>아이디
                     <input type="text" v-model="userid"/></td>
                 </tr>
                 <tr>
                     <td>제목
                     <input type="text" v-model="title"/></td>
                 </tr>
                 <tr>
                     <td>내용
                    <input type="text" v-model="text"/></td>
                 
                 </tr>
                 <tr>
               
                     <label>Files
                <input type="file" id="files" ref="files" multiple v-on:change="handleFileUpload()">
                    </label>
                 </tr>
             </table>
            <v-btn type="submit" v-on:click="submitFiles()">게시물등록</v-btn>
         </form>
         
           
    </div>
</template>

<script>
import axios from 'axios'
export default {
    name: 'FreeBoardRegisterPageForm',
    data() {

        return {
            userid: '한상우',
            title: '',
            text: '',
            picture: '',
            img: '',
        }
    },
    methods: {

       
        handleFileUpload () {
            this.files = this.$refs.files.files
            const info = this.files
            
            this.img = this.userid+"의"+ info[0].name
        },
        OnSubmit() {
            const {userid , title, text, picture , img } = this
            axios.post('http://localhost:9999/test/register', {userid , title, text, picture , img})
            .then( (res) => {
                alert(res.data)
            
            })

        },
        submitFiles () {
            
            let formData = new FormData()
            for (var idx = 0; idx < this.files.length; idx++) {
                this.files.name = this.img
                formData.append('fileList', this.files[idx])
            }
            axios.post(`http://localhost:9999/test/uploadImg/${this.userid}`, formData,{ headers: {'Content-Type': 'multipart/form-data'} })
            .then (res => {
                this.response = res.data
            })
            .catch (res => {
                this.response = res.message
            }) 
            alert('Processing Complete!')
        }
       
    
    }
}
</script>

