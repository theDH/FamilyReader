 <template>
  <div class = "add-reading-activity">
    <h1>Add Reading Activity</h1>
    <select v-model="book">
      <option value="" selected disabled>Which book did you read?</option>
      <option v-for="book in books" v-bind:key="book.id" v-bind:value="book.title">
        {{book.title}}
      </option>
    </select>
    <input v-model="minutes" type="number" placeholder="minutes e.g. 30"/>
    <input v-model="date" type="date"/>
    <primary-button/>
  </div>
</template>

<script>
import axios from 'axios'
import PrimaryButton from './PrimaryButton'
export default {
  name: 'AddReadingActivity',
  data () {
    return {
      books: null,
      personId: 1,
      book: '',
      minutes: null,
      type: null,
      date: new Date().toISOString().substring(0, 10)
    }
  },
  computed: {
    bookParams () {
      const params = new URLSearchParams()
      params.append('personId', this.personId)
      return params
    }
  },
  methods: {
    getBooks () {
      axios({
        method: 'get',
        url: 'http://localhost:8080/capstone/bookList',
        params: this.bookParams
      }).then(response => { this.books = response.data })
    },
    postActivity () {

    }
  },
  created () {
    this.getBooks()
  },
  components: {
    PrimaryButton
  }
}
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
