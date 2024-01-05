<template>
    <LineChart :title="'플러팅 회원수'" :parent-chart-data="chartData" :parent-chart-options="chartOptions" />
</template>

<script>
import LineChart from "@/components/chart/LineChart";
export default {
    name: "UserChart",
    components: { LineChart },
    data() {
        return {
            chartData: {
                labels: ["11월 1주차", "11월 2주차", "11월 3주차", "11월 4주차", "12월 1주차", "12월 2주차"],
                datasets: [
                    {
                        data: [210, 232, 242, 279, 300, 313, 329, 340, 370],
                        label: "총회원",
                        borderColor: "#3e95cd"
                    },
                    {
                        data: [210, 220, 230, 250, 278, 299, 310, 322, 350],
                        label: "활성인원",
                        borderColor: "#ff0000"
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
