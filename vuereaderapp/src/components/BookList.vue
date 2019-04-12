<template>
  <main>
    <h1>Active books</h1>
    <ul>
      <li v-for="book in books" v-bind:key="book.id">
      {{book.title}} {{book.author}}
      </li>
    </ul>
  </main>
</template>

<script>
import axios from 'axios'
export default {
  data () {
    return {
      books: null,
      familyId: 1,
      personId: 1,
      family: false
    }
  },
  computed: {
    personParams () {
      const params = new URLSearchParams()
      params.append('personId', this.personId)
      return params
    },
    familyParams () {
      const params = new URLSearchParams()
      params.append('familyId', this.familyId)
      return params
    }
  },
  methods: {
    getListOfBooks () {
      this.loading = true
      this.books = null
      if (!this.family) {
        axios({
          method: 'get',
          url: 'http://localhost:8080/capstone/bookList',
          params: this.personParams
        }).then(response => { this.books = response.data })
      } else {
        axios({
          method: 'get',
          url: 'http://localhost:8080/capstone/booksListByFamily',
          params: this.familyParams
        }).then(response => { this.books = response.data })
      }
    }
  },
  created () {
    this.getListOfBooks()
  }
}
</script>

<style>

</style>
