<template>
  <div id="app">
    <v-app id="inspire">
      <v-container fluid grid-list-md fill-height>
      <v-layout row fil-height>
          <v-card>
            <v-card-text><family-list/></v-card-text>
          </v-card>
            <v-card>
              <v-card-text><book-list/></v-card-text>
          </v-card>
          <v-card>
            <v-card-text><goal-list v-if="!showAddGoal" /></v-card-text>
            <v-card-text><add-goal v-if="showAddGoal" /></v-card-text>
          </v-card>
          <v-card>
            <v-card-text><competition-list/></v-card-text>
          </v-card>
      </v-layout>
      </v-container>
      <!-- <v-navigation-drawer
      :clipped="drawer.clipped"
      :fixed="drawer.fixed"
      :permanent="drawer.permanent"
      :mini-variant="drawer.mini"
      v-model="drawer.open"
      app
      > -->
      <!-- </v-navigation-drawer> -->
    </v-app>
  </div>
</template>

<script>
import FamilyList from './FamilyList'
import BookList from './BookList'
import GoalList from './GoalList'
import CompetitionList from './CompetitionList'
import AddGoal from './AddGoal'
import EventBus from './EventBus'
export default {
  data () {
    return {
      family: this.$session.get('family'),
      showAddGoal: false
    }
  },
  components: {
    FamilyList,
    BookList,
    GoalList,
    CompetitionList,
    AddGoal
  },
  mounted () {
    EventBus.$on('toggleAddGoal', state => { this.showAddGoal = state })
  }
}
</script>

<style>

</style>
