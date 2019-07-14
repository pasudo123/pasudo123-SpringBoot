
/** firebase 설정 **/
import * as firebase from "firebase/app";
import "firebase/storage";
const fb = require('./properties/firebase-config');

const firebaseConfig = {
    apiKey: fb.apiKey,
    authDomain: fb.authDomain,
    databaseURL: fb.databaseURL,
    projectId: fb.projectId,
    storageBucket: fb.storageBucket,
    messagingSenderId: fb.messagingSenderId,
    appId: fb.appId
};

firebase.initializeApp(firebaseConfig);

import './plugins/vuetify'
import './plugins/axios'
import store from './vuex/store'
import router from './plugins/router'
import Vue from 'vue'
import PaMain from './components/PaMain'

Vue.config.productionTip = false;

/** vue instance 생성 및 로드 **/
new Vue({
    render: h => h(PaMain),
    router: router,
    store: store,
}).$mount('#app');