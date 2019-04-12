<template>
  <div class="competition-detail">
    <h1>Goal Detail</h1>
    <button v-on:click="getCompetitionDetails">Button</button>
    <ul>
      <li v-for="competitionDetail in competitionDetails" v-bind:key="competitionDetail">{{competitionDetail}}</li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  data () {
    return {
      competitionDetails: null
    }
  },
  methods: {
    getCompetitionDetails () {
      this.loading = true
      this.competitionDetails = null
      axios({
        method: 'get',
        url: 'http://localhost:8080/capstone/competitionDetail'
      }).then(response => { this.competitionDetails = response.data })
    }
  }
}
</script>

<style>

</style>
