<template>
  <div class="book-detail">
    <h1>Book Detail</h1>
    <ul>
      <li v-for="bookDetail in bookDetails" v-bind:key="bookDetail">{{ bookDetail }}</li>
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
      bookDetails: null,
      bookId: null
    }
  },
  computed: {
    bookParams () {
      const params = new URLSearchParams()
      params.append('bookId', this.bookId)
      return params
    }
  },
  methods: {
    getBookDetails () {
      this.loading = true
      this.bookDetails = null
      axios({
        method: 'get',
        url: 'http://localhost:8080/capstone/bookdetail',
        params: this.bookParams
      }).then(response => { this.bookDetails = response.data })
    },
    back () {
      EventBus.$emit('showBookDetail', false)
    }
  },
  mounted () {
    EventBus.$on('showBookDdetail', (value, book) => {
      this.bookDetails = book
    })
  }
}
</script>

<style>

</style>
