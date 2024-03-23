import axios from "axios";
import { userInfoStore } from "@/store/user/userInfoStore";

// const userInfo = userInfoStore();

// Axios 인스턴스 생성
const axiosInstance = axios.create({
    headers: {
        "Access-Control-Allow-Origin": "*",
        "Content-type": "application/json",
        "Access-Control-Allow-Headers": "X-Requested-With"
        // Authorization: `Bearer ${userInfo.getUserAceessToken}`
    }
});

axiosInstance.interceptors.request.use(
    config => {
        console.log("Request Interceptor:", config);
        return config;
    },
    error => {
        console.error("Request Error Interceptor:", error);
        return Promise.reject(error);
    }
);

axiosInstance.interceptors.response.use(
    response => {
        console.log("Response Interceptor:", response);
        return response;
    },
    error => {
        console.error("Response Error Interceptor:", error);
        return Promise.reject(error);
    }
);

export default axiosInstance;
