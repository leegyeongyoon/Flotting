<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import SystemManagerSearchCard from "@/views/sys/card/SystemManagerSearchCard.vue";
import SystemManagerList from "@/views/sys/list/SystemManagerList.vue";
import SystemManagerRegisterCard from "@/views/sys/card/SystemManagerRegisterCard.vue";
const router = useRouter();

const breadcrumbs = ref([
    {
        title: "시스템 관리"
    },
    {
        title: "관리자 관리",
        disabled: false
    }
]);
const loading = ref(false);
const list = ref([
    {
        idx: 1,
        type: "최종 관리자",
        name: "이름1",
        id: "아이디1",
        phoneNumber: "01011111111",
        status: "활성화"
    },
    {
        idx: 2,
        type: "매니저?",
        name: "이름2",
        id: "아이디2",
        phoneNumber: "01011112222",
        status: "활성화"
    },
    {
        idx: 3,
        type: "매니저",
        name: "이름2",
        id: "아이디3",
        phoneNumber: "01011113333",
        status: "비활성화"
    }
]);

function search(param) {
    loading.value = true;
    setTimeout(() => {
        loading.value = false;
    }, 2000);
}

const dialog = ref(false);
function closeRegisterDialog() {
    dialog.value = false;
}
function openRegisterDialog() {
    dialog.value = true;
}
</script>

<template>
    <div>
        <v-breadcrumbs :items="breadcrumbs">
            <template #title="{ item }">
                {{ item.title.toUpperCase() }}
            </template>
        </v-breadcrumbs>
        <v-row>
            <v-col cols="12" sm="12" order="2" order-sm="1">
                <system-manager-search-card @search="search" />
            </v-col>
        </v-row>
        <v-row>
            <v-col cols="12" sm="12" order="2" order-sm="1">
                <system-manager-list :loading="loading" :list="list" @register="openRegisterDialog" />
            </v-col>
        </v-row>
        <v-dialog v-model="dialog" width="500">
            <system-manager-register-card :dialog="dialog" @close="closeRegisterDialog" />
        </v-dialog>
    </div>
</template>

<style scoped></style>
