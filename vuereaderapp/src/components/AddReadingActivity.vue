 <template>
  <div class = "add-reading-activity">
    <h1>Add Reading Activity</h1>
    <ul>
      <li v-for="activity in activities" v-bind:key ="activity">{{activity.session}}</li>
    </ul>
    <primary-button/>
  </div>
</template>

<script>
import PrimaryButton from './PrimaryButton'
export default {
  name: 'AddReadingActivity',
  data () {
    return {
      activities: [
        {session: 'cheese'}
      ]
    }
  },
  components: {
    PrimaryButton
  }
}
</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
