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
                                        v-model="content.title"
                                        placeholder="제목을 작성해주세요"
                                ></v-text-field>
                            </v-flex>
                        </v-layout>
                    </v-container>
                </v-form>

                <VueTrix
                        v-model="content.editorContent"
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
    import {mapGetters, mapMutations, mapActions} from 'vuex';
    import Modal from './Modal';

    export default {
        name: "AlbumModal",
        components: {Modal, VueTrix},
        data() {
            return {
                content: {},
                tile: false,
                image: '',
                firebasePayload: {},
            }
        },
        computed: {
            ...mapGetters(['isModalShow']),
        },
        methods: {
            ...mapMutations(['hideModal']),
            ...mapActions(['firebaseStorageSubmit', 'createAlbum']),

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

                const fbProcess = this.firebaseStorageSubmit(this.firebasePayload);
                const payload = {
                    title: this.content.title,
                    content: this.content.editorContent,
                    // 이미지 관련 내용
                };

                fbProcess.then(() => {

                }).catch(() => {

                }).then(() => {
                    this.createAlbum(payload).then(() => {
                        this.init();
                    });
                });
            },

            init() {
                this.content = {};
                this.image = '';
                this.firebasePayload = {};
                this.hideModal();
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

    .v-form > .container > .layout > .flex {
        padding: 0px;
    }

    .footerWrapper {
        text-align: center;
    }

    .footerWrapper .submitBtn, .closeBtn {
        padding: 6px 15px;
        border-radius: 10px;
        background-color: #2e5b8b;
        color: white;
        outline: none;
        margin-left: 5px;
        margin-right: 5px;
    }

    .footerWrapper .submitBtn:hover, .closeBtn:hover {
        background-color: #2f3b8b;
        box-shadow: 1px 1px 1px 1px #c2cccd;
    }
</style>