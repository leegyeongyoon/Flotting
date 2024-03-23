<script setup>
import { ref } from "vue";
import RegisterSecondUserList from "@/views/reg/list/RegisterSecondUserList.vue";

const breadcrumbs = ref([
    {
        title: "신규 고객"
    },
    {
        title: "2차 등록 고객",
        disabled: false
    }
]);
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
                <register-second-user-list :loading="loading" :list="list" />
                <!--        <profile-requested-change-list :loading="loading" :list="list" />-->
            </v-col>
        </v-row>
    </div>
</template>

<style scoped></style>
