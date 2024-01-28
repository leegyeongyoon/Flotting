const profileStore = {
    state() {
        return {
            userId: "",
            userName: "",
            token: "",
            role: "",
            profile: {
                평생이용권여부: "-",
                주차정보:
                    "글이 긴거 테스트해보자.글이 긴거 테스트해보자.글이 긴거 테스트해보자.글이 긴거 테스트해보자.글이 긴거 테스트해보자.글이 긴거 테스트해보자.글이 긴거 테스트해보자.글이 긴거 테스트해보자.글이 긴거 테스트해보자.글이 긴거 테스트해보자.",
                신청경로: "-",
                연락처: "-",
                1: "-",
                2: "-",
                3: "-",
                4: "-",
                5: "-",
                6: "-",
                7: "-",
                8: "-",
                9: "-",
                10: "-"
            }
        };
    },
    mutations: {
        setProfile: (state, data) => {
            state.profile = data;
        },
        setProfileByKey: (state, data) => {
            state.profile[data.key] = data.value;
        }
    },
    getters: {
        getProfile: state => {
            return state.profile;
        },
        getProfileDetail: state => key => {
            return state.profile[key];
        },
        getProfileKeys: state => {
            return Object.keys(state.profile);
        }
    }
};
export default profileStore;
