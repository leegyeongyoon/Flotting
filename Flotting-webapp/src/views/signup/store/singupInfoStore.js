import { defineStore } from "pinia";

const defaultSignupInfo = {
    name: "", // 이름
    birth: "", // 생년월일
    height: 150, // 키
    gender: "", // 성별
    location: "", // 거주지
    detailLocation: "", // 상세 거주지
    appliedPath: "", // 신청 경로
    recommendUserName: "" // 추천인 코드
};

// export const signupInfoStore = defineStore("signupInfoStore", {
//     state: () => ({
//         name: null, // 이름
//         birth: null, // 생년월일
//         height: null, // 키
//         gender: null, // 성별
//         location: null, // 거주지
//         detailLocation: null, // 상세 거주지
//         appliedPath: null, // 신청 경로
//         recommendUserName: null // 추천인 코드
//     }),
//     getters: {},
//     actions: {
//         set(key, value) {
//             if (Object.keys(defaultSignupInfo).includes(key)) {
//                 this[key] = value;
//             }
//         }
//     },
//     persist: sessionStorage
// });

export const signupInfoStore = defineStore("signupInfoStore", () => {
    const name = ref("");
    const birth = ref("");
    const height = ref(150);
    const gender = ref("");
    const location = ref("");
    const detailLocation = ref("");
    const appliedPath = ref("");
    const recommendUserName = ref("");
});
