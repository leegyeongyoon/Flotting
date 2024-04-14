<script setup>
defineProps({
    idx: {
        type: Number,
        default: 0
    }
});
</script>

<template>
    <span
        :class="idx === 0 && 'title-non-active'"
        style="font-size: 28px; font-weight: 800; line-height: 34px; text-align: center; padding-bottom: 16px;"
        >프로필 등록 진행 현황</span
    >
    <div class="w-100 d-flex justify-center align-center" style="margin-bottom: 30px; gap: 20px;">
        <div class="d-flex flex-column justify-center align-center" style="gap: 6px;">
            <div class="d-flex justify-center align-center" style="border-radius: 100%; border: 1px solid #DFDFDF; width: 30px; height:30px;">
                <div
                    :class="[0, 1].includes(idx) ? 'active' : 'non-active'"
                    style="border-radius: 100%;width: 25px; height:25px; text-align: center; align-content: center; color: #FFFFFF; font-size: 10px; font-weight: 800; line-height: 12px;"
                >
                    1
                </div>
            </div>
            <span style="font-size: 10px; font-weight: 800; line-height: 12px; text-align: center;">
                정보 등록
            </span>
        </div>
        <div class="d-flex flex-column justify-center align-center" style="gap: 6px;">
            <div class="d-flex justify-center align-center" style="border-radius: 100%; border: 1px solid #DFDFDF; width: 30px; height:30px;">
                <div
                    :class="[0, 2].includes(idx) ? 'active' : 'non-active'"
                    style="border-radius: 100%; width: 25px; height:25px; text-align: center; align-content: center; color: #FFFFFF; font-size: 10px; font-weight: 800; line-height: 12px;"
                >
                    2
                </div>
            </div>
            <span style="font-size: 10px; font-weight: 800; line-height: 12px; text-align: center;">
                세계관 등록
            </span>
        </div>
        <div class="d-flex flex-column justify-center align-center" style="gap: 6px;">
            <div class="d-flex justify-center align-center" style="border-radius: 100%; border: 1px solid #DFDFDF; width: 30px; height:30px;">
                <div
                    :class="[0, 3].includes(idx) ? 'active' : 'non-active'"
                    style="border-radius: 100%; width: 25px; height:25px; text-align: center; align-content: center; color: #FFFFFF; font-size: 10px; font-weight: 800; line-height: 12px;"
                >
                    3
                </div>
            </div>
            <span style="font-size: 10px; font-weight: 800; line-height: 12px; text-align: center;">
                조건 등록
            </span>
        </div>
        <div class="d-flex flex-column justify-center align-center" style="gap: 6px;">
            <div class="d-flex justify-center align-center" style="border-radius: 100%; border: 1px solid #DFDFDF; width: 30px; height:30px;">
                <div
                    :class="[0, 4].includes(idx) ? 'active' : 'non-active'"
                    style="border-radius: 100%; width: 25px; height:25px; text-align: center; align-content: center; color: #FFFFFF; font-size: 10px; font-weight: 800; line-height: 12px;"
                >
                    4
                </div>
            </div>
            <span style="font-size: 10px; font-weight: 800; line-height: 12px; text-align: center;">
                사진 등록
            </span>
        </div>
    </div>
</template>

<style scoped>
.active {
    background: #60e0e0;
}
.non-active {
    background: #dfdfdf;
}
.title-non-active {
    color: #b6b6b6;
}
</style>
