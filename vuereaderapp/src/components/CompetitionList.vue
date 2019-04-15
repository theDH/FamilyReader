<template>
  <div class="competition-list">
    <h1>List Of Active Competitions</h1>
    <ul>
      <li v-for="competition in competitions" v-bind:key="competition">
        {{competition.name}}
        {{competition.startDate}}
        {{competition.endDate}}
        {{competition.description}}
        {{competition.minutesToFinish}}
        </li>
    </ul>
      <v-btn v-if='family'>Add Competition</v-btn>
  </div>
</template>

<script>
import axios from 'axios'
import EventBus from './EventBus'
export default {
  data () {
    return {
      familyId: this.$session.get('familyId'),
      family: this.$session.get('family'),
      personId: this.$session.get('personId'),
      competitions: []
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
    getListOfCompetitions () {
      if (!this.family) {
        axios({
          method: 'get',
          url: 'http://localhost:8080/capstone/competitionlistperson',
          params: this.personParams
        }).then(response => { this.competitions = response.data })
      } else {
        axios({
          method: 'get',
          url: 'http://localhost:8080/capstone/competitionlistfamily',
          params: this.familyParams
        }).then(response => { this.competitions = response.data })
      }
    }
  },
  created () {
    this.getListOfCompetitions()
  },
  mounted () {
    EventBus.$on('familyPersonState', (fState, pState) => {
      console.log('listener')
      this.family = fState
      this.personId = pState
      this.getGoals()
    })
  }
}
</script>

<style>
  .competition-list {
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
