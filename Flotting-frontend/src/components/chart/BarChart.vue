<template>
    <dashboard-card :title="title">
        <Bar :data="parentChartData" :options="parentChartOptions" />
    </dashboard-card>
</template>

<script>
import { Chart as ChartJS, Title, Tooltip, Legend, BarElement, CategoryScale, LinearScale } from "chart.js";
import { Bar } from "vue-chartjs";
import DashboardCard from "@/components/card/DashboarCard";

ChartJS.register(CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend);

export default {
    name: "BarChart",
    components: {
        DashboardCard,
        Bar
    },
    props: {
        parentChartData: {
            type: Object,
            required: true
        },
        parentChartOptions: {
            type: Object,
            required: true
        },
        title: {
            type: String,
            required: true
        }
    }
};
</script>
<style></style>
