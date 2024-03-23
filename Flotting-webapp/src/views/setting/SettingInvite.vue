<script setup></script>

<template>
    <div class="d-flex flex-column justify-center align-center" style="width:100%; padding: 27px 24px; gap: 24px;">
        <div
            class="d-flex flex-column justify-center align-center"
            style="border-radius: 16px; width: 236px; height: 51px; box-shadow: 0px 4px 4px 0px #60E0E0; background: #F1F1F1;"
        >
            <span style="font-weight: 900; font-size: 23px; line-height: 28px;">친구 초대</span>
        </div>
        <div
            class="d-flex flex-column justify-center align-center"
            style="border-radius: 16px; width: 100%; height: 110px; box-shadow: 0px 4px 4px 0px #60E0E0;"
        >
            <span style="font-weight: 900; font-size: 23px; line-height: 28px;">친구를 초대하면 둘 다</span>
            <span style="font-weight: 900; font-size: 23px; line-height: 28px;">매칭권 1회를 무료로 제공해요!</span>
        </div>
        <div style="width: 100%; height: 303px; box-shadow: 4px 4px 10px 0px #60E0E0; border-radius: 16px; padding: 24px 21px;">
            <div class="d-flex flex-column justify-center align-center" style="width: 100%; height: 100%; background: #F1F1F1; border-radius: 16px;">
                <span style="font-weight: 700; font-size: 20px; line-height: 24px;">지인에게 링크를 공유해요!</span>
                <br />
                <v-btn
                    color="#60E0E0"
                    style="width: 172px; height: 44px; border: 1px solid #60E0E0; box-shadow: 0px 4px 4px 0px #00000040; border-radius: 24px;"
                >
                    <span style="font-weight: 700; font-size: 20px; line-height: 24px; color: #FFFFFF;">링크 복사하기</span>
                </v-btn>
                <br />
                <span style="font-weight: 700; font-size: 20px; line-height: 24px;">프로필 등록 시 추천인 코드 必:</span>
                <span style="font-weight: 700; font-size: 20px; line-height: 24px;">지인 성함 입력!</span>
            </div>
        </div>
    </div>
</template>

<style scoped></style>
