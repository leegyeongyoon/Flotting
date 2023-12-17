<script>
import ImageCard from "@/components/card/ImageCard.vue";

export default {
    name: "UserCurrentLayout",
    components: { ImageCard },
    props: {
        title: {
            type: String,
            required: true
        },
        list: {
            type: Array,
            required: true
        },
        setList: {
            type: Function,
            required: true
        }
    }
};
</script>

<template>
    <div class="d-flex flex-column">
        <div class="d-flex justify-space-between align-center">
            <span>{{ title }}</span>
            <v-btn variant="text" @click="setList">더보기</v-btn>
        </div>
        <v-row>
            <v-col cols="6" v-for="(info, i) in list" :key="i">
                <image-card :src="info.src" />
            </v-col>
        </v-row>
    </div>
</template>

<style scoped></style>
