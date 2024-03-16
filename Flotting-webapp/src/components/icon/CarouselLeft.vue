<script setup>
defineProps({
    width: {
        type: [Number, String],
        default: 36
    },
    height: {
        type: [Number, String],
        default: 90
    },
    color: {
        type: String,
        default: "#B6B6B6"
    }
});
</script>

<template>
    <svg :width="width" :height="height" viewBox="0 0 36 90" fill="none" xmlns="http://www.w3.org/2000/svg" style="display: block">
        <line
            y1="-1.5"
            x2="53.419"
            y2="-1.5"
            transform="matrix(-0.618939 0.785439 -0.429131 -0.903242 34.5635 -0.000976562)"
            :stroke="color"
            stroke-width="3"
            vector-effect="non-scaling-stroke"
        />
        <line
            y1="-1.5"
            x2="55.9501"
            y2="-1.5"
            transform="matrix(-0.590939 -0.806716 0.455099 -0.890441 34.5635 87.0918)"
            :stroke="color"
            stroke-width="3"
            vector-effect="non-scaling-stroke"
        />
    </svg>
</template>

<style scoped></style>
