const { defineConfig } = require("@vue/cli-service");
const Dotenv = require("dotenv-webpack");
module.exports = defineConfig({
    transpileDependencies: true,

    pluginOptions: {
        vuetify: {
            // https://github.com/vuetifyjs/vuetify-loader/tree/next/packages/vuetify-loader
        }
    },
    configureWebpack: {
        plugins: [new Dotenv()]
    },
    devServer: {
        port: 8080,
        allowedHosts: "all",
        // 모듈 전체를 다시 로드하지 않고 애플리케이션이 실행 되는 동안 교환, 추가 또는 제거
        hot: false,
        // liveReload 를 활성화(true) 하려면 hot 옵션은 비활성화(false)
        liveReload: true,
        historyApiFallback: true
    }
});
