 <template>
<div class = "family-list">
    <h1>Family Members</h1>
    <ul>
        <li v-for="member in members" v-bind:key ="member">{{member}}</li>
  </div>
</template>

<script>
export default {
    data(){
        return {
            members: [
              {name: "Tom"},
              {name: "Pig"}
            ]
        }
    }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>