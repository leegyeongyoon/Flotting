<template>
    <v-navigation-drawer v-if="store.getters.getDrawer" v-model="selectedItem" :elevation="3" class="blue-grey-darken-2">
        <v-list :opened="open">
            <v-list-item :to="'/home'" prepend-icon="mdi-view-dashboard" title="대시 보드" value="dashboard"></v-list-item>
            <v-list-item :to="'/account'" prepend-icon="mdi-view-dashboard" title="Account" value="account"></v-list-item>
            <v-list-group value="ExistingManagement">
                <template #activator="{ props }">
                    <v-list-item v-bind="props" prepend-icon="mdi-account-circle" title="기존 고객"></v-list-item>
                </template>
                <v-list-item v-for="([title, to], i) in existingManagement" :key="i" :title="title" :value="title" :to="to"></v-list-item>
            </v-list-group>
            <v-list-group value="NewManagement">
                <template #activator="{ props }">
                    <v-list-item v-bind="props" prepend-icon="mdi-account-circle-outline" title="신규 고객"></v-list-item>
                </template>
                <v-list-item v-for="([title, to], i) in newManagement" :key="i" :title="title" :value="title" :to="to"></v-list-item>
            </v-list-group>
            <v-list-group value="ExistingConsulting">
                <template #activator="{ props }">
                    <v-list-item v-bind="props" prepend-icon="mdi-lan" title="고객 상담"></v-list-item>
                </template>
                <v-list-item v-for="([title, to], i) in existingConsulting" :key="i" :title="title" :value="title" :to="to"></v-list-item>
            </v-list-group>
            <v-list-group value="Announcement">
                <template #activator="{ props }">
                    <v-list-item v-bind="props" prepend-icon="mdi-bell-circle" title="공지 사항"></v-list-item>
                </template>
                <v-list-item v-for="([title, to], i) in announcement" :key="i" :title="title" :value="title" :to="to"></v-list-item>
            </v-list-group>
            <v-list-item :to="'/indicator'" prepend-icon="mdi-chart-line" title="지표 관리(기존)" value="indicator"></v-list-item>
            <v-list-group value="System">
                <template #activator="{ props }">
                    <v-list-item v-bind="props" prepend-icon="mdi-cog-outline" title="시스템 관리"></v-list-item>
                </template>
                <v-list-item v-for="([title, to], i) in system" :key="i" :title="title" :value="title" :to="to"></v-list-item>
            </v-list-group>
        </v-list>
        <template #append>
            <div class="pa-2">
                <v-btn block @click="logout">
                    Logout
                </v-btn>
            </div>
        </template>
    </v-navigation-drawer>
</template>

<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import { useStore } from "vuex";

const router = useRouter();
const store = useStore();

const open = ref([""]);
const existingManagement = ref([
    ["고객 정보 검색", "/mng/user"],
    ["프로필 변경 요청", "/mng/profile"]
]);
const newManagement = ref([
    ["1차 등록 고객", "/reg/first"],
    ["2차 등록 고객", "/reg/second"]
]);
const existingConsulting = ref([
    ["고객 CS 응대", "/cns/user"],
    ["매니저 전담 소개", "/cns/manager"]
]);
const announcement = ref([
    ["관리자 공지사항", "/noti/admin"],
    ["고객 공지사항", "/noti/user"]
]);
const system = ref([["관리자 관리", "/sys/manager"]]);
const selectedItem = ref(null);

function logout() {
    store.commit("logout");
    store.commit("closeDrawer");
    router.push("/");
}
</script>

<style scoped></style>
