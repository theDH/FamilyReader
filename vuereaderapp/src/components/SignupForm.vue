<template>
<div>
    <input v-model="familyName" placeholder="name e.g. 'The Smiths', 'The Robinson Family'"/>
    <input v-model="userName" placeholder="email"/>
    <input v-model="password" type="password" placeholder="password"/>
    <input v-model="confirmPassword" type="password" placeholder="confirm password"/>
    <button @click="addNewUser">Sign Up</button>
    <button @click="launchLogin">Back to Login</button>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'SignupForm',
  data () {
    return {
      userName: '',
      password: '',
      confirmPassword: '',
      familyName: ''
    }
  },
  methods: {
    addNewUser () {
      console.log('add new user')
      axios.post('http://localhost:8080/capstone/signup', {
        headers: {
          'Access-Control-Allow-Origin': '*'
        },
        userName: 'testUsername',
        password: 'testPassword',
        confirmPassword: 'testPassword',
        familyName: 'The Test Family'
      }).then(response => { console.log(response) }).catch(e => this.errors.push(e))
    },
    launchLogin () {
      this.$router.push('/login')
    }
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
