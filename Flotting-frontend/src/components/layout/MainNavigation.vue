<template>
    <v-navigation-drawer :elevation="3" class="blue-grey-darken-2" v-if="drawer" v-model="selectedItem">
        <v-list>
            <v-list-item>
                <v-list-item-avatar> 아이콘</v-list-item-avatar>
            </v-list-item>
            <v-list-item link>
                <v-list-item-content>
                    <v-list-item-title class="text-h6">
                        Flooting
                    </v-list-item-title>
                    <v-list-item-subtitle>https://flotting.com/</v-list-item-subtitle>
                </v-list-item-content>
                <v-list-item-action>
                    <v-icon>mdi-menu-down</v-icon>
                </v-list-item-action>
            </v-list-item>
        </v-list>
        <v-divider></v-divider>
        <v-list>
            <v-list-item link key="1" :to="'/'" prepend-icon="mdi-view-dashboard" title="Dashboard"></v-list-item>
            <v-list-item link key="2" :to="'/account'" prepend-icon="mdi-account-box" title="Account"></v-list-item>
            <v-list-item prepend-icon="mdi-gavel" title="Test"></v-list-item>
        </v-list>

        <template v-slot:append>
            <div class="pa-2">
                <v-btn block>
                    Logout
                </v-btn>
            </div>
        </template>
    </v-navigation-drawer>
</template>

<script>
export default {
    name: "MainNavigation",
    props: {
        drawer: {
            type: Boolean,
            required: true
        }
    },
    data() {
        return {
            selectedItem: null
        };
    }
};
</script>

<style scoped></style>
