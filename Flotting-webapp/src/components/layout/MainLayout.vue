<template>
    <v-main class="pt-0 h-100">
        <main-header />
        <router-view v-slot="{ Component }">
            <component :is="Component" />
        </router-view>
        <main-navigation />
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
