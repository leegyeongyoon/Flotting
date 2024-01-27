<script setup>
import { onBeforeMount, ref, watch } from "vue";
import { onBeforeRouteLeave, onBeforeRouteUpdate, useRoute, useRouter } from "vue-router";
import { useStore } from "vuex";

// const emit = defineEmits(["search"]);
// const router = useRouter();
// const route = useRoute();
// const store = useStore();
//
// onBeforeMount(() => {
//   const path = route.path;
//   const params = store.getters.getSearchParams(path);
//   if (!!params) {
//     Object.keys(params).forEach(key => {
//       console.log(key + " / " + params[key]);
//       searchParams.value[key] = params[key];
//     });
//     height.value = params.height;
//     age.value = params.age;
//   }
// });
//
// onBeforeRouteLeave((to, from) => {
//   const params = searchParams.value;
//   if (!!params) {
//     store.commit("setSearchParams", { path: from.path, params: { ...params } });
//   }
// });
//
// const searchParams = ref({
//   gender: null,
//   dormancy: "N",
//   grade: null,
//   form: null,
//   residence: null,
//   job: null,
//   height: [150, 200],
//   age: [20, 45],
//   smoked: null,
//   searchDate: [null, null]
// });
// const height = ref([150, 200]);
// const age = ref([20, 45]);
//
// const modalHeight = ref(false);
// const modalAge = ref(false);
//
// const forms = ref([
//   { title: "평균", value: "f1" },
//   { title: "슬림한", value: "f2" },
//   { title: "볼륨있는", value: "f3" },
//   { title: "탄탄한", value: "f4" },
//   { title: "통통한", value: "f5" },
//   { title: "듬직한", value: "f6" },
//   { title: "근육이 많은", value: "f7" }
// ]);
// const residences = ref([
//   { title: "서울 북부", value: "r1" },
//   { title: "서울 남부", value: "r2" },
//   { title: "서울 서부", value: "r3" },
//   { title: "서울 동부", value: "r4" },
//   { title: "경기 서부", value: "r5" },
//   { title: "경기 남부", value: "r6" },
//   { title: "경기 동부", value: "r7" },
//   { title: "경기 북부", value: "r8" }
// ]);
// const jobs = ref([
//   { title: "공무원/공기업", value: "j1" },
//   { title: "중견기업/대기업", value: "j2" },
//   { title: "전문직", value: "j3" },
//   { title: "사업가", value: "j4" }
// ]);
//
// function search(param) {
//   emit("search", param);
// }
//
// function reset() {
//   searchParams.value = {
//     gender: null,
//     dormancy: "N",
//     grade: null,
//     form: null,
//     residence: null,
//     job: null,
//     height: [150, 200],
//     age: [20, 45],
//     smoked: null,
//     searchDate: [null, null]
//   };
//   height.value = [150, 200];
//   age.value = [20, 45];
// }
//
// watch(
//     searchParams,
//     newValue => {
//       search(newValue);
//     },
//     { deep: true }
// );
// watch(modalHeight, newValue => {
//   if (!newValue) {
//     searchParams.value.height = height.value;
//   }
// });
//
// watch(modalAge, newValue => {
//   if (!newValue) {
//     searchParams.value.age = age.value;
//   }
// });
</script>

<template>
    <v-card class="text-center text-sm-start w-100" fluid>
        <v-card-item>
            <v-row>
                <v-col class="d-flex align-center">
                    <v-cardTitle class="text-md-h6 ">
                        요청 사항
                    </v-cardTitle>
                </v-col>
            </v-row>
        </v-card-item>
        <v-divider></v-divider>
        <v-container fluid>
            <v-row>
                <v-col>
                    <v-card variant="flat" fluid>
                        <v-cardTitle class="text-md-h6 ">취향</v-cardTitle>
                        <v-card variant="flat" fluid>
                            <v-card-item>
                                <div class="d-flex align-center w-100">
                                    <div class="w-25">직업</div>
                                    <div class="w-75">대기업</div>
                                </div>
                            </v-card-item>
                            <v-card-item>
                                <div class="d-flex align-center w-100">
                                    <div class="w-25">직업</div>
                                    <div class="w-75">대기업</div>
                                </div>
                            </v-card-item>
                        </v-card>
                    </v-card>
                </v-col>
                <v-col>
                    <v-card variant="flat" fluid>
                        <v-cardTitle class="text-md-h6 ">편지</v-cardTitle>
                        <v-card variant="flat">
                            <v-card-item>
                                <div>
                                    편지내용입니답편지내용입니답편지내용입니답편지내용입니답편지내용입니답편지내용입니답편지내용입니답
                                </div>
                            </v-card-item>
                        </v-card>
                    </v-card>
                </v-col>
            </v-row>
        </v-container>
    </v-card>
</template>

<style scoped></style>
