<template>
    <div id="albumMain">
        <AlbumDataTables></AlbumDataTables>

        <!--<router-view></router-view>-->
        <!--<button class="uploadAlbumBtn" @click="showModal">사진첩 등록</button>-->
        <!--<AlbumModal></AlbumModal>-->
        <!--<AlbumElement></AlbumElement>-->
        <!--<AlbumPagination></AlbumPagination>-->
    </div>
</template>

<script>

    import AlbumDataTables from '@/components/album/AlbumDataTables'

    export default {
        name: "AlbumMain",
        components: { AlbumDataTables },
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
