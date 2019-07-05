
import TodoMain from '../components/todo/TodoMain'
import VueRouter from "vue-router";

export default new VueRouter({

    /**
     * push API 사용을 위함 (https://developer.mozilla.org/ko/docs/Web/API/History_API)
     */
    mode: "history",

    routes: [
        {
            path: '/todo',
                name: "todoMain",
            component: TodoMain
        },
    ]
});