<template>
    <v-card class="pa-12 pb-8 h-100" elevation="8" rounded="lg" style="background-color: #81D7D1">
        <v-card-title>
            <v-img class="mx-auto" max-height="300px" max-width="500px" src="../../assets/img/logo.png"></v-img>
        </v-card-title>
        <v-form fast-fail @submit.prevent="signup">
            <div class="text-subtitle-1 text-grey-lighten-5">Phone Number</div>

            <v-text-field
                type="number"
                class="bg-grey-lighten-5"
                density="compact"
                placeholder="Enter your phone number"
                variant="outlined"
                hide-details="auto"
                v-model="userData.phoneNumber"
            ></v-text-field>
            <div class="text-subtitle-1 text-grey-lighten-5 d-flex align-center justify-space-between pt-3">
                Password
            </div>

            <v-text-field
                type="password"
                class="bg-grey-lighten-5"
                density="compact"
                placeholder="Enter your password"
                variant="outlined"
                hide-details="auto"
                v-model="userData.password"
            ></v-text-field>

            <div class="text-subtitle-1 text-grey-lighten-5 d-flex align-center justify-space-between pt-3">
                Name
            </div>

            <v-text-field
                type="text"
                class="bg-grey-lighten-5"
                density="compact"
                placeholder="Enter your name"
                variant="outlined"
                hide-details="auto"
                v-model="userData.name"
            ></v-text-field>

            <div class="text-subtitle-1 text-grey-lighten-5 d-flex align-center justify-space-between pt-3">
                Email
            </div>

            <v-text-field
                :type="'password'"
                class="bg-grey-lighten-5"
                density="compact"
                placeholder="Enter your Email"
                variant="outlined"
                hide-details="auto"
                v-model="userData.email"
            ></v-text-field>

            <div class="text-subtitle-1 text-grey-lighten-5 d-flex align-center justify-space-between pt-3">
                Email
            </div>
            <v-select
                class="bg-grey-lighten-5"
                v-model="userData.job"
                hide-details="auto"
                :items="['PUBLIC_COMPANY', 'MID_MAJOR_COMPANY', 'PROFESSIONAL', 'BUSNINESS']"
            ></v-select>

            <v-btn block type="submit" variant="outlined" class="mt-5 mb-8 bg-grey-lighten-4" size="large">
                Sign in
            </v-btn>
        </v-form>
        <div class="mt-2">
            <p class="text-body-2">Already have an account? <a href="#">Sign in</a></p>
        </div>
    </v-card>
</template>
<script setup>
import { ref } from "vue";
import { fetchApiResource } from "@/axios/commonApi";

const userData = ref({
    email: "",
    name: "",
    password: "",
    phoneNumber: "",
    accessToken: "",
    job: ""
});

const signup = () => {
    try {
        console.log(userData.value);
        const responseUserInfo = fetchApiResource("user/signin", userData.value);
        // userInfo.setUserInfo(responseUserInfo.data);
        alert("회읜 가입 성공");
        console.log(responseUserInfo);
    } catch (error) {
        console.log(error);
    }
};
</script>
