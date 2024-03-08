const profileStore = {
    state() {
        return {
            userNo: "userNo",
            name: "이름",
            age: "나이",
            phoneNumber: "전화번호",
            userStatus: "계정상태",
            job: "직업",
            height: "신장",
            gender: "성별",
            location: "거주지",
            email: "이메일",
            appliedPath: "신청 경로",
            recommendUserName: "추천인 이름",
            preference: "선호도 1위",
            preferenceDetail: "선호 구체적 설명",
            charm: "나의 매력",
            loveValues: "나의 연애관",
            hobby: "취미",
            nickName: "닉네임",
            body: "체형",
            detailJob: "직장명",
            education: "졸업 이력",
            smoking: "흡연 여부",
            drinking: "음주 빈도",
            grade: "등급",
            detailProfileId: "2차 프로필 id"
        };
    },
    mutations: {
        setProfile: (state, data) => {
            state.profile = data;
        },
        setProfileByKey: (state, data) => {
            state[data.key] = data.value;
        }
    },
    getters: {
        getProfile: state => key => {
            if (!!key) {
                return Object.keys(state).findIndex(el => el === key) >= 0 ? state[key] : "";
            } else {
                return state;
            }
        }
    }
};
export default profileStore;
