<template>
  <div class="book-detail">
    <v-card>
       <v-toolbar flat>
          <v-list>
            <v-list-tile>
              <v-list-tile-title class="title">
                Book Details
              </v-list-tile-title>
            </v-list-tile>
          </v-list>
        </v-toolbar>
    <v-divider></v-divider>
      <v-list three-line>
        <v-list-tile :key="book">
          <div>
          <v-img style="height: auto; max-width: 100%; width: auto; max-height: 100%;" :src=book.image></v-img>
          </div>
            <v-card-title>{{book.title}}</v-card-title>
          <v-list-tile-sub-content>
             <v-list-tile-title>{{book.author}}</v-list-tile-title>
          </v-list-tile-sub-content>
        </v-list-tile>
      </v-list>
    <v-btn color="primary" dark  @click="back">
       Back
      </v-btn>
    </v-card>
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

<style scoped>
  .book-detail {
          background: #fff;
          font-family: 'Roboto Condensed', sans-serif;
      }
      h1 {
          background:#f2f2f2;
          color:#4b86A6;
          padding:10px;
          font-size:24px;
          text-transform: uppercase;
          text-align: center;
          margin-bottom: 0px;
          border-top-left-radius: 10px;
          border-top-right-radius: 10px;
      }
      ul {
          list-style-type: none;
          margin:0px;
          padding:0px;
      }
      li {
          font-size: 12px;
          border-bottom:1px solid #f2f2f2;
          padding:10px;
      }
      li:last-child{
          border:0px;
      }
</style>
