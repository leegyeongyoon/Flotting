<script>
export default {
    name: "UserList",
    props: ["loading", "list"],
    data: () => ({
        headers: [
            { title: "제출일자", key: "submitDate", align: "center" },
            { title: "실명", key: "name", align: "center" },
            { title: "거주지", key: "address", align: "start" }
        ]
    }),
    methods: {
        download() {
            alert("엑셀 다운로드 구현 예정");
        }
    }
};
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
