<template>
    <v-app>
        <main-header class="bg-blue-grey-lighten-5" />
        <main-navigation class="bg-blue-grey-lighten-5" />
        <v-main class="bg-grey-lighten-5  align-center justify-center" style="min-height: 300px; ">
            <v-container fluid>
                <router-view />
            </v-container>
        </v-main>
    </v-app>
</template>

<script>
import MainHeader from "@/components/layout/MainHeader";
import MainNavigation from "@/components/layout/MainNavigation";

export default {
    name: "App",
    components: { MainNavigation, MainHeader }
};
</script>
