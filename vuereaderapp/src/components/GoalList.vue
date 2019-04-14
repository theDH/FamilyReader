<template>
  <div class="goal-list">
    <h1>List Of Active Goals</h1>
    <ul>
      <li v-for="goal in goals" v-bind:key="goal">
        {{goal.nameOfGoal}}
        {{goal.description}}
        {{goal.minutesToFinish}}
        {{goal.isComplete}}
      </li>
    </ul>
  </div>
</template>
<script>
import axios from 'axios'
export default {
  data () {
    return {
      personId: this.$session.get('personId'),
      family: this.$session.get('family'),
      familyId: this.$session.get('familyId'),
      goals: []
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
    getDaysRemaining (javaDate, days) {
      let date = new Date(Date(javaDate.year, javaDate.monthValue - 1, javaDate.dayOfMonth))
      let end = date.setDate(date.getDate() + days)
      let today = new Date()
      let diff = end.getTime() - today.getTime()
      return Math.round(diff / 86400000)
    },
    getGoals () {
      if (!this.family) {
        axios({
          method: 'get',
          url: 'http://localhost:8080/capstone/goallist',
          params: this.personParams
        }).then(response => { this.goals = response.data })
      } else {
        axios({
          method: 'get',
          url: 'http://localhost:8080/capstone/goallistbyfamily',
          params: this.familyParams
        }).then(response => { this.goals = response.data })
      }
    }
  },
  created () {
    this.getGoals()
  }
}
</script>
<style>
  .goal-list {
        width:450px;
        background: #fff;
        margin: 50px auto;
        font-family: 'Roboto Condensed', sans-serif;
        border-radius: 10px;
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
        font-size: 24px;
        border-bottom:1px solid #f2f2f2;
        padding:10px 20px;
    }
    li:last-child{
        border:0px;
    }
</style>
