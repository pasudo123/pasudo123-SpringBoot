<template>
    <div>
        <h1>Album</h1>
        <button class="uploadAlbumBtn" @click="showModal">사진첩 등록</button>
        <AlbumModal></AlbumModal>
        <div v-for="index in 10">
            <AlbumElement></AlbumElement>
        </div>
    </div>
</template>

<script>

    import {mapMutations} from 'vuex';
    import AlbumModal from '../album/AlbumModal';
    import AlbumElement from "./AlbumElement";

    export default {
        name: "AlbumMain",
        components: {AlbumElement, AlbumModal},
        data() {
            return {
            }
        },
        methods: {
            ...mapMutations(['showModal']),
        }
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