<script setup>
import MainHeader from "@/components/layout/MainHeader.vue";
import { ref } from "vue";
import router from "@/router";
import SignupProgress from "@/views/signup/components/SignupProgress.vue";
import SignupRadio from "@/views/signup/components/SignupRadio.vue";

const nickname = ref("");

const detailJob = ref("");

const onClicked = () => {
    router.push("/signup/photo");
};

const job = ref("");
const jobOption = ref([
    {
        value: "1",
        title: "대기업"
    },
    {
        value: "2",
        title: "중견기업"
    },
    {
        value: "3",
        title: "공기업/공무원"
    },
    {
        value: "4",
        title: "스타트업"
    },
    {
        value: "5",
        title: "중소기업"
    },
    {
        value: "6",
        title: "학생"
    },
    {
        value: "7",
        title: "전문직\n(회계사 등)"
    },
    {
        value: "8",
        title: "의료직\n(간호사 등)"
    },
    {
        value: "9",
        title: "연구기술직"
    },
    {
        value: "10",
        title: "교육직"
    },
    {
        value: "11",
        title: "사업가"
    },
    {
        value: "12",
        title: "기타"
    }
]);

const education = ref("");
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
const smoking = ref("");
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

const drinking = ref("");
const drinkingOption = ref([
    {
        value: "1",
        title: "자주 마심\n(주 3회 이상)"
    },
    {
        value: "2",
        title: "가끔 마심\n(주 2회 이상)"
    },
    {
        value: "3",
        title: "거의 안 마심\n(월 1~2회)"
    },
    {
        value: "4",
        title: "아예 안 마심\n(월 1회 이하)"
    }
]);

const mbti = ref(["", "", "", ""]);
const mbtis = ref([
    [
        {
            value: "E",
            title: "E"
        },
        {
            value: "I",
            title: "I"
        }
    ],
    [
        {
            value: "S",
            title: "S"
        },
        {
            value: "N",
            title: "N"
        }
    ],
    [
        {
            value: "T",
            title: "T"
        },
        {
            value: "F",
            title: "F"
        }
    ],
    [
        {
            value: "P",
            title: "P"
        },
        {
            value: "J",
            title: "J"
        }
    ]
]);

const personality = ref([]);
const personalityOption = ref([
    {
        value: "1",
        title: "외향적인"
    },
    {
        value: "2",
        title: "애교있는"
    },
    {
        value: "3",
        title: "유머있는"
    },
    {
        value: "4",
        title: "친절한"
    },
    {
        value: "5",
        title: "차분한"
    },
    {
        value: "6",
        title: "긍정적인"
    },
    {
        value: "7",
        title: "지적인"
    },
    {
        value: "8",
        title: "4차원"
    },
    {
        value: "9",
        title: "열정적인"
    },
    {
        value: "10",
        title: "사려깊은"
    },
    {
        value: "11",
        title: "진지한"
    },
    {
        value: "12",
        title: "센스있는"
    }
]);

const hobby = ref([]);
const hobbyOption = ref([
    {
        value: "1",
        title: "운동"
    },
    {
        value: "2",
        title: "자기계발"
    },
    {
        value: "3",
        title: "독서"
    },
    {
        value: "4",
        title: "외국어"
    },
    {
        value: "5",
        title: "카페"
    },
    {
        value: "6",
        title: "요리"
    },
    {
        value: "7",
        title: "음악"
    },
    {
        value: "8",
        title: "악기 연주"
    },
    {
        value: "9",
        title: "산책"
    },
    {
        value: "10",
        title: "반려동물"
    },
    {
        value: "11",
        title: "여행"
    },
    {
        value: "12",
        title: "패션"
    },
    {
        value: "13",
        title: "맛집탐방"
    },
    {
        value: "14",
        title: "영화/넷플릭스"
    },
    {
        value: "15",
        title: "기타 등등"
    }
]);

const dating = ref("");
const datingOption = ref([
    {
        value: "1",
        title: "시간될 때마다\n최대한 자주 보기"
    },
    {
        value: "2",
        title: "일주일에\n1~2 번 데이트"
    },
    {
        value: "3",
        title: "일주일에\n3~4 번 데이트"
    },
    {
        value: "4",
        title: "데이트 일정은 조율 가능!"
    }
]);
</script>

