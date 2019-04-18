 <template>
  <div>
    <!-- <v-app id="inspire"> -->
    <v-card>
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
                        <v-btn color="primary" dark v-if="family" @click="addPerson">Add Person</v-btn>

          <v-list-tile @click="setFamilySession">
            <v-list-tile-content>
              <v-list-tile-title>All Family Members</v-list-tile-title>
            </v-list-tile-content>
          </v-list-tile>
          <v-list-tile v-for="member in members" :key="member" @click="setPersonSession(member)">
            <v-list-tile-content>
             <v-list-tile-title>{{ member.name }}</v-list-tile-title>
           </v-list-tile-content>
          </v-list-tile>
          <v-btn color="primary" dark  v-if="!family" @click="deleteFamilyMember">Delete Person</v-btn>
        </v-list>
      </v-navigation-drawer>
    <!-- </v-app> -->
    </v-card>
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
      family: this.$session.get('family'),
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
      this.family = true
      EventBus.$emit('familyPersonState', true, null)
      EventBus.$emit('navEvent', 'Home')
    },
    setPersonSession (member) {
      console.log('setpersonsession')
      this.$session.set('personId', member.peopleId)
      this.$session.set('family', false)
      EventBus.$emit('familyPersonState', false, member.peopleId)
      EventBus.$emit('navEvent', member.name)
      EventBus.$emit('rebootBookList', true)
      this.family = false
    },
    addPerson () {
      EventBus.$emit('toggleAddPerson', true)
    },
    deleteFamilyMember (personId) {
      axios({
        method: 'post',
        url: 'http://localhost:8080/capstone/deleteperson',
        data: {
          peopleId: this.$session.get('personId')
        }
      }).then(response => {
        this.getMembers()
        this.setFamilySession()
      })
    }
  },
  created () {
    this.getMembers()
  },
  mounted () {
    EventBus.$on('personAdded', value => { if (value) { this.getMembers() } })
    EventBus.$on('rebootFamilyList', value => { if (value) { this.getMembers() } })
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
  margin: 50px;
  font-family: 'Roboto Condensed', sans-serif;
  border-radius: 10px;
}
</style>
