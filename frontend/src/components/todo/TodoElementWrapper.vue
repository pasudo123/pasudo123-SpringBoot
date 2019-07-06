<template>
    <div>
        <div v-for="todo in allTodos" v-bind:key="todo.id">
            {{todo.content}}
        </div>
    </div>
</template>

<script>

    import {mapActions, mapGetters} from 'vuex';


    export default {
        name: "TodoElementWrapper",
        methods: {
            ...mapActions(['fetchTodos'])
        },
        computed: {
            ...mapGetters(['allTodos'])
        },
        created() {
            this.fetchTodos();
        }
    }
</script>

<style scoped>

</style>