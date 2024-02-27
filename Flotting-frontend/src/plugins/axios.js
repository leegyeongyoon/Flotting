import axios from "axios";

const instance = axios.create({
    // baseURL: import.meta.env.VITE_BASE_URL,
    headers: {
        "Content-Type": "application/json"
    }
});

instance.interceptors.request.use(
    config => {
        console.log("axios.js request : ", config);
        return config;
    },
    error => {
        return Promise.reject(error);
    }
);
instance.interceptors.response.use(
    res => {
        console.log("axios.js response : ", res);
        return res;
    },
    error => {
        return Promise.reject(error);
    }
);
export default instance;
