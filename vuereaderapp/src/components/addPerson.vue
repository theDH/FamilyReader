<template>
  <div>
    <input type=text v-model="name" placeholder="name e.g. 'Janet', 'The Rock'"/>
    <select v-model="parent">
      <option value="" selected disabled>Choose role:</option>
      <option value=true>Parent</option>
      <option vaule=false>Child</option>
    </select>
    <button @click="returnToHomepage">Add New Person</button>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'AddPerson',
  data () {
    return {
      name: null,
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
      }).then(response => { console.log(response) }).catch(e => console.log(e))
    },
    returnToHomepage () {
      this.$router.push('/homepage')
    }
  }
}
</script>

<style>

</style>
