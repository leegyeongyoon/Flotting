<script setup>
import MainHeader from "@/components/layout/MainHeader.vue";
</script>

<template>
    <div class="w-100 h-100">
        <main-header start="" end="" :title="false" />
        <main class="w-100 h-100" style="padding-top: 60px;">
            <div class="mx-auto" style="max-width: 390px; min-width: 360px;">
                <div class="w-100 d-flex flex-column justify-center align-center" style="padding-top: 29px; padding-inline: 26px;">
                    <span style="font-size: 28px; font-weight: 800; line-height: 34px; text-align: center; padding-bottom: 16px;"
                        >프로필 등록 진행 현황</span
                    >
                    <div class="w-100" style="margin-bottom: 60px;">진행률</div>
                    <div>사진 등록</div>
                    <div>
                        <v-btn
                            style="height: fit-content; border: 1px solid #3B3B3D; border-radius: 16px; box-shadow: 0px 4px 4px 0px #00000040; color: #3B3B3D; font-size: 20px; font-weight: 700; line-height: 24.2px; padding: 8px 26px; letter-spacing: 0;"
                            >확인했습니다.</v-btn
                        >
                    </div>
                </div>
            </div>
        </main>
    </div>
</template>

<style scoped></style>
