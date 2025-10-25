<template>
  <div class="dashboard-layout">
    <nav class="sidebar">
      </nav>
    <main class="main-content">
      </main>
  </div>
</template>

<script>
export default {
  name: 'DashboardView'
}
</script>

<style scoped>
/* On définit les variables CSS ici,
  rattachées à notre composant principal.
*/
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
  flex-shrink: 0; /* Empêche la sidebar de rétrécir */
  background-color: var(--color-grey-light);
  border-right: 1px solid var(--color-border);
  box-sizing: border-box;
}

/* --- Contenu Principal --- */
.main-content {
  flex-grow: 1; /* Prend tout le reste de la place */
  background-color: #fcfcfc; /* Fond blanc cassé */
  box-sizing: border-box;
}
</style>