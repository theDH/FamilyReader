 <template>

  <div>
    <v-app id="inspire">
      <v-navigation-drawer permanent>
        <v-toolbar flat>
          <v-list>
            <v-list-tile>
              <v-list-tile-title class="title">
                Family Members
              </v-list-tile-title>
           </v-list-tile>
          </v-list>
        </v-toolbar>

        <v-divider></v-divider>

        <v-list dense class="pt-0">
         <v-list-tile
           v-for="member in members"
           :key="member"
         >
            <v-list-tile-content>
             <v-list-tile-title>{{ member.name }}</v-list-tile-title>
           </v-list-tile-content>
          </v-list-tile>
        </v-list>
      </v-navigation-drawer>
    </v-app>
  </div>

</template>

<script>
import axios from 'axios'
export default {
  data () {
    return {
      familyId: this.$session.familyId,
      members: null
    }
  },
  computed: {
    familyParams () {
      const params = new URLSearchParams()
      params.append('familyId', this.familyId)
      return params
    }
  },
  methods: {
    getMembers () {
      this.members = null
      axios({
        method: 'get',
        url: 'http://localhost:8080/capstone/familylist',
        params: this.familyParams
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
