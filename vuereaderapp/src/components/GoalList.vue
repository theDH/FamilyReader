<template>
  <div class="goal-list">
    <h1>List Of Active Goals</h1>
    <ul>
      <li v-for="goal in goals" v-bind:key="goal">
        {{goal.name}}
        {{goal.startDate}}
        {{goal.numberOfDays}}
        {{goal.description}}
        {{goal.minutesToFinish}}
        {{goal.isComplete}}
        </li>
    </ul>
  </div>
</template>

<script>
export default {
  data () {
    return {
      personId: 1,
      goals: [
        {
          name: 'Goal1',
          startDate: '09/29/2019',
          numberOfDays: 7,
          description: 'Read 100 minutes in a week',
          minutesToFinish: 100,
          isComplete: false
        },
        {
          name: 'Goal2',
          startDate: '03/20/2019',
          numberOfDays: 30,
          description: 'Read 1000 minutes in a week',
          minutesToFinish: 1000,
          isComplete: true
        }
      ]
    }
  },
  computed: {
    goalParams () {
      const params = new URLSearchParams()
      params.append("personId", this.personId)
      return params
    }
  }
  methods: {
    getGoals () {
      axios({
        method: get,
        url: 'http://localhost:8080/capstone/GoalList',
        params = this.goalParams
      }).then(response => { this.goals = response.data })
    }
  },
  created () {
    getGoals()
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
