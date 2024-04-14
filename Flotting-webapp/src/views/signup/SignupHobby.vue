<script setup>
import MainHeader from "@/components/layout/MainHeader.vue";
import { ref } from "vue";
import router from "@/router";
import SignupProgress from "@/views/signup/components/SignupProgress.vue";
import SignupRadio from "@/views/signup/components/SignupRadio.vue";

const nickname = ref("");
const job = ref("");
const detailJob = ref("");
const education = ref("");
const smoking = ref("");
const drinking = ref("");
const mbti = ref("");
const onClicked = () => {
    router.push("/signup/photo");
};

const educations = ref([
    {
        value: "1",
        title: "고등학교 졸업"
    },
    {
        value: "2",
        title: "전문대 재학"
    },
    {
        value: "3",
        title: "전문대 졸업"
    },
    {
        value: "4",
        title: "대학교 재학"
    },
    {
        value: "5",
        title: "대학교 졸업"
    },
    {
        value: "6",
        title: "대학원 재학"
    },
    {
        value: "7",
        title: "대학원 졸업"
    },
    {
        value: "8",
        title: "박사과정 진행"
    },
    {
        value: "9",
        title: "박사과정 수료"
    }
]);

const smokings = ref([
    {
        value: "N",
        title: "N"
    },
    {
        value: "Y",
        title: "Y"
    }
]);
</script>

