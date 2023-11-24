import { createApp } from 'vue'
import App from './App.vue'
import VueCompositionAPI from '@vue/composition-api'


createApp(App)
    .use(VueCompositionAPI)
    .mount('#app')
