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

const headers = ref([
    { title: "성함", key: "name", align: "center", minWidth: "200px", sortable: false },
    { title: "나이", key: "age", align: "center", minWidth: "200px", sortable: false },
    { title: "전화번호", key: "phoneNumber", align: "center", minWidth: "200px", sortable: false },
    { title: "직업", key: "job", align: "center", minWidth: "200px", sortable: false },
    { title: "2차 등록 여부", key: "isSecond", align: "center", minWidth: "200px", sortable: false, value: item => `${item.isSecond ? "Y" : "N"}` }
]);
</script>

<template>
    <v-card class="text-center text-sm-start w-100" fluid>
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
            >
            </v-data-table>
        </v-cardText>
    </v-card>
</template>

<style scoped>
.cursor-pointer {
    cursor: pointer;
}
</style>
