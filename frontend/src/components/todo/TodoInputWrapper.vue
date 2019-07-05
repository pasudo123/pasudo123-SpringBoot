<template>
    <div class="todoForm">
        <v-form>
            <v-container>
                <v-layout align="center">
                    <v-flex>
                        <v-text-field
                                class="todoTextField"
                                v-model='todoText'
                                label="할 일 작성하기"
                                solo-inverted
                        ></v-text-field>
                        <a class="createTodoBtn" href="">등록하기</a>
                    </v-flex>
                </v-layout>
            </v-container>
        </v-form>
    </div>
</template>

<script>
    export default {
        name: "TodoInputWrapper",
        data: function () {
            return {
                todoText: '',
            }
        },
        methods: {},

    }
</script>

<style scoped>
    a.createTodoBtn{
        padding:14px 18px;
        background: #333;
        color: #fff;
        text-align: center;
        font-family: Consolas;
        font-size:15px;
        text-decoration: none;
        /*position: absolute;*/
        /*right:0;*/
    }
</style>