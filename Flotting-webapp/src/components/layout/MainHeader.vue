<script setup>
import HomeIcon from "@/components/icon/HomeIcon.vue";
import CogIcon from "@/components/icon/CogIcon.vue";
</script>

<template>
    <header class="position-fixed w-100" style="top: 0; height: 60px; background-color: #60e0e0; z-index: 1000;">
        <div class="d-flex justify-space-between align-center ga-4 mx-auto h-100 px-4" style="max-width: 390px; min-width: 360px;">
            <v-btn icon="true" color="#60e0e0" style="box-shadow: none;" href="/setting"><cog-icon width="35" height="35"/></v-btn>
            <div class="d-flex justify-center align-center">
                <v-btn color="#60e0e0" style="box-shadow: none;" href="/dashboard">
                    <span style="font-size: 30px; line-height: 36px; font-weight: 400; color: #FFFFFF;">Plotting</span>
                </v-btn>
            </div>
            <v-btn icon="true" color="#60e0e0" style="box-shadow: none;" href="/store"><home-icon /></v-btn>
        </div>
    </header>
</template>

<style scoped></style>
