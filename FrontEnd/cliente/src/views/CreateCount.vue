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
      <h3>Registro de Usuario</h3>
      <form @submit.prevent="register">
        <div class="form-group">
          <label for="username">Usuario</label>
          <input
            type="text"
            class="form-control"
            id="username"
            v-model="username"
            required
          />
        </div>
        <div class="form-group">
          <label for="password">Contraseña</label>
          <input
            type="password"
            class="form-control"
            id="password"
            v-model="password"
            required
          />
        </div>
        <button type="submit" class="btnRed">Registrarse</button>
      </form>
      <router-link class="link" to="/login">¿Ya tienes una cuenta?</router-link>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      username: "",
      password: "",
    };
  },
  methods: {
    register() {
      if (this.username && this.password) {
        // Perform registration logic here
        console.log("Registering user...");
      } else {
        alert("Please fill in all fields.");
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
