<script setup>
import { ref } from "vue";
import { useRoute, useRouter } from "vue-router";
import UserInfoCard from "@/components/card/UserInformationCard.vue";
import ApprovalRejectCard from "@/components/card/ApprovalRejectCard.vue";
import RegisterSecondApprovalRejectCard from "@/views/reg/card/RegisterSecondApprovalRejectCard.vue";

const route = useRoute();
const router = useRouter();

const breadcrumbs = ref([
    {
        title: "신규 고객"
    },
    {
        title: "2차 등록 고객",
        to: "/reg/second"
    },
    {
        title: "고객 상세 정보",
        disabled: false
    }
]);

function clickListBtn() {
    router.push("/reg/second");
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
                <user-info-card />
            </v-col>
            <v-col cols="6" sm="6">
                <!--                <approval-reject-card @approve="approve" @reject="reject" />-->
                <register-second-approval-reject-card />
            </v-col>
        </v-row>
    </div>
</template>

<style scoped></style>
