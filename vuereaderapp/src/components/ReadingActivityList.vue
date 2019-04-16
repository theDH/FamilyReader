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
    <v-list-tile v-for="session in sessions" :key="session">
      <v-list-tile-content>
        <v-list-tile-title v-text="session"></v-list-tile-title>
      </v-list-tile-content>
    </v-list-tile>
  </v-list>
  <br>
  <v-btn id = "add-button" @click="addActivity">Add New Reading Activity</v-btn>
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
      family:this.$session.get('family')
    }
  },
    methods: {
    getListOfActivities () {
      this.loading = true
      this.sessions = null
      if (!this.family) {
        axios({
          method: 'get',
          url: 'http://localhost:8080/capstone/getpersonsession',
          params: this.personParams
        }).then(response => { this.sessions = response.data })
      } else {
        axios({
          method: 'get',
          url: 'http://localhost:8080/capstone/getfamilysession',
          params: this.familyParams
        }).then(response => { this.sessions = response.data })
      }
    }
  },
  created () {
    this.getListOfSessionsByPerson()
    this.getListOfSessionsByFamily()
  }


}
</script>

<style scoped>

</style>
