<script setup>
import router from "@/router";

// setTimeout(() => {
//     router.replace("/dashboard");
// }, 2000);

const onClickStart = () => {
    router.push("/signup/guide");
};
</script>

<template>
    <div class="w-100 h-100">
        <div
            class="mx-auto h-100 d-flex flex-column justify-space-between"
            style="max-width: 390px; min-width: 360px; background-color: #60E0E0; padding-top: 150px; padding-bottom: 80px;"
        >
            <div class="w-100 d-flex justify-center flex-column" style="gap: 27px;">
                <span class="font-weight-bold text-center text-white" style="font-size: 50px; letter-spacing: 0;">Plotting</span>
                <span class="font-weight-bold text-center text-white" style="font-size: 20px; letter-spacing: 0;"
                    >둘 사이에 새로운 줄거리를 만들다</span
                >
            </div>
            <div class="w-100 d-flex justify-center">
                <v-btn
                    style="width: 200px; height: 60px; box-shadow: 0px 4px 4px 0px #00000040; border-radius: 16px; font-weight: 700; font-size: 24px; letter-spacing: 0; color: #60E0E0;"
                    @click="onClickStart"
                    >START</v-btn
                >
            </div>
        </div>
    </div>
</template>

<style scoped></style>
