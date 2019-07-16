import axios from 'axios';

const state = {
    showModal: false,
    showCompleteModal: false,
    albumList: [],
    album: '',
};

const actions = {

    firebaseStorageSubmit(context, payload) {

        console.debug("firebase storage save() 호출");

        /** 비어있는 오브젝트 판단 **/
        if (Object.keys(payload).length === 0) {
            console.debug("empty picture");
            return;
        }

        console.debug("not empty picture");

        const firebase = require('firebase/app');
        require('firebase/storage');

        const storage = firebase.storage();
        const storageRef = storage.ref();

        const name = payload.imageName;
        const blob = payload.imageBlob;

        const uploadTask = storageRef.child("image/" + name);
        const metadata = {contentType: blob.type};

        return new Promise((resolve, reject) => {

            uploadTask.put(blob, metadata).then((snapshot) => {
                return snapshot;

                /** 파이어베이스 스로리지 업로드 여부에 따라 **/
                // resolve();
                // reject();
            });
        });
    },

    createAlbum(context, payload) {

        const PAYLOAD = {
            title: payload.title,
            content: payload.content
        };

        console.debug("앨범 추가 메소드 호출");

        axios.post("/api/album", PAYLOAD).then((response) => {
            context.commit('addNewAlbum', response.data);
        }).catch((error) => {
            console.debug(error);
        })
    },

    fetchAllAlbumList(context) {

        console.debug("앨범 목록 전체 조회");

        axios.get("/api/album").then((response) => {
            context.commit('setAlbumList', response.data);
        }).catch((error) => {
            console.debug(error);
        });
    },

    fetchAlbum(context, albumId){

        console.debug('특정 앨범 조회 : ', albumId);

        axios.get("/api/album/" + albumId).then((response) => {
            context.commit('setAlbum', response.data);
        }).catch((error) => {
            console.debug(error);
        });

    }

};

const getters = {
    isModalShow: state => state.showModal,
    allAlbum: state => state.albumList,
    getAlbum: state => state.album,
};

const mutations = {

    showModal(state) {
        state.showModal = true;
    },

    hideModal(state) {
        state.showModal = false;
    },

    setAlbumList(state, albumList) {
        state.albumList = albumList;
    },

    addNewAlbum(state, album) {
        state.albumList.unshift(album);
    },

    setAlbum(state, album){
        state.album = album;
    }

};


export default {
    state,
    actions,
    getters,
    mutations
}
