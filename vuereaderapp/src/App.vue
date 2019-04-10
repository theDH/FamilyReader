<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
import LoginForm from './components/LoginForm'
import SignupForm from './components/SignupForm'
export default {
  data () {
    return {
      appState: 'signup'
    }
  },
  name: 'App',
  components: {
    LoginForm,
    SignupForm
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
