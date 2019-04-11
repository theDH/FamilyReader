 <template>
  <div class = "family-list">
    <h1>Family Members</h1>
    <ul>
      <li v-for="member in members" v-bind:key ="member">{{member.name}}</li>
    </ul>
    <primary-button/>
  </div>
</template>

<script>
import PrimaryButton from './PrimaryButton'
export default {
  data () {
    return {
      members: [
        
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
