<template>
  <div class="book-detail">
    <h1>Book Detail</h1>
    <button v-on:click="getBookDetails">Button</button>
    <ul>
      <li v-for="bookDetail in bookDetails" v-bind:key="bookDetail">{{bookDetail}}</li>
    </ul>
    <v-btn fab dark color="primary" @click="back">
        <v-icon dark>Back</v-icon>
      </v-btn>
  </div>
</template>

<script>
import axios from 'axios'
import EventBus from './EventBus'
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
    },
    back () {
      EventBus.$emit('toggleBookDetail', false)
    }
  }
}
</script>

<style>

</style>
