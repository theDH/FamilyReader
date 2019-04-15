<template>
  <div>
  </div>
</template>

<script>
import axios from 'axios'
import PrimaryButton from './PrimaryButton'
import EventBus from './EventBus'
export default {
name: 'AddCompetition',
  data () {
  return {
    familyId: this.$session.get('familyId'),
    }
  }
}
</script>

<style>

</style>
