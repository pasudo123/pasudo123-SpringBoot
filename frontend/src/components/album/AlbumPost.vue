<template>
    <div>

        <h1>제목</h1>
        <h2>{{this.getAlbum.title}}</h2>
        <hr>
        <h1>내용</h1>
        <div v-html="this.getAlbum.content"></div>
        <hr>
        <v-form @submit.prevent="onSubmit">
            <v-container>
                <v-layout row wrap>
                    <v-flex xs12 sm6>
                        <v-text-field
                                label="댓글을 입력..."
                                messages="댓글 작성"
                                v-model="comment"
                                single-line
                        ></v-text-field>
                    </v-flex>
                </v-layout>
            </v-container>
        </v-form>

        <div class = "commentWrapper" v-for="comment in this.getAlbum.albumCommentList" :key="comment.id">
            <div>
                <span>{{comment.createDate}}</span><br>
                <span>{{comment.comment}}</span>
            </div>
        </div>

    </div>
</template>

<script>
    import {mapActions, mapGetters} from 'vuex';

    export default {
        name: "AlbumPost",
        computed: {
            ...mapGetters(['getAlbum']),
        },
        data() {
            return {
                albumId: '',
                title: '',
                content: '',
                comment: ''
            }
        },
        methods: {
            ...mapActions(['fetchAlbum', 'createAlbumComment']),

            onSubmit() {

                if(this.comment === '') {
                    return;
                }

                const param = {
                    albumId: this.albumId,
                    comment: this.comment
                };

                this.createAlbumComment(param);
                this.comment = '';
            }
        },
        created(){
            this.albumId = this.$route.params.id;
            this.fetchAlbum(this.albumId)
        },

    }
</script>

<style scoped>
    div.commentWrapper{
        margin:0 auto;
        width: 300px;
        padding:20px;
        border-bottom: 1px solid chocolate;
    }
</style>