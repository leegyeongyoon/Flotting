<script setup>
import { ref } from "vue";
import { useRoute, useRouter } from "vue-router";

const emit = defineEmits(["close"]);
const router = useRouter();

const type = ref(null);
const typeRules = ref([
    value => {
        if (!value) return "type is required";

        return true;
    }
]);
const name = ref(null);
const id = ref(null);
const phoneNumber = ref(null);
const nameRules = ref([value => (!value ? "name is required" : true), value => (value?.length < 2 ? "name must be at least 2 characters." : true)]);
const idRules = ref([value => (!value ? "id is required" : true), value => (value?.length < 2 ? "id must be at least 2 characters." : true)]);
const phoneNumberRules = ref([
    value => (!value ? "phoneNumber is required" : true),
    value => (!/[0-9]+/.test(value) ? "phoneNumber must be number" : true),
    value => (value?.length < 10 ? "phoneNumber must be at least 10 numbers." : true)
]);

const form = ref(false);
const loading = ref(false);

const types = ref([
    { title: "최종 관리자", value: "1" },
    { title: "매니저", value: "2" }
]);
function close() {
    emit("close");
}

async function submit(event) {
    loading.value = true;
    const results = await event;
    loading.value = false;
    if (!results.valid) {
        return;
    }
    alert(`관리자 등록 API / 구분: ${type.value}, 이름: ${name.value}, 아이디: ${id.value}, 전화번호: ${phoneNumber.value}`);
}
</script>

<template>
    <v-form v-model="form" @submit.prevent="submit">
        <v-card class="text-center text-sm-start w-100" fluid>
            <v-card-title class="text-md-h6 "> 관리자 등록 </v-card-title>
            <v-divider />
            <v-card-text>
                <v-sheet class="d-flex flex-column ga-2">
                    <v-select v-model="type" density="comfortable" label="구분" :items="types" :rules="typeRules" required :disabled="loading">
                    </v-select>
                    <v-text-field v-model="name" label="이름" :rules="nameRules" :readonly="loading"></v-text-field>
                    <v-text-field v-model="id" label="아이디" :rules="idRules" :readonly="loading"></v-text-field>
                    <v-text-field v-model="phoneNumber" label="전화번호" :rules="phoneNumberRules" :readonly="loading"></v-text-field>
                </v-sheet>
            </v-card-text>
            <v-divider />
            <v-card-actions class="d-flex justify-end">
                <v-btn type="button" color="blue-darken-1" variant="text" @click="close">
                    닫기
                </v-btn>
                <v-btn type="submit" color="success" :disabled="!form" :loading="loading">
                    등록
                </v-btn>
            </v-card-actions>
        </v-card>
    </v-form>
</template>

<style scoped></style>
