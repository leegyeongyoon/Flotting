import { defineStore } from "pinia";

export const userInfoStore = defineStore("userInfoStore", {
    state: () => ({
        userInfo: {
            email: "",
            name: "",
            phoneNumber: "",
            accessToken: ""
        }
    }),
    getters: {
        getUserInfo: state => state.userInfo,
        getUserAceessToken: state => state.userInfo.accessToken
    },
    actions: {
        setUserInfo(userInfo) {
            this.userInfo = userInfo;
        },
        resetUserInfo() {
            this.userInfo = {
                email: "",
                name: "",
                phoneNumber: "",
                accessToken: ""
            };
        }
    },
    persist: true
});
