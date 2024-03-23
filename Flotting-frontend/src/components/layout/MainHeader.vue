<template>
    <v-app-bar app :elevation="2" class="blue-grey-darken-4">
        <v-app-bar-nav-icon v-if="route.path !== '/'" @click.stop="toggle"></v-app-bar-nav-icon>

        <v-app-bar-title>
            Flotting 관리자 웹
        </v-app-bar-title>

        <template #append>
            <!--            <v-btn icon>-->
            <!--                <v-icon>mdi-heart</v-icon>-->
            <!--            </v-btn>-->

            <!--            <v-btn icon>-->
            <!--                <v-icon>mdi-magnify</v-icon>-->
            <!--            </v-btn>-->

            <!--            <v-btn icon>-->
            <!--                <v-icon>mdi-dots-vertical</v-icon>-->
            <!--            </v-btn>-->
        </template>
    </v-app-bar>
</template>

<script setup>
import { useRoute } from "vue-router";
import { useStore } from "vuex";

const route = useRoute();
const store = useStore();

function toggle() {
    store.commit("toggleDrawer");
}
</script>

<style scoped></style>
