<template>
    <BarChart :title="'상품 분류(매칭,헬프)별 판매 개수'" :parent-chart-data="chartData" :parent-chart-options="chartOptions" />
</template>

<script>
import BarChart from "@/components/chart/BarChart";
export default {
    name: "SalesTypeChart",
    components: { BarChart },
    data() {
        return {
            chartData: {
                labels: ["11월 1주차", "11월 2주차", "11월 3주차", "11월 4주차", "12월 1주차", "12월 2주차"],
                datasets: [
                    {
                        data: [5, 7, 10, 3, 15, 3, 8, 5, 1],
                        label: "매칭 상품",
                        backgroundColor: "#3e95cd"
                    },
                    {
                        data: [1, 0, 3, 1, 0, 0, 2, 1, 2],
                        label: "헬프 상품",
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
