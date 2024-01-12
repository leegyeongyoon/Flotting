<script setup>
import { ref } from "vue";

defineProps({
    items: {
        type: Array,
        default: () => [
            {
                idx: 1,
                submitDate: "2024-01-01",
                status: "접수",
                code: "12345",
                name: "고객1",
                managerName: "매니저1"
            },
            {
                idx: 2,
                submitDate: "2024-01-01",
                status: "접수",
                code: "12345",
                name: "고객1",
                managerName: "매니저1"
            },
            {
                idx: 3,
                submitDate: "2024-01-01",
                status: "접수",
                code: "12345",
                name: "고객1",
                managerName: "매니저1"
            },
            {
                idx: 4,
                submitDate: "2024-01-01",
                status: "접수",
                code: "12345",
                name: "고객1",
                managerName: "매니저1"
            },
            {
                idx: 5,
                submitDate: "2024-01-01",
                status: "접수",
                code: "12345",
                name: "고객1",
                managerName: "매니저1"
            }
        ]
    }
});

const headers = ref([
    { title: "접수일자", key: "submitDate", align: "center" },
    { title: "처리현황", key: "status", align: "center" },
    { title: "고객코드", key: "code", align: "center" },
    { title: "고객명", key: "name", align: "center" },
    { title: "담당매니저", key: "managerName", align: "center" }
]);

function clickItem(idx) {
    alert("상담 상세 팝업 개발 예정, idx : " + idx);
}
</script>

<template>
    <v-card class="text-center text-sm-start w-100" fluid>
        <v-card-item>
            <v-row>
                <v-col class="d-flex align-center">
                    <v-cardTitle class="text-md-h6 ">
                        상담 이력
                    </v-cardTitle>
                </v-col>
            </v-row>
        </v-card-item>
        <v-container class="pt-0" fluid>
            <v-data-table
                :headers="headers"
                :items="items"
                :items-per-page="5"
                :items-per-page-options="[
                    { value: 5, title: '5' },
                    { value: 10, title: '10' },
                    { value: 20, title: '20' }
                ]"
                :hover="true"
            >
                <template #item="{ item }">
                    <tr class="cursor-pointer" @click="() => clickItem(item.idx)">
                        <td class="text-center">{{ item.submitDate }}</td>
                        <td class="text-center">{{ item.status }}</td>
                        <td class="text-center">{{ item.code }}</td>
                        <td class="text-center">{{ item.name }}</td>
                        <td class="text-center">{{ item.managerName }}</td>
                    </tr>
                </template>
            </v-data-table>
        </v-container>
    </v-card>
</template>

<style scoped>
.cursor-pointer {
    cursor: pointer;
}
</style>
