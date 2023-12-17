<script>
import UserCurrentLayout from "@/components/layout/UserCurrentLayout.vue";

export default {
    name: "UserCurrentList",
    components: {
        UserCurrentLayout
    },
    data() {
        return {
            sendList: [
                {
                    src:
                        "https://i.namu.wiki/i/GZVW9Wwq2F0zNZGfm6A3XAS29AJgW9j40ZU5eyipqnG-3myXsenebnM6iU6nCTE1sepdut8r2LQVvs0XHZORpFUMYle2DrDdzF9NwPgEgMlmk8D2JCmuR0nG7ce3182uWfsf77E2t1eATzJFvVeZHA.webp"
                },
                {
                    src:
                        "https://i.namu.wiki/i/GZVW9Wwq2F0zNZGfm6A3XAS29AJgW9j40ZU5eyipqnG-3myXsenebnM6iU6nCTE1sepdut8r2LQVvs0XHZORpFUMYle2DrDdzF9NwPgEgMlmk8D2JCmuR0nG7ce3182uWfsf77E2t1eATzJFvVeZHA.webp"
                },
                {
                    src:
                        "https://i.namu.wiki/i/GZVW9Wwq2F0zNZGfm6A3XAS29AJgW9j40ZU5eyipqnG-3myXsenebnM6iU6nCTE1sepdut8r2LQVvs0XHZORpFUMYle2DrDdzF9NwPgEgMlmk8D2JCmuR0nG7ce3182uWfsf77E2t1eATzJFvVeZHA.webp"
                }
            ],
            receiveList: [
                {
                    src:
                        "https://i.namu.wiki/i/GZVW9Wwq2F0zNZGfm6A3XAS29AJgW9j40ZU5eyipqnG-3myXsenebnM6iU6nCTE1sepdut8r2LQVvs0XHZORpFUMYle2DrDdzF9NwPgEgMlmk8D2JCmuR0nG7ce3182uWfsf77E2t1eATzJFvVeZHA.webp"
                }
            ]
        };
    },
    methods: {
        setSendList() {
            if (this.sendList.length === 2) {
                this.sendList.push({
                    src:
                        "https://i.namu.wiki/i/GZVW9Wwq2F0zNZGfm6A3XAS29AJgW9j40ZU5eyipqnG-3myXsenebnM6iU6nCTE1sepdut8r2LQVvs0XHZORpFUMYle2DrDdzF9NwPgEgMlmk8D2JCmuR0nG7ce3182uWfsf77E2t1eATzJFvVeZHA.webp"
                });
            } else {
                this.sendList.pop();
            }
        },
        setReceiveList() {
            if (this.receiveList.length === 1) {
                this.receiveList.push({
                    src:
                        "https://i.namu.wiki/i/GZVW9Wwq2F0zNZGfm6A3XAS29AJgW9j40ZU5eyipqnG-3myXsenebnM6iU6nCTE1sepdut8r2LQVvs0XHZORpFUMYle2DrDdzF9NwPgEgMlmk8D2JCmuR0nG7ce3182uWfsf77E2t1eATzJFvVeZHA.webp"
                });
            } else {
                this.receiveList.pop();
            }
        }
    }
};
</script>

<template>
    <div class="d-flex flex-column pa-3">
        <user-current-layout title="내가 보낸 플러팅" :list="sendList" :setList="setSendList" />
        <user-current-layout title="내가 받은 플러팅" :list="receiveList" :setList="setReceiveList" />
    </div>
</template>

<style scoped></style>
