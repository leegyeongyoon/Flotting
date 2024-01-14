<script setup></script>

<template>
    <v-card class="text-center text-sm-start w-100" fluid>
        <v-card-item>
            <v-row>
                <v-col class="d-flex align-center">
                    <v-cardTitle class="text-md-h6 ">
                        결제 이력
                    </v-cardTitle>
                </v-col>
            </v-row>
        </v-card-item>
        <v-container class="pt-0" fluid>
            <v-table density="compact">
                <thead>
                    <tr>
                        <th class="text-center w-20">
                            상품분류
                        </th>
                        <th class="text-center w-30">
                            상품명
                        </th>
                        <th class="text-center w-10">
                            개수
                        </th>
                        <th class="text-center w-40">
                            금액
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td rowspan="3" class="text-center">매칭상품</td>
                        <td class="text-center">매칭</td>
                        <td class="text-center">1</td>
                        <td class="text-right">10,000</td>
                    </tr>
                    <tr>
                        <td class="text-center">플러팅 부스터</td>
                        <td class="text-center">2</td>
                        <td class="text-right">20,000</td>
                    </tr>
                    <tr>
                        <td class="text-center">매니저 전담 소개</td>
                        <td class="text-center">3</td>
                        <td class="text-right">30,000</td>
                    </tr>
                    <tr>
                        <td rowspan="4" class="text-center">헬프상품</td>
                        <td class="text-center">의류PDF</td>
                        <td class="text-center">1</td>
                        <td class="text-right">10,000</td>
                    </tr>
                    <tr>
                        <td class="text-center">사진PDF + 보정</td>
                        <td class="text-center">2</td>
                        <td class="text-right">20,000</td>
                    </tr>
                    <tr>
                        <td class="text-center">인생샷 패키지</td>
                        <td class="text-center">3</td>
                        <td class="text-right">30,000</td>
                    </tr>
                    <tr>
                        <td class="text-center">의류동행 패키지</td>
                        <td class="text-center">4</td>
                        <td class="text-right">40,000</td>
                    </tr>
                    <tr>
                        <td colspan="2" class="text-center">총계</td>
                        <td class="text-center">10</td>
                        <td class="text-right">1,000,000</td>
                    </tr>
                </tbody>
            </v-table>
        </v-container>
    </v-card>
</template>

<style scoped></style>
