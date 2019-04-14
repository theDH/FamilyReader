<template>
  <div>
    <v-layout justify-start>
    <family-list/>
    </v-layout>
    <v-layout justify-center>
      <book-list/>
    </v-layout>
    <add-reading-activity/>
    <goal-list/>
    <cometition-list/>
  </div>
</template>

<script>
import FamilyList from './FamilyList'
import BookList from './BookList'
import AddReadingActivity from './AddReadingActivity'
import GoalList from './GoalList'
import CompetitionList from './CompetitionList'
export default {
  components: {
    FamilyList,
    BookList,
    AddReadingActivity,
    GoalList,
    CompetitionList
  }
}
</script>

<style>

</style>
