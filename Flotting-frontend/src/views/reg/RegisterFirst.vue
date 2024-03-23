<script setup>
import { ref } from "vue";
import RegisterFristUserList from "@/views/reg/list/RegisterFristUserList.vue";

const breadcrumbs = ref([
    {
        title: "신규 고객"
    },
    {
        title: "1차 등록 고객",
        disabled: false
    }
]);
const loading = ref(false);
const list = ref([
    {
        idx: 1,
        name: "라이언",
        age: 20,
        phoneNumber: "010-0000-0000",
        job: "대기업1",
        isSecond: false
    },
    {
        idx: 2,
        name: "어피치",
        age: 21,
        phoneNumber: "010-1111-1111",
        job: "대기업2",
        isSecond: true
    },
    {
        idx: 3,
        name: "조르디",
        age: 22,
        phoneNumber: "010-1234-1234",
        job: "대기업",
        isSecond: false
    },
    {
        idx: 4,
        name: "최고",
        age: 23,
        phoneNumber: "010-1234-1234",
        job: "대기업",
        isSecond: false
    },
    {
        idx: 5,
        name: "해물파전",
        age: 24,
        phoneNumber: "010-1234-1234",
        job: "대기업",
        isSecond: false
    },
    {
        idx: 6,
        name: "꼬부기",
        age: 25,
        phoneNumber: "010-1234-1234",
        job: "대기업",
        isSecond: true
    },
    {
        idx: 7,
        name: "파이리",
        age: 26,
        phoneNumber: "010-1234-1234",
        job: "대기업",
        isSecond: false
    }
]);
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
                <register-frist-user-list :loading="loading" :list="list" />
                <!--        <profile-requested-change-list :loading="loading" :list="list" />-->
            </v-col>
        </v-row>
    </div>
</template>

<style scoped></style>
