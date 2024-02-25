<template>
  <div class="background-login">
    <div class="formContainerLogin">
      <b-link class="nav-link" href="/">
        <b-img
          class="logoFromForms"
          src="src\img\logoApp.jpeg"
          fluid
          alt="Logo"
        ></b-img>
      </b-link>
      <h3>Recuperar Contraseña</h3>
      <form @submit.prevent="recoverPassword">
        <div class="form-group">
          <label for="email">Correo Electrónico</label>
          <input
            type="email"
            class="form-control"
            id="email"
            v-model="email"
            required
          />
        </div>
        <button type="submit" class="btnRed">Recuperar</button>
      </form>
      <router-link class="link" to="/createcount">¡Soy Nuevo!</router-link>
      <router-link class="link" to="/login">Iniciar Sesión</router-link>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      email: "",
    };
  },
  methods: {
    recoverPassword() {
      if (this.email) {
        // Perform password recovery logic here
        console.log("Recovering password...");
      } else {
        alert("Please enter your email.");
      }
    },
  },
};
</script>

<style scoped>
@import "../views/css/style.css";

.container {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
}
</style>
