<template>
    <Modal v-if="this.isModalShow" @close="this.hideModal">

        <div class="headerWrapper" slot="header">
            <div class="headerText">사진첩</div>
            <div class="todayDate">현재날짜</div>
        </div>

        <div class="bodyWrapper" slot="body">

            <div class="bodyTextWrapper">
                <v-form>
                    <v-container>
                        <v-layout row wrap>
                            <v-flex>
                                <v-text-field
                                        v-model="titleContent"
                                        placeholder="제목을 작성해주세요"
                                ></v-text-field>
                            </v-flex>
                        </v-layout>
                    </v-container>
                </v-form>

                <VueTrix
                        v-model="editorContent"
                        placeholder="글을 작성해주세요"/>
            </div>

            <input
                    style="display:none"
                    type="file"
                    ref="fileInput"
                    @change="onFileSelected">

            <button @click="$refs.fileInput.click()" class="chooseImageBtn">Select Image</button>

            <v-avatar
                    :tile=true
                    size=100px
            >
                <img :src="image" alt=""/>
            </v-avatar>
        </div>
        <div class="footerWrapper" slot="footer">
            <div>
                <button class="submitBtn" @click="submit">
                    작성
                </button>
                <button class="closeBtn" @click="hideModal">닫기</button>
            </div>
        </div>
    </Modal>
</template>

<script>

    import VueTrix from 'vue-trix';
    import {mapGetters, mapMutations} from 'vuex';
    import Modal from './Modal';

    export default {
        name: "AlbumModal",
        components: {Modal, VueTrix},
        data() {
            return {
                titleContent: '',
                editorContent: '',
                tile: false,
                image: '',
                firebasePayload: {},
                writeDate: '',
            }
        },
        computed: {
            ...mapGetters(['isModalShow']),
        },
        methods: {
            ...mapMutations(['hideModal']),

            onFileSelected(event) {

                /** 이미지 파일선택 **/
                const input = event.target;

                const fileReader = new FileReader();

                /** onload 콜백 실행 **/
                fileReader.onload = () => {
                    this.image = fileReader.result;
                };

                /** 이미지 파일을 URL 로 읽는다. **/
                fileReader.readAsDataURL(input.files[0]);

                /** blob 데이터 설정 **/
                this.firebasePayload.imageBlob = input.files[0];
                this.firebasePayload.imageName = this.firebasePayload.imageBlob.name;
            },

            submit() {

                const firebase = require('firebase/app');
                require('firebase/storage');

                const storage = firebase.storage();
                const storageRef = storage.ref();

                const name = this.firebasePayload.imageBlob.name;
                const blob = this.firebasePayload.imageBlob;

                const uploadTask = storageRef.child("image/" + name);
                const metadata = {contentType: this.image.type};

                uploadTask.put(blob, metadata).then((snapshot) => {
                    console.debug("== SnapShot ==");
                    console.debug(snapshot);
                });

                this.hideModal();

                /** init **/
                this.image = '';
                this.firebasePayload = {};
            }
        },
    }
</script>

<style scoped>
    .headerWrapper {
        text-align: center;
    }

    .todayDate {
        text-align: right;
    }

    .v-form > .container > .layout > .flex{
        padding: 0px;
    }

    .footerWrapper{
        text-align: center;
    }

    .footerWrapper .submitBtn, .closeBtn{
        padding: 6px 15px;
        border-radius: 10px;
        background-color: #2e5b8b;
        color: white;
        outline: none;
        margin-left: 5px;
        margin-right: 5px;
    }

    .footerWrapper .submitBtn:hover, .closeBtn:hover{
        background-color: #2f3b8b;
        box-shadow: 1px 1px 1px 1px #c2cccd;
    }
</style>