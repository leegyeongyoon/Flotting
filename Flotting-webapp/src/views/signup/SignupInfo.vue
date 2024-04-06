<script setup>
import MainHeader from "@/components/layout/MainHeader.vue";
import { ref } from "vue";
import router from "@/router";
const gender = ref("");
const height = ref(150);
const location = ref("");
const appliedPath = ref("");
const clickNext = () => {
    router.push("/signup/world");
};
</script>

<template>
    <div class="w-100 h-100">
        <main-header start="" end="" :title="false" />
        <main class="w-100 h-100" style="padding-top: 60px;">
            <div class="mx-auto" style="max-width: 390px; min-width: 360px;">
                <div class="w-100 d-flex flex-column justify-center align-center" style="padding-top: 29px; padding-inline: 18px;">
                    <span style="font-size: 28px; font-weight: 800; line-height: 34px; text-align: center; padding-bottom: 16px;"
                        >프로필 등록 진행 현황</span
                    >
                    <div class="w-100" style="margin-bottom: 60px;">진행률</div>
                    <div class="d-flex flex-column w-100 ga-6 mb-8">
                        <div class="d-flex flex-column ga-3">
                            <span class="text-none title-text">(1) 본인 성함</span>
                            <v-text-field
                                class="text-none input-text"
                                density="compact"
                                placeholder="예시 ) 최연아"
                                variant="plain"
                                hide-details
                                :clearable="true"
                            ></v-text-field>
                        </div>
                        <div class="d-flex flex-column ga-3">
                            <span class="text-none title-text">(2) 본인 생년월일 6자리</span>
                            <v-text-field
                                class="text-none input-text"
                                density="compact"
                                placeholder="예시 ) 950830"
                                variant="plain"
                                hide-details
                                :clearable="true"
                            ></v-text-field>
                        </div>
                        <div class="d-flex flex-column ga-3">
                            <div class="d-flex justify-space-between">
                                <span class="text-none title-text">(3) 본인 신장</span>
                                <span class="text-none title-text">{{ height }}</span>
                            </div>
                            <div>
                                <v-slider v-model="height" min="140" max="200" :step="1" thumb-label color="#60E0E0" hide-details>
                                    <template #thumb-label="{modelValue}"> {{ modelValue }}</template>
                                </v-slider>
                                <div class="d-flex w-100 justify-space-between">
                                    <span class="text-none slider-text">140</span>
                                    <span class="text-none slider-text">200</span>
                                </div>
                                <span class="text-none caution">* 허위 작성 시 서비스 이용 제지 사유</span>
                            </div>
                        </div>
                        <div class="d-flex flex-column ga-3">
                            <span class="text-none title-text">(4) 본인 성별</span>
                            <div class="d-flex" style="gap: 10px;">
                                <div
                                    class="radio"
                                    :class="gender === 'man' && 'radio-clicked'"
                                    @click="gender === 'man' ? (gender = '') : (gender = 'man')"
                                >
                                    <span>남성</span>
                                </div>
                                <div
                                    class="radio"
                                    :class="gender === 'woman' && 'radio-clicked'"
                                    @click="gender === 'woman' ? (gender = '') : (gender = 'woman')"
                                >
                                    <span>여성</span>
                                </div>
                            </div>
                        </div>
                        <div class="d-flex flex-column ga-3">
                            <span class="text-none title-text">(5-1) 본인 거주지</span>
                            <div class="d-flex flex-column" style="gap: 10px;">
                                <div class="d-flex" style="gap: 10px;">
                                    <div
                                        class="radio"
                                        :class="location === 'seoul-north' && 'radio-clicked'"
                                        @click="location === 'seoul-north' ? (location = '') : (location = 'seoul-north')"
                                    >
                                        <span>서울 북부</span>
                                    </div>
                                    <div
                                        class="radio"
                                        :class="location === 'seoul-south' && 'radio-clicked'"
                                        @click="location === 'seoul-south' ? (location = '') : (location = 'seoul-south')"
                                    >
                                        <span>서울 남부</span>
                                    </div>
                                    <div
                                        class="radio"
                                        :class="location === 'seoul-east' && 'radio-clicked'"
                                        @click="location === 'seoul-east' ? (location = '') : (location = 'seoul-east')"
                                    >
                                        <span>서울 동부</span>
                                    </div>
                                </div>
                                <div class="d-flex" style="gap: 10px;">
                                    <div
                                        class="radio"
                                        :class="location === 'seoul-west' && 'radio-clicked'"
                                        @click="location === 'seoul-west' ? (location = '') : (location = 'seoul-west')"
                                    >
                                        <span>서울 서부</span>
                                    </div>
                                    <div
                                        class="radio"
                                        :class="location === 'gi-north' && 'radio-clicked'"
                                        @click="location === 'gi-north' ? (location = '') : (location = 'gi-north')"
                                    >
                                        <span>경기 북부</span>
                                    </div>
                                    <div
                                        class="radio"
                                        :class="location === 'gi-south' && 'radio-clicked'"
                                        @click="location === 'gi-south' ? (location = '') : (location = 'gi-south')"
                                    >
                                        <span>경기 남부</span>
                                    </div>
                                </div>
                                <div class="d-flex" style="gap: 10px;">
                                    <div
                                        class="radio"
                                        :class="location === 'gi-east' && 'radio-clicked'"
                                        @click="location === 'gi-east' ? (location = '') : (location = 'gi-east')"
                                    >
                                        <span>경기 동부</span>
                                    </div>
                                    <div
                                        class="radio"
                                        :class="location === 'gi-west' && 'radio-clicked'"
                                        @click="location === 'gi-west' ? (location = '') : (location = 'gi-west')"
                                    >
                                        <span>경기 서부</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="d-flex flex-column ga-3">
                            <span class="text-none title-text">(5-2) 본인 상세 거주지</span>
                            <div>
                                <v-text-field
                                    class="text-none input-text"
                                    density="compact"
                                    placeholder="예시 ) 서울시 서초구"
                                    variant="plain"
                                    hide-details
                                    :clearable="true"
                                ></v-text-field>
                                <span class="text-none caution">* 상세 주소 입력 시 00시 00구 까지 입력</span>
                            </div>
                        </div>
                        <div class="d-flex flex-column ga-3">
                            <span class="text-none title-text">(6) 신청 경로</span>
                            <div class="d-flex flex-column" style="gap: 10px;">
                                <div class="d-flex" style="gap: 10px;">
                                    <div
                                        class="radio"
                                        :class="appliedPath === '1' && 'radio-clicked'"
                                        @click="appliedPath === '1' ? (appliedPath = '') : (appliedPath = '1')"
                                    >
                                        <span>소모임</span>
                                    </div>
                                    <div
                                        class="radio"
                                        :class="appliedPath === '2' && 'radio-clicked'"
                                        @click="appliedPath === '2' ? (appliedPath = '') : (appliedPath = '2')"
                                    >
                                        <span>프립</span>
                                    </div>
                                    <div
                                        class="radio"
                                        :class="appliedPath === '3' && 'radio-clicked'"
                                        @click="appliedPath === '3' ? (appliedPath = '') : (appliedPath = '3')"
                                    >
                                        <span>포탈 검색</span>
                                    </div>
                                </div>
                                <div class="d-flex" style="gap: 10px;">
                                    <div
                                        class="radio"
                                        :class="appliedPath === '4' && 'radio-clicked'"
                                        @click="appliedPath === '4' ? (appliedPath = '') : (appliedPath = '4')"
                                    >
                                        <span>네이버 카페</span>
                                    </div>
                                    <div
                                        class="radio"
                                        :class="appliedPath === '5' && 'radio-clicked'"
                                        @click="appliedPath === '5' ? (appliedPath = '') : (appliedPath = '5')"
                                    >
                                        <span>인스타그램</span>
                                    </div>
                                    <div
                                        class="radio"
                                        :class="appliedPath === '6' && 'radio-clicked'"
                                        @click="appliedPath === '6' ? (appliedPath = '') : (appliedPath = '6')"
                                    >
                                        <span>네이버 스토어</span>
                                    </div>
                                </div>
                                <div class="d-flex" style="gap: 10px;">
                                    <div
                                        class="radio"
                                        :class="appliedPath === '7' && 'radio-clicked'"
                                        @click="appliedPath === '7' ? (appliedPath = '') : (appliedPath = '7')"
                                    >
                                        <span>와디즈</span>
                                    </div>
                                    <div
                                        class="radio"
                                        :class="appliedPath === '8' && 'radio-clicked'"
                                        @click="appliedPath === '8' ? (appliedPath = '') : (appliedPath = '8')"
                                    >
                                        <span>기타</span>
                                    </div>
                                    <div
                                        class="radio"
                                        :class="appliedPath === '9' && 'radio-clicked'"
                                        @click="appliedPath === '9' ? (appliedPath = '') : (appliedPath = '9')"
                                    >
                                        <span>지인 추천</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="d-flex flex-column ga-3">
                            <span class="text-none title-text">(7) 추천인 코드</span>
                            <v-text-field
                                class="text-none input-text"
                                density="compact"
                                placeholder="예시 ) 김현욱"
                                variant="plain"
                                hide-details
                                :clearable="true"
                            ></v-text-field>
                        </div>
                    </div>
                    <div class="d-flex flex-column text-none security-text mb-9">
                        <span>수집된 개인정보는</span>
                        <span>매칭 외 다른 용도로 활용되지 않습니다.</span>
                    </div>
                    <div>
                        <v-btn class="text-none bottom-btn" @click="clickNext">세계관 등록하러 가기</v-btn>
                    </div>
                </div>
            </div>
        </main>
    </div>
