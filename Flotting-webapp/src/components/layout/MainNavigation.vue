<template>
    <v-bottom-navigation app grow class="bg-teal-lighten-4 rounded-10">
        <v-btn value="recent">
            <v-icon>mdi-24px mdi mdi-account-multiple</v-icon>
        </v-btn>

        <v-btn value="favorites">
            <v-icon>mdi-24px mdi-account-multiple-plus</v-icon>
            <span>매니저 추가 소개</span>
        </v-btn>

        <v-btn value="nearby">
            <v-icon>mdi-24px mdi-account-box</v-icon>
            <span class="text-10">프로필</span>
        </v-btn>
    </v-bottom-navigation>
</template>

<script>
export default {
    name: "MainNavigation"
};
</script>

<style scoped></style>
