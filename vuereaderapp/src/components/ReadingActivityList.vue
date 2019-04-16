<template>
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
    <v-list-tile v-for="session in sessions" :key"session">
      <v-list-tile-content>
        <v-list-tile-title v-text="session.id"></v-list-tile-title>
      </v-list-tile-content>
    </v-list-tile>
  </v-list>
  </v-navigation-drawer>
</v-card>
</template>
<script>
import axios from 'axios'
import EventBus from './EventBus'
export default {
  data () {
    return {
      familyId: this.$session.get('familyId'),


    }
  }

}
</script>

<style>

</style>
