<script setup>
import { ref } from "vue";
import ProfileImage from "@/components/image/ProfileImage.vue";

defineProps({
    to: {
        type: String,
        default: "#"
    },
    info: {
        type: Object,
        default: null
    }
});

const testManagerImageUrl = ref("https://image.kr.canon/pds/gallery/open/1257249062209_0d8F3Kb90P.jpg");
const testUserImageUrl = ref(
    "https://i.namu.wiki/i/RmPNdn0sjKx-SYRoeRffcS5pc1rZXK-uA6PQqqU_kLFrqdMVdD3vM9HeF4c_1DLloZ1qu8KZLDwRwO8y-3vNriadzKfcXOeWaQFwwLC2Bn_HxoX1E-clw78tDqSLGLb37UHelCwkxGLeqKIpHvqPtA.webp"
);
</script>

<template>
    <v-card width="100%" style="box-shadow: 4px 4px 10px 0px #60E0E0; border-radius: 16px;" :to="to">
        <div class="w-100 pa-4 d-flex flex-column ga-4 justify-center align-center">
            <v-card style="border-radius: 16px; width: 98px;">
                <div
                    class="w-100 d-flex flex-column justify-end align-start pl-6 pb-3"
                    style="aspect-ratio: 1; background-color: #F1F1F1; background-size: cover;  background-position: 50%; background-image: url('https://image.kr.canon/pds/gallery/open/1257249062209_0d8F3Kb90P.jpg')"
                ></div>
            </v-card>
            <div class="text-center w-100" style="height: 63px; background: #F1F1F1; border-radius: 16px;"></div>
            <div
                class="w-100 d-flex flex-column justify-end align-start pl-6 pb-3 font-weight-bold"
                style="border-radius: 16px; aspect-ratio: 1; background-color: #F1F1F1; background-size: cover;  background-position: 50%; background-image: url('https://i.namu.wiki/i/RmPNdn0sjKx-SYRoeRffcS5pc1rZXK-uA6PQqqU_kLFrqdMVdD3vM9HeF4c_1DLloZ1qu8KZLDwRwO8y-3vNriadzKfcXOeWaQFwwLC2Bn_HxoX1E-clw78tDqSLGLb37UHelCwkxGLeqKIpHvqPtA.webp'); font-size: 18px; text-shadow: -1px 0px white, 0px 1px white, 1px 0px white, 0px -1px white; "
            >
                <span>원빈</span>
                <span>가수, 서울 강남구</span>
            </div>
        </div>
    </v-card>
</template>

<style scoped></style>
