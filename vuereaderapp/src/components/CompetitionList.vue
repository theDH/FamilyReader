<template>
  <div>
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
  </div>
</template>

<script>
export default {
  data () {
    return {
      competitions: [
        {
          name: 'Comp1',
          startDate: '09/29/2019',
          endDate: '10/10/2019',
          description: 'First to 100',
          minutesToFinish: 100
        },
        {
          name: 'Comp2',
          startDate: '03/20/2019',
          endDate: '03/30/2019',
          description: 'First to 10',
          minutesToFinish: 10
        }
      ]
    }
  }
}
</script>

<style>

</style>
