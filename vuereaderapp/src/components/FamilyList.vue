 <template>
  <div class = "family-list">
    <h1>Family Members</h1>
    <ul>
      <li v-for="member in members" v-bind:key ="member">{{member}}</li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  data () {
    return {
      members: null
    }
  },
  methods: {
    getMembers () {
      this.members = null
      axios({
        method: 'get',
        url: 'http://localhost:8080/capstone/familyList?familyId=1'
      }).then(response => { this.members = response.data })
    }
  }
}
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
