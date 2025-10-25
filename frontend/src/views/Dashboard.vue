<template>
  <div class="dashboard-layout">
    <nav class="sidebar"> 
      <div class="sidebar-header">
        <img src="@/assets/Logo_G.png" alt="Logo GestIUT" class="sidebar-logo" />
        <h3 class="sidebar-title">IUT Gestion</h3> 
      </div>
      
      <ul class="nav-links">
        <li>
          <a href="#" class="active">
            <span class="nav-icon">📊</span> 
            <span class="nav-text">Tableau de bord</span>
          </a>
        </li>
        <li>
          <a href="#">
            <span class="nav-icon">#️⃣</span> 
            <span class="nav-text">Gestion des rôle</span>
          </a>
        </li>
        <li>
          <a href="#">
            <span class="nav-icon">📄</span> 
            <span class="nav-text">Fiches ressources</span>
          </a>
        </li>
        <li>
          <a href="#">
            <span class="nav-icon">🎓</span> 
            <span class="nav-text">MCCC</span>
          </a>
        </li>
        <li>
          <a href="#">
            <span class="nav-icon">🔧</span> 
            <span class="nav-text">TAC</span>
          </a>
        </li>
        <li>
          <a href="#">
            <span class="nav-icon">👥</span> 
            <span class="nav-text">Enseignants & Vacataires</span>
          </a>
        </li>
        <li>
          <a href="#">
            <span class="nav-icon">⚙️</span> 
            <span class="nav-text">Paramètres</span>
          </a>
        </li>
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

      <section class="content-cards">
        <div class="card">
          <h3>Remplir la fiche</h3>
          <p>Algorithmique avancée</p>
          <p class="subtitle">Semestre 3</p>
          <button class="btn-primary">Compléter</button>
        </div>
        <div class="card card-notifications">
          <div class="icon-success">
            <span>✔</span>
          </div>
          <h3>Notifications</h3>
          <p>Aucun notification</p>
        </div>
      </section>
    </main>
  </div>
</template>

<script>
export default {
  name: 'DashboardView',
  data() { // Ajout de la section data
    return {
      isSidebarCollapsed: false // L'état pour savoir si c'est replié (false = ouvert)
    };
  },
  methods: {
    logout() {
      localStorage.removeItem('user-token');
      this.$router.push('/connexion');
    }
    // On ajoutera une méthode toggleSidebar() ici
  }
}
</script>

<style scoped>
/* Variables CSS */
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
  --sidebar-width-open: 260px; /* Largeur ouverte */
  --sidebar-width-closed: 80px;  /* Largeur fermée (ajustez si besoin) */

  display: flex;
  min-height: 100vh;
  background-color: #fcfcfc;
  font-family: var(--font-secondary);
}

/* Sidebar */
.sidebar {
  width: var(--sidebar-width-open); /* Utilise la variable */
  flex-shrink: 0;
  background-color: var(--color-grey-light);
  border-right: 1px solid var(--color-border);
  box-sizing: border-box;
  padding: 1.5rem;
  /* On ajoutera une transition ici */
}

.sidebar-header {
  display: flex;
  align-items: center;
  gap: 15px; 
  padding-bottom: 1rem;
  margin-bottom: 1rem;
  border-bottom: 1px solid var(--color-border);
}

.sidebar-logo {
  height: 45px; 
  width: auto;
  /* On ajoutera une transition ici */
}

.sidebar-title { /* Renommé h3 en .sidebar-title */
  margin: 0;
  font-family: var(--font-primary);
  font-size: 1.4rem;
  font-weight: 700;
  color: #333;
  /* On ajoutera des styles pour cacher/afficher */
  white-space: nowrap; /* Empêche le texte de passer à la ligne */
  overflow: hidden; /* Cache le texte qui dépasse */
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
  /* gap enlevé, on gère l'espace différemment */
  padding: 0.75rem 1rem;
  text-decoration: none;
  color: var(--color-text);
  font-weight: 500;
  border-radius: 8px;
  transition: background-color 0.2s ease, color 0.2s ease;
  white-space: nowrap; /* Empêche le texte de passer à la ligne */
  overflow: hidden; /* Cache le texte qui dépasse */
}

.nav-icon {
  display: inline-block;
  width: 24px; /* Largeur fixe pour l'icône */
  text-align: center;
  margin-right: 12px; /* Espace entre icône et texte */
  flex-shrink: 0; /* Empêche l'icône de rétrécir */
}

.nav-text {
  /* On ajoutera des styles pour cacher/afficher */
}

.nav-links a:hover {
  background-color: #e9ecef;
}

.nav-links a.active {
  background-color: #e6f0ff; 
  color: #0056b3; 
  font-weight: 600;
}

/* Main Content */
.main-content {
  flex-grow: 1;
  background-color: #fcfcfc;
  box-sizing: border-box;
  padding: 2rem 3rem;
  /* On ajoutera une transition ici pour le margin-left */
}

/* Header */
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

/* Content Cards */
.content-cards {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
  gap: 2rem;
}

.card {
  background: #ffffff;
  padding: 2rem;
  border-radius: 20px;
  box-shadow: var(--shadow);
  border: 1px solid #eef; 
}

.card h3 {
  font-family: var(--font-primary);
  font-size: 1.5rem;
  font-weight: 600;
  color: var(--color-grey-dark);
  margin: 0 0 0.5rem 0;
}

.card p {
  font-size: 1rem;
  color: var(--color-text);
  margin: 0.25rem 0;
}

.card p.subtitle {
  font-size: 0.9rem;
  color: #888;
  margin-bottom: 1.5rem;
}

.card-notifications {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  text-align: center;
}

.icon-success {
  width: 50px;
  height: 50px;
  border-radius: 50%;
  background-color: #28a745; 
  color: white;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 1.5rem;
  font-weight: bold;
  margin-bottom: 1rem;
}

.btn-primary {
  width: 100%;
  padding: 14px;
  border: none;
  border-radius: 10px;
  background-color: var(--color-primary);
  color: white;
  font-size: 1.1rem;
  font-weight: 600;
  cursor: pointer;
  transition: background-color 0.3s, box-shadow 0.3s;
  margin-top: 1rem;
  font-family: var(--font-primary);
}

.btn-primary:hover {
  background-color: var(--color-primary-dark);
  box-shadow: 0 5px 15px rgba(192, 0, 0, 0.3);
}
</style>