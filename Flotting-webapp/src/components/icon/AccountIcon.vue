<script setup>
defineProps({
    width: {
        type: [Number, String],
        default: 24
    },
    height: {
        type: [Number, String],
        default: 24
    },
    color: {
        type: String,
        default: "#ffffff"
    }
});
</script>

<template>
    <svg :width="width" :height="height" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" style="display: block">
        <title>account</title>
        <path
            d="M12,4A4,4 0 0,1 16,8A4,4 0 0,1 12,12A4,4 0 0,1 8,8A4,4 0 0,1 12,4M12,14C16.42,14 20,15.79 20,18V20H4V18C4,15.79 7.58,14 12,14Z"
            :fill="color"
        />
    </svg>
</template>

<style scoped></style>