</template>

<style scoped>
.title-text {
    letter-spacing: 0;
    font-size: 18px;
    font-weight: 700;
    line-height: 22px;
    text-align: left;
}
.input-text {
    height: fit-content;
    border: 2px solid #b6b6b6;
    border-radius: 12px;
    letter-spacing: 0;
    font-size: 16px;
    font-weight: 700;
    line-height: 19px;
    text-align: left;
    padding: 4px 12px 12px 12px;
}
.caution {
    font-size: 12px;
    font-weight: 800;
    line-height: 15px;
    text-align: left;
    color: #f23030;
    letter-spacing: 0;
}

.radio {
    width: 100%;
    height: 48px;
    border: 2px solid #00000066;
    border-radius: 8px;
    background: #ffffff99;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 14px;
    font-weight: 700;
    line-height: 17px;
    text-align: center;
    cursor: pointer;
}
.radio-clicked {
    border: 2px solid #60e0e0;
    background: #60e0e08c;
}
.slider-text {
    letter-spacing: 0;
    font-size: 11px;
    font-weight: 700;
    line-height: 13px;
    text-align: center;
}
.security-text {
    color: #2f9c9e;
    letter-spacing: 0;
    font-size: 16px;
    font-weight: 700;
    line-height: 19px;
    text-align: center;
}

.bottom-btn {
    width: 316px;
    height: 58px;
    padding: 17px 49px;
    border-radius: 16px;
    border: 1px solid #dfdfdf;
    box-shadow: 0px 4px 4px 0px #00000040;
    font-size: 24px;
    font-weight: 700;
    line-height: 29px;
    text-align: center;
    color: #ffffff;
    background: #60e0e0;
    letter-spacing: 0;
    margin-bottom: 30px;
}
</style>
