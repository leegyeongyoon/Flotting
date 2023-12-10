<template>
    <PieChart :title="'회원수'" :parent-chart-data="chartData" :parent-chart-options="chartOptions" />
</template>

<script>
import PieChart from "@/components/chart/PieChart";
export default {
    name: "UserTypeChart",
    components: { PieChart },
    data() {
        return {
            chartData: {
                labels: ["프립", "소모임", "지인", "기타"],
                datasets: [
                    {
                        backgroundColor: ["#3e95cd", "#E46651", "#e2d7f6", "#DD1B16"],
                        data: [40, 20, 80, 10]
                    }
                ]
            },
            chartOptions: {
                responsive: true,
                maintainAspectRatio: false,
                plugins: {
                    legend: {
                        position: "bottom"
                    }
                }
            }
        };
    }
};
</script>

<style scoped></style>
