<template>
    <header class="position-fixed w-100" style="top: 0; height: 60px; background-color: #60e0e0; z-index: 1000;">
        <div class="d-flex justify-space-between align-center ga-4 mx-auto h-100 px-4" style="max-width: 1024px; min-width: 360px;">
            <v-btn icon="true" color="#60e0e0" style="box-shadow: none;" href="/setting"><cog-icon width="35" height="35"/></v-btn>
            <div class="d-flex justify-center align-center">
                <v-btn class="font-weight-bold text-white text-h4" color="#60e0e0" style="box-shadow: none;" href="/dashboard">Plotting</v-btn>
            </div>
            <v-btn icon="true" color="#60e0e0" style="box-shadow: none;" href="/store"><home-icon /></v-btn>
        </div>
    </header>
</template>

<script setup>
import HomeIcon from "@/components/icon/HomeIcon.vue";
import CogIcon from "@/components/icon/CogIcon.vue";
</script>

<style scoped></style>
