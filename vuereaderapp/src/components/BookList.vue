<template>
  <main>
    <div v-for="book in books" :key="book.id">
      {{book.title}}
      {{book.author}}
    </div>
  </main>
</template>

<script>
export default {
  name: 'BookList',
  data () {
    return {
      books: [
        {
          title: 'Book 1',
          author: 'Author 1'
        },
        {
          title: 'Book 2',
          author: 'Author 2'
        }
      ]
    }
  }
}
</script>

<style>

</style>
