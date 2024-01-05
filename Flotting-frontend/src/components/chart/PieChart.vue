<template>
    <dashboard-pie-chart-card :title="'t1'" class="h-100">
        <Pie :data="parentChartData" :options="parentChartOptions" />
    </dashboard-pie-chart-card>
</template>
<script>
import { Chart as ChartJS, ArcElement, Tooltip, Legend, CategoryScale, LinearScale, Title } from "chart.js";
import { Pie } from "vue-chartjs";
import DashboardPieChartCard from "@/components/card/DashboarCard";

ChartJS.register(CategoryScale, ArcElement, LinearScale, Title, Tooltip, Legend);
export default {
    name: "PieChart",
    components: {
        DashboardPieChartCard,
        Pie
    },
    props: {
        parentChartData: {
            type: Object,
            required: true
        },
        parentChartOptions: {
            type: Object,
            required: true
        }
    }
};
</script>
<style></style>
