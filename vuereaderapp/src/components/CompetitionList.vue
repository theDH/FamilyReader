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
