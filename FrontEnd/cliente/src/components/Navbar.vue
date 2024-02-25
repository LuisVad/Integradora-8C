<template>
  <div>
    <b-navbar toggleable="lg" type="light" variant="light" class="nav">

      <b-link class="nav-link" href="/">
        <b-img class="logo" src="src\img\logoApp.jpeg" fluid alt="Logo"></b-img>
        </b-link>
      <b-navbar-brand href="#/banquetes">Banquetes</b-navbar-brand>
      <b-navbar-brand href="#/entradas">Entradas</b-navbar-brand>
      <b-navbar-brand href="#/fuertes">Fuertes</b-navbar-brand>
      <b-navbar-brand href="#/Utencilios">Utencilios</b-navbar-brand>

      <!-- Nuevo elemento para el carrito con ícono BiCartFill -->
      <b-nav-item>
        <b-link class="nav-link" href="#/carrito">
          <b-icon icon="cart-fill" class="carrito"></b-icon>
        </b-link>
      </b-nav-item>


      <!-- Right aligned nav items -->
      <b-navbar-nav class="col-auto">
        <b-nav-item-dropdown right>
          <!-- Using 'button-content' slot -->
          <template #button-content>
            <b-icon icon="person-circle"></b-icon>
          </template>
          <b-dropdown-item href="#">Profile</b-dropdown-item>
          <b-dropdown-item href="#/login">Login</b-dropdown-item>
        </b-nav-item-dropdown>
      </b-navbar-nav>
    </b-navbar>
  </div>
</template>

<style scoped>
.logo {
  width: 60px;
  height: 60px;
  border-radius: 50%;
  margin-right: 10px;
}

.nav {

  border-radius: 5vmin;
  padding: 10px;
  justify-content: space-between;
  border: 2px solid rgb(153, 7, 7); /* Add this line to set the border color to black */
  width: 100%;
}
.carrito
{
  font-size: 10vmin;
  color: #000000;
}
</style>
