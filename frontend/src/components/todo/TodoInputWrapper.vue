<template>
    <div class="todoForm">
        <form @submit.prevent="onSubmit">
            <input type="text" v-model="todoText" name="todoText" placeholder="할 일 작성하기...  ">
            <input type="submit" value="등록하기" class="btn">
        </form>
    </div>
</template>

<script>

    import {mapActions} from 'vuex';

    export default {
        name: "TodoInputWrapper",
        data: function () {
            return {
                todoText: '',
            }
        },
        methods: {

            /** vuex helper function **/
            ...mapActions(['createTodo']),

            onSubmit(){
                if (this.todoText.length === 0){
                    return;
                }

                this.createTodo(this.todoText);

                this.todoText = '';
            }
        },

    }
</script>

<style scoped>

    div.todoForm {
        margin: 0 auto;
        width: 600px;
        /*border: 1px solid red;*/
    }

    form {
        display: flex;
    }

    input[type="text"] {
        flex: 10;
        padding: 5px;
        border:1px solid grey;
    }

    input[type="submit"] {
        flex: 2;
        background: #333;
        color: #fff;
        text-align: center;
        padding: 10px;
        font-family: Consolas;
    }

</style>