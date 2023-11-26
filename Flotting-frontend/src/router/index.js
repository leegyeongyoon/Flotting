import { createWebHistory, createRouter } from "vue-router";

const routes = [
    {
        path: "/",
        name: "Post List"
    },
    {
        path: "/:title",
        name: "PostDetail"
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;
