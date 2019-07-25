import axios from 'axios';

const state = {
    showModal: false,
    showCompleteModal: false,
    albumHeaders: [
        {text: '번호', align: 'center', sortable: false, value: 'id'},
        {text: '제목', align: 'center', sortable: false, value: 'title'},
        {text: '작성일', align: 'center', sortable: false, value: 'createDate'},
    ],
    albumList: [],
    album: {}
};

const actions = {

    firebaseStorageSubmit({commit}, payload) {

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

    createAlbum({commit}, payload) {

        console.debug("앨범 추가 메소드 호출");

        axios.post("/api/album", payload).then((response) => {
            commit('addNewAlbum', response.data);
        }).catch((error) => {
            console.debug(error);
        })
    },

    fetchAllAlbumList({commit}) {

        console.debug("앨범 목록 전체 조회");

        axios.get("/api/album").then((response) => {
            commit('setAlbumList', response.data);
        }).catch((error) => {
            console.debug(error);
        });
    },

    fetchAlbum({commit}, albumId){

        console.debug('특정 앨범 조회 :', albumId);

        axios.get("/api/album/" + albumId).then((response) => {
            commit('setAlbum', response.data);
        }).catch((error) => {
            console.debug(error);
        });

    },

    createAlbumComment({commit}, param){

        // 데이터 셋팅
        let payload = {
            comment: param.comment
        };
        let albumId = param.albumId;

        axios.post(`/api/album/${albumId}/comment`, payload).then((response) => {
            commit(`addNewAlbumComment`, response.data);
        }).catch((error) => {
           console.error(error);
        });
    }
};

const getters = {
    isModalShow: state => state.showModal,
    albumHeaders: state => state.albumHeaders,
    albumList: state => {
        console.debug(state.albumList);
        if(Object.keys(state.albumList).length === 0){
            return [];
        }

        return state.albumList;
    },
    album: state => state.album,
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
        state.album.albumCommentList = album.albumCommentList;
    },

    addNewAlbumComment(state, albumComment){
        state.album.albumCommentList.unshift(albumComment);
    }

};


export default {
    state,
    actions,
    getters,
    mutations
}
