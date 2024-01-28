const userStore = {
    state: {
        userId: "",
        userName: "",
        token: ""
    },
    mutations: {
        login: (state, payload) => {
            state.userId = payload.userId;
            state.userName = payload.userName;
            state.token = payload.token;
        },
        logout: state => {
            state.userId = "";
            state.userName = "";
            state.token = "";
        }
    },
    getters: {
        isLogin: state => {
            return !!state.token;
        }
    }
};
export default userStore;
