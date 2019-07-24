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


/** font-awesome 설정 **/
import { library } from '@fortawesome/fontawesome-svg-core'
import { faUserSecret, faCameraRetro, faList, faAngleRight, faArrowsAltH } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome'

library.add(faUserSecret, faCameraRetro, faList, faAngleRight, faArrowsAltH);
Vue.component('font-awesome-icon', FontAwesomeIcon);


/** 일반설정 **/
import './plugins/vuetify'
import './plugins/axios'
import store from './store/store'
import router from './plugins/router'
import Vue from 'vue'
import App from './App'

Vue.config.productionTip = false;

/** vue instance 생성 및 로드 **/
new Vue({
    render: h => h(App),
    router: router,
    store: store,
}).$mount('#app');