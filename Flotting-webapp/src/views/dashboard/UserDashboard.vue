<script setup>
import { ref } from "vue";
import UserProfileImageCard from "@/components/card/UserProfileImageCard.vue";

const tab = ref(null);

const list = ref([]);
</script>

<template>
    <v-main class="w-100 h-100 pb-0">
        <v-main class="mx-10 mt-7 pa-0 d-flex ga-6">
            <div class="w-100">
                <v-btn
                    class="w-100 text-center"
                    style="height: 63px; padding-block: 10px; box-shadow: 4px 4px 10px 0px #60E0E0; border-radius: 16px;"
                    href="/dashboard"
                >
                    <div class="d-flex flex-column ">
                        <span class="font-weight-bold" style="font-size: 14px; letter-spacing: 0; ">이번주</span>
                        <span class="font-weight-bold" style="font-size: 14px; letter-spacing: 0;">소개 프로필</span>
                    </div>
                </v-btn>
            </div>
            <div class="w-100"></div>
        </v-main>
        <v-main class="pa-0">
            <v-container class="my-3 h-auto">
                <v-row>
                    <v-col cols="12" class="px-6">
                        <user-profile-image-card href="/profile" />
                    </v-col>
                    <v-col cols="12" class="px-6">
                        <user-profile-image-card href="/profile" />
                    </v-col>
                    <v-col cols="12" class="px-6">
                        <user-profile-image-card href="/profile" />
                    </v-col>
                    <v-col cols="12" class="px-6">
                        <v-card width="100%" style="height: 567px; box-shadow: 4px 4px 10px 0px #60E0E0; border-radius: 16px;">
                            <div class="w-100 h-100 d-flex flex-column justify-center align-self-center">
                                <span class="text-center font-weight-bold" style="font-size: 20px; letter-spacing: 0;">이번 주 모든 프로필을</span>
                                <span class="text-center font-weight-bold" style="font-size: 20px; letter-spacing: 0;">확인하셨습니다.</span>
                                <br />
                                <span class="text-center font-weight-bold" style="font-size: 20px; letter-spacing: 0;"
                                    >매주 <span style="color: #60E0E0;">월요일 19시</span>에</span
                                >
                                <span class="text-center font-weight-bold" style="font-size: 20px; letter-spacing: 0;"
                                    >새로운 인연을 소개해드려요 !</span
                                >
                            </div>
                        </v-card>
                    </v-col>
                    <v-col cols="12" class="px-13">
                        <v-btn
                            width="100%"
                            height="48"
                            class="font-weight-bold text-white text-center"
                            style="box-shadow: 0px 4px 4px 0px #00000040; background: #60E0E0; border-radius: 16px; font-size:16px; letter-spacing: 0;"
                        >
                            새로운 인연 소개받기
                        </v-btn>
                    </v-col>
                </v-row>
            </v-container>
        </v-main>
    </v-main>
</template>

<style scoped></style>
