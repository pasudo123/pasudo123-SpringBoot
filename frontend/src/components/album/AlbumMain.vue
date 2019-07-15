<template>
    <div>
        <h1>Album</h1>
        <button class="uploadAlbumBtn" @click="showModal">사진첩 등록</button>
        <AlbumModal></AlbumModal>
        <AlbumElement></AlbumElement>
        <AlbumPagination></AlbumPagination>
    </div>
</template>

<script>

    import {mapActions, mapMutations} from 'vuex';
    import AlbumModal from '../album/AlbumModal';
    import AlbumElement from './AlbumElement';
    import AlbumPagination from './AlbumPagination';

    export default {
        name: "AlbumMain",
        components: {AlbumPagination, AlbumElement, AlbumModal},
        data() {
            return {
            }
        },
        methods: {
            ...mapMutations(['showModal']),
            ...mapActions(['fetchAllAlbumList']),
        },
        created(){
            this.fetchAllAlbumList();
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