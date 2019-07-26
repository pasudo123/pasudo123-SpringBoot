<template>
    <div>
        <div class="text-xs-center">
            <v-pagination
                    v-model="page"
                    :length="4"
                    prev-icon="mdi-menu-left"
                    next-icon="mdi-menu-right"
            ></v-pagination>
        </div>
    </div>
</template>

<script>
    export default {
        name: "AlbumPagination",
        data(){
            return{
                page: 1,
            }
        }
    }
</script>

<style scoped>

</style>