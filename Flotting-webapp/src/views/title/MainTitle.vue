<script setup>
import router from "@/router";

setTimeout(() => {
    router.replace("/dashboard");
}, 2000);
</script>

<template>
    <div class="w-100 h-100 d-flex align-center justify-center" style="background-color: #60E0E0;">
        <span class="font-weight-bold text-center text-white" style="font-size: 50px; letter-spacing: 0;">Plotting</span>
    </div>
</template>

<style scoped></style>
