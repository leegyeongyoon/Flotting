<script>
import UserWeekendList from "@/views/dashboard/list/UserWeekendList.vue";
import UserCurrentList from "@/views/dashboard/list/UserCurrentList.vue";
import MainHeader from "@/components/layout/MainHeader.vue";
import MainNavigation from "@/components/layout/MainNavigation.vue";

export default {
    name: "UserDashboard",
    components: {},
    data() {
        return {
            tab: null
        };
    }
};
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
                        <v-card width="100%" style="box-shadow: 4px 4px 10px 0px #60E0E0; border-radius: 16px;" href="/profile">
                            <div class="w-100 pa-4 d-flex flex-column ga-4 justify-center align-center">
                                <div
                                    style="width: 98px; aspect-ratio: 1; background: #F1F1F1; border-radius: 16px; background-image: url('https://image.kr.canon/pds/gallery/open/1257249062209_0d8F3Kb90P.jpg'); background-size: cover; background-position: 50%; filter: blur(0.5px);"
                                ></div>
                                <div class="text-center w-100" style="height: 63px; background: #F1F1F1; border-radius: 16px;"></div>
                                <div
                                    class="text-center w-100 d-flex flex-column justify-end align-start pl-6 pb-3"
                                    style="aspect-ratio: 1; background: #F1F1F1; border-radius: 16px; background-image: url('https://i.namu.wiki/i/VVHm5cCXt7SrQIQLbIc9TKDU7XQmDSnVFL9L3pJNsMGHzCtCe62jPNNpWHvt-1bPd7N-2FAap95kW1tDrNJC72QOCDXTSGtF7fxgEGrse1ru_xupMj7NSzbUEhEQU9AUKQI_QyH1HaoEDHpFOzhK_A.webp'); background-size: cover; background-position: 50%;"
                                >
                                    <span
                                        class="font-weight-bold"
                                        style="font-size: 18px; text-shadow: -1px 0px white, 0px 1px white, 1px 0px white, 0px -1px white; "
                                        >원빈</span
                                    >
                                    <span
                                        class="font-weight-bold"
                                        style="font-size: 18px; text-shadow: -1px 0px white, 0px 1px white, 1px 0px white, 0px -1px white; "
                                        >가수, 서울 관악구</span
                                    >
                                </div>
                            </div>
                        </v-card>
                    </v-col>
                    <v-col cols="12" class="px-6">
                        <v-card width="100%" style="box-shadow: 4px 4px 10px 0px #60E0E0; border-radius: 16px;" href="/profile">
                            <div class="w-100 pa-4 d-flex flex-column ga-4 justify-center align-center">
                                <div
                                    style="width: 98px; aspect-ratio: 1; background: #F1F1F1; border-radius: 16px; background-image: url('https://image.kr.canon/pds/gallery/open/1257249062209_0d8F3Kb90P.jpg'); background-size: cover; background-position: 50%; filter: blur(0.5px);"
                                ></div>
                                <div class="text-center w-100" style="height: 63px; background: #F1F1F1; border-radius: 16px;"></div>
                                <div
                                    class="text-center w-100 d-flex flex-column justify-end align-start pl-6 pb-3"
                                    style="aspect-ratio: 1; background: #F1F1F1; border-radius: 16px; background-image: url('https://i.namu.wiki/i/VVHm5cCXt7SrQIQLbIc9TKDU7XQmDSnVFL9L3pJNsMGHzCtCe62jPNNpWHvt-1bPd7N-2FAap95kW1tDrNJC72QOCDXTSGtF7fxgEGrse1ru_xupMj7NSzbUEhEQU9AUKQI_QyH1HaoEDHpFOzhK_A.webp'); background-size: cover; background-position: 50%;"
                                >
                                    <span
                                        class="font-weight-bold"
                                        style="font-size: 18px; text-shadow: -1px 0px white, 0px 1px white, 1px 0px white, 0px -1px white;"
                                        >원빈</span
                                    >
                                    <span
                                        class="font-weight-bold"
                                        style="font-size: 18px;  text-shadow: -1px 0px white, 0px 1px white, 1px 0px white, 0px -1px white;"
                                        >가수, 서울 관악구</span
                                    >
                                </div>
                            </div>
                        </v-card>
                    </v-col>
                    <v-col cols="12" class="px-6">
                        <v-card width="100%" style="box-shadow: 4px 4px 10px 0px #60E0E0; border-radius: 16px;" href="/profile">
                            <div class="w-100 pa-4 d-flex flex-column ga-4 justify-center align-center">
                                <div
                                    style="width: 98px; aspect-ratio: 1; background: #F1F1F1; border-radius: 16px; background-image: url('https://image.kr.canon/pds/gallery/open/1257249062209_0d8F3Kb90P.jpg'); background-size: cover; background-position: 50%; filter: blur(0.5px);"
                                ></div>
                                <div class="text-center w-100" style="height: 63px; background: #F1F1F1; border-radius: 16px;"></div>
                                <div
                                    class="text-center w-100 d-flex flex-column justify-end align-start pl-6 pb-3"
                                    style="aspect-ratio: 1; background: #F1F1F1; border-radius: 16px; background-image: url('https://i.namu.wiki/i/VVHm5cCXt7SrQIQLbIc9TKDU7XQmDSnVFL9L3pJNsMGHzCtCe62jPNNpWHvt-1bPd7N-2FAap95kW1tDrNJC72QOCDXTSGtF7fxgEGrse1ru_xupMj7NSzbUEhEQU9AUKQI_QyH1HaoEDHpFOzhK_A.webp'); background-size: cover; background-position: 50%;"
                                >
                                    <span
                                        class="font-weight-bold"
                                        style="font-size: 18px;  text-shadow: -1px 0px white, 0px 1px white, 1px 0px white, 0px -1px white;"
                                        >원빈</span
                                    >
                                    <span
                                        class="font-weight-bold"
                                        style="font-size: 18px; text-shadow: -1px 0px white, 0px 1px white, 1px 0px white, 0px -1px white; "
                                        >가수, 서울 관악구</span
                                    >
                                </div>
                            </div>
                        </v-card>
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
