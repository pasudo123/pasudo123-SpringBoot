import axios from 'axios';

const state = {
    showModal: true,
};

const actions = {};

const getters = {
    isModalShow: state => state.showModal
};

const mutations = {

    showModal(state) {
        state.showModal = true;
    },

    hideModal(state) {
        state.showModal = false;
    }

};


export default {
    state,
    actions,
    getters,
    mutations
}
