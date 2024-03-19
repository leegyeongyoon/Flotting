<script setup>
import { ref } from "vue";
import UserProfileImageCard from "@/components/card/UserProfileImageCard.vue";

const tab = ref(null);

const list = ref([]);
</script>

<template>
    <div class="w-100 px-6 py-8 d-flex flex-column" style="gap: 24px;">
        <div class="d-flex justify-center w-100">
            <div
                class="text-white font-weight-bold d-flex justify-center align-center"
                style="width: 268px; height: 63px; background-color: #60E0E0B2; box-shadow: 4px 4px 10px 0px #60E0E0 inset; border-radius: 16px; font-size: 25px;"
            >
                이번주 프로필
            </div>
        </div>
        <div class="d-flex justify-center w-100">
            <user-profile-image-card href="/profile" />
        </div>
        <div class="d-flex justify-center w-100">
            <user-profile-image-card href="/profile" />
        </div>
        <div class="d-flex justify-center w-100">
            <user-profile-image-card href="/profile" />
        </div>
        <div class="d-flex justify-center w-100">
            <v-card width="100%" style="height: 567px; box-shadow: 4px 4px 10px 0px #60E0E0; border-radius: 16px;">
                <div class="w-100 h-100 d-flex flex-column justify-center align-self-center">
                    <span class="text-center font-weight-bold" style="font-size: 20px; letter-spacing: 0;">이번 주 모든 프로필을</span>
                    <span class="text-center font-weight-bold" style="font-size: 20px; letter-spacing: 0;">확인하셨습니다.</span>
                    <br />
                    <span class="text-center font-weight-bold" style="font-size: 20px; letter-spacing: 0;"
                        >매주 <span style="color: #60E0E0;">월요일 19시</span>에</span
                    >
                    <span class="text-center font-weight-bold" style="font-size: 20px; letter-spacing: 0;">새로운 인연을 소개해드려요 !</span>
                </div>
            </v-card>
        </div>
        <div class="d-flex justify-center w-100">
            <v-btn
                width="281"
                height="47"
                class="font-weight-bold text-white text-center"
                style="box-shadow: 0px 4px 4px 0px #00000040; background: #60E0E0; border-radius: 16px; font-size:16px; letter-spacing: 0;"
            >
                새로운 인연 소개받기
            </v-btn>
        </div>
    </div>
</template>

<style scoped></style>
