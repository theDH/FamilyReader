<template>
  <div class="book-detail">
    <h1>Book Detail</h1>
    <ul>
      <li>{{ book }}</li>
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
      bookId: this.$session.get('bookId'),
      book: null
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
      this.book = null
      axios({
        method: 'get',
        url: 'http://localhost:8080/capstone/bookdetail',
        params: this.bookParams
      }).then(response => { this.book = response.data })
    },
    back () {
      EventBus.$emit('showBookDetail', false)
    }
  },
  created () {
    this.getBookDetails()
  },
  mounted () {
    EventBus.$on('showBookDetail', (state, bookId) => {
      this.bookId = bookId
      this.state = true
      this.getBookDetails()
    })
  }
}
</script>

<style>

</style>
