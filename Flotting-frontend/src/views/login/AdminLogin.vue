<script setup>
import { onBeforeMount, ref } from "vue";
import { useStore } from "vuex";
import { useRouter } from "vue-router";

const router = useRouter();
const store = useStore();

const id = ref(null);
const password = ref(null);

onBeforeMount(() => {
    store.commit("closeDrawer");
});

function loginSubmit() {
    let saveData = {};
    saveData.id = id.value;
    saveData.password = password.value;

    if (id.value !== "test" || password.value !== "test12") {
        alert("잘못된 정보를 입력하였습니다.");
        return;
    }

    try {
        // this.$axios
        //     .post(HOST + "/signin", JSON.stringify(saveData), {
        //       headers: {
        //         "Content-Type": `application/json`,
        //       },
        //     })
        //     .then((res) => {
        //       if (res.status === 200) {
        //         // 로그인 성공시 처리해줘야할 부분
        //       }
        //     });
        console.log({ userId: "test", userName: "테스터", token: "tokentest1" });
        store.commit("login", { userId: "test", userName: "테스터", token: "tokentest1" });
        store.commit("toggleDrawer");
        router.push("/home");
    } catch (error) {
        console.error(error);
    }
}
</script>

<template>
    <v-card class="mx-auto" max-width="400">
        <v-card-title>
            Login
        </v-card-title>
        <v-divider />
        <v-card-text>
            <v-form>
                <v-text-field v-model="id" placeholder="ID" required @keyup.enter="loginSubmit"></v-text-field>
                <v-text-field v-model="password" placeholder="Password" type="password" required @keyup.enter="loginSubmit"></v-text-field>
            </v-form>
        </v-card-text>
        <v-card-actions>
            <v-btn color="#2c4f91" dark large block @click="loginSubmit">Login</v-btn>
        </v-card-actions>
    </v-card>
</template>

<style scoped></style>
