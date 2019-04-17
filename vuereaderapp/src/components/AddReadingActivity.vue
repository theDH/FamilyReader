 <template>
  <div class = "add-reading-activity">
    <select v-model="book">
      <option value="" selected disabled>Which book did you read?</option>
      <option v-for="book in books" v-bind:key="book.id" v-bind:value="book">
        {{book.title}}
      </option>
      <option value="findNewBook">Find a new book</option>
    </select>
    <br><input v-if="book === 'findNewBook'" v-model="newBookQuery" type="text" placeholder="search isbn, title, author"/>
    <button v-if="book === 'findNewBook'" @click="searchForNewBooks">Search</button>
    <v-list style="max-height: 200px" class="scroll-y" v-if="book === 'findNewBook'">
      <v-list-tile v-for="book in otherBooks" :key="book.title" @click="addFamilyBookToList(book)">
        <v-list-tile-avatar>
          <img :src="book.image">
        </v-list-tile-avatar>
        <v-list-tile-content>
          <v-list-tile-title v-text="book.title"></v-list-tile-title>
          <v-list-tile-sub-title v-text="book.author"></v-list-tile-sub-title>
        </v-list-tile-content>
      </v-list-tile>
      <v-list-tile v-for="result in newBookResults" :key="result.title" @click="addSearchedBookToList(result)">
        <v-list-tile-avatar>
          <img :src="'http://covers.openlibrary.org/b/id/' + result.cover_i + '-S.jpg'">
        </v-list-tile-avatar>
        <v-list-tile-content>
          <v-list-tile-title v-text="result.title"></v-list-tile-title>
          <v-list-tile-sub-title v-if="result.author_name" v-text="result.author_name[0]"></v-list-tile-sub-title>
        </v-list-tile-content>
      </v-list-tile>
    </v-list>
    <input v-model="minutes" type="number" placeholder="minutes e.g. 30"/>
    <input v-model="date" type="date"/><br>
    <br>
    <checkbox v-model="finished"></checkbox>
    <button @click="postActivity">Submit</button>
    <button @click="cancel">Cancel</button>
  </div>
</template>

<script>
import axios from 'axios'
import PrimaryButton from './PrimaryButton'
import EventBus from './EventBus'
export default {
  name: 'AddReadingActivity',
  data () {
    return {
      bookIsNew: false,
      newBookQuery: '',
      newBookResults: null,
      books: null,
      otherBooks: null,
      personId: this.$session.get('personId'),
      familyId: this.$session.get('familyId'),
      book: '',
      minutes: null,
      type: null,
      date: '',
      finished: false,
      goalId: this.$session.get('goalId')
    }
  },
  computed: {
    bookParams () {
      const params = new URLSearchParams()
      params.append('personId', this.personId)
      return params
    },
    familyParams () {
      const params = new URLSearchParams()
      params.append('familyId', this.familyId)
      params.append('personId', this.personId)
      return params
    },
    searchParams () {
      const params = new URLSearchParams()
      params.append('q', this.newBookQuery)
      return params
    },
    personBookParams () {
      const params = new URLSearchParams()
      params.append('personId', this.personId)
      params.append('bookTitle', this.book.title)
      return params
    }
  },
  methods: {
    getBooks () {
      axios({
        method: 'get',
        url: 'http://localhost:8080/capstone/booklist',
        params: this.bookParams
      }).then(response => { this.books = response.data })
      axios({
        method: 'get',
        url: 'http://localhost:8080/capstone/getbooksnotreading',
        params: this.familyParams
      }).then(response => { this.otherBooks = response.data })
    },
    getGoals () {
      if (!this.family) {
        axios({
          method: 'get',
          url: 'http://localhost:8080/capstone/goallist',
          params: this.personParams
        }).then(response => { this.goals = response.data })
      } else {
        axios({
          method: 'get',
          url: 'http://localhost:8080/capstone/goallistbyfamily',
          params: this.familyParams
        }).then(response => { this.goals = response.data })
      }
    },
    searchForNewBooks () {
      axios({
        method: 'get',
        url: 'http://openlibrary.org/search.json',
        params: this.searchParams
      }).then(response => { this.newBookResults = response.data.docs })
    },
    postActivity () {
      if (this.book !== '' && this.minutes && this.date !== '') {
        if (this.bookIsNew) {
          this.addNewBook()
        } else {
          this.addActivity()
        }
      } else {
        //  throw error about missing data
      }
    },
    addNewBook () {
      axios({
        method: 'post',
        url: 'http://localhost:8080/capstone/addbook',
        data: {
          title: this.book.title,
          author: this.book.author,
          isbn: this.book.isbn,
          image: this.book.image
        }
      }).then(response => { this.addBookPerson() })
    },
    addBookPerson () {
      axios({
        method: 'post',
        url: 'http://localhost:8080/capstone/addpersonbook',
        data: {
          book: this.book,
          personId: this.personId
        }
      }).then(response => { this.addActivity() })
    },
    addActivity () {
      axios({
        method: 'post',
        url: 'http://localhost:8080/capstone/addreadingactivity',
        data: {
          minutesRead: this.minutes,
          dateOfReading: this.date,
          typeOfReading: 'Read-To_Self',
          isbn: this.book.isbn,
          personId: this.personId,
          finished: this.finished,
          goalId: this.goalId
        }
      })
    },
    addFamilyBookToList (a) {
      if (this.books == null) {
        this.books = []
      }
      this.books.push(a)
      this.book = a
      this.bookIsNew = true
    },
    addSearchedBookToList (a) {
      if (this.books == null) {
        this.books = []
      }
      let b = {
        title: a.title,
        author: a.author_name[0],
        image: 'http://covers.openlibrary.org/b/id/' + a.cover_i + '-S.jpg',
        isbn: a.isbn[0]
      }
      this.books.push(b)
      this.book = b
      this.bookIsNew = true
    },
    cancel () {
      EventBus.$emit('toggleAddReadingActivity', false)
    }
  },
  created () {
    this.getBooks()
    this.getGoals()
  },
  components: {
    PrimaryButton
  }
}
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.p {
padding: 10px;
}
</style>
