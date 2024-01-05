<template>
    <LineChart :title="'여자(Y) 응답비율'" :parent-chart-data="chartData" :parent-chart-options="chartOptions" />
</template>

<script>
import LineChart from "@/components/chart/LineChart";
export default {
    name: "FemaleResponseChart",
    components: { LineChart },
    data() {
        return {
            chartData: {
                labels: ["11월 1주차", "11월 2주차", "11월 3주차", "11월 4주차", "12월 1주차", "12월 2주차"],
                datasets: [
                    {
                        data: [0.5, 0.35, 0.6, 0.2, 0.56, 0.75, 0.24, 0.3, 0.4],
                        label: "응답비율",
                        borderColor: "#3e95cd"
                    }
                ]
            },

            chartOptions: {
                plugins: {
                    legend: {
                        position: "right"
                    }
                },
                responsive: true,
                maintainAspectRatio: false
            }
        };
    }
};
</script>

<style scoped></style>
