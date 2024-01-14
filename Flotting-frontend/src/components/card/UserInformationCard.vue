<script setup>
import { ref } from "vue";
const test = ref("1234");

defineProps({
    isEdit: {
        type: Boolean,
        default: false
    }
});
</script>

<template>
    <v-card class="text-center text-sm-start w-100" fluid>
        <v-card-item>
            <v-row>
                <v-col class="d-flex align-center">
                    <v-cardTitle class="text-md-h6 "> (사용자 이름) </v-cardTitle>
                </v-col>
                <v-col v-if="isEdit" class="d-flex justify-end">
                    <v-btn size="small" class="ma-1" color="green">저장</v-btn>
                    <v-btn size="small" class="ma-1" color="red">정지</v-btn>
                </v-col>
            </v-row>
        </v-card-item>
        <v-container class="pt-0" fluid>
            <v-table density="compact">
                <thead>
                    <tr>
                        <th class="text-left w-25">
                            속성
                        </th>
                        <th class="text-left w-75">
                            정보
                        </th>
                    </tr>
                </thead>
                <tbody class="td-py-2">
                    <tr>
                        <td>평생이용권여부</td>
                        <td>-</td>
                    </tr>
                    <tr>
                        <td class="py-2">평생이용권여부</td>
                        <td>
                            글이 긴거 테스트해보자.글이 긴거 테스트해보자.글이 긴거 테스트해보자.글이 긴거 테스트해보자.글이 긴거 테스트해보자.글이
                            긴거 테스트해보자.글이 긴거 테스트해보자.글이 긴거 테스트해보자.글이 긴거 테스트해보자.글이 긴거 테스트해보자.
                        </td>
                    </tr>
                    <tr>
                        <td>평생이용권여부</td>
                        <td>
                            <v-text-field v-model="test" class="py-2" density="compact" variant="solo" hide-details></v-text-field>
                        </td>
                    </tr>
                    <tr>
                        <td>평생이용권여부</td>
                        <td>
                            <v-textarea v-model="test" rows="1" auto-grow class="py-2" variant="solo" hide-details></v-textarea>
                        </td>
                    </tr>
                </tbody>
            </v-table>
        </v-container>
    </v-card>
</template>

<style scoped></style>
