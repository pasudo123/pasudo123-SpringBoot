import Vue from 'vue'
import './plugins/vuetify'
import './plugins/axios'
// import App from './App.vue'
import PaMain from './components/PaMain'

import Vuex from 'vuex'
import VueRouter from 'vue-router'

Vue.config.productionTip = false;

/**
 * Vuex, VueRouter 사용
 */
Vue.use(Vuex);
Vue.use(VueRouter);

new Vue({
  render: h => h(PaMain),
}).$mount('#app');
