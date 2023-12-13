<template>
    <v-row>
        <v-col cols="12" sm="12" order="2" order-sm="1">
            <v-card class="text-center text-sm-start w-100" fluid>
                <v-card-item>
                    <v-cardTitle class="text-md-h6 ">
                        관리자 공지사항
                    </v-cardTitle>
                </v-card-item>
                <v-divider></v-divider>

                <v-cardText>
                    <v-data-table
                        :items="items1"
                        :items-per-page="5"
                        :items-per-page-options="[
                            { value: 5, title: '5' },
                            { value: 10, title: '10' },
                            { value: 20, title: '20' }
                        ]"
                    ></v-data-table>
                </v-cardText>
            </v-card>
        </v-col>
    </v-row>
</template>

<script>
export default {
    name: "AdminNotice",
    data() {
        return {
            items1: [
                {
                    title: "공지사항 ",
                    text: "공지사항 내용"
                },
                {
                    title: "공지사항 ",
                    text: "공지사항 내용"
                }
            ]
        };
    }
};
</script>

<style scoped></style>
