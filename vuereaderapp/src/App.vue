<template>
  <div id="app">
    <v-app>
      <v-toolbar dense="true" class="cyan darken-2">
        <v-toolbar-title>Booknanza</v-toolbar-title>
      </v-toolbar>
      <h1>{{ navigation }}</h1>
      <v-content>
        <router-view/>
        <footer>@BenDabSteveAlexandraSanthiyaCo.</footer>
      </v-content>
    </v-app>
  </div>
</template>

<script>
import EventBus from './components/EventBus';
export default {
  data () {
    return {
      navigation: 'Log In'
    }
  },
  mounted () {
    EventBus.$on('navEvent', value => { this.navigation = value })
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
}
h1 {
  background:#f2f2f2;
  color:#4b86A6;
  padding:10px;
  font-size:24px;
  text-transform: uppercase;
  text-align: center;
  margin-bottom: 0px;
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
}
</style>
