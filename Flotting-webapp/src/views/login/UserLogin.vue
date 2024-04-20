<template>
    <v-card class="pa-12 pb-8 h-100" elevation="8" rounded="lg" style="background-color: #81D7D1">
        <v-card-title>
            <v-img class="mx-auto " src="../../assets/img/logo.png"></v-img>
        </v-card-title>
        <div class="text-subtitle-1 text-grey-lighten-5">Account</div>

        <v-text-field
            v-model="accountInfo.phoneNumber"
            class="bg-grey-lighten-5"
            type="number"
            density="compact"
            placeholder="PhoneNumber"
            prepend-inner-icon="mdi-cellphone"
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
            v-model="accountInfo.password"
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

        <v-btn block class="mt-5 mb-8 bg-grey-lighten-4" size="large" @click="userLogin">
            Log In
        </v-btn>

        <v-card-text class="text-center">
            <a class="text-grey-lighten-5 text-decoration-none" rel="noopener noreferrer" target="_blank">
                Sign up now <v-icon icon="mdi-chevron-right"></v-icon>
            </a>
        </v-card-text>
    </v-card>
</template>
<script setup>
import { fetchApiResource } from "@/axios/commonApi";
import { ref } from "vue";

import router from "@/router";
import { userInfoStore } from "@/store/user/userInfoStore";

const visible = true;

const userInfo = userInfoStore();

const accountInfo = ref({
    phoneNumber: "",
    password: ""
});
const userLogin = async () => {
    try {
        const responseUserInfo = await fetchApiResource("user/login", "POST", accountInfo.value);
        userInfo.setUserInfo(responseUserInfo.data);
        router.push("/dashboard");
    } catch (error) {
        console.log(error);
    }
};
</script>
