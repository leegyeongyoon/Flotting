<script setup>
import { signupInfoStore } from "@/store/signup/signupInfoStore";

const info = signupInfoStore();
</script>

<template>
    {{ info.height }}
</template>

<style scoped></style>
