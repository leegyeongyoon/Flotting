<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import UserInfoCard from "@/components/card/UserInformationCard.vue";
import RegisterSecondApprovalRejectCard from "@/views/reg/card/RegisterSecondApprovalRejectCard.vue";

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

const clickListBtn = () => router.push("/reg/second");

const managerComment = ref("");
const rejectionReason = ref("");
</script>

<template>
    <v-container>
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
            <v-col cols="8" sm="8">
                <user-info-card />
            </v-col>
            <v-col cols="4" sm="4" class="col-gap">
                <v-card>
                    <v-card-title class="text-md-h6">매니저 코멘트 입력</v-card-title>
                    <v-card-text>
                        <v-textarea v-model="managerComment" label="comment" rows="4" auto-grow></v-textarea>
                    </v-card-text>
                </v-card>
                <v-card>
                    <v-card-title class="text-md-h6">반려 사유 입력</v-card-title>
                    <v-card-text>
                        <v-textarea v-model="rejectionReason" label="comment" rows="4" auto-grow></v-textarea>
                    </v-card-text>
                </v-card>
                <!-- <approval-reject-card @approve="approve" @reject="reject" />-->
                <register-second-approval-reject-card />
            </v-col>
        </v-row>
    </v-container>
</template>

<style scoped>
.col-gap {
    display: flex;
    flex-direction: column;
    gap: 1rem;
}
</style>
