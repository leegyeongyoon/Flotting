<script setup></script>

<template>
    <div class="d-flex align-center" style="width: 100%; padding: 57px 24px;">
        <div class="d-flex flex-column" style="width: 100%; border-radius: 16px; box-shadow: 4px 4px 10px 0px #60E0E0; padding: 53px 36px; gap:16px;">
            <v-btn to="/setting/my-profile" style="height: 73px; box-shadow: 0px 4px 4px 0px #00000040; background: #F1F1F1; border-radius: 16px;">
                <span style="font-weight: 900; font-size: 23px; line-height: 28px;">나의 프로필</span>
            </v-btn>
            <v-btn to="/setting/inquire" style="height: 73px; box-shadow: 0px 4px 4px 0px #00000040; background: #F1F1F1; border-radius: 16px;">
                <span style="font-weight: 900; font-size: 23px; line-height: 28px;">고객 문의</span>
            </v-btn>
            <v-btn to="/setting/notice" style="height: 73px; box-shadow: 0px 4px 4px 0px #00000040; background: #F1F1F1; border-radius: 16px;">
                <span style="font-weight: 900; font-size: 23px; line-height: 28px;">공지 사항</span>
            </v-btn>
            <v-btn to="/setting/invite" style="height: 73px; box-shadow: 0px 4px 4px 0px #00000040; background: #F1F1F1; border-radius: 16px;">
                <span style="font-weight: 900; font-size: 23px; line-height: 28px;">친구 초대</span>
            </v-btn>
            <v-btn to="/setting/block" style="height: 73px; box-shadow: 0px 4px 4px 0px #00000040; background: #F1F1F1; border-radius: 16px;">
                <span style="font-weight: 900; font-size: 23px; line-height: 28px;">지인 차단</span>
            </v-btn>
            <v-btn to="/setting/status" style="height: 73px; box-shadow: 0px 4px 4px 0px #00000040; background: #F1F1F1; border-radius: 16px;">
                <span style="font-weight: 900; font-size: 23px; line-height: 28px;">상태 변경</span>
            </v-btn>
        </div>
    </div>
</template>

<style scoped></style>
