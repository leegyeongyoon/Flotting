import { defineStore } from "pinia";
import { ref } from "vue";
export const signupInfoStore = defineStore(
    "signupInfoStore",
    () => {
        const name = ref(""); // 이름
        const birth = ref(""); // 생년월일
        const height = ref(150); // 키
        const gender = ref(""); // 성별
        const location = ref(""); // 거주지
        const detailLocation = ref(""); // 상세 거주지
        const appliedPath = ref(""); // 신청 경로
        const recommendUserName = ref(""); // 추천인

        return {
            name,
            birth,
            height,
            gender,
            location,
            detailLocation,
            appliedPath,
            recommendUserName
        };
    },
    {
        persist: {
            enabled: true,
            strategies: [
                {
                    key: "signup",
                    storage: sessionStorage
                }
            ]
        }
    }
);
