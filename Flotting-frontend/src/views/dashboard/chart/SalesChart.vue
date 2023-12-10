<template>
    <LineChart :title="'플러팅 주차별 상품판매 매출'" :parent-chart-data="chartData" :parent-chart-options="chartOptions" />
</template>

<script>
import LineChart from "@/components/chart/LineChart";
export default {
    name: "SalesChart",
    components: { LineChart },
    data() {
        return {
            chartData: {
                labels: ["11월 1주차", "11월 2주차", "11월 3주차", "11월 4주차", "12월 1주차", "12월 2주차"],
                datasets: [
                    {
                        data: [300000, 250000, 400000, 100000, 450000, 700000, 200000, 341000, 400100],
                        label: "매출액(원)",
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
