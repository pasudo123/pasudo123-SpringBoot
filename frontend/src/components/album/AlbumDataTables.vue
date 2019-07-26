<template>
    <div id="tableWrapper">
        <v-app id="inspire" style="height:100%; min-height:0;">

            <div class="appWrapper">
                <v-card>
                    <v-toolbar flat color="#2c5234">
                        <v-toolbar-title><span class="titleText">Album</span></v-toolbar-title>
                        <v-spacer></v-spacer>
                        <v-btn color="#507f70" @click="write">
                            <span class="btnText">write</span>
                        </v-btn>
                    </v-toolbar>
                    <v-data-table
                            hide-actions
                            :headers="albumHeaders"
                            :items="albumList"
                    >
                        <template v-slot:items="props">
                            <td>{{ props.item.id }}</td>
                            <td>{{ props.item.title }}</td>
                            <td>{{ props.item.createDate }}</td>
                        </template>
                    </v-data-table>

                    <div class="pagiWrapper">
                        <v-pagination
                                v-model="page"
                                :length="6"
                        ></v-pagination>
                    </div>
                </v-card>
            </div>
        </v-app>
    </div>
</template>

<script>

    import DateUtil from '@/utils/DateUtil'
    import {mapActions, mapGetters} from 'vuex'

    export default {
        name: "DataTables",
        data() {
            return {
                page: 1,
            }
        },
        computed: {
            ...mapGetters(['albumHeaders', 'albumList']),
        },
        methods: {
            ...mapActions(['fetchAllAlbumList']),

            write() {
                this.$router.push({path: '/album/post'})
            },

            isFetch() {
                if (this.albumList.length !== 0) {
                    return;
                }

                this.fetchAllAlbumList();
            }

        },
        created() {
            this.isFetch();
        }
    }
</script>

<style>

    .application--wrap {
        min-height: 0;
    }

    div.appWrapper {
        width: 100%;
    }

    tr {
        cursor: pointer;
    }

    td {
        text-align: center;
    }

    div#tableWrapper {
        margin-top: 50px;
        width: 960px;
    }

    span.titleText {
        color: white;
    }

    span.btnText {
        color: white;
    }

    div.pagiWrapper{
        padding: 15px 0;
        text-align: center;
    }

</style>
