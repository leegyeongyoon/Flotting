<script setup>
import { ref } from "vue";

const dormancyDialog = ref(null);
const resignDialog = ref(null);
</script>

<template>
    <div class="d-flex flex-column justify-center align-center" style="width:100%; padding: 27px 24px; gap: 24px;">
        <div
            class="d-flex flex-column justify-center align-center"
            style="border-radius: 16px; width: 236px; height: 51px; box-shadow: 0px 4px 4px 0px #60E0E0; background: #F1F1F1;"
        >
            <span style="font-weight: 900; font-size: 23px; line-height: 28px;">내 상태 변경</span>
        </div>
        <div class="d-flex flex-column" style="width: 100%; gap:7px;">
            <div class="d-flex flex-column justify-center align-center" style="width: 172px; height: 55px; border-radius: 16px; background: #F7F7F7;">
                <span style="font-weight: 700; font-size: 20px; line-height: 24px;">서비스 휴면</span>
            </div>
            <div
                class="d-flex flex-column justify-center align-center"
                style="width: 100%; border-radius: 16px; background: #F1F1F1; padding-block: 25px;"
            >
                <span style="font-weight: 300; font-size: 17px; line-height: 21px;">나의 서비스 상태가 ‘휴면’으로 변경되며,</span>
                <span style="font-weight: 300; font-size: 17px; line-height: 21px;">나의 프로필이 모두에게 비공개 됩니다.</span>
                <br />
                <span style="font-weight: 300; font-size: 17px; line-height: 21px;">이후 재이용 시 프로필 재등록 없이</span>
                <span style="font-weight: 300; font-size: 17px; line-height: 21px;">바로 다시 서비스 재이용이 가능합니다.</span>
            </div>
        </div>
        <div class="d-flex flex-column" style="width: 100%; gap:7px;">
            <div class="d-flex flex-column justify-center align-center" style="width: 172px; height: 55px; border-radius: 16px; background: #F7F7F7;">
                <span style="font-weight: 700; font-size: 20px; line-height: 24px;">서비스 탈퇴</span>
            </div>
            <div
                class="d-flex flex-column justify-center align-center"
                style="width: 100%; border-radius: 16px; background: #F1F1F1; padding-block: 25px;"
            >
                <span style="font-weight: 300; font-size: 17px; line-height: 21px;">플러팅 서비스를 ‘탈퇴' 하게되면,</span>
                <span style="font-weight: 300; font-size: 17px; line-height: 21px;">플러팅 내 모든 개인정보가 삭제됩니다.</span>
                <br />
                <span style="font-weight: 300; font-size: 17px; line-height: 21px;">이후 재이용 시 프로필을 재등록 해야하며,</span>
                <span style="font-weight: 300; font-size: 17px; line-height: 21px;">상대방과의 매칭 기록 및 모든 결제 내역은</span>
                <span style="font-weight: 300; font-size: 17px; line-height: 21px;">복구가 절대 불가합니다.</span>
            </div>
        </div>
        <div
            class="d-flex justify-center align-center"
            style="width: 100%; background: #F1F1F1; box-shadow: 0px 4px 4px 0px #00000040; padding-block: 15px; border-radius: 16px; gap: 15px;"
        >
            <v-btn color="#ffffff" style="height: 51px; border-radius: 16px;" @click="dormancyDialog = true">
                <div class="d-flex flex-column justify-center align-center">
                    <span style="font-weight: 700; font-size: 14px; line-height: 17px; letter-spacing: normal;">서비스 휴면</span>
                    <span style="font-weight: 400; font-size: 10px; line-height: 12px; letter-spacing: normal;">(다음에 다시 이용할게요)</span>
                </div>
            </v-btn>
            <v-dialog v-model="dormancyDialog" width="auto" :persistent="true">
                <v-card
                    class="d-flex flex-column"
                    style="padding-block: 30px; background-color: #FFFFFF; box-shadow: 0px 4px 4px 0px #60E0E0; width: 309px; height: 465px; border-radius: 16px;"
                >
                    <div class="d-flex justify-center align-center" style="background: #60E0E0; width: 100%; height: 60px; margin-bottom: 24px;">
                        <span style="font-size: 30px; color: #FFFFFF; font-weight: 400;">Plotting</span>
                    </div>
                    <div
                        class="d-flex justify-center align-center flex-column"
                        style="height: 100%; margin-inline: 26px; padding-inline: 10px; margin-bottom: 26px; width: 256px; background: #F1F1F1; border-radius: 16px; font-weight: 300; font-size: 13px;  line-height: 16px; text-align: center;"
                    >
                        <span>나의 서비스상태가 '휴면'으로 변경되며,</span>
                        <span>나의 프로필이 모두에게 비공개 됩니다.</span>
                        <br />
                        <span>이후 재이용 시 프로필 재등록 없이</span>
                        <span>바로 다시 서비스 재이용이 가능합니다.</span>
                        <br />
                        <span>모든 내용을 읽고 동의하시겠습니까?</span>
                    </div>
                    <div class="d-flex justify-center w-100" style="margin-bottom: 14px;">
                        <v-btn
                            color="#60E0E0"
                            style="border: 1px solid #60E0E0; border-radius: 24px; width: 268px; height: 44px; box-shadow: none;"
                            @click="dormancyDialog = false"
                        >
                            <span
                                style="text-align: center; color:#FFFFFF; font-weight: 700; font-size: 20px; line-height: 24px; letter-spacing: normal;"
                                >서비스 계속 이용</span
                            >
                        </v-btn>
                    </div>
                    <div class="d-flex justify-center w-100">
                        <v-btn
                            style="border: 1px solid #C4C4C4; border-radius: 24px; width: 268px; height: 44px; box-shadow: none;"
                            @click="dormancyDialog = false"
                        >
                            <span style="text-align: center; font-weight: 400; font-size: 20px; line-height: 24px; letter-spacing: normal;"
                                >서비스 휴면</span
                            >
                        </v-btn>
                    </div>
                </v-card>
            </v-dialog>
            <v-btn color="#ffffff" style="height: 51px; border-radius: 16px;" @click="resignDialog = true">
                <div class="d-flex flex-column justify-center align-center">
                    <span style="font-weight: 700; font-size: 14px; line-height: 17px; letter-spacing: normal;">서비스 탈퇴</span>
                    <span style="font-weight: 400; font-size: 10px; line-height: 12px; letter-spacing: normal;">(모든 기록 삭제해주세요)</span>
                </div>
            </v-btn>
            <v-dialog v-model="resignDialog" width="auto" :persistent="true">
                <v-card
                    class="d-flex flex-column"
                    style="padding-block: 30px; background-color: #FFFFFF; box-shadow: 0px 4px 4px 0px #60E0E0; width: 309px; height: 465px; border-radius: 16px;"
                >
                    <div class="d-flex justify-center align-center" style="background: #60E0E0; width: 100%; height: 60px; margin-bottom: 24px;">
                        <span style="font-size: 30px; color: #FFFFFF; font-weight: 400;">Plotting</span>
                    </div>
                    <div
                        class="d-flex justify-center align-center flex-column"
                        style="height: 100%; margin-inline: 26px; padding-inline: 6px; margin-bottom: 26px; width: 256px; background: #F1F1F1; border-radius: 16px; font-weight: 300; font-size: 13px;  line-height: 16px; text-align: center;"
                    >
                        <span>플러팅 서비스를 ‘탈퇴' 하게되면,</span>
                        <span>플러팅 내 모든 개인정보가 삭제됩니다.</span>
                        <br />
                        <span>이후 재이용 시 프로필을 재등록 해야하며,</span>
                        <span>상대방과의 매칭 기록 및 모든 결제 내역은</span>
                        <span>복구가 절대 불가합니다.</span>
                        <br />
                        <span>모든 내용을 읽고 동의하시겠습니까?</span>
                    </div>
                    <div class="d-flex justify-center w-100" style="margin-bottom: 14px;">
                        <v-btn
                            color="#60E0E0"
                            style="border: 1px solid #60E0E0; border-radius: 24px; width: 268px; height: 44px; box-shadow: none;"
                            @click="resignDialog = false"
                        >
                            <span
                                style="text-align: center; color:#FFFFFF; font-weight: 700; font-size: 20px; line-height: 24px; letter-spacing: normal;"
                                >서비스 계속 이용</span
                            >
                        </v-btn>
                    </div>
                    <div class="d-flex justify-center w-100">
                        <v-btn
                            style="border: 1px solid #C4C4C4; border-radius: 24px; width: 268px; height: 44px; box-shadow: none;"
                            @click="resignDialog = false"
                        >
                            <span style="text-align: center; font-weight: 400; font-size: 20px; line-height: 24px; letter-spacing: normal;"
                                >서비스 탈퇴</span
                            >
                        </v-btn>
                    </div>
                </v-card>
            </v-dialog>
        </div>
    </div>
</template>

<style scoped></style>
