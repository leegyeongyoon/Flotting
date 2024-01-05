<template>
    <div>
        <admin-to-do-list />
        <admin-notice />
        <v-row>
            <v-col cols="12" md="6" sm="6" order="3">
                <sales-chart />
            </v-col>

            <!-- 👉 Tabs chart -->
            <v-col cols="12" md="6" sm="6" order="3">
                <sales-type-chart />
            </v-col>
        </v-row>

        <v-row>
            <v-col cols="12" sm="6" md="6" order="1" order-md="1">
                <v-row>
                    <!-- 👉 Payments -->
                    <v-col cols="12" sm="12">
                        <user-chart />
                    </v-col>
                </v-row>

                <v-row>
                    <!-- 👉 Profit Report -->
                    <v-col cols="12" sm="12">
                        <female-response-chart />
                    </v-col>
                </v-row>
            </v-col>
            <v-col cols="12" md="6" order="6" order-md="2">
                <user-type-chart />
            </v-col>
        </v-row>

        <v-row>
            <v-col cols="12" md="4" sm="6" order="3">
                <user-ratio-chart />
            </v-col>

            <!-- 👉 Tabs chart -->
            <v-col cols="12" md="4" sm="6" order="3">
                <matching-chart />
            </v-col>

            <!-- 👉 Transactions -->
            <v-col cols="12" md="4" sm="6" order="3">
                <in-active-user-chart />
            </v-col>
        </v-row>
    </div>
</template>

<script>
import SalesChart from "@/views/dashboard/chart/SalesChart";
import SalesTypeChart from "@/views/dashboard/chart/SalesTypeChart";
import UserChart from "@/views/dashboard/chart/UserChart";
import FemaleResponseChart from "@/views/dashboard/chart/FemaleResponseChart";
import UserTypeChart from "@/views/dashboard/chart/UserTypeChart";
import UserRatioChart from "@/views/dashboard/chart/UserRatioChart";
import MatchingChart from "@/views/dashboard/chart/MatchingChart";
import InActiveUserChart from "@/views/dashboard/chart/InactiveUserChart";
import AdminToDoList from "@/views/dashboard/list/AdminToDoList";
import AdminNotice from "@/views/dashboard/list/AdminNotice";
export default {
    name: "AdminDashboard",
    components: {
        AdminNotice,
        AdminToDoList,
        InActiveUserChart,
        MatchingChart,
        UserRatioChart,
        UserTypeChart,
        FemaleResponseChart,
        UserChart,
        SalesTypeChart,
        SalesChart
    }
};
</script>

<style scoped></style>
