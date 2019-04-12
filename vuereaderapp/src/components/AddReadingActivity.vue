 <template>
  <div class = "add-reading-activity">
    <h1>Add Reading Activity</h1>
    <book-list/>
    <input v-model="minutes" type="number"/>
    <input v-model="date" type="date"/>
    <primary-button/>
  </div>
</template>

<script>
import axios from 'axios'
import BookList from './BookList'
import PrimaryButton from './PrimaryButton'
export default {
  name: 'AddReadingActivity',
  data () {
    return {
      activity: [
        {
          person: null,
          book: null,
          minutes: null,
          type: null,
          date: new Date().toISOString().substring(0, 10)
        }
      ]
    }
  },
  methods: {
    getFamilyMembers () {
      axios({
        method: 'get',
        url: 'http://localhost:8080/capstone/familyList?familyId=1'
      }).then(response => { this.members = response.data })
    }
  },
  components: {
    PrimaryButton,
    BookList
  }
}
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
