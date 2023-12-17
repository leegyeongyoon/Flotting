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
    <div>
        <v-tabs v-model="tab" align-tabs="center" grow>
            <v-tab value="one">이번주 프로필</v-tab>
            <v-tab value="two">플러팅 현황</v-tab>
            <v-tab value="three">
                매니저 전담 소개
            </v-tab>
        </v-tabs>
        <v-window v-model="tab">
            <v-window-item value="one">
                <user-weekend-list />
            </v-window-item>

            <v-window-item value="two">
                <user-current-list />
            </v-window-item>

            <v-window-item value="three">
                Three
            </v-window-item>
        </v-window>
    </div>
</template>

<style scoped></style>
