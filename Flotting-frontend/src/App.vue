<template>
    <v-app>
        <main-header
            class="bg-blue-grey-lighten-5
"
            :toggle-drawer="toggleDrawer"
        />
        <main-navigation
            class="bg-blue-grey-lighten-5
"
            :drawer="drawer"
        />
        <v-main class="bg-grey-lighten-5  align-center justify-center" style="min-height: 300px; ">
            <v-container fluid>
                <router-view />
            </v-container>
        </v-main>
    </v-app>
</template>

<script>
import { ref } from "vue";
import MainHeader from "@/components/layout/MainHeader";
import MainNavigation from "@/components/layout/MainNavigation";

export default {
    name: "App",
    components: { MainNavigation, MainHeader },

    setup() {
        const drawer = ref(true);

        const toggleDrawer = () => {
            drawer.value = !drawer.value;
        };

        return {
            drawer,
            toggleDrawer
        };
    }
};
</script>
