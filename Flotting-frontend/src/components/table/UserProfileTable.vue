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

// const images = ref([1, 2, 3, 4, 5, 6, 7, 8]);
const images = ref([
    {
        src:
            "https://i.namu.wiki/i/gsooT4pgV-ZrStK3vLKMAJpA-COPAcHQT5qoV3NwDfBXcup4VUbNednTs_7wmPk-SyKPXo5ozCWYWzvibDhLKJDxrAJ7BYbj3cHpnw4HQ71W_lUBreNo-B_XfV3KbLocgbm5_Bt8lKAH7IRwJmbr4A.webp"
    },
    {
        src: "https://talkimg.imbc.com/TVianUpload/tvian/TViews/image/2019/01/31/re6YXQA754Ov636845332625672795.jpg"
    },
    {
        src:
            "https://i.namu.wiki/i/XCRzZxq0oUaHigMbmnr2NORktdQ2hyzNen5-VMgCfZ4_mGaMYuUHHuY7Id7RhHKoAWeE_oOY8l82GeKXgHXczYzua1HnjlkAaXEOW2AzGR0URPlAjUECDIqXcJv8d1KTNQeQD6hkqKvjX9HHHDXMfw.webp"
    },
    {
        src:
            "https://i.namu.wiki/i/CCXq4x7u0FDEqJHi-GRqoI1NITwah0CxzrTSbYZuYsfEQHCngOq2Rmmi8lbYM1a4hN3-7hbOisTxe7U7G760syWx-klgPX25jEg4pUYNpjphs46mLFOu4zhsCsNubuOijFsbpd0LAtPJ0zrAadaNxA.webp"
    },
    {
        src:
            "https://i.namu.wiki/i/d_bpb6Xd6RFULIEqYKSAAvKMeAz0Y825rdkhA4SyG70hYOyP1wM9vuPpgH8hm_mHUmeI9lX_UiIeNi3zH32ThDfBCt7Ou66pnVx1UtbPJqAaRv39H2O4y94HkTo-IbVA6qu62JDeKc-NBQhUgwoqMQ.webp"
    },
    {
        src:
            "https://i.namu.wiki/i/v5ufNkWV76wZpAhKGgN827QChgFAcE_2XteE5HU7NGVWEtpRiwgsQ5vOo1HMkZ4UBWa2dtjlxhE6Tg5huhrGTXJvo2sCEJAWIbmN1bj30GWKj1Nj3ipHSm73zzW-BVvSAhQO4UoHs1WSY0dIULF33A.webp"
    },
    {
        src:
            "https://i.namu.wiki/i/BPt7xW8AL0MMeCpwfJxnzfavnUGPrV0LHJxdajMGnLnF3HjabKc2jW03Tk4bZnGvNKZcIGJydiaboFj65RzXO92pPUSGi0MP2NN9qqZTH8geE052DDFv1VoTeiaOXmdnozWBq-7JmBToXlc4C6f70Q.webp"
    },
    {
        src:
            "https://i.namu.wiki/i/8eHWi_3SXnnDcClx2UceaevfhKXcYdFJwM0Z4wpkO-Vf4Kea0Bn0KOVnbJC8mMcawb_t_CFxEave_Zqq5mX0SpKu8pikzLyQznFxE1U7SaIrsQJjvWYEYga90_HlC7kcGruNswkNWDxAPQOEOdoctw.webp"
    }
]);
const selection = ref([]);
const dialog = ref(false);
const selected = ref(-1);
function clickImage(idx) {
    selected.value = idx;
    dialog.value = true;
}
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
            <tr>
                <td>프로필 사진</td>
                <td class="pa-2">
                    <v-container class="pa-1">
                        <v-item-group v-model="selection" multiple="true" max="3">
                            <v-row>
                                <v-col v-for="(item, i) in images" :key="i" cols="12" md="6">
                                    <v-item v-slot="{ isSelected, toggle }">
                                        <v-img :src="item.src" class="pa-1" :max-width="500" cover="true" aspect-ratio="1">
                                            <div class="d-flex w-100 justify-space-between">
                                                <v-btn icon="mdi-arrow-expand" @click.prevent="clickImage(i)"></v-btn>
                                                <v-btn :icon="isSelected ? 'mdi-heart' : 'mdi-heart-outline'" @click.prevent="toggle"></v-btn>
                                            </div>
                                        </v-img>
                                    </v-item>
                                </v-col>
                            </v-row>
                        </v-item-group>
                        <v-dialog v-model="dialog" width="700">
                            <v-card class="text-center" fluid>
                                <v-img :src="images[selected]" aspect-ratio="1/"></v-img>
                            </v-card>
                        </v-dialog>
                    </v-container>
                </td>
            </tr>
        </tbody>
    </v-table>
</template>

<style scoped></style>
