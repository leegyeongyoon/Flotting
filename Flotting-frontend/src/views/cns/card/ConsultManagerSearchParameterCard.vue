<script setup>
import { onBeforeMount, ref, watch } from "vue";
import { useRoute, useRouter } from "vue-router";
import { DatePicker } from "v-calendar";
import "v-calendar/style.css";
import dayjs from "dayjs";

const emit = defineEmits(["search"]);
const router = useRouter();
const route = useRoute();

onBeforeMount(() => {
    const path = route.path;
    const params = localStorage.getItem(path);
    if (!!params) {
        const paramsObj = JSON.parse(params);
        Object.keys(paramsObj).forEach(key => {
            searchParams.value[key] = paramsObj[key];
        });
        name.value = paramsObj.name;
    }
});

const searchParams = ref({
    start: null,
    end: null,
    name: ""
});

const name = ref("");

const modalStart = ref(false);
const modalEnd = ref(false);
const modalName = ref(false);

function search(param) {
    emit("search", param);
}

function reset() {
    searchParams.value = {
        start: null,
        end: null,
        name: ""
    };
    name.value = "";
}

watch(
    () => searchParams.value.start,
    newStart => {
        if (!!searchParams.value.end && newStart > searchParams.value.end) {
            searchParams.value = {
                ...searchParams.value,
                end: newStart
            };
        }
    }
);

watch(
    () => searchParams.value.end,
    newEnd => {
        if (!!searchParams.value.start && searchParams.value.start > newEnd) {
            searchParams.value = {
                ...searchParams.value,
                start: newEnd
            };
        }
    }
);

watch(
    searchParams,
    newValue => {
        search(newValue);
    },
    { deep: true }
);

function closeSearchName() {
    modalName.value = false;
}

watch(modalName, newVal => {
    if (!newVal) {
        searchParams.value = {
            ...searchParams.value,
            name: name.value
        };
    } else {
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
                        <v-sheet class="d-flex ga-3 align-center">
                            <v-label class="">접수일자</v-label>
                            <v-menu v-model="modalStart" :close-on-content-click="false" location="bottom">
                                <template #activator="{ props }">
                                    <v-btn v-bind="props" width="120px" height="48px">{{
                                        searchParams.start ? dayjs(searchParams.start).format("YYYY-MM-DD") : " "
                                    }}</v-btn>
                                </template>
                                <DatePicker v-model="searchParams.start" mode="date" />
                            </v-menu>
                            <span>~</span>
                            <v-sheet>
                                <v-menu v-model="modalEnd" :close-on-content-click="false" location="bottom">
                                    <template #activator="{ props }">
                                        <v-btn v-bind="props" width="120px" height="48px">{{
                                            searchParams.end ? dayjs(searchParams.end).format("YYYY-MM-DD") : " "
                                        }}</v-btn>
                                    </template>
                                    <DatePicker v-model="searchParams.end" mode="date" />
                                </v-menu>
                            </v-sheet>
                        </v-sheet>
                        <v-sheet class="d-flex ga-3 align-center" width="300">
                            <v-label class="mr-3">고객명</v-label>
                            <v-menu v-model="modalName" :close-on-content-click="false" location="bottom">
                                <template #activator="{ props }">
                                    <v-text-field
                                        v-model="searchParams.name"
                                        readonly
                                        variant="outlined"
                                        v-bind="props"
                                        hide-details
                                        density="compact"
                                    />
                                </template>
                                <v-card min-width="200">
                                    <v-card-text>
                                        <v-text-field
                                            v-model="name"
                                            density="compact"
                                            variant="solo"
                                            hide-details
                                            clearable
                                            append-inner-icon="mdi-magnify"
                                            @keyup.enter="closeSearchName"
                                            @click:append-inner="closeSearchName"
                                        ></v-text-field>
                                    </v-card-text>
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
