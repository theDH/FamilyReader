<template>
  <div>
    <book-list id="bookList"/><family-list id="familyList"/>
  </div>
</template>

<script>
import FamilyList from './FamilyList'
import BookList from './BookList'
export default {
  components: {
    FamilyList,
    BookList
  }

}
</script>

<style>

</style>
