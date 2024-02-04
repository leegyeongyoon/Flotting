import { createWebHistory, createRouter } from "vue-router";
import UserDashboard from "@/views/dashboard/UserDashboard.vue";
import UserLogin from "@/views/login/UserLogin";
import MainLayout from "@/components/layout/MainLayout";

const routes = [
    {
        path: "/",
        component: MainLayout,
        children: [
            { path: "", component: UserDashboard },
            { path: "/dashboard", component: UserDashboard }
        ]
    },
    { path: "/login", component: UserLogin }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;
