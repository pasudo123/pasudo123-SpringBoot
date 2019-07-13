<template>
    <div>
        <h1>Album</h1>
        <button class="uploadAlbumBtn" @click="modalShow">사진첩 등록</button>

        <AlbumModal v-if="showModal" @close="modelHide">
            <h3 slot="header">custom header</h3>
            <h3 slot="body">
                <input
                        style="display:none"
                        type="file"
                        ref="fileInput"
                        @change="onFileSelected">
                <button @click="$refs.fileInput.click()" class="ChooseImageBtn">Choose Image</button>

                <v-avatar
                        :tile="tile"
                        size=250px
                >
                    <img :src="image" alt="avatar"/>
                </v-avatar>
            </h3>
            <div slot="footer">
                <button class="modal-default-button" @click="onUploadAlbum">
                    Upload Album
                </button>
            </div>
        </AlbumModal>
    </div>
</template>

<script>
    import AlbumModal from '../album/AlbumModal';

    export default {
        name: "AlbumMain",
        components: {AlbumModal},
        data() {
            return {
                tile: false,
                showModal: false,
                image: '',
                firebasePayload: {},
            }
        },
        methods: {
            modalShow() {
                this.showModal = true;
            },

            modelHide() {
                this.showModal = false;
            },

            onFileSelected(event){

                /** 이미지 파일선택 **/
                const input = event.target;

                const fileReader = new FileReader();

                /** onload 콜백 실행 **/
                fileReader.onload = (e) => {
                    this.image = fileReader.result;
                };

                /** 이미지 파일을 URL 로 읽는다. **/
                fileReader.readAsDataURL(input.files[0]);

                /** blob 데이터 설정 **/
                this.firebasePayload.imageBlob = input.files[0];
                this.firebasePayload.imageName = this.firebasePayload.imageBlob.name;
            },

            onUploadAlbum(){

                const firebase = require('firebase/app');
                require('firebase/storage');

                const storage = firebase.storage();
                const storageRef = storage.ref();

                const name = this.firebasePayload.imageBlob.name;
                const blob = this.firebasePayload.imageBlob;

                const uploadTask = storageRef.child("image/" + name);
                const metadata = { contentType: this.image.type };

                uploadTask.put(blob, metadata).then((snapshot) => {
                    console.debug("== SnapShot ==");
                    console.debug(snapshot);
                });

                this.modelHide();
            }
        },

    }
</script>

<style scoped>
    button.uploadAlbumBtn {
        padding: 15px 20px;
        border: 1px solid #77658b;
        border-radius: 10px;
        background-color: #77658b;
        color: white;
        outline: none;
    }

    button.uploadAlbumBtn:hover {
        background-color: darkslateblue;
        box-shadow: 1px 1px 1px 1px #c2cccd;
    }
</style>