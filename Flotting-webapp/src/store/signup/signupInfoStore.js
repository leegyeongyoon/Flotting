import { defineStore } from "pinia";

const defaultSignupInfo = {
    topStep: 0, // 최고 진행 단계 0 : default, 1 : 가이드, 2 : 정보, 3 : 세계관, 4 : 취향, 5 : 사진, 6 : 완료
    name: "", // 이름
    birth: "", // 생년월일
    height: 150, // 키
    gender: "", // 성별
    location: "", // 거주지
    detailLocation: "", // 상세 거주지
    appliedPath: "", // 신청 경로
    recommendUserName: "" // 추천인 코드
};

export const signupInfoStore = defineStore("signupInfoStore", {
    state: () => ({
        topStep: 0, // 최고 진행 단계 0 : default, 1 : 주의, 2 : 정보, 3 : 세계관, 4 : 취향, 5 : 사진, 6 : 완료
        name: "", // 이름
        birth: "", // 생년월일
        height: 150, // 키
        gender: "", // 성별
        location: "", // 거주지
        detailLocation: "", // 상세 거주지
        appliedPath: "", // 신청 경로
        recommendUserName: "" // 추천인 코드
    }),
    getters: {},
    actions: {
        set(key, value) {
            if (Object.keys(defaultSignupInfo).includes(key)) {
                this[key] = value;
            }
        }
    },
    persist: sessionStorage
});