<template>
    <div class="w-100 h-100">
        <main-header start="back" end="" :title="false" />
        <main class="w-100 h-100" style="padding-top: 60px;">
            <div class="mx-auto" style="max-width: 390px; min-width: 360px;">
                <div class="w-100 d-flex flex-column justify-center align-center" style="padding-top: 29px; padding-inline: 18px;">
                    <signup-progress :idx="3" />
                    <div class="w-100 d-flex flex-column ga-3 page-guide">
                        <span class="page-title">소중한 나를 소개해주세요 !</span>
                        <div class="d-flex flex-column ga-1">
                            <span class="page-sub">(주의) 사실과 다른 정보의 향후</span>
                            <span class="page-sub">서비스 이용 정지의 사유가 될 수 있습니다.</span>
                        </div>
                    </div>
                    <div class="d-flex flex-column w-100 ga-6 mb-8">
                        <div class="d-flex flex-column ga-2">
                            <span class="title-text">(1) 닉네임</span>
                            <span class="sub-title">- 프로필에는 닉네임만 보여집니다.</span>
                            <v-text-field
                                v-model="nickname"
                                class="input-text"
                                density="compact"
                                placeholder="예시 ) 프로필에는 닉네임만 보여집니다."
                                variant="plain"
                                hide-details
                                :clearable="true"
                            ></v-text-field>
                        </div>
                        <div class="d-flex flex-column ga-2">
                            <span class="title-text">(2) 직업</span>
                            <span class="sub-title">- 대학생 / 대학원생의 경우 학생으로 선택해주세요</span>
                            <div class="d-flex flex-column ga-2">
                                <div class="d-flex ga-2">
                                    <div
                                        class="radio d-flex flex-column justify-center align-center"
                                        :class="job === '1' && 'radio-clicked'"
                                        @click="job === '1' ? (job = '') : (job = '1')"
                                    >
                                        <span>일반</span>
                                        <span>(금융직)</span>
                                    </div>
                                    <div
                                        class="radio d-flex flex-column justify-center align-center"
                                        :class="job === '2' && 'radio-clicked'"
                                        @click="job === '2' ? (job = '') : (job = '2')"
                                    >
                                        <span>일반</span>
                                        <span>(대기업/중견)</span>
                                    </div>
                                    <div
                                        class="radio d-flex flex-column justify-center align-center"
                                        :class="job === '3' && 'radio-clicked'"
                                        @click="job === '3' ? (job = '') : (job = '3')"
                                    >
                                        <span>일반</span>
                                        <span>(공기업/공무원)</span>
                                    </div>
                                </div>
                                <div class="d-flex ga-2">
                                    <div
                                        class="radio d-flex flex-column justify-center align-center"
                                        :class="job === '4' && 'radio-clicked'"
                                        @click="job === '4' ? (job = '') : (job = '4')"
                                    >
                                        <span>일반</span>
                                        <span>(스타트업)</span>
                                    </div>
                                    <div
                                        class="radio d-flex flex-column justify-center align-center"
                                        :class="job === '5' && 'radio-clicked'"
                                        @click="job === '5' ? (job = '') : (job = '5')"
                                    >
                                        <span>일반</span>
                                        <span>(중소기업)</span>
                                    </div>
                                    <div
                                        class="radio d-flex flex-column justify-center align-center"
                                        :class="job === '6' && 'radio-clicked'"
                                        @click="job === '6' ? (job = '') : (job = '6')"
                                    >
                                        <span>일반</span>
                                        <span>(프리랜서)</span>
                                    </div>
                                </div>
                                <div class="d-flex ga-2">
                                    <div
                                        class="radio d-flex flex-column justify-center align-center"
                                        :class="job === '7' && 'radio-clicked'"
                                        @click="job === '7' ? (job = '') : (job = '7')"
                                    >
                                        <span>전문직</span>
                                        <span>(회계사 등)</span>
                                    </div>
                                    <div
                                        class="radio d-flex flex-column justify-center align-center"
                                        :class="job === '8' && 'radio-clicked'"
                                        @click="job === '8' ? (job = '') : (job = '8')"
                                    >
                                        <span>의료직</span>
                                        <span>(간호사 등)</span>
                                    </div>
                                    <div
                                        class="radio d-flex flex-column justify-center align-center"
                                        :class="job === '9' && 'radio-clicked'"
                                        @click="job === '9' ? (job = '') : (job = '9')"
                                    >
                                        <span>연구기술직</span>
                                    </div>
                                </div>
                                <div class="d-flex ga-2">
                                    <div
                                        class="radio d-flex flex-column justify-center align-center"
                                        :class="job === '10' && 'radio-clicked'"
                                        @click="job === '10' ? (job = '') : (job = '10')"
                                    >
                                        <span>교육직</span>
                                    </div>
                                    <div
                                        class="radio d-flex flex-column justify-center align-center"
                                        :class="job === '11' && 'radio-clicked'"
                                        @click="job === '11' ? (job = '') : (job = '11')"
                                    >
                                        <span>사업가</span>
                                    </div>
                                    <div
                                        class="radio d-flex flex-column justify-center align-center"
                                        :class="job === '12' && 'radio-clicked'"
                                        @click="job === '12' ? (job = '') : (job = '12')"
                                    >
                                        <span>기타</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="d-flex flex-column ga-3">
                            <span class="title-text">(3) 상세 직업</span>
                            <div class="d-flex flex-column ga-1">
                                <span class="sub-title">- 직장인은 직장명 & 기타 전문직은 상세 직군을 작성해주세요</span>
                                <span class="sub-title pl-3">예시 )</span>
                                <span class="sub-title pl-3">직장인 -> 삼성전자, 한화케미칼 등</span>
                                <span class="sub-title pl-3">사업가 -> 부동산 개발 법인 대표 등</span>
                                <span class="sub-title pl-3">의료직 -> 간호사, 간호조무사 등</span>
                                <span class="sub-title pl-3">기타 -> 자영업자 (식당 운영 등) / 자산가 / 투자자 등</span>
                            </div>
                            <v-text-field
                                v-model="detailJob"
                                class="input-text"
                                density="compact"
                                placeholder="상세 직업"
                                variant="plain"
                                hide-details
                                :clearable="true"
                            ></v-text-field>
                        </div>
                        <div class="d-flex flex-column ga-3">
                            <span class="title-text">(4) 학력</span>
                            <div style="display: grid; grid-template-columns: repeat(3, 1fr); grid-gap: 8px;">
                                <signup-radio
                                    v-for="({ value, title }, i) in educations"
                                    :key="`edu_${i}`"
                                    :group-value="education"
                                    :value="value"
                                    :title="title"
                                />
                            </div>
                        </div>
                        <div class="d-flex flex-column ga-3">
                            <span class="title-text">(5) 흡연 여부</span>
                            <div style="display: grid; grid-template-columns: repeat(2, 1fr); grid-gap: 8px;">
                                <signup-radio
                                    v-for="({ value, title }, i) in smokings"
                                    :key="`smo_${i}`"
                                    :group-value="smoking"
                                    :value="value"
                                    :title="title"
                                />
                            </div>
                        </div>
                        <div class="d-flex flex-column ga-3">
                            <span class="title-text">(6) 음주 여부</span>
                            <div class="d-flex flex-column ga-2">
                                <div class="d-flex ga-2">
                                    <div
                                        class="radio d-flex flex-column justify-center align-center"
                                        :class="drinking === '1' && 'radio-clicked'"
                                        @click="drinking === '1' ? (drinking = '') : (drinking = '1')"
                                    >
                                        <span>자주 마심</span>
                                        <span>(주 3회 이상)</span>
                                    </div>
                                    <div
                                        class="radio d-flex flex-column justify-center align-center"
                                        :class="drinking === '2' && 'radio-clicked'"
                                        @click="drinking === '2' ? (drinking = '') : (drinking = '2')"
                                    >
                                        <span>가끔 마심</span>
                                        <span>(주 2회 이상)</span>
                                    </div>
                                </div>
                                <div class="d-flex ga-2">
                                    <div
                                        class="radio d-flex flex-column justify-center align-center"
                                        :class="drinking === '3' && 'radio-clicked'"
                                        @click="drinking === '3' ? (drinking = '') : (drinking = '3')"
                                    >
                                        <span>거의 안 마심</span>
                                        <span>(월 1~2회)</span>
                                    </div>
                                    <div
                                        class="radio d-flex flex-column justify-center align-center"
                                        :class="drinking === '4' && 'radio-clicked'"
                                        @click="drinking === '4' ? (drinking = '') : (drinking = '4')"
                                    >
                                        <span>아예 안 마심</span>
                                        <span>(월 1회 이하)</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="d-flex flex-column ga-3">
                            <span class="title-text">(7) MBTI</span>
                        </div>
                    </div>
                    <div class="d-flex flex-column security-text mb-9">
                        <span>수집된 개인정보는</span>
                        <span>매칭 외 다른 용도로 활용되지 않습니다.</span>
                    </div>
                    <div>
                        <v-btn class="bottom-btn" @click="onClicked">사진 등록하러 가기</v-btn>
                    </div>
                </div>
            </div>
        </main>
    </div>
