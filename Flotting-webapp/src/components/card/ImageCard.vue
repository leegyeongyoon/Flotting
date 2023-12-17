<script>
export default {
    name: "ImageCard",

    props: {
        src: {
            type: String,
            required: true
        },
        title: {
            type: String,
            required: false
        },
        subTitle: {
            type: String,
            required: false
        }
    }
};
</script>

<template>
    <v-card min-width="100%">
        <v-img v-bind:src="src" aspect-ratio="1" class="align-end" cover>
            <v-card-title class="text-white" v-show="!!title">{{ title }}</v-card-title>
            <v-card-subtitle class="text-white pb-2" v-show="!!subTitle">{{ subTitle }}</v-card-subtitle>
        </v-img>
    </v-card>
</template>

<style scoped></style>
