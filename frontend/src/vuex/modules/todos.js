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

        console.debug("Create TODO");
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
    },

    deleteTodo(context, payload){

        const todo = payload.todo;
        const id = payload.id;

        // 같은 id 로 중복삭제 되는 것을 막기 위함 (서버와 통신 최소화)
        if (!todo.exist){
            return;
        }

        console.debug("Delete TODO ID : ", id);

        todo.exist = false;

        axios.delete("/api/todos/" + id)
            .then((response) => {
                context.commit('deleteTodo', id);
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
        
        const todoList = state.todos;

        for (let i = 0; i < todoList.length; i++){
            todoList[i].exist = true;
        }
    },

    // _TODO 추가시 _TODO 목록 가장 앞 단에 추가 (unshift)
    addNewTodo(state, todo){
        todo.exist = true;
        state.todos.unshift(todo);
    },

    deleteTodo(state, id){
        // filter() : Callback 함수로써, 새롭게 배열을 생성 (true 가 되는 모든 값들을 반환)
        state.todos = state.todos.filter(todo => todo.id !== id);
    }
};


export default {
    state,
    getters,
    actions,
    mutations
}