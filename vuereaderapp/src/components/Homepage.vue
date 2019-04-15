<template>
  <div id="app">
    <v-app id="inspire">
      <v-container fluid grid-list-md fill-height>
      <v-layout row>
          <v-card color="green lighten-2">
            <v-card-text> <family-list/> </v-card-text>
          </v-card>
          <template v-if='family'>
          <v-card color="green lighten-2">
            <v-card-text><book-list/></v-card-text>
          </v-card>
          </template>
          <v-card color="green lighten-2">
            <v-card-text> <goal-list/></v-card-text>
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
export default {
  data () {
    return {
      family: this.$session.get('family')
    }
  },
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
