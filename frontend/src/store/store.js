
import todosModule from './modules/todosModule';
import albumModule from './modules/albumModule';

import Vue from 'vue';
import Vuex from 'vuex';

/** Load Vuex **/
Vue.use(Vuex);

/** Crate store **/
export default new Vuex.Store({

    state: {

    },

    mutations: {

    },

    actions: {

    },

    getters: {
    },

    modules: {
        todosModule,
        albumModule,
    }
});