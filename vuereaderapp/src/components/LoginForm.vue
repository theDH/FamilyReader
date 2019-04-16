<template>
<div>
    <input v-model="userName" placeholder="email"/>
    <input v-model="password" type="password" placeholder="password"/>
    <div v-if="this.error">Your email and/or password was invalid. Please try again.</div>
    <button @click="authorizeLogin">Log In</button>
    <button @click="launchSignup">Sign Up</button>
  </div>
</template>

<script>
import axios from 'axios'
import EventBus from './EventBus'
export default {
  name: 'LoginForm',
  data () {
    return {
      userName: '',
      password: '',
      error: false
    }
  },
  methods: {
    authorizeLogin () {
      axios({
        method: 'post',
        url: 'http://localhost:8080/capstone/authenticate',
        data: {
          userName: this.userName,
          password: this.password
        }
      }).then(response => {
        if (response.data > 0) {
          console.log(response.data)
          this.error = false
          this.$session.set('username', this.userName)
          this.$session.set('familyId', response.data)
          this.$session.set('family', true)
          this.launchLogin()
        } else {
          this.error = true
        }
      }).catch(e => console.log(e))
    },
    launchSignup () {
      this.$router.push('/signup')
    },
    launchLogin () {
      this.$router.push('/homepage')
    }
  },
  created () {
    EventBus.$emit('navEvent', 'Log In')
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  div {
    margin: auto;
    max-width: 400px;
    display: flex;
    justify-content: center;
    flex-direction: column;
  }
  input {
    margin: 5px;
  }
  button {
    margin: 5px;
  }
</style>
