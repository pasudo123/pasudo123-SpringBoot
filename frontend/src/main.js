
import './plugins/vuetify'
import './plugins/axios'
import router from './plugins/router'
import Vue from 'vue'
import PaMain from './components/PaMain'

import Vuex from 'vuex'
import VueRouter from "vue-router";

// vue-router, vuex 사용
Vue.use(VueRouter);
Vue.use(Vuex);

Vue.config.productionTip = false;

/* eslint-disable */
new Vue({
  render: h => h(PaMain),
  router: router,
}).$mount('#app');