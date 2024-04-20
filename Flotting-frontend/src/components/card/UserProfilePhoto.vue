<script setup>
import { ref } from "vue";
import { mockImages } from "../../mocks/userProfilePhoto";

const selection = ref({
    face: "",
    full: "",
    appeal: "",
    identityVerification: ""
});
const dialog = ref(false);
const selectedExpendImgSrc = ref("");

const onOpenDialog = src => {
    selectedExpendImgSrc.value = src;
    dialog.value = true;
};

const onSelectPhoto = (type, src) => (selection.value[type] = src);
const getHeartIcon = (type, src) => (selection[type] === src ? "mdi-heart" : "mdi-heart-outline");
</script>

<template>
    <v-card>
        <v-container style="display:flex;flex-direction:column;gap:0.5rem">
            <!-- 얼굴 목록 -->
            <v-container>
                <v-item-group v-model="selection" multiple="true" max="2">
                    <v-row style="display: flex;flex-direction: column;">
                        <p class="photo-list-title">(1) 얼굴 사진</p>
                        <p class="photo-list-info">얼굴이 선명하게 나온 사진 (마스크 X)</p>
                    </v-row>
                    <v-row class="flex-gap">
                        <v-item v-for="(src, i) in mockImages.face" :key="i">
                            <v-img :src="src" cover aspect-ratio="1">
                                <div class="d-flex w-100 justify-space-between">
                                    <v-btn icon="mdi-arrow-expand" @click.prevent="onOpenDialog(src)"></v-btn>
                                    <v-btn :icon="getHeartIcon('face', src)" @click.prevent="onSelectPhoto('face', src)"></v-btn>
                                </div>
                            </v-img>
                        </v-item>
                    </v-row>
                </v-item-group>
            </v-container>
            <!-- 전신 목록 -->
            <v-container>
                <v-item-group v-model="selection" multiple="true" max="2">
                    <v-row style="display: flex;flex-direction: column;">
                        <p class="photo-list-title">(2) 전신 사진</p>
                        <p class="photo-list-info">전신이 다 드러나는 사진!</p>
                    </v-row>
                    <v-row class="flex-gap">
                        <v-item v-for="(src, i) in mockImages.full" :key="i" v-slot="{ isSelected, toggle }">
                            <v-img :src="src" cover aspect-ratio="1">
                                <div class="d-flex w-100 justify-space-between">
                                    <v-btn icon="mdi-arrow-expand" @click.prevent="onOpenDialog(src)"></v-btn>
                                    <v-btn :icon="isSelected ? 'mdi-heart' : 'mdi-heart-outline'" @click.prevent="toggle"></v-btn>
                                </div>
                            </v-img>
                        </v-item>
                    </v-row>
                </v-item-group>
            </v-container>
            <!-- 어필 사진 목록 -->
            <v-container>
                <v-item-group v-model="selection" multiple="true" max="2">
                    <v-row style="display: flex;flex-direction: column;">
                        <p class="photo-list-title">(3) 매력어필 사진</p>
                        <p class="photo-list-info">취미 생활, 스튜디오 사진 등</p>
                    </v-row>
                    <v-row class="flex-gap">
                        <v-item v-for="(src, i) in mockImages.appeal" :key="i" v-slot="{ isSelected, toggle }">
                            <v-img :src="src" cover aspect-ratio="1">
                                <div class="d-flex w-100 justify-space-between">
                                    <v-btn icon="mdi-arrow-expand" @click.prevent="onOpenDialog(src)"></v-btn>
                                    <v-btn :icon="isSelected ? 'mdi-heart' : 'mdi-heart-outline'" @click.prevent="toggle"></v-btn>
                                </div>
                            </v-img>
                        </v-item>
                    </v-row>
                </v-item-group>
            </v-container>
            <!-- 신원검증 서류 목록 -->
            <v-container>
                <v-item-group v-model="selection" multiple="true" max="2">
                    <v-row style="display: flex;flex-direction: column;">
                        <p class="photo-list-title">(4) 신원검증 서류</p>
                        <p class="photo-list-info">신분증, 재직 서류 모두 필수 제출</p>
                    </v-row>
                    <v-row class="flex-gap">
                        <v-item v-for="(src, i) in mockImages.identityVerification" :key="i" v-slot="{ isSelected, toggle }">
                            <v-img :src="src" cover aspect-ratio="1">
                                <div class="d-flex w-100 justify-space-between">
                                    <v-btn icon="mdi-arrow-expand" @click.prevent="onOpenDialog(src)"></v-btn>
                                    <v-btn :icon="isSelected ? 'mdi-heart' : 'mdi-heart-outline'" @click.prevent="toggle"></v-btn>
                                </div>
                            </v-img>
                        </v-item>
                    </v-row>
                </v-item-group>
            </v-container>

            <!-- 크게보는 다이얼로그 -->
            <v-dialog v-model="dialog" width="700">
                <v-card class="text-center" fluid>
                    <v-img :src="selectedExpendImgSrc" aspect-ratio="1/"></v-img>
                </v-card>
            </v-dialog>
        </v-container>
    </v-card>
</template>

<style>
.flex-gap {
    display: flex;
    gap: 1rem;
}
.photo-list-title {
    font-size: 1rem;
    font-weight: bold;
    margin-bottom: 0.1rem;
}
.photo-list-info {
    font-size: 0.8rem;
    color: #42b3b5;
    margin-bottom: 0.5rem;
}
</style>
