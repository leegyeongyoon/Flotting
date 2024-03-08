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
        name.value = paramsObj.name;
        id.value = paramsObj.id;
        phoneNumber.value = paramsObj.phoneNumber;
    }
});

const searchParams = ref({
    type: null,
    name: null,
    id: null,
    phoneNumber: null,
    status: null
});

const name = ref(null);
const modalName = ref(false);

const id = ref(null);
const modalId = ref(false);

const phoneNumber = ref(null);
const modalPhoneNumber = ref(false);

const types = ref([
    { title: "최종 관리자", value: "1" },
    { title: "매니저", value: "2" }
]);

function search(param) {
    !!props.isKeep && localStorage.setItem(route.path, JSON.stringify(param));
    emit("search", param);
}

function reset() {
    searchParams.value = {
        type: null,
        name: null,
        id: null,
        phoneNumber: null,
        status: null
    };
    name.value = null;
    id.value = null;
    phoneNumber.value = null;
}

function closeModal(key) {
    switch (key) {
        case "name":
            modalName.value = false;
            break;
        case "id":
            modalId.value = false;
            break;
        case "phoneNumber":
            modalPhoneNumber.value = false;
            break;
    }
}

watch(modalName, newVal => {
    if (!newVal && searchParams.value.name != name.value) {
        searchParams.value = {
            ...searchParams.value,
            name: name.value
        };
    }
});

watch(modalId, newVal => {
    if (!newVal && searchParams.value.id != id.value) {
        searchParams.value = {
            ...searchParams.value,
            id: id.value
        };
    }
});

watch(modalPhoneNumber, newVal => {
    if (!newVal && searchParams.value.phoneNumber != phoneNumber.value) {
        searchParams.value = {
            ...searchParams.value,
            phoneNumber: phoneNumber.value
        };
    }
});

watch(
    searchParams,
    newValue => {
        search(newValue);
    },
    { deep: true }
);
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
                        <v-sheet width="250">
                            <v-select
                                v-model="searchParams.type"
                                density="comfortable"
                                clearable
                                multiple
                                label="구분"
                                :items="types"
                                variant="solo"
                                hide-details
                            >
                                <template #selection="{ item, index }">
                                    <span v-if="index < 1">{{ item.title }}</span>
                                    <span v-if="index === 1" class="text-grey text-caption align-self-center">
                                        ( +{{ searchParams.type.length - 1 }} )
                                    </span>
                                </template>
                            </v-select>
                        </v-sheet>
                        <v-sheet class="d-flex ga-3 align-center" width="200">
                            <v-label class="mr-3">이름</v-label>
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
                                            @keyup.enter="() => closeModal('name')"
                                            @click:append-inner="() => closeModal('name')"
                                        ></v-text-field>
                                    </v-card-text>
                                </v-card>
                            </v-menu>
                        </v-sheet>
                        <v-sheet class="d-flex ga-3 align-center" width="200">
                            <v-label class="mr-3">아이디</v-label>
                            <v-menu v-model="modalId" :close-on-content-click="false" location="bottom">
                                <template #activator="{ props }">
                                    <v-text-field
                                        v-model="searchParams.id"
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
                                            v-model="id"
                                            density="compact"
                                            variant="solo"
                                            hide-details
                                            clearable
                                            append-inner-icon="mdi-magnify"
                                            @keyup.enter="() => closeModal('id')"
                                            @click:append-inner="() => closeModal('id')"
                                        ></v-text-field>
                                    </v-card-text>
                                </v-card>
                            </v-menu>
                        </v-sheet>
                        <v-sheet class="d-flex ga-3 align-center" width="250">
                            <v-label class="mr-3">전화번호</v-label>
                            <v-menu v-model="modalPhoneNumber" :close-on-content-click="false" location="bottom">
                                <template #activator="{ props }">
                                    <v-text-field
                                        v-model="searchParams.phoneNumber"
                                        readonly
                                        variant="outlined"
                                        v-bind="props"
                                        hide-details
                                        density="compact"
                                    />
                                </template>
                                <v-card min-width="250">
                                    <v-card-text>
                                        <v-text-field
                                            v-model="phoneNumber"
                                            density="compact"
                                            variant="solo"
                                            hide-details
                                            clearable
                                            append-inner-icon="mdi-magnify"
                                            @keyup.enter="() => closeModal('phoneNumber')"
                                            @click:append-inner="() => closeModal('phoneNumber')"
                                        ></v-text-field>
                                    </v-card-text>
                                </v-card>
                            </v-menu>
                        </v-sheet>
                        <v-sheet>
                            <v-label class="mr-3">활성화</v-label>
                            <v-btn-toggle v-model="searchParams.status" variant="outlined" divided multiple>
                                <v-btn value="Y">활성화</v-btn>
                                <v-btn value="N">비활성화</v-btn>
                            </v-btn-toggle>
                        </v-sheet>
                    </v-sheet>
                </v-col>
            </v-row>
        </v-container>
    </v-card>
</template>

<style scoped></style>
