<template>
  <div>
    <input type=text v-model="name" placeholder="'Janet', 'The Rock'"/>
    <select v-model="parent">
      <option value="" selected disabled>Choose role:</option>
      <option value=true>Parent</option>
      <option value=false>Child</option>
    </select><br>
    <v-btn color="primary" dark @click="validate">Add New Person</v-btn>
    <v-btn color="secondary" light  @click="cancel">Cancel</v-btn>
  </div>
</template>

<script>
import axios from 'axios'
import PrimaryButton from './PrimaryButton'
import EventBus from './EventBus'
export default {
  name: 'AddPerson',
  data () {
    return {
      name: '',
      familyId: this.$session.get('familyId'),
      parent: ''
    }
  },
  methods: {
    addPerson () {
      axios({
        method: 'post',
        url: 'http://localhost:8080/capstone/addperson',
        data: {
          name: this.name,
          parent: this.parent,
          familyId: this.familyId
        }
      }).then(response => {
        console.log(response)
        EventBus.$emit('rebootFamilyList', true)
      }).catch(e => console.log(e))
    },
    returnToHomepage () {
      EventBus.$emit('toggleAddPerson', false)
    },
    validate () {
      console.log('validate')
      if (this.name || this.parent !== '') {
        console.log('validated')
        this.addPerson()
        EventBus.$emit('personAdded', true)
        this.returnToHomepage()
      }
    },
    cancel () {
      EventBus.$emit('toggleAddPerson', false)
    }
  },
  components: {
    PrimaryButton
  }
}
</script>

<style>

</style>
