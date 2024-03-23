<script setup>
import { onBeforeMount, ref, watch } from "vue";
import { useRoute, useRouter } from "vue-router";

const props = defineProps({
    isKeep: {
        type: Boolean,
        default: true
    }
});
const emit = defineEmits(["search"]);
const router = useRouter();
const route = useRoute();

onBeforeMount(() => {
    if (!props.isKeep) {
        return;
    }
    const path = route.path;
    const params = localStorage.getItem(path);
    if (!!params) {
        const paramsObj = JSON.parse(params);
        Object.keys(paramsObj).forEach(key => {
            searchParams.value[key] = paramsObj[key];
        });
        height.value = paramsObj.height;
        age.value = paramsObj.age;
    }
});

const searchParams = ref({
    gender: null,
    dormancy: "N",
    grade: null,
    form: null,
    residence: null,
    job: null,
    height: [150, 200],
    age: [20, 45],
    smoked: null,
    searchDate: [null, null]
});
const height = ref([150, 200]);
const age = ref([20, 45]);

const modalHeight = ref(false);
const modalAge = ref(false);

const forms = ref([
    { title: "평균", value: "f1" },
    { title: "슬림한", value: "f2" },
    { title: "볼륨있는", value: "f3" },
    { title: "탄탄한", value: "f4" },
    { title: "통통한", value: "f5" },
    { title: "듬직한", value: "f6" },
    { title: "근육이 많은", value: "f7" }
]);
const residences = ref([
    { title: "서울 북부", value: "r1" },
    { title: "서울 남부", value: "r2" },
    { title: "서울 서부", value: "r3" },
    { title: "서울 동부", value: "r4" },
    { title: "경기 서부", value: "r5" },
    { title: "경기 남부", value: "r6" },
    { title: "경기 동부", value: "r7" },
    { title: "경기 북부", value: "r8" }
]);
const jobs = ref([
    { title: "공무원/공기업", value: "j1" },
    { title: "중견기업/대기업", value: "j2" },
    { title: "전문직", value: "j3" },
    { title: "사업가", value: "j4" }
]);

function search(param) {
    !!props.isKeep && localStorage.setItem(route.path, JSON.stringify(param));
    emit("search", param);
}

function reset() {
    searchParams.value = {
        gender: null,
        dormancy: "N",
        grade: null,
        form: null,
        residence: null,
        job: null,
        height: [150, 200],
        age: [20, 45],
        smoked: null,
        searchDate: [null, null]
    };
    height.value = [150, 200];
    age.value = [20, 45];
}

watch(
    searchParams,
    newValue => {
        search(newValue);
    },
    { deep: true }
);
watch(modalHeight, newValue => {
    if (!newValue) {
        searchParams.value.height = height.value;
    }
});

watch(modalAge, newValue => {
    if (!newValue) {
        searchParams.value.age = age.value;
    }
});
</script>

