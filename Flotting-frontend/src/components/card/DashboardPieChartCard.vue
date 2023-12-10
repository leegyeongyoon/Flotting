<template>
    <v-card class="h-100">
        <v-card-item class="bg-blue-grey-lighten-5">
            <v-card-title class="">{{ title }}</v-card-title>
        </v-card-item>
        <div class="align-center  h-100">
            <v-card-text style="height: 90%">
                <slot></slot>
            </v-card-text>
        </div>
    </v-card>
</template>
<script>
export default {
    name: "DashboardPieChartCard",
    props: {
        title: {
            type: String,
            required: true
        }
    }
};
</script>
<style></style>