<template>
    <div class="w-100 h-100">
        <main-header start="back" end="" :title="false" />
        <main class="w-100 h-100" style="padding-top: 60px;">
            <div class="mx-auto" style="max-width: 390px; min-width: 360px;">
                <div class="w-100 d-flex flex-column justify-center align-center" style="padding: 29px 18px;">
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
                            <div style="display: grid; grid-template-columns: repeat(3, 1fr); grid-gap: 8px;">
                                <signup-radio
                                    v-for="({ value, title }, i) in jobOption"
                                    :key="`job_${i}`"
                                    :group-value="job"
                                    :value="value"
                                    :title="title"
                                    @click="val => (job = val)"
                                />
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
                                    @click="val => (education = val)"
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
                                    @click="val => (smoking = val)"
                                />
                            </div>
                        </div>
                        <div class="d-flex flex-column ga-3">
                            <span class="title-text">(6) 음주 여부</span>
                            <div style="display: grid; grid-template-columns: repeat(2, 1fr); grid-gap: 8px;">
                                <signup-radio
                                    v-for="({ value, title }, i) in drinkingOption"
                                    :key="`dri_${i}`"
                                    :group-value="drinking"
                                    :value="value"
                                    :title="title"
                                    @click="val => (drinking = val)"
                                />
                            </div>
                        </div>
                        <div class="d-flex flex-column ga-2">
                            <span class="title-text">(7) MBTI</span>
                            <span class="sub-title">- 잘 기억이 안나거나 모르는 경우 패스할 수 있어요 !</span>
                            <div class="d-flex justify-center align-center w-100">
                                <div style="display: grid; grid-template-columns: repeat(2, 1fr); grid-gap: 8px; width: 80%; margin-inside: auto;">
                                    <template v-for="(el, i) in mbtis" :key="`mbti_${i}`">
                                        <signup-radio
                                            v-for="({ value, title }, j) in el"
                                            :key="`mbti_${i}_${j}`"
                                            :group-value="mbti[i]"
                                            :value="value"
                                            :title="title"
                                            @click="val => (mbti[i] = val)"
                                        />
                                    </template>
                                </div>
                            </div>
                        </div>
                        <div class="d-flex flex-column ga-2">
                            <span class="title-text">(8) 나의 성격을 단어로 표현한다면?</span>
                            <span class="sub-title">- 최대 3가지를 선택해주세요!</span>
                            <div style="display: grid; grid-template-columns: repeat(3, 1fr); grid-gap: 8px;">
                                <signup-radio
                                    v-for="({ value, title }, i) in personalityOption"
                                    :key="`per_${i}`"
                                    :group-value="personality"
                                    :value="value"
                                    :title="title"
                                    @click="
                                        val =>
                                            personality.includes(val)
                                                ? (personality = personality.filter(el => el !== val))
                                                : personality.length < 3 && personality.push(val)
                                    "
                                />
                            </div>
                        </div>
                        <div class="d-flex flex-column ga-2">
                            <span class="title-text">(9) 나의 관심사 / 취미를 모두 골라주세요 !</span>
                            <span class="sub-title">- 최대 3가지를 선택해주세요!</span>
                            <div style="display: grid; grid-template-columns: repeat(3, 1fr); grid-gap: 8px;">
                                <signup-radio
                                    v-for="({ value, title }, i) in hobbyOption"
                                    :key="`hob_${i}`"
                                    :group-value="hobby"
                                    :value="value"
                                    :title="title"
                                    @click="
                                        val => (hobby.includes(val) ? (hobby = hobby.filter(el => el !== val)) : hobby.length < 3 && hobby.push(val))
                                    "
                                />
                            </div>
                        </div>
                        <div class="d-flex flex-column ga-2">
                            <span class="title-text">(10) 어떤 데이트를 선호하시나요 ?</span>
                            <span class="sub-title">- 1가지를 선택해주세요!</span>
                            <div style="display: grid; grid-template-columns: repeat(2, 1fr); grid-gap: 8px;">
                                <signup-radio
                                    v-for="({ value, title }, i) in datingOption"
                                    :key="`dat_${i}`"
                                    :group-value="dating"
                                    :value="value"
                                    :title="title"
                                    @click="val => (dating = val)"
                                />
                            </div>
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
    padding-inline: 49px;
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
