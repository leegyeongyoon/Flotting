import { createWebHistory, createRouter } from "vue-router";
import UserDashboard from "@/views/dashboard/UserDashboard.vue";

const routes = [{ path: "/", component: UserDashboard }];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;
