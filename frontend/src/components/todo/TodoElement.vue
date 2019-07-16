<template>
    <div class="elementWrapper">
        <div    class="element"
                v-for="todo in allTodos"
                v-bind:key="todo.id">
            <div class="todoDate">{{dateFormat(todo.createDate)}}</div>
            {{todo.content}}

            <a class="deleteTodoBtn" @click="deleteTodo({todo: todo, id: todo.id})">삭제</a>
        </div>
    </div>
</template>

<script>

    import {mapActions, mapGetters} from 'vuex';
    import DateUtil from '../../utils/DateUtil';

    export default {
        name: "TodoElementWrapper",
        computed: {
            ...mapGetters(['allTodos'])
        },
        methods: {
            ...mapActions(['fetchTodos', 'deleteTodo']),

            dateFormat(date){
                return DateUtil.parseToyyyyMMdd_hhmmss(date);
            }

        },
        created() {
            this.fetchTodos();
        }
    }
</script>

<style scoped>

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
        cursor: pointer;
    }

</style>