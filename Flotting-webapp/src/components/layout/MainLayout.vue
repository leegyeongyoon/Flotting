<template>
    <div class="h-100">
        <main-header />
        <v-main class="pt-0 h-100" fluid>
            <router-view />
        </v-main>
        <main-navigation />
    </div>
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
