<template>
    <v-card class="pa-12 pb-8 h-100" elevation="8" rounded="lg" style="background-color: #81D7D1">
        <v-card-title>
            <v-img class="mx-auto " src="../../assets/img/logo.png"></v-img>
        </v-card-title>
        <div class="text-subtitle-1 text-grey-lighten-5">Account</div>

        <v-text-field
            class="bg-grey-lighten-5"
            density="compact"
            placeholder="Email address"
            prepend-inner-icon="mdi-email-outline"
            variant="outlined"
            hide-details="auto"
        ></v-text-field>

        <div class="text-subtitle-1 text-grey-lighten-5 d-flex align-center justify-space-between pt-3">
            Password

            <a class="text-caption text-decoration-none text-grey-lighten-5" href="#" rel="noopener noreferrer" target="_blank">
                Forgot login password?</a
            >
        </div>

        <v-text-field
            :append-inner-icon="visible ? 'mdi-eye-off' : 'mdi-eye'"
            :type="visible ? 'text' : 'password'"
            class="bg-grey-lighten-5"
            density="compact"
            placeholder="Enter your password"
            prepend-inner-icon="mdi-lock-outline"
            variant="outlined"
            hide-details="auto"
            @click:append-inner="visible = !visible"
        ></v-text-field>

        <v-btn block class="mt-5 mb-8 bg-grey-lighten-4" size="large">
            Log In
        </v-btn>

        <v-card-text class="text-center">
            <a class="text-grey-lighten-5 text-decoration-none" href="#" rel="noopener noreferrer" target="_blank">
                Sign up now <v-icon icon="mdi-chevron-right"></v-icon>
            </a>
        </v-card-text>
    </v-card>
</template>
<script setup>
const visible = true;
</script>
