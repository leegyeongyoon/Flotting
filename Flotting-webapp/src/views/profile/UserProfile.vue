<script setup>
import CarouselLeft from "@/components/icon/CarouselLeft.vue";
import CarouselRight from "@/components/icon/CarouselRight.vue";
import HeartIcon from "@/components/icon/HeartIcon.vue";
import PassIcon from "@/components/icon/PassIcon.vue";
import ProfileImage from "@/components/image/ProfileImage.vue";
import UserProfileLayout from "@/components/layout/UserProfileLayout.vue";
import { ref } from "vue";

const refuseDialog = ref(null);
const agreeDialog = ref(null);
</script>

<template>
    <user-profile-layout>
        <div class="w-100">
            <v-carousel height="auto" hide-delimiters style="box-shadow: 4px 4px 10px 0px #00000040;">
                <template #prev="{ props }">
                    <carousel-left @click="props.onClick"></carousel-left>
                </template>
                <template #next="{ props }">
                    <carousel-right @click="props.onClick"></carousel-right>
                </template>
                <v-carousel-item>
                    <profile-image
                        src="https://i.namu.wiki/i/RmPNdn0sjKx-SYRoeRffcS5pc1rZXK-uA6PQqqU_kLFrqdMVdD3vM9HeF4c_1DLloZ1qu8KZLDwRwO8y-3vNriadzKfcXOeWaQFwwLC2Bn_HxoX1E-clw78tDqSLGLb37UHelCwkxGLeqKIpHvqPtA.webp"
                    />
                </v-carousel-item>
                <v-carousel-item>
                    <profile-image
                        src="https://i.namu.wiki/i/VE44Pr9Xrqrinf43GS7Yu945HyT3XyKWhmisPJcZ6qaCqV9J4oLnpUOHSrY-rjBh8j6ZI-3KtYkNf9x8sBe0Ew.webp"
                    />
                </v-carousel-item>
                <v-carousel-item>
                    <profile-image src="https://cdn.k-trendynews.com/news/photo/202312/162732_242532_2228.jpg" />
                </v-carousel-item>
            </v-carousel>
        </div>
        <div
            class="w-100 d-flex"
            style="gap: 14px; box-shadow: 4px 4px 10px 0px #00000040; border-radius: 16px; padding-block: 6px; padding-inline: 10px;"
        >
            <div style="width: 70px; min-width:70px; height: 70px;  background-color: #F1F1F1; border-radius: 70px; "></div>
            <div class="w-100" style="height: 70px; background-color: #F1F1F1; border-radius: 16px; "></div>
        </div>
        <div class="w-100 d-flex flex-column pa-4 ga-6" style="box-shadow: 4px 4px 10px 0px #00000040; border-radius: 16px;">
            <div class="w-100" style="height: 100px; background-color: #F1F1F1; border-radius: 16px; "></div>
            <div class="w-100" style="background-color: #60E0E0; border-radius: 16px; padding:10px;">
                <span class="font-weight-bold text-white" style="font-size: 17px;">나의 매력은 ?</span>
            </div>
            <div class="w-100" style="height: 5px; background-color: #60E0E0; border-radius: 16px; "></div>
            <div class="w-100" style="height: 100px; background-color: #F1F1F1; border-radius: 16px; "></div>
            <div class="w-100" style="background-color: #60E0E0; border-radius: 16px; padding:10px;">
                <span class="font-weight-bold text-white" style="font-size: 17px;">나의 연애관은 ?</span>
            </div>
            <div class="w-100" style="height: 5px; background-color: #60E0E0; border-radius: 16px; "></div>
            <div class="w-100" style="height: 100px; background-color: #F1F1F1; border-radius: 16px; "></div>
            <div class="w-100" style="background-color: #60E0E0; border-radius: 16px; padding:10px;">
                <span class="font-weight-bold text-white" style="font-size: 17px;">나의 취미는 ?</span>
            </div>
            <div class="w-100" style="height: 5px; background-color: #60E0E0; border-radius: 16px; "></div>
            <div class="w-100" style="height: 100px; background-color: #F1F1F1; border-radius: 16px; "></div>
        </div>
        <div class="w-100 d-flex justify-space-between">
            <v-btn
                color="#60E0E0"
                style="width: 49%; height: 82px; box-shadow: 0px 4px 4px 0px #00000040; border-radius: 16px;"
                @click="agreeDialog = true"
            >
                <div class="d-flex flex-column justify-center align-center h-100" style="gap: 4px;">
                    <heart-icon></heart-icon>
                    <span class="font-weight-bold text-white" style="font-size: 20px; letter-spacing: 0;">플러팅 보내기</span>
                </div>
            </v-btn>
            <v-dialog v-model="agreeDialog" width="auto" :persistent="true">
                <v-card
                    class="d-flex flex-column"
                    style="padding-block: 30px; background-color: #FFFFFF; box-shadow: 0px 4px 4px 0px #60E0E0; width: 309px; height: 465px; border-radius: 16px;"
                >
                    <div class="d-flex justify-center align-center" style="background: #60E0E0; width: 100%; height: 60px; margin-bottom: 24px;">
                        <span style="font-size: 30px; color: #FFFFFF; font-weight: 400;">Plotting</span>
                    </div>
                    <div
                        class="d-flex justify-center align-center flex-column"
                        style="height: 200px; margin-inline: 26px; margin-bottom: 26px; width: 256px; background: #F1F1F1; border-radius: 16px; font-size: 16px; font-weight: 500; line-height: 19px; text-align: center;"
                    >
                        <span> 플러팅을 보내기 위해</span>
                        <span><span style="font-weight: 800;">매칭권</span>을 먼저 구매해주세요<br /></span>
                        <span>😀</span>
                    </div>
                    <div class="d-flex justify-center w-100" style="margin-bottom: 14px;">
                        <v-btn
                            color="#60E0E0"
                            style="border: 1px solid #60E0E0; border-radius: 24px; width: 268px; height: 44px; box-shadow: none; "
                            @click="agreeDialog = false"
                        >
                            <span style="text-align: center; color:#FFFFFF; font-weight: 700; font-size: 20px; line-height: 24px;"
                                >구매하러 가기 !</span
                            >
                        </v-btn>
                    </div>
                    <div class="d-flex justify-center w-100">
                        <v-btn
                            style="border: 1px solid #C4C4C4; border-radius: 24px; width: 268px; height: 44px; box-shadow: none;"
                            @click="agreeDialog = false"
                        >
                            <span style="text-align: center; font-weight: 400; font-size: 18px; line-height: 22px;">새로운 인연 포기할게요..</span>
                        </v-btn>
                    </div>
                </v-card>
            </v-dialog>
            <v-btn
                color="#60E0E0"
                style="width: 49%; height: 82px; box-shadow: 0px 4px 4px 0px #00000040; border-radius: 16px;"
                @click="refuseDialog = true"
            >
                <div class="d-flex flex-column justify-center align-center h-100" style="gap: 4px;">
                    <pass-icon></pass-icon>
                    <span class="font-weight-bold text-white" style="font-size: 20px; letter-spacing: 0;">패스할게요</span>
                </div>
            </v-btn>
            <v-dialog v-model="refuseDialog" width="auto" :persistent="true">
                <v-card
                    class="d-flex flex-column"
                    style="padding-block: 30px; background-color: #FFFFFF; box-shadow: 0px 4px 4px 0px #60E0E0; width: 309px; height: 465px; border-radius: 16px;"
                >
                    <div class="d-flex justify-center align-center" style="background: #60E0E0; width: 100%; height: 60px; margin-bottom: 24px;">
                        <span style="font-size: 30px; color: #FFFFFF; font-weight: 400;">Plotting</span>
                    </div>
                    <div
                        class="d-flex justify-center align-center flex-column"
                        style="height: 200px; margin-inline: 26px; margin-bottom: 26px; width: 256px; background: #F1F1F1; border-radius: 16px; font-size: 18px; font-weight: 700; line-height: 22px; text-align: center;"
                    >
                        <span>거절하시면,</span>
                        <span>해당 프로필은</span>
                        <span>재열람이 불가능합니다.</span>
                        <br />
                        <span>정말 패스하시겠습니까 ?</span>
                    </div>
                    <div class="d-flex justify-center w-100" style="margin-bottom: 14px;">
                        <v-btn
                            color="#60E0E0"
                            style="border: 1px solid #60E0E0; border-radius: 24px; width: 268px; height: 44px; box-shadow: none;"
                            @click="refuseDialog = false"
                        >
                            <span style="text-align: center; color:#FFFFFF; font-weight: 700; font-size: 20px; line-height: 24px;"
                                >한 번 더 생각해 볼게요</span
                            >
                        </v-btn>
                    </div>
                    <div class="d-flex justify-center w-100">
                        <v-btn
                            style="border: 1px solid #C4C4C4; border-radius: 24px; width: 268px; height: 44px; box-shadow: none;"
                            @click="refuseDialog = false"
                        >
                            <span style="text-align: center; font-weight: 400; font-size: 18px; line-height: 22px;">네 패스할게요</span>
                        </v-btn>
                    </div>
                </v-card>
            </v-dialog>
        </div>
        <div class="w-100 d-flex justify-center" style="">
            <div
                class="d-flex justify-center align-center"
                style="background: #60E0E0; box-shadow: 0px 4px 4px 0px #00000040; text-align: center; width: 310px; height: 64px; border-radius: 16px;"
            >
                <span class="font-weight-bold" style="font-size: 18px; color: white; line-height: 22px;"
                    >플러팅 중 입니다...<br />상대방의 답변을 기다리고 있습니다</span
                >
            </div>
        </div>
        <div class="w-100 d-flex justify-center" style="">
            <div
                class="d-flex justify-center align-center"
                style="background: #3B3B3D; box-shadow: 0px 4px 4px 0px #00000040; text-align: center; width: 310px; height: 64px; border-radius: 16px;"
            >
                <span class="font-weight-bold" style="font-size: 18px; color: #60E0E0; line-height: 22px;"
                    >매칭이 성사되었습니다 😀<br />010-0000-0000</span
                >
            </div>
        </div>
        <div class="w-100 d-flex justify-center" style="">
            <div
                class="d-flex justify-center align-center"
                style="background: #3B3B3D; box-shadow: 0px 4px 4px 0px #00000040; text-align: center; width: 310px; height: 64px; border-radius: 16px;"
            >
                <span class="font-weight-bold" style="font-size: 18px; color: #60E0E0; line-height: 22px; ">상대방이 플러팅을 거절했습니다</span>
            </div>
        </div>
        <div class="w-100 d-flex justify-center" style="">
            <div
                class="d-flex justify-center align-center"
                style="background: #3B3B3D; box-shadow: 0px 4px 4px 0px #00000040; text-align: center; width: 310px; height: 64px; border-radius: 16px;"
            >
                <span class="font-weight-bold" style="font-size: 18px; color: #60E0E0; line-height: 22px; ">010-0000-0000</span>
            </div>
        </div>
    </user-profile-layout>
</template>

<style scoped></style>
