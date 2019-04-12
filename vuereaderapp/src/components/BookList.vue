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
        books: null   
      }
    },
  methods: {
    getListOfBooksByPerson(){
      this.loading = true
      this.books = null
      axios({
        method: 'get',
        url: 'http://localhost:8080/capstone/booksList'
      }).then(response => {this.books = response.data })
    }
  }
}
</script>

<style>

</style>
