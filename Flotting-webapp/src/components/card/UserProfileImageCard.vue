<script setup>
import { ref } from "vue";
import ProfileImage from "@/components/image/ProfileImage.vue";

defineProps({
    href: {
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
    <v-card width="100%" style="box-shadow: 4px 4px 10px 0px #60E0E0; border-radius: 16px;" :href="href">
        <div class="w-100 pa-4 d-flex flex-column ga-4 justify-center align-center">
            <div style="width: 98px;">
                <profile-image src="https://image.kr.canon/pds/gallery/open/1257249062209_0d8F3Kb90P.jpg" is-radius />
            </div>

            <div class="text-center w-100" style="height: 63px; background: #F1F1F1; border-radius: 16px;"></div>
            <profile-image
                is-radius
                title="원빈"
                sub-title="가수, 서울 강남구"
                src="https://i.namu.wiki/i/RmPNdn0sjKx-SYRoeRffcS5pc1rZXK-uA6PQqqU_kLFrqdMVdD3vM9HeF4c_1DLloZ1qu8KZLDwRwO8y-3vNriadzKfcXOeWaQFwwLC2Bn_HxoX1E-clw78tDqSLGLb37UHelCwkxGLeqKIpHvqPtA.webp"
            />
        </div>
    </v-card>
</template>

<style scoped></style>
