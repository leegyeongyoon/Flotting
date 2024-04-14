<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
const router = useRouter();

defineProps({
    loading: {
        type: Boolean,
        default: false
    },
    list: {
        type: Array,
        default: () => []
    }
});

const emit = defineEmits(["register"]);

const headers = ref([
    { title: "구분", key: "type", align: "center", minWidth: "200px", sortable: false },
    { title: "이름", key: "name", align: "center", minWidth: "200px", sortable: false },
    { title: "아이디", key: "id", align: "center", minWidth: "200px", sortable: false },
    { title: "전화번호", key: "phoneNumber", align: "center", minWidth: "200px", sortable: false },
    { title: "상태", key: "status", align: "center", minWidth: "200px", sortable: false }
]);

const selected = ref([]);

function clickStatus(idx, status) {
    const msg = `정말로 ${status === "활성화" ? "비활성화" : "활성화"} 하시겠습니까?`;

    if (!confirm(msg)) {
        return;
    }

    alert(`idx : ${idx}, ${status === "활성화" ? "비활성화" : "활성화"} API 호출`);
}
function clickActivate() {
    if (!confirm(`정말로 ${selected.value.length}개를 활성화 하시겠습니까?`)) {
        return;
    }
    alert("활성화 API / " + JSON.stringify(selected.value));
}
function clickDeactivate() {
    if (!confirm(`정말로 ${selected.value.length}개를 비활성화 하시겠습니까?`)) {
        return;
    }
    alert("비활성화 API / " + JSON.stringify(selected.value));
}
function clickPasswordReset() {
    if (!confirm(`정말로 ${selected.value.length}개를 초기화 하시겠습니까?`)) {
        return;
    }
    alert("비밀번호 초기화 API / " + JSON.stringify(selected.value));
}
function clickRegister() {
    emit("register");
}
</script>

<template>
    <v-card class="text-center text-sm-start w-100" fluid>
        <v-card-item>
            <v-row>
                <v-col class="d-flex align-center">
                    <v-cardTitle class="text-md-h6 ">
                        조회 결과
                    </v-cardTitle>
                </v-col>
                <v-col class="d-flex justify-end">
                    <template v-if="selected.length > 0">
                        <v-btn size="small" class="ma-1" @click="clickActivate">활성화</v-btn>
                        <v-btn size="small" class="ma-1" @click="clickDeactivate">비활성화</v-btn>
                        <v-btn size="small" class="ma-1" @click="clickPasswordReset">비밀번호 초기화</v-btn>
                    </template>
                    <v-btn size="small" class="ma-1" @click="clickRegister">등록</v-btn>
                </v-col>
            </v-row>
        </v-card-item>
        <v-divider></v-divider>
        <v-cardText>
            <v-data-table
                v-model="selected"
                item-value="idx"
                :headers="headers"
                :loading="loading"
                :items="list"
                :items-per-page="5"
                :items-per-page-options="[
                    { value: 5, title: '5' },
                    { value: 10, title: '10' },
                    { value: 20, title: '20' }
                ]"
                hover
                show-select
            >
                <template #item="{ item }">
                    <v-btn @click="() => clickStatus(item.idx, item.status)">{{ item.status }}</v-btn>
                </template>
            </v-data-table>
        </v-cardText>
    </v-card>
</template>

<style scoped>
.cursor-pointer {
    cursor: pointer;
}
</style>
