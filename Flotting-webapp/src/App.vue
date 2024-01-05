<template>
    <v-app max-width="430" class="mx-auto">
        <v-app-bar density="comfortable" color="#eeb0b0">
            <template v-slot:prepend>
                <v-icon icon="mdi-bell-outline"></v-icon>
            </template>
            <template v-slot:append>
                <v-icon icon="mdi-cog-outline"></v-icon>
            </template>
        </v-app-bar>
        <v-main>
            <router-view />
        </v-main>
        <v-bottom-navigation bg-color="#eeb0b0">
            <v-btn value="recent">
                <span>소개</span>
            </v-btn>
            <v-btn value="favorites">
                <span>매니저</span>
            </v-btn>
            <v-btn value="nearby">
                <span>프로필</span>
            </v-btn>
        </v-bottom-navigation>
    </v-app>
</template>

<script>
export default {
    name: "App"
};
</script>
