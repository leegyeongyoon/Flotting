<script setup>
import { ref } from "vue";
import { useRoute, useRouter } from "vue-router";
import UserInfoCard from "@/components/card/UserInformationCard.vue";
import UserPayHistoryCard from "@/views/user/card/UserPayHistoryCard.vue";
import UserConsultHistoryCard from "@/components/card/UserConsultHistoryCard.vue";

const route = useRoute();
const router = useRouter();

const breadcrumbs = ref([
    {
        title: "기존 고객"
    },
    {
        title: "고객 정보 검색",
        to: "/mng/user"
    },
    {
        title: "고객 상세 정보",
        disabled: false
    }
]);

function clickListBtn() {
    router.push("/mng/user");
}
</script>

<template>
    <div>
        <v-row>
            <v-col>
                <v-breadcrumbs :items="breadcrumbs" class="pa-0">
                    <template #title="{ item }">
                        {{ item.title.toUpperCase() }}
                    </template>
                </v-breadcrumbs>
            </v-col>
            <v-col class="d-flex justify-end">
                <v-btn size="small" class="ma-1" @click="clickListBtn()">목록</v-btn>
            </v-col>
        </v-row>
        <v-row>
            <v-col cols="6" sm="6">
                <user-info-card :is-edit="true" />
            </v-col>
            <v-col cols="6" sm="6">
                <v-row>
                    <v-col>
                        <user-pay-history-card />
                    </v-col>
                </v-row>
                <v-row>
                    <v-col>
                        <user-consult-history-card />
                    </v-col>
                </v-row>
            </v-col>
        </v-row>
    </div>
</template>

<style scoped></style>
