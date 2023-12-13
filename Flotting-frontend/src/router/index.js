import { createWebHistory, createRouter } from "vue-router";
import AdminDashboard from "@/views/dashboard/AdminDashboard";
import UserList from "@/views/account/UserList";

const routes = [
    { path: "/", component: AdminDashboard },
    { path: "/account", component: UserList }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;
