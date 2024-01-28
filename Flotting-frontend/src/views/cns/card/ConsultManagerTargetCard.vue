<script setup>
const emit = defineEmits(["delete"]);

defineProps({
    list: {
        type: Array,
        default: () => []
    }
});

function clickDeleteIcon(i) {
    if (!confirm("정말로 삭제하시겠습니까?")) {
        return;
    }

    emit("delete", i);
}
</script>

<template>
    <v-card class="text-center text-sm-start w-100" fluid>
        <v-card-title>소개 대상 목록</v-card-title>
        <v-divider></v-divider>
        <v-card-item>
            <v-row v-if="list.length === 0">
                <v-col>
                    <p>소개 대상을 선택해주세요.</p>
                </v-col>
            </v-row>
            <v-row v-for="({ userNumber, name }, i) in list" :key="i">
                <v-col cols="1"><v-icon icon="mdi-delete" @click="() => clickDeleteIcon(i)"/></v-col>
                <v-col>{{ userNumber }}</v-col>
                <v-col>{{ name }}</v-col>
            </v-row>
        </v-card-item>
        <v-divider></v-divider>
        <v-card-item>
            <v-row>
                <v-col class="d-flex justify-end align-center">
                    <v-btn type="submit" class="ma-1" color="green" :disabled="list.length !== 2">제출</v-btn>
                </v-col>
            </v-row>
        </v-card-item>
    </v-card>
</template>

<style scoped></style>
