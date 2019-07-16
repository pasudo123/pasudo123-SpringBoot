<template>
    <div>
        <h1>앨범 진입</h1>
        <p>{{this.getAlbum}}</p>
        <div>댓글 작성</div>
    </div>
</template>

<script>
    import {mapActions, mapGetters} from 'vuex';

    export default {
        name: "AlbumPost",
        computed: {
            ...mapGetters(['getAlbum']),
        },
        methods: {
            ...mapActions(['fetchAlbum'])
        },
        created(){
            const albumId = this.$route.params.id;
            this.fetchAlbum(albumId)
        },

    }
</script>

<style scoped>

</style>