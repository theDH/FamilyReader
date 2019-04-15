<template>
  <div id="app">
  <v-app>
    <v-toolbar class="cyan darken-2">
      <v-toolbar-title>Booknanza</v-toolbar-title>
    </v-toolbar>
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
  data () {
    return {
      navigation: this.$session.get('navigation')
    }
  },
  created () {
    this.$session.set('navigation', 'Log In')
  }
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
