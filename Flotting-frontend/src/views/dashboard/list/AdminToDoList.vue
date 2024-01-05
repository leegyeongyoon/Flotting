<template>
    <v-row>
        <v-col>
            <v-card title="신규 가입" prepend-icon="mdi-account">
                <template v-slot:append>
                    <v-avatar size="24">
                        <a href="#" link>5</a>
                    </v-avatar>
                </template>
                <v-divider></v-divider>
                <v-card-text> 1차 등록 고객 : <a href="#" link>2</a></v-card-text>
                <v-divider></v-divider>
                <v-card-text> 2차 등록 고객 : <a href="#" link>3</a></v-card-text>
            </v-card>
        </v-col>

        <v-col>
            <v-card title="프로필 변경" prepend-icon="mdi-account">
                <template v-slot:append>
                    <v-avatar size="24">
                        <a href="#" link>2</a>
                    </v-avatar>
                </template>
                <v-divider></v-divider>
                <v-card-text> 프로필 변경 : <a href="#" link>2</a></v-card-text>
            </v-card>
        </v-col>

        <v-col>
            <v-card title="고객 CS" prepend-icon="mdi-account">
                <template v-slot:append>
                    <v-avatar size="24">
                        <a href="#" link>5</a>
                    </v-avatar>
                </template>
                <v-divider></v-divider>
                <v-card-text> 문의 대기 : <a href="#" link>2</a></v-card-text>
                <v-divider></v-divider>
                <v-card-text> 문의 중 : <a href="#" link>3</a></v-card-text>
            </v-card>
        </v-col>

        <v-col>
            <v-card title="매니저 전담 소개" prepend-icon="mdi-account">
                <template v-slot:append>
                    <v-avatar size="24">
                        <a href="#" link>1</a>
                    </v-avatar>
                </template>
                <v-divider></v-divider>
                <v-card-text> 소개 요청 : <a href="#" link>1</a></v-card-text>
            </v-card>
        </v-col>
    </v-row>
</template>

<script>
export default {
    name: "AdminToDoList"
};
</script>

<style scoped></style>
