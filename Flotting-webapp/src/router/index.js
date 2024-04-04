import { createWebHistory, createRouter } from "vue-router";
import UserDashboard from "@/views/dashboard/UserDashboard.vue";
import UserLogin from "@/views/login/UserLogin";
import MainLayout from "@/components/layout/MainLayout";
import SignupSimple from "@/views/signup/SignupSimple.vue";
import UserProfile from "@/views/profile/UserProfile.vue";
import MainTitle from "@/views/title/MainTitle.vue";
import UserPlotting from "@/views/plotting/UserPlotting.vue";
import SettingMain from "@/views/setting/SettingMain.vue";
import SettingInquire from "@/views/setting/SettingInquire.vue";
import SettingNotice from "@/views/setting/SettingNotice.vue";
import SettingInvite from "@/views/setting/SettingInvite.vue";
import SettingBlock from "@/views/setting/SettingBlock.vue";
import SettingStatus from "@/views/setting/SettingStatus.vue";
import AlarmMain from "@/views/alarm/AlarmMain.vue";
import StoreMain from "@/views/store/StoreMain.vue";
import TestMain from "@/views/test/TestMain.vue";
import SettingMyProfile from "@/views/setting/SettingMyProfile.vue";
import SingupMain from "@/views/signup/SingupMain.vue";
import SignupGuide from "@/views/signup/SignupGuide.vue";

const routes = [
    { path: "/login", component: UserLogin },
    { path: "/signupTest", component: SignupSimple },
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
                path: "plotting",
                component: UserPlotting
            },
            {
                path: "setting",
                component: SettingMain
            },
            {
                path: "setting/inquire",
                component: SettingInquire
            },
            {
                path: "setting/notice",
                component: SettingNotice
            },
            {
                path: "setting/invite",
                component: SettingInvite
            },
            {
                path: "setting/block",
                component: SettingBlock
            },
            {
                path: "setting/status",
                component: SettingStatus
            },
            {
                path: "alarm",
                component: AlarmMain
            },
            {
                path: "store",
                component: StoreMain
            }
        ]
    },
    {
        path: "/profile",
        component: UserProfile
    },
    {
        path: "/setting/my-profile",
        component: SettingMyProfile
    },
    {
        path: "/signup",
        component: SingupMain
    },
    {
        path: "/signup/guide",
        component: SignupGuide
    },
    {
        path: "/test",
        component: TestMain
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes
});

export default router;
