import { createInstance } from "./axios";

const fetchApiResource = async (url, type, param) => {
    if (type === "POST") return createInstance.post(`${url}`, param);
    createInstance.get(`${url}`, {
        param
    });
};
export { fetchApiResource };
