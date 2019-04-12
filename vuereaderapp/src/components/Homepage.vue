<template>
  <div>
    <family-list id="familyList"/>
    <book-list id="bookList"/>
    <add-reading-activity id ="activityList"/>
    <goal-list id="goalList"/>
    <competition-list id="competitionList"/>
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
