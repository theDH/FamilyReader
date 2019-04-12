<template>
  <div class="book-detail">
    <h1>Book Detail</h1>
    <button v-on:click="getBookDetails">Button</button>
    <ul>
      <li v-for="bookDetail in bookDetails" v-bind:key="bookDetail">{{bookDetail}}</li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  data () {
    return {
      bookDetails: null
    }
  },
  methods: {
    getBookDetails () {
      this.loading = true
      this.bookDetails = null
      axios({
        method: 'get',
        url: 'http://localhost:8080/capstone/bookdetail'
      }).then(response => { this.bookDetails = response.data })
    }
  }
}
</script>

<style>

</style>
