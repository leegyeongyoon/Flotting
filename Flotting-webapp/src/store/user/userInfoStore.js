import { ref } from "vue";
import { defineStore } from "pinia";

export const userInfoStore = defineStore(
    "userStore",
    () => {
        const userInfo = ref({
            email: "",
            name: "",
            phoneNumber: "",
            accessToken: ""
        });

        const getUserInfo = () => userInfo.value;
        const getUserAccessToken = () => userInfo.value.accessToken;
        const resetUserAccessToken = () => (userInfo.value.accessToken = "");
        const setUserInfo = newUserInfo => {
            userInfo.value = newUserInfo;
        };
        const resetUserInfo = () => {
            userInfo.value = {
                email: "",
                name: "",
                phoneNumber: "",
                accessToken: ""
            };
        };

        return {
            userInfo,
            getUserInfo,
            getUserAccessToken,
            setUserInfo,
            resetUserInfo,
            resetUserAccessToken
        };
    },
    {
        persist: true
    }
);
