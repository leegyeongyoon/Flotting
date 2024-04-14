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
    <svg :width="width" :height="height" viewBox="0 0 37 90" fill="none" xmlns="http://www.w3.org/2000/svg" style="display: block">
        <line
            y1="-1.5"
            x2="53.4188"
            y2="-1.5"
            transform="matrix(0.604009 -0.802641 0.446023 0.890976 2.44531 90)"
            :stroke="color"
            stroke-width="3"
            vector-effect="non-scaling-stroke"
        />
        <line
            y1="-1.5"
            x2="55.9495"
            y2="-1.5"
            transform="matrix(0.605958 0.789892 -0.438253 0.903043 0.807617 2.92969)"
            :stroke="color"
            stroke-width="3"
            vector-effect="non-scaling-stroke"
        />
    </svg>
</template>

<style scoped></style>
