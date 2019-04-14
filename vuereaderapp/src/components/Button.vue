<template>
  <button class="Button">Button</button>
</template>

<script>
export default {
  data () {
    return {
      userName: this.$session.get('username'),
      familyId: this.$session.get('familyId')
    }
  }
}
</script>

<style scoped>

.Button {
  background: #fff;
  border: none;
  color:#00ccff;
  cursor: pointer;
  font-size: 0.75rem;
  padding: 10px 25px;
  text-transform: uppercase;
  transition: background .2s ease-in-out;
  }

</style>
