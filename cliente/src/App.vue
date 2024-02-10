<template>
  <div id="app">
    <div>
      <header>
        <div>
          <Navbar v-if="$route.path !== '/login' && $route.path !== '/createcount' && $route.path !== '/recoverpassword'"/>
        </div>
      </header>
      <main>
          <router-view> </router-view>
      </main>
    </div>
  </div>
</template>

<script setup>
import Navbar from "./components/Navbar.vue";
</script>

<style scoped></style>
