import { createInstance } from "./axios";

const fetchApiResource = async (url, param) => {
    return createInstance.post(`${url}`, param);
};
export { fetchApiResource };
