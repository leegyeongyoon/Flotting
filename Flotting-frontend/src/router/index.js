import { createWebHistory, createRouter } from "vue-router";
import AdminDashboard from "@/views/dashboard/AdminDashboard";
import UserList from "@/views/account/UserList";
import UserManagement from "@/views/mng/user/UserManagement";
import RequestChangeProfile from "@/views/mng/profile/RequestChangeProfile";
import CsResponse from "@/views/cns/user/CsResponse";
import ManagerConsulting from "@/views/cns/manager/ManagerConsulting";
import SecondRegister from "@/views/reg/second/SecondRegister";
import FirstRegister from "@/views/reg/first/FirstRegister";
import AdminNotice from "@/views/noti/admin/AdminNotice";
import UserNotice from "@/views/noti/user/UserNotice";
import IndicatorManagement from "@/views/ind/IndicatorManagement";

const routes = [
    { path: "/", component: AdminDashboard },
    { path: "/account", component: UserList },

    { path: "/mng/user", component: UserManagement },
    { path: "/mng/profile", component: RequestChangeProfile },

    { path: "/reg/first", component: FirstRegister },
    { path: "/reg/second", component: SecondRegister },

    { path: "/cns/user", component: CsResponse },
    { path: "/cns/manager", component: ManagerConsulting },

    { path: "/noti/admin", component: AdminNotice },
    { path: "/noti/user", component: UserNotice },

    { path: "/indicator", component: IndicatorManagement }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;
