<template>
    <div class="elementWrapper">
        <div    class="element"
                v-for="todo in allTodos"
                v-bind:key="todo.id">
            <div class="todoDate">날짜 값 입력</div>
            {{todo.content}}

            <a class="deleteTodoBtn" @click="deleteTodo(todo.id)">삭제</a>
        </div>
    </div>
</template>

<script>

    import {mapActions, mapGetters} from 'vuex';


    export default {
        name: "TodoElementWrapper",
        methods: {
            ...mapActions(['fetchTodos', 'deleteTodo']),
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

    /*div.elementWrapper{*/
        /*margin:0 auto;*/
        /*width: 600px;*/
    /*}*/

    div.todoDate{
        margin-bottom:5px;
    }

    div.element{
        margin-top:5px;
        padding:10px 20px;
        background-color:beige;
    }

    a.deleteTodoBtn{
        background: #525252;
        color: #fff;
        border-radius: 10px;
        padding:10px 15px;
        margin-top:-23px;
        position:absolute;
        right:15px;
        text-decoration: none;
        font-family: Consolas;
        cursor: pointer;
    }

</style>