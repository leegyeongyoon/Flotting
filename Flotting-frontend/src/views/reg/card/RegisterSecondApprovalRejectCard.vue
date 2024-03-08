<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
const rejectReason = ref("");

const router = useRouter();

const btnValue = ref("");
const grade = ref("");

function approve() {
    if (!confirm("정말로 승인하시겠습니까?")) {
        return;
    }
    alert("승인 API, 고객 등급 : " + grade.value);
    router.push("/reg/second");
}

const rules = ref({
    required: value => !!value || "필수 값 입니다.",
    min: value => String(value).length > 40 || "40 글자 이상"
});

async function reject(event) {
    const results = await event;
    if (!results.valid) {
        return;
    }
    if (!confirm("정말로 반려하시겠습니까?")) {
        return;
    }

    alert("반려 API / 반려 사유 : " + rejectReason.value);
    router.push("/reg/second");
}
</script>

<template>
    <v-card class="text-center text-sm-start w-100" fluid>
        <v-card-item>
            <v-row>
                <v-col class="d-flex align-center ga-2">
                    <v-btn value="Y" color="green" :variant="btnValue === 'Y' ? 'flat' : 'outlined'" @click="() => (btnValue = 'Y')">승인</v-btn>
                    <v-btn value="N" color="red" :variant="btnValue === 'N' ? 'flat' : 'outlined'" @click="() => (btnValue = 'N')">반려</v-btn>
                </v-col>
                <v-col class="d-flex justify-end"> </v-col>
            </v-row>
        </v-card-item>
        <v-container v-if="btnValue === 'Y'" fluid>
            <v-form @submit.prevent="approve">
                <v-row>
                    <v-col>
                        <p class="text-h5">고객 등급 설정</p>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col class="d-flex flex-column">
                        <v-sheet>
                            <v-label class="mr-3">회원등급</v-label>
                            <v-btn-toggle v-model="grade" variant="outlined" divided>
                                <v-btn icon="mdi-alpha-g-circle-outline" value="G"></v-btn>
                                <v-btn icon="mdi-alpha-p-circle-outline" value="P"></v-btn>
                                <v-btn icon="mdi-alpha-d-circle-outline" value="D"></v-btn>
                            </v-btn-toggle>
                        </v-sheet>
                        <div class="w-100 d-flex justify-end">
                            <v-btn type="submit" :disabled="grade === ''">승인</v-btn>
                        </div>
                    </v-col>
                </v-row>
            </v-form>
        </v-container>
        <v-container v-if="btnValue === 'N'" fluid>
            <v-form @submit.prevent="reject">
                <v-row>
                    <v-col>
                        <p class="text-h5">반려 사유</p>
                        <p class="text-body-1 text-red">입력된 내용은 고객에게 직접 발송됩니다. (발송 전 재확인 필수)</p>
                    </v-col>
                </v-row>
                <v-row>
                    <v-col class="d-flex flex-column">
                        <v-textarea
                            v-model="rejectReason"
                            rows="1"
                            auto-grow
                            class="py-2"
                            variant="outlined"
                            label="반려 사유"
                            :disabled="btnValue !== 'N'"
                            :rules="[rules.required, rules.min]"
                        ></v-textarea>
                        <div class="w-100 d-flex justify-end">
                            <v-btn type="submit">반려</v-btn>
                        </div>
                    </v-col>
                </v-row>
            </v-form>
        </v-container>
    </v-card>
</template>

<style scoped></style>
