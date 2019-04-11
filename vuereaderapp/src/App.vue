<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
import LoginForm from './components/LoginForm'
import FamilyList from './components/FamilyList'
import SignupForm from './components/SignupForm'
import BookList from './components/BookList'
import Button from './components/Button'
import PrimaryButton from './components/PrimaryButton'
import AddReadingActivity from './components/AddReadingActivity'
export default {
  data () {
    return {
      appState: 'signup'
    }
  },
  name: 'App',
  components: {
    LoginForm,
    SignupForm,
    BookList,
    FamilyList,
    Button,
    PrimaryButton,
    AddReadingActivity
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
