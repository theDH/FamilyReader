<template>
  <div id="app">
  <v-app>
    <v-toolbar class="cyan darken-2">
      <h1>Booknanza</h1>
    </v-toolbar>
      <v-toolbar-title></v-toolbar-title>
    <v-content>
    <router-view/>
    <footer>@BenDabSteveAlexandraSanthiyaCo.</footer>
    </v-content>
    <v-navigation-drawer></v-navigation-drawer>
  </v-app>
  </div>
</template>

<script>
export default {

}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
