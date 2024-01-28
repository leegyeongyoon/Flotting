<script setup>
import { ref } from "vue";
import UserProfileTable from "@/components/table/UserProfileTable.vue";

const dialog = ref(false);
</script>

<template>
    <v-dialog v-model="dialog" scrollable="true" width="auto">
        <v-card class="text-center text-sm-start w-100" fluid>
            <v-card-title class="text-md-h6 "> (사용자 이름) </v-card-title>
            <v-divider />
            <v-card-text>
                <user-profile-table />
            </v-card-text>
            <v-divider />
            <v-card-actions class="d-flex justify-end">
                <v-btn color="blue-darken-1" variant="text" @click="dialog = false">
                    닫기
                </v-btn>
                <v-btn color="blue-darken-1" variant="text" @click="dialog = false">
                    추가
                </v-btn>
            </v-card-actions>
        </v-card>
    </v-dialog>
</template>

<style scoped></style>
