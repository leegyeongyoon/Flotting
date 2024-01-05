<script>
import ImageCard from "@/components/card/ImageCard.vue";

export default {
    name: "UserWeekendList",
    components: {
        ImageCard
    }
};
</script>

<template>
    <div>
        <v-row>
            <v-col cols="12">
                <image-card
                    src="https://i.namu.wiki/i/GZVW9Wwq2F0zNZGfm6A3XAS29AJgW9j40ZU5eyipqnG-3myXsenebnM6iU6nCTE1sepdut8r2LQVvs0XHZORpFUMYle2DrDdzF9NwPgEgMlmk8D2JCmuR0nG7ce3182uWfsf77E2t1eATzJFvVeZHA.webp"
                    title="닉네임 (만,나이)"
                    sub-title="직업, 거주지"
                />
            </v-col>
        </v-row>
        <v-row>
            <v-col cols="12" md="4">
                <image-card
                    src="https://i.namu.wiki/i/GZVW9Wwq2F0zNZGfm6A3XAS29AJgW9j40ZU5eyipqnG-3myXsenebnM6iU6nCTE1sepdut8r2LQVvs0XHZORpFUMYle2DrDdzF9NwPgEgMlmk8D2JCmuR0nG7ce3182uWfsf77E2t1eATzJFvVeZHA.webp"
                    title="닉네임 (만,나이)"
                    sub-title="직업, 거주지"
                />
            </v-col>
        </v-row>
    </div>
</template>

<style scoped></style>
