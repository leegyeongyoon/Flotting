<template>
    <div class="position-fixed w-100" style="bottom: 0; height: 80px; background-color: #60e0e0; z-index: 1000;">
        <div class="d-flex justify-space-between align-center mx-auto h-100 ga-0" style="max-width: 1024px; min-width: 360px;">
            <v-btn height="100%" style="width: calc(50% - 1px); border-radius: 0; box-shadow: none;" color="#60e0e0" href="/plotting">
                <div class="d-flex flex-column justify-center align-center" style="gap: 4px;">
                    <account-icon width="39" height="39" />
                    <span class="text-white font-weight-bold" style="font-size: 14px; letter-spacing: 0;">이번주 프로필</span>
                </div>
            </v-btn>
            <div style="width: 2px; height: 100%; background-color: white;"></div>
            <v-btn height="100%" style="width: calc(50% - 1px); border-radius: 0; box-shadow: none;" color="#60e0e0" href="/setting">
                <div class="d-flex flex-column justify-center align-center" style="gap: 4px;">
                    <heart-icon></heart-icon>
                    <span class="text-white font-weight-bold" style="font-size: 14px; letter-spacing: 0;">플러팅 현황</span>
                </div>
            </v-btn>
        </div>
    </div>
</template>

<script setup>
import HeartIcon from "@/components/icon/HeartIcon.vue";
import AccountIcon from "@/components/icon/AccountIcon.vue";
</script>

<style scoped></style>
