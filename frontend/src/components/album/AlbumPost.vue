<template>
    <div id="albumPost">
        <v-form @submit.prevent="{submit, cancel}">
            <v-container>
                <v-layout>
                    <v-flex>
                        <div class="postWrapper">
                            <div class="postTitle">
                                앨범
                            </div>

                            <v-text-field
                                    @keypress.enter.prevent
                                    v-model="albumPost.title"
                                    label="제목"
                            ></v-text-field>

                            <VueTrix
                                    v-model="albumPost.content"
                                    placeholder="내용 작성"/>

                            <div class="buttonWrapper">
                                <button @click="cancel()" class="customButton">취소</button>
                                <button @click="submit()" class="customButton">작성</button>
                            </div>
                        </div>
                    </v-flex>
                </v-layout>
            </v-container>
        </v-form>

        <!--        <h1>제목</h1>-->
        <!--        <h2>{{this.album.title}}</h2>-->
        <!--        <hr>-->
        <!--        <h1>내용</h1>-->
        <!--        <div v-html="this.getAlbum.content"></div>-->
        <!--        <hr>-->
        <!--        <v-form @submit.prevent="onSubmit">-->
        <!--            <v-container>-->
        <!--                <v-layout row wrap>-->
        <!--                    <v-flex xs12 sm6>-->
        <!--                        <v-text-field-->
        <!--                                label="댓글을 입력..."-->
        <!--                                messages="댓글 작성"-->
        <!--                                v-model="comment"-->
        <!--                                single-line-->
        <!--                        ></v-text-field>-->
        <!--                    </v-flex>-->
        <!--                </v-layout>-->
        <!--            </v-container>-->
        <!--        </v-form>-->

        <!--        <div class="commentWrapper" v-for="comment in this.getAlbum.albumCommentList" :key="comment.id">-->
        <!--            <div>-->
        <!--                <span>{{comment.createDate}}</span><br>-->
        <!--                <span>{{comment.comment}}</span>-->
        <!--            </div>-->
        <!--        </div>-->

    </div>
</template>

<script>
    import VueTrix from 'vue-trix'
    import {mapActions} from 'vuex'

    export default {
        name: "AlbumPost",
        components: { VueTrix },
        data() {
            return {
                albumId: '',
                albumPost: {},
            }
        },
        methods: {
            ...mapActions(['fetchAlbum', 'createAlbum', 'createAlbumComment']),

            submit() {
                let payload = {
                    title: this.albumPost.title,
                    content: this.albumPost.content
                };

                this.createAlbum(payload).then(() => {
                    this.$router.push({path: '/album'});
                })
            },

            cancel() {
                this.$router.push({path: '/album'});
            },
        }
    }
</script>

<style scoped>

    div.postWrapper {
        width: 800px;
        padding: 8px;
        border: 2px solid darkslategray;
    }

    div.postTitle {
        background-color: darkslategrey;
        color: white;
        font-size: 20px;
        padding-top: 15px;
        padding-bottom: 15px;
        padding-left: 20px;
        margin-bottom: 10px;
    }

    trix-editor {
        min-height: 250px;
    }

    div.buttonWrapper {
        margin-top: 8px;
        display: flex;
    }

    button.customButton {
        border-radius: 5px;
        background-color: darkslategrey;
        color: white;
        padding: 5px 10px;
        outline: none;
    }

    button.customButton:hover {
        background-color: #243d3d;
        box-shadow: 1px 0px 0px 1px #525252;
    }

    div.commentWrapper {
        margin: 0 auto;
        width: 300px;
        padding: 20px;
        border-bottom: 1px solid chocolate;
    }

</style>
