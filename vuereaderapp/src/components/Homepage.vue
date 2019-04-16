<template>
  <div id="app">
    <v-app id="inspire">
      <v-container fluid grid-list-md>
      <v-layout row wrap>
          <v-card>
            <v-card-text><family-list v-if="!showAddPerson"/></v-card-text>
            <v-card-text><add-person v-if="showAddPerson"/></v-card-text>
          </v-card>
            <v-card>
              <v-card-text><book-list v-if="!showBookDetail"/></v-card-text>
              <v-card-text><book-detail v-if="showBookDetail"/></v-card-text>
            </v-card>
          <v-card>
            <v-card-text><goal-list v-if="!showAddGoal" /></v-card-text>
            <v-card-text><add-goal v-if="showAddGoal" /></v-card-text>
          </v-card>
          <v-card>
            <v-card-text><competition-list v-if="!showAddCompetition" /></v-card-text>
            <v-card-text><add-competition v-if="showAddCompetition" /></v-card-text>
          </v-card>
          <v-card>
            <v-card-text><reading-activity-list v-if="!showAddReadingActivity" /></v-card-text>
            <v-card-text><add-reading-activity v-if="showAddReadingActivity" /></v-card-text>
          </v-card>
      </v-layout>
      </v-container>
    </v-app>
  </div>
</template>

<script>
import BookDetail from './BookDetail'
import FamilyList from './FamilyList'
import BookList from './BookList'
import GoalList from './GoalList'
import CompetitionList from './CompetitionList'
import AddGoal from './AddGoal'
import EventBus from './EventBus'
import AddCompetition from './AddCompetition'
import addPerson from './addPerson'
import ReadingActivityList from './ReadingActivityList'
import AddReadingActivity from './AddReadingActivity'
export default {
  data () {
    return {
      family: this.$session.get('family'),
      showAddGoal: false,
      showAddCompetition: false,
      showAddPerson: false,
      showBookDetail: false,
      showAddReadingActivity: false
    }
  },
  components: {
    FamilyList,
    BookList,
    GoalList,
    CompetitionList,
    AddGoal,
    AddCompetition,
    addPerson,
    BookDetail,
    AddReadingActivity,
    ReadingActivityList
  },
  mounted () {
    EventBus.$on('toggleAddGoal', state => { this.showAddGoal = state })
    EventBus.$on('toggleAddCompetition', state => { this.showAddCompetition = state })
    EventBus.$on('toggleAddPerson', state => { this.showAddPerson = state })
    EventBus.$on('showBookDetail', (state, book) => { this.showBookDetail = state })
    EventBus.$on('toggleAddReadingActivity', state => { this.showAddReadingActivity = state })
    EventBus.$emit('navEvent', 'Home')
  }
}
</script>

<style>

</style>
