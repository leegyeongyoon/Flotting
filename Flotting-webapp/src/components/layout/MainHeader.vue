<template>
    <v-app-bar :elevation="0" color="#60e0e0" height="60">
        <div class="d-flex justify-center align-center w-100 ga-4">
            <v-btn icon="true"><bell-icon /></v-btn>
            <div class="d-flex justify-center align-center" style="width: 244px">
                <span class="font-weight-bold text-white text-h4">Plotting</span>
            </div>
            <v-btn icon="true"><home-icon /></v-btn>
        </div>
    </v-app-bar>
</template>

<script setup>
import HomeIcon from "@/components/icon/HomeIcon.vue";
import BellIcon from "@/components/icon/BellIcon.vue";
</script>

<style scoped></style>
