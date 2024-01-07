<script>
import SearchParameterCard from "@/views/mng/user/card/SearchParameterCard.vue";
import UserList from "@/views/mng/user/list/UserList.vue";

export default {
    name: "MngUser",
    components: { UserList, SearchParameterCard },
    data: () => ({
        breadcrumbs: [
            {
                title: "기존 고객"
            },
            {
                title: "고객 정보 검색",
                disabled: false,
                href: "user"
            }
        ],
        loading: false,
        list: [
            { submitDate: "2024년 1월 1일 오후 1:12", name: "강남1", address: "서울시 강남구1" },
            { submitDate: "2024년 1월 1일 오후 1:13", name: "강남2", address: "서울시 강남구2" },
            { submitDate: "2024년 1월 1일 오후 1:14", name: "강남3", address: "서울시 강남구3" }
        ]
    }),
    methods: {
        search(param) {
            console.log("1");
            console.log(param);
            this.loading = true;
            setTimeout(() => {
                this.loading = false;
            }, 2000);
        }
    }
};
</script>

<template>
    <div>
        <v-breadcrumbs :items="breadcrumbs">
            <template v-slot:title="{ item }">
                {{ item.title.toUpperCase() }}
            </template>
        </v-breadcrumbs>
        <v-row>
            <v-col cols="12" sm="12" order="2" order-sm="1">
                <search-parameter-card @search="search" />
            </v-col>
        </v-row>
        <v-row>
            <v-col cols="12" sm="12" order="2" order-sm="1">
                <user-list :loading="loading" :list="list" />
            </v-col>
        </v-row>
    </div>
</template>

<style scoped></style>
