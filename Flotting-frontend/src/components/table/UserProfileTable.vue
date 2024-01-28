<script setup>
import { useStore } from "vuex";
import UserProfileTableTextareaTd from "@/components/table/UserProfileTableTextareaTd.vue";

const store = useStore();

const props = defineProps({
    isEdit: {
        type: Boolean,
        default: false
    }
});

const info = store.getters.getProfile;
const keys = store.getters.getProfileKeys;
</script>

<template>
    <v-table density="compact">
        <thead>
            <tr>
                <th class="text-left w-25">
                    속성
                </th>
                <th class="text-left w-75">
                    정보
                </th>
            </tr>
        </thead>
        <tbody class="td-py-2">
            <user-profile-table-textarea-td v-for="key in keys" :key="key" :title="key" :content="info[key]" :is-edit="isEdit" />
        </tbody>
    </v-table>
</template>

<style scoped></style>
