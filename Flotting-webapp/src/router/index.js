import { createWebHistory, createRouter } from "vue-router";
import UserDashboard from "@/views/dashboard/UserDashboard.vue";
import UserLogin from "@/views/login/UserLogin";
import MainLayout from "@/components/layout/MainLayout";
import SignupSimple from "@/views/signup/SignupSimple.vue";
import UserProfile from "@/views/profile/UserProfile.vue";
import MainTitle from "@/views/title/MainTitle.vue";

const routes = [
    { path: "/login", component: UserLogin },
    { path: "/signup", component: SignupSimple },
    {
        path: "/",
        component: MainTitle
    },
    {
        path: "/",
        component: MainLayout,
        children: [
            {
                path: "dashboard",
                component: UserDashboard
            },
            {
                path: "profile",
                component: UserProfile
            }
        ]
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;
