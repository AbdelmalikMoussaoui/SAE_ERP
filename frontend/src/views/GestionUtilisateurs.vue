<template>
  <div class="dashboard-layout" :class="{ 'sidebar-collapsed': isSidebarCollapsed }">
    <nav class="sidebar">
      <div class="sidebar-header">
        <img src="@/assets/Logo_G.png" alt="Logo GestIUT" class="sidebar-logo" />
        <h3 class="sidebar-title">IUT Gestion</h3>
        <button @click="toggleSidebar" class="toggle-button">«</button>
      </div>
      <ul class="nav-links">
        <li><a href="#" @click.prevent="$router.push('/dashboard')"><img src="@/assets/TableauDeBord.png" class="nav-icon" /><span class="nav-text">Tableau de bord</span></a></li>
        <li><a href="#" class="active"><img src="@/assets/GestionRole.png" class="nav-icon" /><span class="nav-text">Gestion des rôles</span></a></li>
        <li><a href="#"><img src="@/assets/FicheRessource.png" class="nav-icon" /><span class="nav-text">Fiches ressources</span></a></li>
        <li><a href="#"><img src="@/assets/MCC.png" class="nav-icon" /><span class="nav-text">MCCC</span></a></li>
        <li><a href="#"><img src="@/assets/TAC.png" class="nav-icon" /><span class="nav-text">TAC</span></a></li>
        <li><a href="#"><img src="@/assets/EnseignantVacataire.png" class="nav-icon" /><span class="nav-text">Enseignants & Vacataires</span></a></li>
        <li><a href="#"><img src="@/assets/parametre.png" class="nav-icon" /><span class="nav-text">Paramètres</span></a></li>
      </ul>
    </nav>

    <main class="main-content">
      <header class="header">
        <div class="header-welcome">
          <h1 class="page-title">Gestionnaire</h1>
        </div>
        <div class="user-info">
          <span><img src="@/assets/Bonhomme.png" alt="Admin" class="user-icon" /> Administrateur</span>
          <a href="#" @click.prevent="logout">Déconnexion</a>
        </div>
      </header>
      
      <div style="padding: 20px; text-align: center; color: #888;">
        Chargement de la liste des utilisateurs...
      </div>
    </main>
  </div>
</template>

<script>
export default {
  name: 'GestionUtilisateurs',
  data() {
    return {
      isSidebarCollapsed: false
    };
  },
  methods: {
    toggleSidebar() {
      this.isSidebarCollapsed = !this.isSidebarCollapsed;
    },
    logout() {
      localStorage.removeItem('user-token');
      this.$router.push('/connexion');
    }
  }
}
</script>

<style scoped>
/* Layout de base */
.dashboard-layout { display: flex; min-height: 100vh; background-color: #fcfcfc; font-family: 'Montserrat', sans-serif; overflow-x: hidden; }
.sidebar { width: 260px; flex-shrink: 0; background: #f8f9fa; border-right: 1px solid #eee; padding: 1.5rem; transition: 0.3s; position: relative; }
.main-content { flex-grow: 1; padding: 2rem 3rem; width: 100%; }
.sidebar-header { display: flex; align-items: center; gap: 15px; margin-bottom: 1rem; }
.sidebar-logo { height: 45px; }
.nav-links { list-style: none; padding: 0; }
.nav-links a { display: flex; align-items: center; padding: 0.75rem 1rem; text-decoration: none; color: #555; border-radius: 8px; }
.nav-links a.active { background-color: #e6f0ff; color: #C00000; font-weight: 600; }
.nav-icon { width: 24px; margin-right: 12px; }
.header { display: flex; justify-content: space-between; align-items: center; margin-bottom: 2rem; }
.toggle-button { position: absolute; top: 50%; right: -25px; background: white; border: 1px solid #eee; border-radius: 0 50% 50% 0; width: 25px; height: 40px; cursor: pointer; }
.dashboard-layout.sidebar-collapsed .sidebar { width: 80px; }
.dashboard-layout.sidebar-collapsed .nav-text, .dashboard-layout.sidebar-collapsed .sidebar-title { display: none; }
/* Header styles */
.page-title { font-family: 'Poppins', sans-serif; font-size: 2.5rem; font-weight: 700; color: #222; margin: 0; }
.user-info { display: flex; align-items: center; gap: 1.5rem; font-size: 0.9rem; color: #555; }
.user-info a { color: #C00000; text-decoration: none; font-weight: 600; }
.user-icon { width: 20px; margin-right: 8px; }
</style>