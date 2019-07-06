import axios from 'axios';

const state = {
    todos: [

    ]
};

const getters = {
    allTodos: state => state.todos,
};

const actions = {
    createTodo(context, payload) {

        const PAYLOAD = {content: payload};

        console.debug("Create TODO")
        console.debug(PAYLOAD);

        axios.post("/api/todos", PAYLOAD)
            .then((response) => {
                const todo = response.data;
                context.commit('addNewTodo', todo);
            })
            .catch((error) => {
                console.log(error);
            });
    },

    fetchTodos(context) {

        console.debug("Select TODO List");

        axios.get("/api/todos")
            .then((response) => {
                const todos = response.data;
                context.commit('setTodos', todos);
            })
            .catch((error) => {
                console.log(error);
            });
    }
};

const mutations = {

    // 뷰 라이프 사이클때 최초로 갱신 (created)
    setTodos(state, todos){
        state.todos = todos;
    },

    // _TODO 추가시 _TODO 목록 가장 앞 단에 추가 (unshift)
    addNewTodo(state, todo){
        state.todos.unshift(todo);
    }

};


export default {
    state,
    getters,
    actions,
    mutations
}