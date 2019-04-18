<template>
  <div id="app">
    <div class="md-layout md-gutter">
    <v-app id="inspire">
      <!-- <v-container fluid grid-list-sm >
      <v-card-group deck>
      <v-layout row wrap> -->
        <family-list class="m" v-if="!showAddPerson"/>
        <add-person class="m" v-if="showAddPerson"/>
        <book-list class="m" v-if="!showBookDetail"/>
        <book-detail class="m" v-if="showBookDetail"/>
        <goal-list class="m" v-if="!showAddGoal" />
        <add-goal class="m" v-if="showAddGoal" />
        <competition-list class="m" v-if="!showAddCompetition" />
        <add-competition class="m" v-if="showAddCompetition" />
        <reading-activity-list class="m" v-if="!showAddReadingActivity" />
        <add-reading-activity class="m" v-if="showAddReadingActivity" />
      <!-- </v-layout>
      </v-card-group>
      </v-container> -->
    </v-app>
    </div>
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
.m{
  margin: 10px;
  flex: auto;

}
input {
  border: 2px solid rgb(53, 82, 160);
  border-radius: 4px;
}

</style>
