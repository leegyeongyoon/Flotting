import { createStore } from "vuex";
import createPersistedState from "vuex-persistedstate";
import profileStore from "@/plugins/vuex/modules/profileStore";
import userStore from "@/plugins/vuex/modules/userStore";
import mainStore from "@/plugins/vuex/modules/mainStore";

export default createStore({
    modules: {
        profileStore: profileStore,
        userStore: userStore,
        mainStore: mainStore
    },
    plugins: [
        createPersistedState({
            paths: ["userStore"]
        })
    ]
});
