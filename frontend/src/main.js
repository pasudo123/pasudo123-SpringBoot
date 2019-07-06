
import './plugins/vuetify'
import './plugins/axios'
import store from './vuex/store'
import router from './plugins/router'
import Vue from 'vue'
import PaMain from './components/PaMain'


Vue.config.productionTip = false;

/* eslint-disable */
new Vue({
  render: h => h(PaMain),
  router: router,
  store: store,
}).$mount('#app');