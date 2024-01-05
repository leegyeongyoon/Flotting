<template>
    <dashboard-card :title="title">
        <Line :data="parentChartData" :options="parentChartOptions" />
    </dashboard-card>
</template>

<script>
import { Chart as ChartJS, CategoryScale, LinearScale, PointElement, LineElement, Title, Tooltip, Legend, Filler } from "chart.js";
import { Line } from "vue-chartjs";
import DashboardCard from "@/components/card/DashboarCard";

ChartJS.register(CategoryScale, LinearScale, PointElement, LineElement, Title, Tooltip, Legend, Filler);
export default {
    name: "LineChart",
    components: {
        DashboardCard,
        Line
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
