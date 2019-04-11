<template>
  <div class="book-detail">
    <h1>Book Detail</h1>
    <ul>
      <li v-for="bookDetail in bookDetails" v-bind:key="bookDetail">{{bookDetail.title}}</li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  data () {
    return {
      bookDetails: []
    }
  },
  mounted () {
    axios({ method: 'GET', 'url': 'http://localhost:8081/bookDetail' }).then(result => {
      this.bookDetails = result.data.origin
    }, error => {
      console.error(error)
    })
  }

}
</script>

<style>

</style>
