<template>
  <div class="book-list">
    <v-card>
        <v-toolbar>
          <v-list>
            <v-list-tile>
              <v-list-tile-title class="title">
                Active Books
              </v-list-tile-title>
              </v-list-tile>
            </v-list>
          </v-toolbar>
          <v-list-tile v-for="book in books" :key="book.bookId" @click="setBookDetail(book.bookId)">
            <v-list-tile-avatar>
              <img :src="book.image">
          </v-list-tile-avatar>
          <v-list-tile-content>
              <v-list-tile-title v-text="book.title"></v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>
        <br>
    </v-card>
  </div>
</template>

<script>
import axios from 'axios'
import EventBus from './EventBus'
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
    setBookDetail (bookId) {
      this.$session.set('bookId', bookId)
      EventBus.$emit('showBookDetail', true, bookId)
    },
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
  },
  mounted () {
    EventBus.$on('familyPersonState', (fState, pState) => {
      console.log('listener')
      this.family = fState
      this.personId = pState
      this.getListOfBooks()
    })
    EventBus.$on('rebootBookList', value => { if (value) { this.getListOfBooks() } })
  }
}
</script>
<style>
add-btn{
  color:cadetblue;
}
#title {
background-color:paleturquoise;
}

</style>
