<script setup>
import UserProfileLayout from "@/components/layout/UserProfileLayout.vue";
import PassIcon from "@/components/icon/PassIcon.vue";
import CarouselLeft from "@/components/icon/CarouselLeft.vue";
import CarouselRight from "@/components/icon/CarouselRight.vue";
import HeartIcon from "@/components/icon/HeartIcon.vue";
import ProfileImage from "@/components/image/ProfileImage.vue";
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
