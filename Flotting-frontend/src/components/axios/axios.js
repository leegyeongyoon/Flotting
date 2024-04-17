import axios from "axios";
import { userInfoStore } from "@/components/store/user/userInfoStore";

export const createInstance = axios.create({
    headers: {
        "Access-Control-Allow-Origin": "*",
        "Content-type": "application/json"
    },
    baseURL: process.env.VUE_FLOTTING_API_URL
});

createInstance.interceptors.request.use(
    config => {
        const userInfo = userInfoStore();
        console.log("Request Interceptor:", config);
        config.headers.Authorization = `Bearer ${userInfo.getUserAccessToken()}`;
        return config;
    },
    error => {
        console.error("Request Error Interceptor:", error);
        return Promise.reject(error);
    }
);

createInstance.interceptors.response.use(
    response => {
        console.log("Response Interceptor:", response);
        return response;
    },
    error => {
        console.error("Response Error Interceptor:", error);
        return Promise.reject(error);
    }
);
