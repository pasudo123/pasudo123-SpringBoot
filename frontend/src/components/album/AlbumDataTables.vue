<template>
    <div id="tableWrapper">
        <v-app>
            <v-toolbar flat color="#c9d0e2">
                <v-toolbar-title><span class="titleText">Album</span></v-toolbar-title>
                <v-spacer></v-spacer>
                <v-btn color="#b0b0b8" @click="write
">
                    <span class="btnText">write</span>
                </v-btn>
            </v-toolbar>

            <v-data-table
                    :headers="albumHeaders"
                    :items="albumList"
            >
                <template v-slot:items="props">
                    <td>{{ props.item.id }}</td>
                    <td>{{ props.item.title }}</td>
                    <td>{{ props.item.createDate }}</td>
                </template>

                <template v-slot:footer>
                    <td :colspan="albumHeaders.length">
                        <strong>푸터로 일단 뭐를 집어넣는게 좋을까...</strong>
                    </td>
                </template>
            </v-data-table>
        </v-app>
    </div>
</template>

<script>

    import DateUtil from '@/utils/DateUtil'
    import AlbumModal from '@/components/album/AlbumModal'
    import {mapActions, mapGetters, mapMutations} from 'vuex'

    export default {
        name: "DataTables",
        components: {AlbumModal},
        data() {
            return {}
        },
        computed: {
            ...mapGetters(['albumHeaders', 'albumList']),
        },
        methods: {
            ...mapActions(['fetchAllAlbumList']),
            ...mapMutations(['showModal']),

            write() {
                this.$router.push({path: '/album/post'})
            },

        },
        created() {
            this.fetchAllAlbumList();
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

    div#tableWrapper {
        margin-top: 20px;
        width: 960px;
    }

</style>
