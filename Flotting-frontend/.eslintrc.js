module.exports = {
    parser: "vue-eslint-parser",
    parserOptions: {
        sourceType: "module",
        parser: "babel-eslint",
        allowImportExportEverywhere: false
    },
    root: true,
    env: {
        node: true,
        "vue/setup-compiler-macros": true
    },
    globals: {
        $: true,
        jQuery: true
    },
    extends: ["plugin:vue/base", "plugin:vue/vue3-essential", "plugin:vue/vue3-recommended", "@vue/prettier", "eslint-config-prettier"],
    plugins: ["prettier"],
    ignorePatterns: ["vuetify.js", "webfontloader.js"],
    rules: {
        indent: ["error", 4, { SwitchCase: 1 }]
    }
};
