<template>
  <div id="app" class="background">
    <div>
      <header>
        <div>
          <Navbar v-if="$route.path !== '/login' && $route.path !== '/createcount' && $route.path !== '/recoverpassword'"/>
        </div>
      </header>
      <main class="contentrouter">
          <router-view> </router-view>
      </main>
    </div>
  </div>
</template>

<script setup>
import Navbar from "./components/Navbar.vue";
</script>

<style scoped>
.background {
  padding: 5px;
  background-color: #9a221a;
  height: 100%;
  align-items: center;
  justify-content: center;
}
.contentrouter {
  padding: 5px;
  height: 100vh;
}
</style>
