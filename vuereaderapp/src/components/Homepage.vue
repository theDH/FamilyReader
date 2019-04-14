<template>
  <div id="app">
    <v-app id="inspire">
      <!-- <v-navigation-drawer
      :clipped="drawer.clipped"
      :fixed="drawer.fixed"
      :permanent="drawer.permanent"
      :mini-variant="drawer.mini"
      v-model="drawer.open"
      app
      > -->
    <family-list/>
      <!-- </v-navigation-drawer> -->
    <book-list/>
    <goal-list/>
    </v-app>
  </div>
</template>

<script>
import FamilyList from './FamilyList'
import BookList from './BookList'
import GoalList from './GoalList'
import CompetitionList from './CompetitionList'
export default {
  components: {
    FamilyList,
    BookList,
    GoalList,
    CompetitionList
  }
}
</script>

<style>

</style>
