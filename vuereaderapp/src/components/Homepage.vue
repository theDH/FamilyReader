<template>
  <div>
    <family-list/>
    <book-list/>
    <goal-list/>
    <competition-list/>
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
