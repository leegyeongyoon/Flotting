<template>
    <v-app>
        <v-app-bar app :elevation="0">
            <v-app-bar-nav-icon @click.stop="toggleDrawer"></v-app-bar-nav-icon>

            <v-app-bar-title>
                application-bar
            </v-app-bar-title>

            <template v-slot:append>
                <v-btn icon>
                    <v-icon>mdi-heart</v-icon>
                </v-btn>

                <v-btn icon>
                    <v-icon>mdi-magnify</v-icon>
                </v-btn>

                <v-btn icon>
                    <v-icon>mdi-dots-vertical</v-icon>
                </v-btn>
            </template>
        </v-app-bar>

        <v-navigation-drawer v-if="drawer">
            <v-list>
                <v-list-item title="Navigation drawer"></v-list-item>
            </v-list>
        </v-navigation-drawer>

        <v-main class="bg-grey-lighten-5 d-flex align-center justify-center" style="min-height: 300px;">
            <router-view />
            Main Content
        </v-main>
    </v-app>
</template>

<script>
export default {
    name: "App",

    data: () => ({
        drawer: false
    }),

    methods: {
        toggleDrawer() {
            this.drawer = !this.drawer;
        }
    }
};
</script>
