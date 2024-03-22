<template>
    <div class="w-100 h-100">
        <main-header />
        <main class="w-100 h-100" style="padding-top: 60px; padding-bottom: 80px;">
            <div class="mx-auto" style="max-width: 390px; min-width: 360px;">
                <router-view v-slot="{ Component }">
                    <component :is="Component" />
                </router-view>
            </div>
        </main>
        <main-navigation />
    </div>
</template>

<script>
import BellIcon from "@/components/icon/BellIcon.vue";
import HomeIcon from "@/components/icon/HomeIcon.vue";
import HeartIcon from "@/components/icon/HeartIcon.vue";
import CogIcon from "@/components/icon/CogIcon.vue";
import AccountIcon from "@/components/icon/AccountIcon.vue";
import MainNavigation from "@/components/layout/MainNavigation.vue";
import MainHeader from "@/components/layout/MainHeader.vue";
export default {
    name: "MainLayout",
    components: { MainHeader, MainNavigation, AccountIcon, CogIcon, HeartIcon, HomeIcon, BellIcon }
    // components: { MainNavigation, MainHeader }
};
</script>

<style scoped></style>
