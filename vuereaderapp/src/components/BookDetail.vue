<template>
<div>
  <ul>
    <li v-for="bookDetail in bookDetails" v-bind:key="bookDetail">{{bookDetail.title}}</li>
  </ul>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  data () {
    return {
      bookDetails: [
      {bookId: null},
      {title: null},
      {authorFirstName: null},
      {authorLastName: null},
      {illustratorFirstName: null},
      {illustratorLastName: null},
      {bookType: null},
      {isbn: null},
      {image: null}
      ]
    }
  },
  mounted () {
    axios({ method: "GET", "url": "http://localhost:8081/bookDetail" }).then(result => {
      this.bookDetail = result.data.origin;
    }, error => {
      console.error(error);
    });
  },

}
</script>

<style>

</style>
