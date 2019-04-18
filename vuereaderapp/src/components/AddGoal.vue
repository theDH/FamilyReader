<template>
<v-app>
  <div>
          <div>
    <input type="text" v-model="nameOfGoal" placeholder="'name of goal'"/>
    </div>
          <div>
    <input v-model="startDate" type="date" placeholder="start date"/>
    </div>
          <div>
    <input v-model="numberOfDays" type="number" placeholder="'length of goal'"/>
    </div>
          <div>
    <input type="text" v-model="description" placeholder="'reward for reaching goal'"/>
    </div>
          <div>
    <input type="number" v-model="minutesToReachGoal" placeholder="'100'"/>
</div>
          <div>
    <v-btn color="primary" dark @click="validate">Add New Goal</v-btn>
    </div>
          <div>
    <v-btn color="secondary" light @click="cancel">Cancel</v-btn>
    </div>
          
  </div>
</v-app>
</template>

<script>
import axios from 'axios'
import EventBus from './EventBus'
export default {
  name: 'AddGoal',
  data () {
    return {
      nameOfGoal: '',
      startDate: new Date().toISOString().substring(0, 10),
      numberOfDays: '',
      description: '',
      minutesToReachGoal: '',
      personId: this.$session.get('personId'),
      minutesRead: this.$session.get('minutesRead')
    }
  },
  computed: {
    personParams () {
      const params = new URLSearchParams()
      params.append('personId', this.personId)
      return params
    }
  },
  methods: {
    addGoal () {
      axios({
        method: 'post',
        url: 'http://localhost:8080/capstone/addgoal',
        data: {
          nameOfGoal: this.nameOfGoal,
          startDate: this.startDate,
          numberOfDays: this.numberOfDays,
          description: this.description,
          minutesToReachGoal: this.minutesToReachGoal,
          personId: this.personId,
          minutesRead: this.minutesRead
        }
      }).then(response => {
        console.log(response)
        EventBus.$emit('rebootGetGoals', true)
      }).catch(e => console.log(e))
    },
    returnToHomepage () {
      EventBus.$emit('toggleAddGoal', false)
    },
    validate () {
      console.log('validate')
      if (this.nameOfGoal || this.parent || this.numberOfDays || this.description || this.minutesToReachGoal !== '') {
        console.log('validated')
        this.addGoal()
        EventBus.$emit('goalAdded', true)
        this.returnToHomepage()
      }
    },
    cancel () {
      EventBus.$emit('toggleAddGoal', false)
    }
  }
}
</script>

<style>

</style>
