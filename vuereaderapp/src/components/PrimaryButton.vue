<template>
<div>
  <button class="Button">Submit</button>
</div>

</template>

<script>
export default {
  name: 'PrimaryButton'
}
</script>

<style scoped>
  .Button {
    background: #00ccff;
    border: none;
    color:#fff;
    cursor: pointer;
    font-size: 0.75rem;
    padding: 10px 25px;
    text-transform: uppercase;
    transition: background .2s ease-in-out;
    }
</style>
