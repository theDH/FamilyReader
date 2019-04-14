<template>
  <div id="app">
  <v-app id="inspire">
      <v-navigation-drawer permanent>
        <v-toolbar flat>
          <v-list>
            <v-list-tile>
              <v-list-tile-title class="title">
                Current Book List
              </v-list-tile-title>
           </v-list-tile>
          </v-list>
          </v-toolbar>
          <v-list>
            <v-list-tile
              v-for="book in books"
              :key="book.title"
              image
            >
              <v-list-tile-content>
                <v-list-tile-title v-text="book.title"></v-list-tile-title>
              </v-list-tile-content>
              <v-list-tile-avatar>
                <img :src="book.image">
              </v-list-tile-avatar>
            </v-list-tile>
          </v-list>
      </v-navigation-drawer>
    </v-app>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  data () {
    return {
      books: null,
      familyId: this.$session.get('familyId'),
      personId: this.$session.get('personId'),
      family: this.$session.get('family')
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
          url: 'http://localhost:8080/capstone/booklist',
          params: this.personParams
        }).then(response => { this.books = response.data })
      } else {
        axios({
          method: 'get',
          url: 'http://localhost:8080/capstone/booklistbyfamily',
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
