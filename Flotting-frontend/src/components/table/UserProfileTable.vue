<script setup>
import UserProfileTableTextareaTd from "@/components/table/UserProfileTableTextareaTd.vue";
import { ref } from "vue";

const props = defineProps({
    isEdit: {
        type: Boolean,
        default: false
    }
});

const columns = {
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
    grade: "등급"
};
</script>

<template>
    <v-table density="compact">
        <thead>
            <tr>
                <th class="text-left w-25">
                    속성
                </th>
                <th class="text-left w-75">
                    정보
                </th>
            </tr>
        </thead>
        <tbody class="td-py-2">
            <user-profile-table-textarea-td v-for="key in Object.keys(columns)" :key="key" :index-key="key" :title="columns[key]" :is-edit="isEdit" />
        </tbody>
    </v-table>
</template>

<style scoped></style>
