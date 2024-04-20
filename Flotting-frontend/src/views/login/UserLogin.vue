<template>
    <div class="pa-12 pb-8 h-100">
        <h1>관리자 포탈 로그인</h1>
        <div class="text-subtitle-1 ">Account</div>

        <v-text-field
            v-model="accountInfo.phoneNumber"
            type="number"
            density="compact"
            placeholder="PhoneNumber"
            prepend-inner-icon="mdi-cellphone"
            variant="outlined"
            hide-details="auto"
        ></v-text-field>

        <div class="text-subtitle-1  d-flex align-center justify-space-between pt-3">
            Password

            <a class="text-caption text-decoration-none " href="#" rel="noopener noreferrer" target="_blank"> Forgot login password?</a>
        </div>

        <v-text-field
            v-model="accountInfo.password"
            :append-inner-icon="visible ? 'mdi-eye-off' : 'mdi-eye'"
            :type="visible ? 'text' : 'password'"
            density="compact"
            placeholder="Enter your password"
            prepend-inner-icon="mdi-lock-outline"
            variant="outlined"
            hide-details="auto"
            @click:append-inner="visible = !visible"
        ></v-text-field>

        <v-btn block class="mt-5 mb-8" size="large" @click="userLogin">
            Log In
        </v-btn>

        <v-card-text class="text-center">
            <a class="text-decoration-none" rel="noopener noreferrer" target="_blank" @click="onClickSignUp">
                Sign up now <v-icon icon="mdi-chevron-right"></v-icon>
            </a>
        </v-card-text>
    </div>
</template>
<script setup>
import { fetchApiResource } from "@/components/axios/commonApi";
import { ref } from "vue";

import router from "@/router";
import { userInfoStore } from "@/components/store/user/userInfoStore";

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
        router.push("/home");
    } catch (error) {
        console.log(error);
    }
};
const onClickSignUp = () => {
    router.push("/signupTest");
};
</script>
