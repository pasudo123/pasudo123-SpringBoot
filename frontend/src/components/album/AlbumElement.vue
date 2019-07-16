<template>
    <div class="elementWrapper">
        <v-layout>
            <v-flex>
                <v-card class="cardElement" v-for="album in allAlbum" :key="album.id">
                    <v-container fill-height fluid>
                        <v-layout fill-height>
                            <v-flex xs12 align-end flexbox>
                                <div class="headline">{{album.title}}</div>
                            </v-flex>
                        </v-layout>
                    </v-container>

                    <div class="imageWrapper">
                        <v-img
                                width="100%"
                                height="180px"
                                src="https://cdn.vuetifyjs.com/images/cards/docks.jpg"
                        >
                        </v-img>
                    </div>

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
                                <span>{{dateFormat(album.createDate)}}</span>
                            </div>
                            <div class="albumText" v-html="album.content"></div>
                        </div>
                    </v-card-title>

                    <v-card-actions>
                        <v-btn flat color="orange">하트</v-btn>
                        <v-btn flat color="orange" @click="goAlbumPost(album.id)">내용보기</v-btn>
                    </v-card-actions>
                </v-card>
            </v-flex>
        </v-layout>
    </div>
</template>

<script>

    import {mapGetters, mapMutations} from 'vuex';
    import DateUtil from '../../utils/DateUtil';

    export default {
        name: "AlbumElement",
        computed: {
            ...mapGetters(['allAlbum']),
        },
        data() {
            return {
                image: "https://avatars1.githubusercontent.com/u/17797352?s=400&u=d8373790d3ea5b4ac35323b0effd1171c2a14a3d&v=4",
            }
        },
        methods: {
            ...mapMutations(['showCompleteModal']),

            dateFormat(date){
                return DateUtil.parseToyyyyMMdd_hhmmss(date);
            },

            goAlbumPost(albumId){
                console.debug(">>>");
                const path = 'album/' + albumId;
                this.$router.push({path:path});
            }

        },
        created(){

        }
    }
</script>

<style scoped>

    div.headline{
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
    }

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
    }

    div.albumText {
        white-space: nowrap;
        height: 50px;
        overflow-x: hidden;
        overflow-y: auto;
        border-top: 1px solid darkslategrey;
        border-bottom: 1px solid darkslategrey;
    }

    div.grey--text {
        padding-bottom: 10px;
    }

    div.imageWrapper:hover{
        cursor: pointer;
        box-shadow: 2px 2px 5px 1px #c2cccd;
    }

    div.v-avatar{
        cursor:pointer;
    }

</style>