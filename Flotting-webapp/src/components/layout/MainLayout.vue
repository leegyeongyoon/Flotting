<script setup>
import MainHeader from "@/components/layout/MainHeader.vue";
import MainNavigation from "@/components/layout/MainNavigation.vue";
</script>

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

<style scoped></style>
