<template>
  <div id="app">
    <v-app>
      <v-toolbar dense class="cyan darken-2">
        <v-toolbar-title>Booknanza</v-toolbar-title>
      </v-toolbar>
      <v-toolbar flat color="#2c3e50"></v-toolbar>
      <h1>{{ navigation }}</h1>
        <h2>Booknanza helps your children read good</h2>
      <v-content>
        <router-view/>
        <reader-footer></reader-footer>
      </v-content>
    </v-app>
  </div>
</template>

<script>
import EventBus from './components/EventBus'
import ReaderFooter from './components/ReaderFooter'
export default {
  data () {
    return {
      navigation: 'Log In',
      quote: ''
    }
  },
  mounted () {
    EventBus.$on('navEvent', value => {
      this.navigation = value
    })
  },
  components: {
    ReaderFooter
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
