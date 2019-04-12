<template>
  <div>
      <family-list id="familyList"/>
      <book-list id="bookList"/>
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
