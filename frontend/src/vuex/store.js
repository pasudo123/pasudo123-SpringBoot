
import todos from './modules/todos';
import album from './modules/album';

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
        todos,
        album,
    }
});