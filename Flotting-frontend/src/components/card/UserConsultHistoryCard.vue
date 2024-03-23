<script setup>
import { ref } from "vue";
import UserConsultHistoryDetailEditor from "@/components/container/UserConsultHistoryDetailEditor.vue";

const props = defineProps({
    items: {
        type: Array,
        default: () => [
            {
                idx: 1,
                submitDate: "2024-01-01",
                status: "접수",
                code: "12345",
                name: "고객1",
                managerName: "매니저1",
                detail: "detail1"
            },
            {
                idx: 2,
                submitDate: "2024-01-01",
                status: "접수",
                code: "12345",
                name: "고객1",
                managerName: "매니저1",
                detail: "detail1"
            },
            {
                idx: 3,
                submitDate: "2024-01-01",
                status: "접수",
                code: "12345",
                name: "고객1",
                managerName: "매니저1",
                detail: "detail1"
            },
            {
                idx: 4,
                submitDate: "2024-01-01",
                status: "접수",
                code: "12345",
                name: "고객1",
                managerName: "매니저1",
                detail: "detail1"
            },
            {
                idx: 5,
                submitDate: "2024-01-01",
                status: "접수",
                code: "12345",
                name: "고객1",
                managerName: "매니저1",
                detail: "detail1"
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
const expanded = ref([]);

function clickEditSaveBtn(item, index) {
    console.log(item);
    console.log(index);
    console.log(props.items[index]);
}

function update(val) {
    console.log(val);
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
                :expanded="expanded"
                :headers="headers"
                :items="items"
                item-value="idx"
                :items-per-page="5"
                :items-per-page-options="[
                    { value: 5, title: '5' },
                    { value: 10, title: '10' },
                    { value: 20, title: '20' }
                ]"
                show-expand
            >
                <template #expanded-row="{ index, columns, item }">
                    <tr>
                        <td :colspan="columns.length" class="pa-0">
                            <user-consult-history-detail-editor :index="index" :item="item" :val="item.detail"></user-consult-history-detail-editor>
                        </td>
                        <!--                      <td :colspan="columns.length">More info about {{ item.name }}</td>-->
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
