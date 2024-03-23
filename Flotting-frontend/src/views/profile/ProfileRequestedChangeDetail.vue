<script setup>
import { ref } from "vue";
import { useRoute, useRouter } from "vue-router";
import UserInfoCard from "@/components/card/UserInformationCard.vue";
import ApprovalRejectCard from "@/components/card/ApprovalRejectCard.vue";

const route = useRoute();
const router = useRouter();

const breadcrumbs = ref([
    {
        title: "기존 고객"
    },
    {
        title: "프로필 변경 요청",
        disabled: false,
        to: "/mng/profile"
    },
    {
        title: "프로필 상세 정보",
        disabled: false
    }
]);

function clickListBtn() {
    router.push("/mng/profile");
}

function approve() {
    alert("승인 API");
}

function reject(reason) {
    alert("반려 API / 반려 사유 : " + reason);
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
                <approval-reject-card @approve="approve" @reject="reject" />
            </v-col>
        </v-row>
    </div>
</template>

<style scoped></style>
