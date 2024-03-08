<script setup></script>

<template>
    <v-card class="text-center text-sm-start w-100" fluid>
        <v-card-item>
            <v-row>
                <v-col class="d-flex align-center">
                    <v-cardTitle class="text-md-h6 ">
                        요청 사항
                    </v-cardTitle>
                </v-col>
            </v-row>
        </v-card-item>
        <v-divider></v-divider>
        <v-container fluid>
            <v-row>
                <v-col>
                    <v-card variant="flat" fluid>
                        <v-cardTitle class="text-md-h6 ">취향</v-cardTitle>
                        <v-card variant="flat" fluid>
                            <v-card-item>
                                <div class="d-flex align-center w-100">
                                    <div class="w-25">직업</div>
                                    <div class="w-75">대기업</div>
                                </div>
                            </v-card-item>
                            <v-card-item>
                                <div class="d-flex align-center w-100">
                                    <div class="w-25">직업</div>
                                    <div class="w-75">대기업</div>
                                </div>
                            </v-card-item>
                        </v-card>
                    </v-card>
                </v-col>
                <v-col>
                    <v-card variant="flat" fluid>
                        <v-cardTitle class="text-md-h6 ">편지</v-cardTitle>
                        <v-card variant="flat">
                            <v-card-item>
                                <div>
                                    편지내용입니답편지내용입니답편지내용입니답편지내용입니답편지내용입니답편지내용입니답편지내용입니답
                                </div>
                            </v-card-item>
                        </v-card>
                    </v-card>
                </v-col>
            </v-row>
        </v-container>
    </v-card>
</template>

<style scoped></style>
