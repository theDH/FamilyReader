<template>
  <div>
    <family-list/>
    <book-list/>
    <add-reading-activity/>
    <goal-list/>
    <competition-list/>
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
