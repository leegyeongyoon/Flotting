<script setup>
import { ref } from "vue";

const props = defineProps({
    index: {
        type: Number,
        default: -1
    },
    item: {
        type: Object,
        default: () => {}
    },
    val: {
        type: String,
        default: ""
    }
});

const text = ref(props.val);

function clickEditSaveBtn() {
    alert(`index : ${props.index} / edit value : ${text.value} / default value : ${props.val}`);
}
</script>

<template>
    <v-container fluid>
        <v-row>
            <v-col>
                <v-textarea v-model="text" rows="1" auto-grow class="py-2" variant="solo" hide-details></v-textarea>
            </v-col>
        </v-row>
        <v-row>
            <v-col class="pt-0 d-flex justify-end">
                <v-btn size="small" class="ma-1" color="green" :disabled="text === props.val" @click="clickEditSaveBtn()">저장</v-btn>
            </v-col>
        </v-row>
    </v-container>
</template>

<style scoped></style>
