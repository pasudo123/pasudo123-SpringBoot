
import PaMain from '@/components/PaMain'
import Home from '@/components/home/Home'
import About from '@/components/home/about'
import TodoMain from '@/components/todo/TodoMain'
import AlbumMain from '@/components/album/AlbumMain'
import AlbumPost from '@/components/album/AlbumPost'

import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter);

export default new VueRouter({

    /**
     * push API 사용을 위함 (https://developer.mozilla.org/ko/docs/Web/API/History_API)
     */
    mode: "history",

    routes: [
        {
            path: '/',
            name: 'paMain',
            component: PaMain,
            children: [
                {
                    path: 'home',
                    name: 'home',
                    component: Home

                },
                {
                    path: 'about',
                    name: 'about',
                    component: About
                },
                {
                    path: 'todo',
                    name: "todoMain",
                    component: TodoMain
                },
                {
                    path: 'album',
                    name: 'AlbumMain',
                    component: AlbumMain
                },
                {
                    path: 'album/post',
                    name: 'AlbumPost',
                    component: AlbumPost
                },
            ]
        },
    ]
});