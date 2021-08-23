<template>
    <v-container>
        <h3>File Upload Result: </h3>
        <div>
            <button @click="selectUploadFile()">이미지선택</button>
        </div>
    </v-container>
</template>

<script>
import axios from 'axios'
export default {
    name: 'FileUploadPage',
    data(){
        return{
            response: '',
            files: '',
        }
    },
    methods: {
        selectUploadFile () {
           
            let multiFileElem = document.createElement('input')

            multiFileElem.id = 'image'
            multiFileElem.type = 'file'
            multiFileElem.accept = 'image/*'
            multiFileElem.multiple = true

            multiFileElem.click()

            multiFileElem.onchange = () => {
                const formData = new FormData()
                var idx  = 0;
                for(idx ; idx< this.files.length; idx++){
                    formData.append('fileList', this.files[idx])
                }
                console.log(formData)
                axios.post('http://localhost:9999/file/uploadImg',formData,{
                    headers: {
                        'Content-Type': 'multipart/form-data'
                        }
                })
                .then(res => {
                    this.response = res.data
                })
                .catch(res => {
                    this.response = res.message
                })
                alert('Processing" ' + this.response)
            }
        }
    },
}
</script>