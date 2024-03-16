<script setup>
import MainHeader from "@/components/layout/MainHeader.vue";
import CarouselLeft from "@/components/icon/CarouselLeft.vue";
import CarouselRight from "@/components/icon/CarouselRight.vue";
import HeartIcon from "@/components/icon/HeartIcon.vue";
import PassIcon from "@/components/icon/PassIcon.vue";
</script>

<template>
    <v-main class="pb-0 h-100 w-100">
        <v-container class="pt-5 px-6">
            <v-row>
                <v-col cols="12">
                    <v-carousel height="auto" hide-delimiters style="box-shadow: 4px 4px 10px 0px #00000040;">
                        <template v-slot:prev="{ props }">
                            <carousel-left @click="props.onClick"></carousel-left>
                        </template>
                        <template v-slot:next="{ props }">
                            <carousel-right @click="props.onClick"></carousel-right>
                        </template>
                        <v-carousel-item>
                            <div
                                class="w-100"
                                style="aspect-ratio: 1; background: #F1F1F1; background-image: url('https://i.namu.wiki/i/VVHm5cCXt7SrQIQLbIc9TKDU7XQmDSnVFL9L3pJNsMGHzCtCe62jPNNpWHvt-1bPd7N-2FAap95kW1tDrNJC72QOCDXTSGtF7fxgEGrse1ru_xupMj7NSzbUEhEQU9AUKQI_QyH1HaoEDHpFOzhK_A.webp'); background-size: cover; background-position: 50%;"
                            ></div>
                        </v-carousel-item>
                        <v-carousel-item>
                            <div
                                class="w-100"
                                style="aspect-ratio: 1; background: #F1F1F1; background-image: url('https://i.namu.wiki/i/VE44Pr9Xrqrinf43GS7Yu945HyT3XyKWhmisPJcZ6qaCqV9J4oLnpUOHSrY-rjBh8j6ZI-3KtYkNf9x8sBe0Ew.webp'); background-size: cover; background-position: 50%;"
                            ></div>
                        </v-carousel-item>
                        <v-carousel-item>
                            <div
                                class="w-100"
                                style="aspect-ratio: 1; background: #F1F1F1; background-image: url('https://cdn.k-trendynews.com/news/photo/202312/162732_242532_2228.jpg'); background-size: cover; background-position: 50%;"
                            ></div>
                        </v-carousel-item>
                    </v-carousel>
                </v-col>
                <v-col cols="12">
                    <v-card
                        width="100%"
                        style="box-shadow: 4px 4px 10px 0px #00000040; border-radius: 16px; padding-block: 6px; padding-inline: 10px;"
                    >
                        <div class="w-100 d-flex" style="gap: 14px;">
                            <div style="width: 70px; min-width:70px; height: 70px;  background-color: #F1F1F1; border-radius: 70px; "></div>
                            <div class="w-100" style="height: 70px; background-color: #F1F1F1; border-radius: 16px; "></div>
                        </div>
                    </v-card>
                </v-col>
                <v-col cols="12">
                    <v-card width="100%" style="box-shadow: 4px 4px 10px 0px #00000040; border-radius: 16px;">
                        <div class="w-100 d-flex flex-column pa-4 ga-6">
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
                    </v-card>
                </v-col>
                <v-col cols="12">
                    <div class="w-100 d-flex justify-center" style="gap: 18px;">
                        <v-btn color="#60E0E0" style="width: 152px; height: 82px; box-shadow: 0px 4px 4px 0px #00000040; border-radius: 16px;">
                            <div class="d-flex flex-column justify-center align-center h-100" style="">
                                <heart-icon></heart-icon>
                                <span class="font-weight-bold text-white" style="font-size: 20px; letter-spacing: 0;">플러팅 보내기</span>
                            </div>
                        </v-btn>
                        <v-btn
                            color="#60E0E0"
                            style="width: 152px; height: 82px; box-shadow: 0px 4px 4px 0px #00000040; border-radius: 16px;"
                            href="/dashboard"
                        >
                            <div class="d-flex flex-column justify-center align-center h-100" style="">
                                <pass-icon></pass-icon>
                                <span class="font-weight-bold text-white" style="font-size: 20px; letter-spacing: 0;">패스할게요</span>
                            </div>
                        </v-btn>
                    </div>
                </v-col>
            </v-row>
        </v-container>
    </v-main>
</template>

<style scoped></style>
