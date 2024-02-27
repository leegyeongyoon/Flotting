import axios from "axios";

const createInstance = axios.create({
    headers: {
        "Access-Control-Allow-Origin": "*",
        "Content-type": "application/json"
    },
    baseURL: process.env.VUE_FLOTTING_API_URL
});

createInstance.interceptors.request.use(
    config => {
        console.log("Request Interceptor:", config);
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

export { createInstance };
