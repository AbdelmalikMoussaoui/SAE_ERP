import { createRouter, createWebHistory } from 'vue-router'
import ConnexionView from '../views/Connexion.vue'
// 1. Importez votre nouveau dashboard
import DashboardView from '../views/Dashboard.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/connexion',
      name: 'connexion',
      component: ConnexionView
    },
    {
      path: '/',
      redirect: '/connexion'
    },
    // 2. Ajoutez la nouvelle route ici
    {
      path: '/dashboard',
      name: 'dashboard',
      component: DashboardView
    }
  ]
})

export default router