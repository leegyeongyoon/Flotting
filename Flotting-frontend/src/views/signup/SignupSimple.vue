<template>
    <div class="pa-12 pb-8 h-100">
        <v-card-title> <h2>관리자 포탈 회원가입</h2> </v-card-title>
        <v-form fast-fail @submit.prevent="signup">
            <div class="text-subtitle-1 ">Phone Number</div>

            <v-text-field
                v-model="userData.phoneNumber"
                type="number"
                class="bg-grey-lighten-5"
                density="compact"
                placeholder="Enter your phone number"
                variant="outlined"
                hide-details="auto"
            ></v-text-field>
            <div class="text-subtitle-1  d-flex align-center justify-space-between pt-3">
                Password
            </div>

            <v-text-field
                v-model="userData.password"
                type="password"
                class="bg-grey-lighten-5"
                density="compact"
                placeholder="Enter your password"
                variant="outlined"
                hide-details="auto"
            ></v-text-field>

            <div class="text-subtitle-1  d-flex align-center justify-space-between pt-3">
                Name
            </div>

            <v-text-field
                v-model="userData.name"
                type="text"
                class="bg-grey-lighten-5"
                density="compact"
                placeholder="Enter your name"
                variant="outlined"
                hide-details="auto"
            ></v-text-field>

            <div class="text-subtitle-1  d-flex align-center justify-space-between pt-3">
                Email
            </div>

            <v-text-field
                v-model="userData.email"
                :type="'password'"
                class="bg-grey-lighten-5"
                density="compact"
                placeholder="Enter your Email"
                variant="outlined"
                hide-details="auto"
            ></v-text-field>
            <v-btn block type="submit" variant="outlined" class="mt-5 mb-8 bg-grey-lighten-4" size="large">
                Sign in
            </v-btn>
        </v-form>
        <div class="mt-2">
            <p class="text-body-2">Already have an account? <a @click="onClickSignIn">Sign in</a></p>
        </div>
    </div>
</template>
<script setup>
import { ref } from "vue";
import { fetchApiResource } from "@/components/axios/commonApi";
import router from "@/router";

const userData = ref({
    email: "",
    name: "",
    password: "",
    phoneNumber: "",
    accessToken: "",
    job: "PUBLIC_COMPANY"
});

const signup = async () => {
    try {
        await fetchApiResource("user/signin", "POST", userData.value);
        router.push("/");
    } catch (error) {
        console.log(error);
    }
};
const onClickSignIn = () => {
    router.push("/");
};
</script>
