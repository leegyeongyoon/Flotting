<template>
    <v-app class="app mx-auto">
        <router-view />
    </v-app>
</template>

<script>
export default {
    name: "App"
};
</script>
<style scoped>
.app {
    max-width: 1000px;
    max-height: 1500px;
}
</style>
