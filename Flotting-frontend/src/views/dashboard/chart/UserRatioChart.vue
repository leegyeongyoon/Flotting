<template>
    <LineChart :title="'여자 비율'" :parent-chart-data="chartData" :parent-chart-options="chartOptions" />
</template>

<script>
import LineChart from "@/components/chart/LineChart";
export default {
    name: "UserRatioChart",
    components: { LineChart },
    data() {
        return {
            chartData: {
                labels: ["11월 1주차", "11월 2주차", "11월 3주차", "11월 4주차", "12월 1주차", "12월 2주차"],
                datasets: [
                    {
                        data: [0.4, 0.45, 0.5, 0.39, 0.35, 0.41, 0.35, 0.45, 0.49],
                        label: "여자 비율",
                        borderColor: "#3e95cd",
                        backgroundColor: "#3e95cd",
                        fill: true
                    }
                ]
            },

            chartOptions: {
                plugins: {
                    legend: {
                        position: "right"
                    },
                    filler: {
                        propagate: true
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
