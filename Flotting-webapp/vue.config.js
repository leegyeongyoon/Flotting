const { defineConfig } = require("@vue/cli-service");
const Dotenv = require("dotenv-webpack");
module.exports = defineConfig({
    transpileDependencies: true,
    assetsDir: "assets",

    pluginOptions: {
        vuetify: {
            // https://github.com/vuetifyjs/vuetify-loader/tree/next/packages/vuetify-loader
        }
    },
    configureWebpack: {
        plugins: [new Dotenv()]
    }
});
