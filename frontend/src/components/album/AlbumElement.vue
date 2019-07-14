<template>
    <div class="elementWrapper">
        <v-layout>
            <v-flex>
                <v-card>
                    <v-container fill-height fluid>
                        <v-layout fill-height>
                            <v-flex xs12 align-end flexbox>
                                <span class="headline">앨범의 제목</span>
                            </v-flex>
                        </v-layout>
                    </v-container>

                    <v-img
                            class="white--text"
                            width="100%"
                            height="150px"
                            src="https://cdn.vuetifyjs.com/images/cards/docks.jpg"
                    >
                    </v-img>

                    <v-card-title>
                        <div class="writer">
                            <v-avatar
                                    :tile=false
                                    size=80px
                            >
                                <img :src="image" alt="avatar"/>
                            </v-avatar>
                        </div>
                        <div class="content">
                            <div class="grey--text">
                                <span>홍길동</span><br>
                                <span>2019년 7월 14일 오후 8시</span>
                            </div>
                            <div class="albumText"><span>절반의 내용1절반의 내용1절반의 내용1절반의 내용1절반의 내용1절반의 내용1</span><br><span>절반의 내용2절반의 내용2절반의 내용2절반의 내용2절반의 내용2절반의 내용2</span>
                            </div>
                        </div>
                    </v-card-title>

                    <v-card-actions>
                        <v-btn flat color="orange">하트표시</v-btn>
                        <v-btn flat color="orange">댓글보기</v-btn>
                    </v-card-actions>
                </v-card>
            </v-flex>
        </v-layout>
    </div>
</template>

<script>

    export default {
        name: "AlbumElement",
        data() {
            return {
                image: "https://avatars1.githubusercontent.com/u/17797352?s=400&u=d8373790d3ea5b4ac35323b0effd1171c2a14a3d&v=4",
            }
        },
        methods: {},
    }
</script>

<style scoped>
    div.v-card {
        margin-top: 30px;
        width: 550px;
    }

    div.writer {
        padding-top: 5px;
        text-align: center;
        flex-grow: 1;
    }

    div.content {
        width: 300px;
        margin-left: 10px;
        flex-grow: 3;
        /*border:1px solid red;*/
    }

    div.albumText {
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
    }

    div.grey--text {
        padding-bottom: 10px;
    }
</style>