<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import ConsultManagerUserRequestInfoCard from "@/views/cns/card/ConsultManagerUserRequestInfoCard.vue";
import UserSearchParameterCard from "@/components/card/UserSearchParameterCard.vue";
import UserManagementList from "@/views/user/list/UserManagementList.vue";
import ConsultManagerLetterCard from "@/views/cns/card/ConsultManagerLetterCard.vue";
import ConsultManagerTargetCard from "@/views/cns/card/ConsultManagerTargetCard.vue";
import UserProfileTable from "@/components/table/UserProfileTable.vue";
import { useStore } from "vuex";

const router = useRouter();

const store = useStore();

const breadcrumbs = ref([
    {
        title: "고객 상담"
    },
    {
        title: "매니저 전담 소개",
        disabled: false,
        to: "/cns/manager"
    },
    {
        title: "상세 정보",
        disabled: false
    }
]);

function clickListBtn() {
    router.push("/cns/manager");
}

const loading = ref(false);
const list = ref([
    {
        idx: 1,
        submitDate: "2024년 1월 1일 오후 1:12",
        name: "강남1",
        address: "서울시 강남구1"
    },
    {
        idx: 2,
        submitDate: "2024년 1월 1일 오후 1:12",
        name: "강남2",
        address: "서울시 강남구2"
    },
    {
        idx: 3,
        submitDate: "2024년 1월 1일 오후 1:12",
        name: "강남3",
        address: "서울시 강남구3"
    },
    {
        idx: 4,
        submitDate: "2024년 1월 1일 오후 1:12",
        name: "강남4",
        address: "서울시 강남구4"
    },
    {
        idx: 5,
        submitDate: "2024년 1월 1일 오후 1:12",
        name: "강남5",
        address: "서울시 강남구5"
    },
    {
        idx: 6,
        submitDate: "2024년 1월 1일 오후 1:12",
        name: "강남6",
        address: "서울시 강남구6"
    }
]);

function search(param) {
    loading.value = true;
    setTimeout(() => {
        loading.value = false;
    }, 2000);
}

function onClickRow(idx) {
    // TODO : set profile in vuex
    store.commit("setProfileByKey", { key: "idx", value: idx });
    dialog.value = true;
}

async function save(event) {
    const results = await event;
    if (!results.valid) {
        return;
    }

    if (targets.value.length !== 2) {
        alert("소개 대상을 2명 선택해주세요.");
        return;
    }

    alert("전담 소개 제출 API / letter : " + letter.value + " / targets : " + JSON.stringify(targets.value));
}

const targets = ref([
    {
        userNumber: 1234,
        name: "라이언"
    },
    {
        userNumber: 1234,
        name: "라이언"
    }
]);
function deleteTarget(index) {
    console.log("index : ", +index);
    targets.value = targets.value.filter((el, idx) => idx !== index);
}

const letter = ref("");
function setLetter(text) {
    letter.value = text;
}

const dialog = ref(false);

function add() {
    const idx = store.getters.getProfile("idx");
    const row = list.value[idx];
    const target = { userNumber: idx, name: row.name };
    const currentTargets = targets.value;
    if (!!currentTargets.find(el => el.userNumber === target.userNumber)) {
        alert("중복으로 추가하셨습니다.");
        return;
    }
    currentTargets.push(target);
    targets.value = currentTargets;
    dialog.value = false;
}
</script>

<template>
    <div>
        <v-row>
            <v-col>
                <v-breadcrumbs :items="breadcrumbs" class="pa-0">
                    <template #title="{ item }">
                        {{ item.title.toUpperCase() }}
                    </template>
                </v-breadcrumbs>
            </v-col>
            <v-col class="d-flex justify-end">
                <v-btn size="small" class="ma-1" @click="clickListBtn()">목록</v-btn>
            </v-col>
        </v-row>
        <v-row>
            <v-col cols="8" sm="8" class="d-flex flex-column ga-3">
                <consult-manager-user-request-info-card />
                <user-search-parameter-card :is-keep="false" @search="search" />
                <user-management-list :loading="loading" :list="list" @click-row="onClickRow" />
                <v-dialog v-model="dialog" :scrollable="true" width="auto" min-width="800">
                    <v-card class="text-center text-sm-start w-100" fluid>
                        <v-card-title class="text-md-h6 "> (사용자 이름) </v-card-title>
                        <v-divider />
                        <v-card-text>
                            <user-profile-table />
                        </v-card-text>
                        <v-divider />
                        <v-card-actions class="d-flex justify-end">
                            <v-btn color="blue-darken-1" variant="text" @click="dialog = false">
                                Close
                            </v-btn>
                            <v-btn color="blue-darken-1" variant="text" @click="add">
                                Add
                            </v-btn>
                        </v-card-actions>
                    </v-card>
                </v-dialog>
            </v-col>
            <v-col cols="4" sm="4">
                <v-form class="d-flex flex-column ga-3" @submit.prevent="save">
                    <consult-manager-letter-card @set="setLetter" />
                    <consult-manager-target-card :list="targets" @delete="deleteTarget" />
                </v-form>
            </v-col>
        </v-row>
    </div>
</template>

<style scoped></style>
