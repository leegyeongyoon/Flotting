<script setup>
import { ref, watch } from "vue";
import { useStore } from "vuex";

const store = useStore();

const props = defineProps({
    isEdit: {
        type: Boolean,
        default: false
    },
    title: {
        type: String,
        default: ""
    },
    indexKey: {
        type: String,
        default: ""
    }
});

const text = ref(store.getters.getProfile(props.indexKey));

watch(text, newVal => {
    store.commit("setProfileByKey", { key: props.indexKey, value: newVal });
});
</script>

<template>
    <tr>
        <td>{{ title }}</td>
        <td v-if="isEdit">
            <v-textarea v-model="text" rows="1" auto-grow class="py-2" density="compact" variant="solo" hide-details></v-textarea>
        </td>
        <td v-else>
            {{ text }}
        </td>
    </tr>
</template>

<style scoped></style>
