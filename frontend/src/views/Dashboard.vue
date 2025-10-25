<template>
  <div class="dashboard-layout">
    <nav class="sidebar">
      <div class="sidebar-header">
        <img src="@/assets/Logo_G.png" alt="Logo GestIUT" class="sidebar-logo" />
        <h3>IUT Gestion</h3>
      </div>
      <ul class="nav-links">
        <li><a href="#" class="active">📊 Tableau de bord</a></li>
        <li><a href="#">#️⃣ Gestion des rôle</a></li>
        <li><a href="#">📄 Fiches ressources</a></li>
        <li><a href="#">🎓 MCCC</a></li>
        <li><a href="#">🔧 TAC</a></li>
        <li><a href="#">👥 Enseignants & Vacataires</a></li>
        <li><a href="#">⚙️ Paramètres</a></li>
      </ul>
    </nav>
    <main class="main-content">
      <header class="header">
        <div class="header-welcome">
          <h2>Bonjour, [Nom] [Prenom]</h2>
          <h1>Tableau de bord</h1>
        </div>
        <div class="user-info">
          <span>👤 Administrateur</span>
          <a href="#" @click.prevent="logout">Déconnexion</a>
        </div>
      </header>
      </main>
  </div>
</template>

<script>
export default {
  name: 'DashboardView',
  methods: {
    logout() {
      localStorage.removeItem('user-token');
      this.$router.push('/connexion');
    }
  }
}
</script>

<style scoped>
.dashboard-layout {
  --font-primary: 'Poppins', sans-serif;
  --font-secondary: 'Montserrat', sans-serif;
  --color-primary: #C00000;
  --color-primary-dark: #a00000;
  --color-grey-light: #f8f9fa;
  --color-grey-dark: #333;
  --color-text: #555;
  --color-border: #eee;
  --shadow: 0 10px 30px rgba(0, 0, 0, 0.07);

  /* --- Layout Principal --- */
  display: flex;
  min-height: 100vh;
  background-color: #fcfcfc;
  font-family: var(--font-secondary);
}

/* --- Barre latérale (Sidebar) --- */
.sidebar {
  width: 260px;
  flex-shrink: 0;
  background-color: var(--color-grey-light);
  border-right: 1px solid var(--color-border);
  box-sizing: border-box;
  padding: 1.5rem;
}

/* --- Contenu Principal --- */
.main-content {
  flex-grow: 1;
  background-color: #fcfcfc;
  box-sizing: border-box;
  padding: 2rem 3rem; 
}

/* --- Styles de la Sidebar --- */

.sidebar-header {
  display: flex;
  align-items: center;
  gap: 15px;
  padding-bottom: 1rem;
  margin-bottom: 1rem; 
  border-bottom: 1px solid var(--color-border);
}

.sidebar-logo {
  height: 55px; 
  width: auto;
}

.sidebar-header h3 {
  margin: 0;
  font-family: var(--font-primary);
  font-size: 1.4rem;
  font-weight: 700;
  color: #333;
}

.nav-links {
  list-style: none;
  padding: 0;
  margin: 0;
}

.nav-links li {
  margin-bottom: 0.5rem;
}

.nav-links a {
  display: flex;
  align-items: center;
  gap: 12px;
  padding: 0.75rem 1rem;
  text-decoration: none;
  color: var(--color-text);
  font-weight: 500;
  border-radius: 8px;
  transition: background-color 0.2s ease, color 0.2s ease;
}

.nav-links a:hover {
  background-color: #e9ecef;
}

.nav-links a.active {
  background-color: #e6f0ff; 
  color: #0056b3; 
  font-weight: 600;
}

/* --- NOUVEAUX STYLES POUR LE HEADER --- */

.header {
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
  border-bottom: 1px solid var(--color-border);
  padding-bottom: 1.5rem;
  margin-bottom: 2rem;
}

.header-welcome h1 {
  font-family: var(--font-primary);
  font-size: 2rem;
  font-weight: 700;
  color: var(--color-grey-dark);
  margin: 0.25rem 0 0 0;
}

.header-welcome h2 {
  font-size: 1.25rem;
  font-weight: 500;
  color: var(--color-text);
  margin: 0;
}

.user-info {
  display: flex;
  align-items: center;
  font-size: 0.9rem;
  color: var(--color-text);
  gap: 1.5rem;
}

.user-info span {
  display: flex;
  align-items: center;
  gap: 8px;
}

.user-info a {
  color: var(--color-primary);
  text-decoration: none;
  font-weight: 600;
}
.user-info a:hover {
  text-decoration: underline;
}
</style>