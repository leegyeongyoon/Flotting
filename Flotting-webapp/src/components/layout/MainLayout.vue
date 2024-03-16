<template>
    <v-main class="pt-0 h-100">
        <main-header />
        <router-view v-slot="{ Component, route }">
            <transition :name="route.meta.transition || 'none'">
                <component :is="Component" />
            </transition>
        </router-view>
    </v-main>
</template>

<script>
import MainHeader from "@/components/layout/MainHeader";
import MainNavigation from "@/components/layout/MainNavigation";
export default {
    name: "MainLayout",
    components: { MainNavigation, MainHeader }
};
</script>

<style scoped></style>