</template>

<style scoped>
.page-guide {
    box-shadow: 4px 4px 10px 0px #60e0e0;
    border-radius: 16px;
    padding: 18px 8px;
    margin-bottom: 30px;
}
.page-title {
    letter-spacing: 0;
    font-size: 20px;
    font-weight: 700;
    line-height: 24px;
    text-align: center;
}
.page-sub {
    letter-spacing: 0;
    font-size: 14px;
    font-weight: 700;
    line-height: 17px;
    text-align: center;
}
.title-text {
    letter-spacing: 0;
    font-size: 18px;
    font-weight: 700;
    line-height: 22px;
    text-align: left;
}
.textarea-text {
    border: 2px solid #b6b6b6;
    border-radius: 12px;
    letter-spacing: 0;
    font-size: 12px;
    font-weight: 700;
    line-height: 20px;
    text-align: left;
    padding: 0 12px 8px 12px;
}
.sub-title {
    letter-spacing: 0;
    color: #35a8aa;
    font-size: 12px;
    font-weight: 700;
    line-height: 15px;
    text-align: left;
}
.security-text {
    color: #2f9c9e;
    letter-spacing: 0;
    font-size: 16px;
    font-weight: 700;
    line-height: 19px;
    text-align: center;
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
    letter-spacing: 0;
}
.radio-clicked {
    border: 2px solid #60e0e0;
    background: #60e0e08c;
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
</style>
