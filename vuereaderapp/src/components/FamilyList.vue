 <template>
 <v-card>
  <div class = "family-list">
    <v-card-title>
      <h1>Family Members</h1>
    </v-card-title>
    <v-card-text>
        <h3 v-for="member in members" v-bind:key ="member">{{member.name}}</h3>
    </v-card-text>
  </div>
 </v-card>
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
        url: 'http://localhost:8080/capstone/familylist?familyId=1'
      }).then(response => { this.members = response.data })
    }
  },
  mounted () {
    this.getMembers()
  }
}
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
