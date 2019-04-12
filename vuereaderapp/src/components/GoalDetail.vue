<template>
  <div class="goal-detail">
    <h1>Goal Detail</h1>
    <button v-on:click="getGoalDetails">Button</button>
    <ul>
      <li v-for="goalDetail in goalDetails" v-bind:key="goalDetail">{{goalDetail}}</li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  data () {
    return {
      goalDetails: null
    }
  },
  methods: {
    getGoalDetails () {
      this.loading = true
      this.goalDetails = null
      axios({
        method: 'get',
        url: 'http://localhost:8080/capstone/goaldetail'
      }).then(response => { this.goalDetails = response.data })
    }
  }
}
</script>

<style>

</style>
