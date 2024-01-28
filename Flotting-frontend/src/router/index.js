import { createWebHistory, createRouter } from "vue-router";
import AdminDashboard from "@/views/dashboard/AdminDashboard";
import UserList from "@/views/account/UserList";
import UserManagement from "@/views/user/UserManagement.vue";
import ProfileRequestedChange from "@/views/profile/ProfileRequestedChange.vue";
import AdminNotice from "@/views/noti/admin/AdminNotice";
import UserNotice from "@/views/noti/user/UserNotice";
import IndicatorManagement from "@/views/ind/IndicatorManagement";
import UserManagementDetail from "@/views/user/UserManagementDetail.vue";
import ProfileRequestedChangeDetail from "@/views/profile/ProfileRequestedChangeDetail.vue";
import RegisterFirst from "@/views/reg/RegisterFirst.vue";
import RegisterSecond from "@/views/reg/RegisterSecond.vue";
import RegisterSecondDetail from "@/views/reg/RegisterSecondDetail.vue";
import ConsultManager from "@/views/cns/ConsultManager.vue";
import ConsultUser from "@/views/cns/ConsultUser.vue";
import ConsultManagerDetail from "@/views/cns/ConsultManagerDetail.vue";
import AdminLogin from "@/views/login/AdminLogin.vue";
import store from "@/plugins/vuex/store";

const routes = [
    { path: "/", component: AdminLogin },
    { path: "/home", component: AdminDashboard },
    { path: "/account", component: UserList },

    { path: "/mng/user", component: UserManagement },
    { path: "/mng/user/:id", component: UserManagementDetail },
    { path: "/mng/profile", component: ProfileRequestedChange },
    { path: "/mng/profile/:id", component: ProfileRequestedChangeDetail },

    { path: "/reg/first", component: RegisterFirst },
    { path: "/reg/second", component: RegisterSecond },
    { path: "/reg/second/:id", component: RegisterSecondDetail },

    { path: "/cns/user", component: ConsultUser },
    { path: "/cns/manager", component: ConsultManager },
    { path: "/cns/manager/:id", component: ConsultManagerDetail },

    { path: "/noti/admin", component: AdminNotice },
    { path: "/noti/user", component: UserNotice },

    { path: "/indicator", component: IndicatorManagement }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

router.beforeEach((to, from) => {
    if (to.path !== "/" && !store.getters.isLogin) {
        return "/";
    }
});

export default router;
