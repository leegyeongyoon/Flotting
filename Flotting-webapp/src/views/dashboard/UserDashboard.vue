<script>
import UserWeekendList from "@/views/dashboard/list/UserWeekendList.vue";
import UserCurrentList from "@/views/dashboard/list/UserCurrentList.vue";

export default {
    name: "UserDashboard",
    components: {
        UserWeekendList,
        UserCurrentList
    },
    data() {
        return {
            tab: null
        };
    }
};
</script>

<template>
    <v-main class="fill-height w-100">
        <v-tabs v-model="tab" class="bg-grey-lighten-5" align-tabs="center" grow>
            <v-tab value="one">이번주 프로필</v-tab>
            <v-tab value="two">플러팅 현황</v-tab>
            <v-tab value="three">
                매니저 전담 소개
            </v-tab>
        </v-tabs>
        <v-main class="pa-0 fill-height">
            <v-window class="fill-height" v-model="tab">
                <v-window-item class="fill-height" value="one">
                    <user-weekend-list />
                </v-window-item>

                <v-window-item class="h-100" value="two">
                    <user-current-list />
                </v-window-item>

                <v-window-item class="h-100" value="three">
                    Three
                </v-window-item>
            </v-window>
        </v-main>
    </v-main>
</template>

<style scoped></style>
