<script setup>
import HomeIcon from "@/components/icon/HomeIcon.vue";
import CogIcon from "@/components/icon/CogIcon.vue";
import router from "@/router";

defineProps({
    start: {
        type: String,
        default: "cog"
    },
    title: {
        type: Boolean,
        default: true
    },
    end: {
        type: String,
        default: "store"
    }
});
</script>

<template>
    <header class="position-fixed w-100" style="top: 0; height: 60px; background-color: #60e0e0; z-index: 1000;">
        <div class="d-flex justify-space-between align-center ga-4 mx-auto h-100 px-4" style="max-width: 390px; min-width: 360px;">
            <div class="w-25">
                <v-btn v-if="start === 'cog'" icon="true" color="#60e0e0" style="box-shadow: none;" href="/setting"
                    ><cog-icon width="35" height="35"
                /></v-btn>
                <v-btn v-else-if="start === 'back'" icon="true" color="#60e0e0" style="box-shadow: none;" @click="router.go(-1)"
                    ><v-icon icon="mdi-arrow-left" size="large" color="white"></v-icon
                ></v-btn>
            </div>
            <div class="d-flex justify-center align-center w-100">
                <v-btn v-if="title" class="text-none" color="#60e0e0" style="box-shadow: none;" href="/dashboard" variant="text">
                    <span style="font-size: 30px; line-height: 36px; font-weight: 400; color: #FFFFFF; letter-spacing: 0;">Plotting</span>
                </v-btn>
                <span v-else style="font-size: 30px; line-height: 36px; font-weight: 400; color: #FFFFFF; letter-spacing: 0;">Plotting</span>
            </div>
            <div class="w-25">
                <v-btn v-if="end === 'store'" icon="true" color="#60e0e0" style="box-shadow: none;" href="/store"><home-icon /></v-btn>
            </div>
        </div>
    </header>
</template>

<style scoped></style>
