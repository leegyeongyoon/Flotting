import { createWebHistory, createRouter } from "vue-router";
import UserDashboard from "@/views/dashboard/UserDashboard.vue";
import UserLogin from "@/views/login/UserLogin";
import MainLayout from "@/components/layout/MainLayout";
import SignupSimple from "@/views/signup/SignupSimple.vue";

const routes = [
    { path: "/login", component: UserLogin },
    { path: "/signup", component: SignupSimple },
    {
        path: "/",
        component: MainLayout,
        children: [
            { path: "", component: UserDashboard },
            { path: "/dashboard", component: UserDashboard }
        ]
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;
