<script setup>
import { ref } from "vue";

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

const headers = ref([
    { title: "제출일자", key: "submitDate", align: "center", minWidth: "200px" },
    { title: "실명", key: "name", align: "center", minWidth: "200px" },
    { title: "거주지", key: "address", align: "start", minWidth: "200px" },
    { title: "제출일자", key: "submitDate1", align: "center", minWidth: "200px" },
    { title: "실명", key: "name1", align: "center", minWidth: "200px" },
    { title: "거주지", key: "address1", align: "start", minWidth: "200px" },
    { title: "제출일자", key: "submitDate1", align: "center", minWidth: "200px" },
    { title: "실명", key: "name2", align: "center", minWidth: "200px" },
    { title: "거주지", key: "address2", align: "start", minWidth: "200px" },
    { title: "제출일자", key: "submitDate2", align: "center", minWidth: "200px" },
    { title: "실명", key: "name3", align: "center", minWidth: "200px" },
    { title: "거주지", key: "address3", align: "start", minWidth: "200px" },
    { title: "제출일자", key: "submitDate4", align: "center", minWidth: "200px" },
    { title: "실명", key: "name4", align: "center", minWidth: "200px" },
    { title: "거주지", key: "address4", align: "start", minWidth: "200px" },
    { title: "제출일자", key: "submitDate5", align: "center", minWidth: "200px" },
    { title: "실명", key: "name5", align: "center", minWidth: "200px" },
    { title: "거주지", key: "address5", align: "start", minWidth: "200px" },
    { title: "제출일자", key: "submitDate6", align: "center", minWidth: "200px" },
    { title: "실명", key: "name6", align: "center", minWidth: "200px" },
    { title: "거주지", key: "address6", align: "start", minWidth: "200px" },
    { title: "제출일자", key: "submitDate7", align: "center", minWidth: "200px" },
    { title: "실명", key: "name7", align: "center", minWidth: "200px" },
    { title: "거주지", key: "address7", align: "start", minWidth: "200px" },
    { title: "제출일자", key: "submitDate8", align: "center", minWidth: "200px" },
    { title: "실명", key: "name8", align: "center", minWidth: "200px" },
    { title: "거주지", key: "address8", align: "start", minWidth: "200px" }
]);

function download() {
    alert("엑셀 다운로드 구현 예정");
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
                    <v-btn size="small" class="ma-1" icon="mdi-microsoft-excel" @click="download"></v-btn>
                </v-col>
            </v-row>
        </v-card-item>
        <v-divider></v-divider>
        <v-cardText>
            <v-data-table
                :headers="headers"
                :loading="loading"
                :items="list"
                :items-per-page="5"
                :items-per-page-options="[
                    { value: 5, title: '5' },
                    { value: 10, title: '10' },
                    { value: 20, title: '20' }
                ]"
            ></v-data-table>
        </v-cardText>
    </v-card>
</template>

<style scoped></style>
