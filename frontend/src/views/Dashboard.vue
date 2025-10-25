<template>
  <div class="dashboard-layout">
    
    <nav class="sidebar">
      <div class="sidebar-header">
        <h3>IUT Gestion</h3>
      </div>
      <ul class="nav-links">
        <li><a href="#" class="active">📊 Tableau de bord</a></li>
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
  methods: {
    logout() {
      // 1. Vider le token de la simulation
      localStorage.removeItem('user-token');
      
      // 2. Rediriger vers la page de connexion
      this.$router.push('/connexion');
    }
  }
}
</script>

<style scoped>
/* --- Polices (similaire à la connexion) --- */
:root {
  --font-primary: 'Poppins', sans-serif;
  --font-secondary: 'Montserrat', sans-serif;
  --color-primary: #C00000;
  --color-primary-dark: #a00000;
  --color-grey-light: #f8f9fa;
  --color-grey-dark: #333;
  --color-text: #555;
  --color-border: #eee;
  --shadow: 0 10px 30px rgba(0, 0, 0, 0.07);
}

/* --- Layout Principal --- */
.dashboard-layout {
  display: flex;
  min-height: 100vh;
  background-color: #fcfcfc;
  font-family: var(--font-secondary);
}

/* ======================== */
/* BARRE LATERALE       */
/* ======================== */
.sidebar {
  width: 260px;
  flex-shrink: 0;
  background-color: var(--color-grey-light);
  border-right: 1px solid var(--color-border);
  padding: 1.5rem;
  box-sizing: border-box;
}

.sidebar-header {
  padding-bottom: 1.5rem;
  margin-bottom: 1.5rem;
  border-bottom: 1px solid var(--color-border);
}

.sidebar-header h3 {
  font-family: var(--font-primary);
  font-size: 1.5rem;
  font-weight: 700;
  color: var(--color-primary);
  text-align: center;
  margin: 0;
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
  display: block;
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
  background-color: var(--color-primary);
  color: white;
  font-weight: 600;
}

/* ======================== */
/* CONTENU PRINCIPAL    */
/* ======================== */
.main-content {
  flex-grow: 1;
  padding: 2rem 3rem;
  box-sizing: border-box;
}

/* --- En-tête --- */
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
}

.user-info span {
  margin-right: 1.5rem;
}

.user-info a {
  color: var(--color-primary);
  text-decoration: none;
  font-weight: 600;
}
.user-info a:hover {
  text-decoration: underline;
}

/* --- Cartes de contenu --- */
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
  border: 1px solid var(--color-border);
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

/* Carte Notifications Spécifique */
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

/* Bouton */
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