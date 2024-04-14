<script setup>
defineProps({
    src: {
        type: String,
        default: null
    },
    title: {
        type: String,
        default: null
    },
    subTitle: {
        type: String,
        default: null
    },
    isRadius: {
        type: Boolean,
        default: false
    }
});
</script>

<template>
    <div
        class="w-100 d-flex flex-column justify-end align-start pl-6 pb-3"
        :class="isRadius && 'rounded-16'"
        style="aspect-ratio: 1; background: #F1F1F1; background-size: cover; background-position: 50%;"
        :style="!!src && `background-image: url(${src});`"
    >
        <span
            v-show="!!title"
            class="font-weight-bold"
            style="font-size: 20px; text-shadow: -1px 0px white, 0px 1px white, 1px 0px white, 0px -1px white; "
            >{{ title }}</span
        >
        <span
            v-show="!!subTitle"
            class="font-weight-bold"
            style="font-size: 20px; text-shadow: -1px 0px white, 0px 1px white, 1px 0px white, 0px -1px white; "
            >{{ subTitle }}</span
        >
    </div>
</template>

<style scoped>
.rounded-16 {
    border-radius: 16px;
}
</style>
