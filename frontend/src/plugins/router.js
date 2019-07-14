
import Home from '../components/home/Home';
import TodoMain from '../components/todo/TodoMain';
import AlbumMain from '../components/album/AlbumMain';
import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);

export default new VueRouter({

    /**
     * push API 사용을 위함 (https://developer.mozilla.org/ko/docs/Web/API/History_API)
     */
    mode: "history",

    routes: [
        {
            path: '/',
            name: "home",
            component: Home,
        },
        {
            path: '/todo',
            name: "todoMain",
            component: TodoMain
        },
        {
            path: '/album',
            name: 'album',
            component: AlbumMain
        }
    ]
});