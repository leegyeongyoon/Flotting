<script setup></script>

<template>
    <div class="w-100 pa-6 d-flex flex-column" style="gap: 24px;">
        <div class="d-flex justify-center w-100">
            <div
                class="text-white font-weight-bold d-flex justify-center align-center"
                style="width: 268px; height: 63px; background-color: #60E0E0B2; box-shadow: 4px 4px 10px 0px #60E0E0 inset; border-radius: 16px; font-size: 25px;"
            >
                플러팅 현황
            </div>
        </div>
        <div
            class="d-flex justify-center w-100 pl-6 py-10 flex-column"
            style="height: 569px; box-shadow: 4px 4px 10px 0px #60E0E0; border-radius: 16px; gap: 35px;"
        >
            <div class="d-flex flex-column" style="gap: 7px;">
                <div class="d-flex">
                    <div
                        class="d-flex justify-center align-center"
                        style="width: 124px; height: 24px; border-radius: 16px; box-shadow: 0px 4px 4px 0px #00000040; background: #60E0E0; color:#FFFFFF; font-size: 14px; line-height: 17px; text-align: center; font-weight: 700;"
                    >
                        내가 받은 플러팅
                    </div>
                </div>
                <div class="w-100 pr-6">
                    <div class="w-100" style="height: 3px; background: #F1F1F1; border-radius: 16px;"></div>
                </div>
                <div class="d-flex w-auto overflow-x-auto pr-6" style="gap: 5px;">
                    <v-card style="border-radius: 16px; max-width: 135px; min-width: 135px; aspect-ratio: 1; " to="/profile">
                        <div
                            class="w-100 d-flex flex-column justify-end align-start pl-6 pb-3 font-weight-bold"
                            style="aspect-ratio: 1; background-color: #F1F1F1; background-size: cover;  background-position: 50%; background-image: url('https://i.namu.wiki/i/RmPNdn0sjKx-SYRoeRffcS5pc1rZXK-uA6PQqqU_kLFrqdMVdD3vM9HeF4c_1DLloZ1qu8KZLDwRwO8y-3vNriadzKfcXOeWaQFwwLC2Bn_HxoX1E-clw78tDqSLGLb37UHelCwkxGLeqKIpHvqPtA.webp'); font-size: 10px; text-shadow: -1px 0px white, 0px 1px white, 1px 0px white, 0px -1px white; "
                        >
                            <span>원빈</span>
                            <span>가수, 서울 강남구</span>
                        </div>
                    </v-card>
                    <v-card style="border-radius: 16px; max-width: 135px; min-width: 135px; aspect-ratio: 1; " to="/profile">
                        <div
                            class="w-100 d-flex flex-column justify-end align-start pl-6 pb-3 font-weight-bold"
                            style="aspect-ratio: 1; background-color: #F1F1F1; background-size: cover;  background-position: 50%; background-image: url('https://i.namu.wiki/i/RmPNdn0sjKx-SYRoeRffcS5pc1rZXK-uA6PQqqU_kLFrqdMVdD3vM9HeF4c_1DLloZ1qu8KZLDwRwO8y-3vNriadzKfcXOeWaQFwwLC2Bn_HxoX1E-clw78tDqSLGLb37UHelCwkxGLeqKIpHvqPtA.webp'); font-size: 10px; text-shadow: -1px 0px white, 0px 1px white, 1px 0px white, 0px -1px white; "
                        >
                            <span>원빈</span>
                            <span>가수, 서울 강남구</span>
                        </div>
                    </v-card>
                    <v-card style="border-radius: 16px; max-width: 135px; min-width: 135px; aspect-ratio: 1; " to="/profile">
                        <div
                            class="w-100 d-flex flex-column justify-end align-start pl-6 pb-3 font-weight-bold"
                            style="aspect-ratio: 1; background-color: #F1F1F1; background-size: cover;  background-position: 50%; background-image: url('https://i.namu.wiki/i/RmPNdn0sjKx-SYRoeRffcS5pc1rZXK-uA6PQqqU_kLFrqdMVdD3vM9HeF4c_1DLloZ1qu8KZLDwRwO8y-3vNriadzKfcXOeWaQFwwLC2Bn_HxoX1E-clw78tDqSLGLb37UHelCwkxGLeqKIpHvqPtA.webp'); font-size: 10px; text-shadow: -1px 0px white, 0px 1px white, 1px 0px white, 0px -1px white; "
                        >
                            <span>원빈</span>
                            <span>가수, 서울 강남구</span>
                        </div>
                    </v-card>
                </div>
            </div>
            <div class="d-flex flex-column" style="gap: 7px;">
                <div class="d-flex">
                    <div
                        class="d-flex justify-center align-center"
                        style="width: 124px; height: 24px; border-radius: 16px; box-shadow: 0px 4px 4px 0px #00000040; background: #60E0E0; color:#FFFFFF;  font-size: 14px; line-height: 17px; text-align: center; font-weight: 700;"
                    >
                        내가 보낸 플러팅
                    </div>
                </div>
                <div class="w-100 pr-6">
                    <div class="w-100" style="height: 3px; background: #F1F1F1; border-radius: 16px;"></div>
                </div>
                <div class="d-flex w-auto overflow-x-auto pr-6" style="gap: 5px;">
                    <v-card style="border-radius: 16px; max-width: 135px; min-width: 135px; aspect-ratio: 1; " to="/profile">
                        <div
                            class="w-100 d-flex flex-column justify-end align-start pl-6 pb-3 font-weight-bold"
                            style="aspect-ratio: 1; background-color: #F1F1F1; background-size: cover;  background-position: 50%; background-image: url('https://i.namu.wiki/i/RmPNdn0sjKx-SYRoeRffcS5pc1rZXK-uA6PQqqU_kLFrqdMVdD3vM9HeF4c_1DLloZ1qu8KZLDwRwO8y-3vNriadzKfcXOeWaQFwwLC2Bn_HxoX1E-clw78tDqSLGLb37UHelCwkxGLeqKIpHvqPtA.webp'); font-size: 10px; text-shadow: -1px 0px white, 0px 1px white, 1px 0px white, 0px -1px white; "
                        >
                            <span>원빈</span>
                            <span>가수, 서울 강남구</span>
                        </div>
                    </v-card>
                    <v-card style="border-radius: 16px; max-width: 135px; min-width: 135px; aspect-ratio: 1; " to="/profile">
                        <div
                            class="w-100 d-flex flex-column justify-end align-start pl-6 pb-3 font-weight-bold"
                            style="aspect-ratio: 1; background-color: #F1F1F1; background-size: cover;  background-position: 50%; background-image: url('https://i.namu.wiki/i/RmPNdn0sjKx-SYRoeRffcS5pc1rZXK-uA6PQqqU_kLFrqdMVdD3vM9HeF4c_1DLloZ1qu8KZLDwRwO8y-3vNriadzKfcXOeWaQFwwLC2Bn_HxoX1E-clw78tDqSLGLb37UHelCwkxGLeqKIpHvqPtA.webp'); font-size: 10px; text-shadow: -1px 0px white, 0px 1px white, 1px 0px white, 0px -1px white; "
                        >
                            <span>원빈</span>
                            <span>가수, 서울 강남구</span>
                        </div>
                    </v-card>
                    <v-card style="border-radius: 16px; max-width: 135px; min-width: 135px; aspect-ratio: 1; " to="/profile">
                        <div
                            class="w-100 d-flex flex-column justify-end align-start pl-6 pb-3 font-weight-bold"
                            style="aspect-ratio: 1; background-color: #F1F1F1; background-size: cover;  background-position: 50%; background-image: url('https://i.namu.wiki/i/RmPNdn0sjKx-SYRoeRffcS5pc1rZXK-uA6PQqqU_kLFrqdMVdD3vM9HeF4c_1DLloZ1qu8KZLDwRwO8y-3vNriadzKfcXOeWaQFwwLC2Bn_HxoX1E-clw78tDqSLGLb37UHelCwkxGLeqKIpHvqPtA.webp'); font-size: 10px; text-shadow: -1px 0px white, 0px 1px white, 1px 0px white, 0px -1px white; "
                        >
                            <span>원빈</span>
                            <span>가수, 서울 강남구</span>
                        </div>
                    </v-card>
                </div>
            </div>
            <div class="d-flex justify-center mr-6">
                <div
                    class="d-flex justify-center flex-column align-center font-weight-bold"
                    style="width: 268px; height: 70px; background: #F1F1F1; box-shadow: 0px 4px 4px 0px #00000040; border-radius: 16px;"
                >
                    <span>프로필 공개 후 7일</span>
                    <span>경과 시 확인이 불가합니다</span>
                </div>
            </div>
        </div>
    </div>
</template>

<style scoped></style>
