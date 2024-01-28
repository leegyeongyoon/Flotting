const mainStore = {
    state: {
        drawer: true
    },
    mutations: {
        toggleDrawer: state => {
            state.drawer = !state.drawer;
        },
        setDrawer: (state, val) => {
            state.drawer = val;
        },
        closeDrawer: state => {
            state.drawer = false;
        }
    },
    getters: {
        getDrawer: state => {
            return state.drawer;
        }
    }
};
export default mainStore;
