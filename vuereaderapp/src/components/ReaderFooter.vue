<template>
  <main>
    <div>@BDASSCo.</div>
    <div>{{ quote }} -- Kanye West</div>
  </main>
</template>

<script>
import axios from 'axios'
export default {
  name: 'ReaderFooter',
  data () {
    return {
      quote: ''
    }
  },
  methods: {
    getQuote () {
      axios({
        method: 'get',
        url: 'https://api.kanye.rest'
      }).then(response => { this.quote = response.data.quote })
    }
  },
  mounted () {
    this.getQuote()
  }
}
</script>

<style>
main{
background-color:paleturquoise;
}
</style>
