<script setup>
import { ref, watch } from "vue";

const emit = defineEmits(["set"]);

const rules = ref({
    required: value => !!value || "필수 값 입니다.",
    min: value => String(value).length > 40 || "40 글자 이상"
});

const text = ref("");

watch(text, newText => {
    emit("set", newText);
});
</script>

<template>
    <v-card class="text-center text-sm-start w-100" fluid>
        <v-card-title>매니저가 보내는 편지</v-card-title>
        <v-divider></v-divider>
        <v-card-item>
            <v-row>
                <v-col>
                    <p class="text-body-1 text-red">입력된 내용은 고객에게 직접 발송됩니다. (발송 전 재확인 필수)</p>
                </v-col>
            </v-row>
            <v-row>
                <v-col>
                    <v-textarea
                        v-model="text"
                        rows="1"
                        auto-grow
                        class="py-2"
                        variant="outlined"
                        label="매니저가 보내는 편지"
                        :rules="[rules.required, rules.min]"
                    ></v-textarea>
                </v-col>
            </v-row>
        </v-card-item>
    </v-card>
</template>

<style scoped></style>
