<template>
    <div id="albumMain">
        <DataTables></DataTables>

        <!--<router-view></router-view>-->
        <!--<button class="uploadAlbumBtn" @click="showModal">사진첩 등록</button>-->
        <!--<AlbumModal></AlbumModal>-->
        <!--<AlbumElement></AlbumElement>-->
        <!--<AlbumPagination></AlbumPagination>-->
    </div>
</template>

<script>

    import DataTables from '@/components/common/DataTables'
    import {mapActions, mapMutations} from 'vuex'

    export default {
        name: "AlbumMain",
        components: { DataTables },
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