<template>
    <v-app-bar app :elevation="2" class="bg-teal-lighten-4 ">
        <template v-slot:prepend>
            <v-icon icon="mdi-bell-outline"></v-icon>
        </template>
        <template v-slot:append>
            <v-icon icon="mdi-cog-outline"></v-icon>
        </template>
    </v-app-bar>
</template>

<script>
export default {
    name: "MainHeader"
};
</script>

<style scoped></style>
