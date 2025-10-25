<template>
  <div class="page-layout">
    <header class="top-header">
      <div class="header-content">
        <div class="brand-section" @click="toggleNav">
          <img src="@/assets/GestIUT_logo.png" alt="Logo GestIUT" class="brand-logo" />
          <span class="dropdown-arrow" :class="{ 'open': isNavOpen }">▼</span>
        </div>

        <div class="user-section-placeholder">
           <span>👤 Administrateur</span>
           <a href="#" @click.prevent="logout">Déconnexion</a>
        </div>
      </div>
      <nav class="dropdown-nav" :class="{ 'open': isNavOpen }">
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
    </header>

    <main class="main-content">
       <header class="content-header">
        <div class="header-welcome">
          <h2>Bonjour, [Nom] [Prenom]</h2>
          <h1>Tableau de bord</h1>
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
  data() {
    return {
      isNavOpen: false
    };
  },
  methods: {
    toggleNav() {
      this.isNavOpen = !this.isNavOpen;
    },
     logout() {
      localStorage.removeItem('user-token');
      this.$router.push('/connexion');
    }
  }
}
</script>

<style scoped>
/* Variables */
.page-layout {
  --font-primary: 'Poppins', sans-serif;
  --font-secondary: 'Montserrat', sans-serif;
  --color-primary: #C00000;
  --color-primary-dark: #a00000;
  --color-grey-light: #f8f9fa;
  --color-grey-dark: #333;
  --color-text: #555;
  --color-border: #eee;
  --shadow: 0 4px 10px rgba(0, 0, 0, 0.05);
  --header-height: 70px;
  --nav-transition-duration: 0.3s;
}

/* Layout */
.page-layout {
  min-height: 100vh;
  background-color: #fcfcfc;
  font-family: var(--font-secondary);
  padding-top: var(--header-height);
}

/* Header Fixe */
.top-header {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  background-color: white;
  border-bottom: 1px solid var(--color-border);
  box-shadow: var(--shadow);
  z-index: 1000;
}

.header-content {
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 100%;
  height: var(--header-height);
  padding: 0 2rem;
  box-sizing: border-box;
}

.brand-section {
  display: flex;
  align-items: center;
  gap: 10px;
  cursor: pointer;
}

/* Style pour le logo GestIUT (agrandit) */
.brand-logo {
  height: 100px; /* Agrandit (avant 45px) */
  width: auto;
}

/* Flèche déroulante */
.dropdown-arrow {
  font-size: 0.8rem;
  color: var(--color-text);
  transition: transform var(--nav-transition-duration) ease;
}
.dropdown-arrow.open {
  transform: rotate(180deg);
}

/* Section utilisateur */
.user-section-placeholder {
   display: flex;
   align-items: center;
   font-size: 0.9rem;
   color: var(--color-text);
   gap: 1.5rem;
}
.user-section-placeholder span {
  display: flex;
  align-items: center;
  gap: 8px;
}
.user-section-placeholder a {
  color: var(--color-primary);
  text-decoration: none;
  font-weight: 600;
}
.user-section-placeholder a:hover {
  text-decoration: underline;
}

/* Menu Déroulant */
.dropdown-nav {
  background-color: white;
  max-height: 0;
  overflow: hidden;
  transition: max-height var(--nav-transition-duration) ease-out;
  border-top: 1px solid var(--color-border);
}

.dropdown-nav.open {
  max-height: 500px; /* Hauteur estimée */
}

.nav-links {
  list-style: none;
  padding: 1rem 2rem;
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

/* Contenu Principal */
.main-content {
  padding: 2rem 3rem;
  box-sizing: border-box;
}

.content-header {
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
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