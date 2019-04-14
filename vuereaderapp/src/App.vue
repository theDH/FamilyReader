<template>
  <!-- <div id="app"> -->
  <v-app>
    <v-toolbar class="cyan darken-2">Family Reading App</v-toolbar>
      <v-toolbar-title></v-toolbar-title>
    <v-content>
    <router-view/>
    </v-content>
  </v-app>
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
