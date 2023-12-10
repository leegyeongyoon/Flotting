<template>
    <BarChart :title="'총 휴먼 전환'" :parent-chart-data="chartData" :parent-chart-options="chartOptions" />
</template>

<script>
import BarChart from "@/components/chart/BarChart";
export default {
    name: "InActiveUserChart",
    components: { BarChart },
    data() {
        return {
            chartData: {
                labels: ["11월 1주차", "11월 2주차", "11월 3주차", "11월 4주차", "12월 1주차", "12월 2주차"],
                datasets: [
                    {
                        data: [3, 5, 4, 3, 5, 1, 5, 3, 2],
                        label: "여자 이탈수",
                        backgroundColor: "#3e95cd",
                        fill: true
                    },
                    {
                        data: [2, 3, 1, 4, 6, 2, 4, 5, 9],
                        label: "남자 이탈수",
                        backgroundColor: "#ff0000"
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
