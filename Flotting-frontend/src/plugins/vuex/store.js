import { createStore } from "vuex";
import createPersistedState from "vuex-persistedstate";

export default createStore({
    plugins: [createPersistedState()],
    state() {
        return {
            searchParams: {}
        };
    },
    mutations: {
        resetSearchParams(state) {
            state.searchParams = {};
        },
        setSearchParams(state, data) {
            state.searchParams[data.path] = data.params;
        }
    },
    getters: {
        getSearchParams: state => path => {
            console.log(state.searchParams);
            return state.searchParams[path];
        }
    }
});
