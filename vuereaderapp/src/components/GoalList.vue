<template>
  <div class="goal-list">
    <v-card>
      <v-navigation-drawer permanent>
      <v-toolbar flat>
          <v-list>
            <v-list-tile>
              <v-list-tile-title class="title">
                List of Active Goals
              </v-list-tile-title>
            </v-list-tile>
          </v-list>
      </v-toolbar>
         <v-card-text v-for="goal in goals" :key="goal.goalId">
           <v-card-text-title v-text="goal.nameOfGoal" class= "title font-weight-medium"></v-card-text-title>
           <v-card-text v-text="goal.description" class= "font-weight-light"></v-card-text>
           <v-card-text-title class= "font-weight-light"> Minutes to reach goal:</v-card-text-title>
           <v-card-text goal v-text="goal.minutesToReachGoal" class= "font-weight-light"></v-card-text>
           <v-card-text-title class= "font-weight-light">Days remaining to reach goal:</v-card-text-title>
           <v-card-text v-text="getDaysRemaining(goal.startDate, goal.numberOfDays)"class= "font-weight-light"></v-card-text>
           <v-divider></v-divider>
         </v-card-text>
      <v-btn v-if='!family' @click="addGoal">Add Goals</v-btn>
      </v-navigation-drawer>
    </v-card>
  </div>
</template>
<script>
import axios from 'axios'
import EventBus from './EventBus'
export default {
  data () {
    return {
      personId: this.$session.get('personId'),
      family: this.$session.get('family'),
      familyId: this.$session.get('familyId'),
      goals: null
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
    addGoal () {
      EventBus.$emit('toggleAddGoal', true)
    },
    getDaysRemaining (javaDate, days) {
      let date = new Date(javaDate.year, javaDate.monthValue - 1, javaDate.dayOfMonth)
      console.log(date)
      let end = new Date(date.setDate(date.getDate() + days))
      console.log(end)
      let today = new Date()
      console.log(today)
      let diff = end.getTime() - today.getTime()
      console.log(diff)
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
  },
  mounted () {
    EventBus.$on('familyPersonState', (fState, pState) => {
      console.log('listener')
      this.family = fState
      this.personId = pState
      this.getGoals()
    })
    EventBus.$on('goalAdded', value => { if (value) { this.getGoals() } })
    EventBus.$on('rebootGetGoals', value => { if (value) { this.getGoals() } })
  }
}
</script>
<style>
  .goal-list {
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