<template>
    <v-card class="text-center text-sm-start w-100" fluid>
        <v-card-item>
            <v-row>
                <v-col class="d-flex align-center">
                    <v-cardTitle class="text-md-h6 ">
                        검색 조건
                    </v-cardTitle>
                </v-col>
                <v-col class="d-flex justify-end">
                    <v-btn size="small" class="ma-1" @click="reset()">초기화</v-btn>
                </v-col>
            </v-row>
        </v-card-item>
        <v-divider></v-divider>
        <v-container fluid>
            <v-row>
                <v-col>
                    <v-sheet class="d-flex ga-4 flex-wrap">
                        <v-sheet>
                            <v-label class="mr-3">성별</v-label>
                            <v-btn-toggle v-model="searchParams.gender" variant="outlined" divided multiple>
                                <v-btn icon="mdi-human-male" value="man"></v-btn>
                                <v-btn icon="mdi-human-female" value="woman"></v-btn>
                            </v-btn-toggle>
                        </v-sheet>
                        <v-sheet>
                            <v-label class="mr-3">회원등급</v-label>
                            <v-btn-toggle v-model="searchParams.grade" variant="outlined" divided multiple>
                                <v-btn icon="mdi-alpha-d-circle-outline" value="D"></v-btn>
                                <v-btn icon="mdi-alpha-p-circle-outline" value="P"></v-btn>
                                <v-btn icon="mdi-alpha-g-circle-outline" value="G"></v-btn>
                            </v-btn-toggle>
                        </v-sheet>
                        <v-sheet>
                            <v-label class="mr-3">흡연</v-label>
                            <v-btn-toggle v-model="searchParams.smoked" variant="outlined" divided multiple>
                                <v-btn icon="mdi-alpha-y-circle-outline" value="Y"></v-btn>
                                <v-btn icon="mdi-alpha-n-circle-outline" value="N"></v-btn>
                            </v-btn-toggle>
                        </v-sheet>
                        <v-sheet>
                            <v-label class="mr-3">휴먼여부</v-label>
                            <v-btn-toggle v-model="searchParams.dormancy" variant="outlined" divided multiple>
                                <v-btn icon="mdi-alpha-y-circle-outline" value="Y"></v-btn>
                                <v-btn icon="mdi-alpha-n-circle-outline" value="N"></v-btn>
                            </v-btn-toggle>
                        </v-sheet>
                    </v-sheet>
                </v-col>
            </v-row>
            <v-row>
                <v-col>
                    <v-sheet class="d-flex ga-4 flex-wrap">
                        <v-sheet width="300px">
                            <v-select
                                v-model="searchParams.form"
                                density="comfortable"
                                clearable
                                multiple
                                label="체형"
                                :items="forms"
                                variant="solo"
                                hide-details
                            >
                                <template #selection="{ item, index }">
                                    <span v-if="index < 1">{{ item.title }}</span>
                                    <span v-if="index === 1" class="text-grey text-caption align-self-center">
                                        ( +{{ searchParams.form.length - 1 }} )
                                    </span>
                                </template>
                            </v-select>
                        </v-sheet>
                        <v-sheet width="300px">
                            <v-select
                                v-model="searchParams.residence"
                                density="comfortable"
                                label="거주지"
                                :items="residences"
                                variant="solo"
                                hide-details
                                clearable
                                multiple
                            >
                                <template #selection="{ item, index }">
                                    <span v-if="index < 1">{{ item.title }}</span>
                                    <span v-if="index === 1" class="text-grey text-caption align-self-center">
                                        ( +{{ searchParams.residence.length - 1 }} )
                                    </span>
                                </template>
                            </v-select></v-sheet
                        >
                        <v-sheet width="300px">
                            <v-select
                                v-model="searchParams.job"
                                density="comfortable"
                                clearable
                                multiple
                                label="직업"
                                :items="jobs"
                                variant="solo"
                                hide-details
                                @update="search"
                            >
                                <template #selection="{ item, index }">
                                    <span v-if="index < 1">{{ item.title }}</span>
                                    <span v-if="index === 1" class="text-grey text-caption align-self-center">
                                        ( +{{ searchParams.job.length - 1 }} )
                                    </span>
                                </template>
                            </v-select>
                        </v-sheet>
                    </v-sheet>
                </v-col>
            </v-row>
            <v-row>
                <v-col>
                    <v-sheet class="d-flex ga-4 flex-wrap">
                        <v-sheet>
                            <v-menu v-model="modalAge" :close-on-content-click="false" location="bottom">
                                <template #activator="{ props }">
                                    <v-btn v-bind="props" width="100%" height="48px">{{
                                        "나이 " + searchParams.age[0] + " ~ " + searchParams.age[1]
                                    }}</v-btn>
                                </template>
                                <v-card min-width="300">
                                    <v-card-title>{{ "나이 " + age[0] + " ~ " + age[1] }}</v-card-title>
                                    <v-card-text>
                                        <v-range-slider v-model="age" :thumb-label="true" :min="20" :max="45" step="1" hide-details></v-range-slider>
                                    </v-card-text>
                                    <v-divider></v-divider>
                                    <v-card-actions>
                                        <v-spacer></v-spacer>
                                        <v-btn variant="text" @click="modalAge = false">
                                            확인
                                        </v-btn>
                                    </v-card-actions>
                                </v-card>
                            </v-menu>
                        </v-sheet>
                        <v-sheet>
                            <v-menu v-model="modalHeight" :close-on-content-click="false" location="bottom">
                                <template #activator="{ props }">
                                    <v-btn v-bind="props" width="100%" height="48px">{{
                                        "키 " + searchParams.height[0] + " ~ " + searchParams.height[1]
                                    }}</v-btn>
                                </template>
                                <v-card min-width="300">
                                    <v-card-title>{{ "키 " + height[0] + " ~ " + height[1] }}</v-card-title>
                                    <v-card-text>
                                        <v-range-slider
                                            v-model="height"
                                            :thumb-label="true"
                                            :min="150"
                                            :max="200"
                                            step="1"
                                            hide-details
                                        ></v-range-slider>
                                    </v-card-text>
                                    <v-divider></v-divider>
                                    <v-card-actions>
                                        <v-spacer></v-spacer>
                                        <v-btn variant="text" @click="modalHeight = false">
                                            확인
                                        </v-btn>
                                    </v-card-actions>
                                </v-card>
                            </v-menu>
                        </v-sheet>
                    </v-sheet>
                </v-col>
            </v-row>
        </v-container>
    </v-card>
</template>

<style scoped></style>
