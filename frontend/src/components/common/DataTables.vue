<template>
    <div id="dataTables">
        <div class="tableWrapper">
            <v-toolbar flat color="#c9d0e2">
                <v-toolbar-title><span class="titleText">Album</span></v-toolbar-title>
                <v-spacer></v-spacer>
                <v-btn color="#b0b0b8" @click="write
">
                    <span class="btnText">write</span>
                </v-btn>
            </v-toolbar>

            <v-data-table
                    :headers="getAlbumHeaders"
                    :items="albumPostList"
                    class="elevation-1"
            >
                <template v-slot:items="props">
                    <td>{{ props.item.number }}</td>
                    <td>{{ props.item.title }}</td>
                    <td>{{ props.item.writer }}</td>
                    <td>{{ props.item.created }}</td>
                    <td>{{ props.item.like }}</td>
                </template>

                <template v-slot:footer>
                    <td :colspan="getAlbumHeaders.length">
                        <strong>푸터로 일단 뭐를 집어넣는게 좋을까...</strong>
                    </td>
                </template>
            </v-data-table>
        </div>
    </div>
</template>

<script>

    import AlbumModal from '@/components/album/AlbumModal'
    import {mapGetters, mapMutations} from 'vuex'

    export default {
        name: "DataTables",
        components: {AlbumModal},
        data() {
            return {
                albumPostList: [
                    {
                        number: '1',
                        title: '앨범제목',
                        writer: '작성자',
                        created: '2019년 1월 1일',
                        like: 10,
                    }
                ]
            }
        },
        computed: {
            ...mapGetters(['getAlbumHeaders']),
        },
        methods: {
            ...mapMutations(['showModal']),

            write() {
                this.$router.push({path: '/album/post'})
            }
        }
    }
</script>

<style>

    tr {
        cursor: pointer;
    }

    td {
        text-align: center;
    }

    div.tableWrapper {
        margin-top: 20px;
        width: 960px;
    }

</style>