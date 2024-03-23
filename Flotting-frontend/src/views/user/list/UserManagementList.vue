<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
const router = useRouter();

const emit = defineEmits(["clickRow"]);

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
    { title: "거주지", key: "address", align: "start", minWidth: "200px" }
]);

function download() {
    alert("엑셀 다운로드 구현 예정");
}

function clickItem(idx) {
    emit("clickRow", idx);
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
                :hover="true"
            >
                <template #item="{ item }">
                    <tr class="cursor-pointer" @click="() => clickItem(item.idx)">
                        <td class="text-center">{{ item.submitDate }}</td>
                        <td class="text-center">{{ item.name }}</td>
                        <td class="text-start">{{ item.address }}</td>
                    </tr>
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
