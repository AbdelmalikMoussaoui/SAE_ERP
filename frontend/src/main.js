import { createApp } from 'vue'
import App from './App.vue'

// 1. On importe le "GPS" (le routeur)
import router from './router' 

// On crée l'application
const app = createApp(App)

// 2. On dit à Vue d'utiliser le "GPS"
app.use(router) 

// 3. On "monte" l'application dans la page
app.mount('#app')