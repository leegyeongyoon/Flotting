<script>
export default {
    name: "UserWeekendList",
    components: {}
};
</script>

<template>
    <v-carousel class="pa-3 h-100 " hide-delimiters>
        <template v-slot:prev="{ props }">
            <v-icon color="#eeeeee" @click="props.onClick">mdi-48px mdi-chevron-left</v-icon>
        </template>
        <template v-slot:next="{ props }">
            <v-icon color="#eeeeee" @click="props.onClick">mdi-48px mdi-chevron-right</v-icon>
        </template>
        <v-carousel-item cover>
            <v-container class="pa-3 h-100  rounded-lg">
                <v-row class="h-100">
                    <v-col>
                        <v-card class="pa-5 pb-10 rounded-lg h-100">
                            <v-list-item prepend-avatar="https://cdn.vuetifyjs.com/images/lists/2.jpg">
                                <template v-slot:title> xxx매니저</template>

                                <template v-slot:subtitle>
                                    <span class="font-weight-bold">사람이 좋네요</span>
                                </template>
                            </v-list-item>
                            <v-divider class="py-5" />
                            <v-img src="../../../assets/img/face.png" class="h-auto rounded-lg " cover></v-img>

                            <v-card-title>
                                김길동
                            </v-card-title>

                            <v-card-subtitle>
                                나이 : 22세
                            </v-card-subtitle>
                            <v-card-subtitle>
                                거주지 : 서울
                            </v-card-subtitle>

                            <v-card-actions>
                                <v-btn color="orange-lighten-2" variant="text">
                                    더보기
                                </v-btn>
                            </v-card-actions>
                        </v-card>
                    </v-col>
                </v-row>
            </v-container>
        </v-carousel-item>
    </v-carousel>
</template>

<style scoped></style>
