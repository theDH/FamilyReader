<template>
  <div id="app">
  <v-app id="inspire">
    <v-layout justify-center>
      <v-flex xs12 sm6 offset-sm3>
        <v-card>
          <v-toolbar color="indigo" dark>
            <v-toolbar-title>Active Books</v-toolbar-title>
            <v-spacer></v-spacer>
            <v-btn icon>
              <v-icon>Thumbnail</v-icon>
            </v-btn>
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
        </v-card>
      </v-flex>
    </v-layout>
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
