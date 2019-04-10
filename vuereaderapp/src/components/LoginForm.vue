<template>
<div>
    <input v-model="userName" placeholder="email"/>
    <input v-model="password" type="password" placeholder="password"/>
    <button @click="authorizeLogin">Log In</button>
    <button @click="launchSignup">Sign Up</button>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'LoginForm',
  data () {
    return {
      userName: '',
      password: '',
      posts: axios.get('https://jsonplaceholder.typicode.com/posts').then(response => { console.log(response) }).catch(e => this.errors.push(e))
    }
  },
  methods: {
    authorizeLogin () {
      console.log('login')
      axios({
        method: 'post',
        url: 'http://localhost:8080/capstone/authenticate',
        data: {
          userName: 'testusername',
          password: 'testpassword'
        }
      }).then(response => { console.log(response) }).catch(e => console.log(e))
    },
    launchSignup () {
      this.$router.push('/signup')
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
