import { createWebHistory, createRouter } from "vue-router";
import AdminDashboard from "@/views/dashboard/AdminDashboard";

const routes = [{ path: "/", component: AdminDashboard }];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;
