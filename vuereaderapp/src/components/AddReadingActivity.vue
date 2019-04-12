 <template>
  <div class = "add-reading-activity">
    <h1>Add Reading Activity</h1>
    <primary-button/>
  </div>
</template>

<script>
import PrimaryButton from './PrimaryButton'
export default {
  name: 'AddReadingActivity',
  data () {
    return {
      members = null,
      activity: [
        {
          person: null,
          book: null,
          minutes: null,
          type: null,
          date: null
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
    PrimaryButton
  }
}
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
