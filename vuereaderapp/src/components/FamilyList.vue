 <template>

  <div>
    <!-- <v-app id="inspire"> -->
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
          <v-list-tile @click="setFamilySession">
            <v-list-tile-content>
              <v-list-tile-title>All Family Members</v-list-tile-title>
            </v-list-tile-content>
          </v-list-tile>
          <v-list-tile v-for="member in members" :key="member" @click="setPersonSession(member.peopleId)">
            <v-list-tile-content>
             <v-list-tile-title>{{ member.name }}</v-list-tile-title>
           </v-list-tile-content>
          </v-list-tile>
        </v-list>
        <select v-model="deletePerson">
            <option value="" selected disabled>Select person to delete</option>
            <option v-for="member in members" v-bind:key="member">
            {{member.name}}
            </option>
        </select>
        <v-btn @click="deleteFamilyMember">Delete Person</v-btn>
      </v-navigation-drawer>
    <!-- </v-app> -->
  </div>

</template>

<script>
import axios from 'axios'
import EventBus from './EventBus'
import PrimaryButton from './PrimaryButton'
export default {
  data () {
    return {
      familyId: this.$session.get('familyId'),
      members: null,
      deletePerson: ''
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
    },
    setFamilySession () {
      console.log('setfamilysession')
      this.$session.set('personId', null)
      this.$session.set('family', true)
      EventBus.$emit('familyPersonState', true, null)
    },
    setPersonSession (personId) {
      console.log('setpersonsession')
      this.$session.set('personId', personId)
      this.$session.set('family', false)
      EventBus.$emit('familyPersonState', false, personId)
    },
    deleteFamilyMember (personId) {
      this.$session.set('personId', personId)
      axios({
        method: 'post',
        url: 'http://localhost:8080/capstone/deleteperson',
        data: {
          personId: this.personId
        }
      })
    }
  },
  created () {
    this.getMembers()
  },
  mounted () {
    EventBus.$on('personAdded', value => { if (value) { this.getMembers() } })
  },
  components: {
    PrimaryButton
  }
}
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.family-list{
  background: #fff;
  margin: 50px auto;
  font-family: 'Roboto Condensed', sans-serif;
  border-radius: 10px;
}
</style>
