<template>
    <BarChart :title="'매칭 성공 횟수'" :parent-chart-data="chartData" :parent-chart-options="chartOptions" />
</template>

<script>
import BarChart from "@/components/chart/BarChart";
export default {
    name: "MatchingChart",
    components: { BarChart },
    data() {
        return {
            chartData: {
                labels: ["11월 1주차", "11월 2주차", "11월 3주차", "11월 4주차", "12월 1주차", "12월 2주차"],
                datasets: [
                    {
                        data: [10, 3, 5, 2, 8, 1, 5, 2, 3],
                        label: "매칭 상품",
                        backgroundColor: "#3e95cd"
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
