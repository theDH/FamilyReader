<template>
  <div>
    <input type=text v-model="nameOfGoal" placeholder="'Read 100 in a week'"/>
    <input v-model="startDate" type="date"/>
    <input v-model="numberOfDays" placeholder="'7'"/>
    <input type=text v-model="description" placeholder="'Get a hug if you read 100 minutes in a week'"/>
    <input type=number v-model="minutesToReachGoal" placeholder="'100'"/>
    <button @click="validate">Add New Goal</button>
  </div>
</template>

<script>
import axios from 'axios'
import PrimaryButton from './PrimaryButton'
export default {
  name: 'AddGoal',
  data () {
    return {
      nameOfGoal: '',
      startDate: new Date().toISOString().substring(0, 10),
      numberOfDays: '',
      description: '',
      minutesToReachGoal: '',
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
          minutesToReachGoal: this.minutesToReachGoal
        }
      }).then(response => { console.log(response) }).catch(e => console.log(e))
    },
    returnToHomepage () {
      this.$router.push('/homepage')
    },
    validate () {
      console.log('validate')
      if (this.nameOfGoal || this.parent || this.numberOfDays || this.description || this.minutesToReachGoal !== '') {
        console.log('validated')
        this.addGoal()
        EventBus.$emit('goalAdded', true)
        this.returnToHomepage()
      }
    }
  }
}
</script>

<style>

</style>
