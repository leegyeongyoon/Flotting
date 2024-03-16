<template>
    <v-bottom-navigation bg-color="#60e0e0" height="80" model-value="false">
        <div class="d-flex justify-center align-center w-100">
            <v-btn width="49%" height="100%">
                <div class="d-flex flex-column justify-center align-center" style="gap: 4px;">
                    <heart-icon></heart-icon>
                    <span class="text-white font-weight-bold" style="font-size: 14px; letter-spacing: 0;">플러팅</span>
                </div>
            </v-btn>
            <div style="width: 2px; height: 100%; background-color: white;"></div>
            <v-btn width="49%" height="100%">
                <div class="d-flex flex-column justify-center align-center" style="gap: 4px;">
                    <cog-icon></cog-icon>
                    <span class="text-white font-weight-bold" style="font-size: 14px; letter-spacing: 0;">설정</span>
                </div>
            </v-btn>
        </div>
    </v-bottom-navigation>
</template>

<script setup>
import HeartIcon from "@/components/icon/HeartIcon.vue";
import CogIcon from "@/components/icon/CogIcon.vue";
</script>

<style scoped></style>
