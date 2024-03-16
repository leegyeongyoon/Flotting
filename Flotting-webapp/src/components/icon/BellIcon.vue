<script setup>
defineProps({
    width: {
        type: [Number, String],
        default: 32
    },
    height: {
        type: [Number, String],
        default: 34
    },
    color: {
        type: String,
        default: "#ffffff"
    }
});
</script>

<template>
    <svg :width="width" :height="height" viewBox="0 0 32 34" fill="none" xmlns="http://www.w3.org/2000/svg" style="display: block">
        <path
            d="M11.8271 28.3994C12.0271 29.7194 13.8138 30.7507 16.0005 30.7507C18.1872 30.7507 19.9738 29.7194 20.1738 28.3994"
            :fill="color"
            vector-effect="non-scaling-stroke"
        />
        <path
            d="M23.6138 20.0032V15.4542C23.6138 11.3038 20.6672 7.57941 16.6805 7.22209C12.1738 6.80979 8.37381 10.4792 8.37381 15.0419V20.0032C8.37381 20.0032 8.36048 20.0719 8.33381 20.0719C6.62715 20.7316 5.38715 22.3945 5.33381 24.3735C5.29381 26.1464 6.74716 27.5894 8.46716 27.5894H23.5205C25.2405 27.5894 26.7071 26.1464 26.6538 24.3735C26.5871 22.3945 25.3605 20.7316 23.6538 20.0719C23.6271 20.0719 23.6138 20.0444 23.6138 20.0032Z"
            :fill="color"
            vector-effect="non-scaling-stroke"
        />
        <path
            d="M13.7334 6.38343V4.85794C13.7334 3.97838 14.7601 3.25 16.0001 3.25C16.6267 3.25 17.1868 3.42866 17.6001 3.71727C18.0268 4.00587 18.2668 4.40442 18.2668 4.8442V6.38343"
            :fill="color"
            vector-effect="non-scaling-stroke"
        />
    </svg>
</template>

<style scoped></style>
