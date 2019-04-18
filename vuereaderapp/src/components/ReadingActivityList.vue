<template>
<v-div>
<v-card>
  <v-navigation-drawer permanent>
  <v-toolbar>
    <v-list>
      <v-list-tile>
        <v-list-tile-title>
          Reading Activity Log
        </v-list-tile-title>
      </v-list-tile>
    </v-list>
  </v-toolbar>
  <v-divider></v-divider>
  <v-list>
    <v-list-tile v-for="session in sessions" :key="session.sessionId">
            <div>Minutes Read: {{ session.minutesRead }}</div>
    </v-list-tile>
  </v-list>
  <br>
  <v-btn color="primary" dark  v-if='!family' @click="addReadingActivity">Add New Reading Activity</v-btn>
  </v-navigation-drawer>
</v-card>
</v-div>
</template>

<script>
import axios from 'axios'
import EventBus from './EventBus'
export default {
  data () {
    return {
      sessions: null,
      familyId: this.$session.get('familyId'),
      personId: this.$session.get('personId'),
      family: this.$session.get('family')
    }
  },
  computed: {
    personSessionParams () {
      const params = new URLSearchParams()
      params.append('personId', this.personId)
      return params
    },
    familySessionParams () {
      const params = new URLSearchParams()
      params.append('familyId', this.familyId)
      return params
    }
  },
  methods: {
    addReadingActivity () {
      EventBus.$emit('toggleAddReadingActivity', true)
    },
    getListOfActivities () {
      this.loading = true
      this.sessions = null
      if (!this.family) {
        axios({
          method: 'get',
          url: 'http://localhost:8080/capstone/getpersonsession',
          params: this.personSessionParams
        }).then(response => { this.sessions = response.data })
      } else {
        axios({
          method: 'get',
          url: 'http://localhost:8080/capstone/getfamilysession',
          params: this.familySessionParams
        }).then(response => { this.sessions = response.data })
      }
    }
  },
  created () {
    this.getListOfActivities()
  },
  mounted () {
    EventBus.$on('familyPersonState', (fState, pState) => {
      console.log('listener')
      this.family = fState
      this.personId = pState
      this.getListOfActivities()
    })
    EventBus.$on()
  }
}
</script>

<style scoped>

</style>
