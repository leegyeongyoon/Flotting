<template>
    <v-app-bar app :elevation="2" class="blue-grey-darken-4">
        <v-app-bar-nav-icon @click.stop="toggleDrawer"></v-app-bar-nav-icon>

        <v-app-bar-title>
            Flotting 관리자 웹
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
</template>

<script>
export default {
    name: "MainHeader",
    props: {
        toggleDrawer: {
            type: Function,
            required: true
        }
    }
};
</script>

<style scoped></style>
