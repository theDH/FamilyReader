<template>
<div>
  <b-button>Button</b-button>
  <b-button variant="danger">Button</b-button>
  <b-button variant="success">Button</b-button>
  <b-button variant="outline-primary">Button</b-button>
  <button class="Button">Button</button>
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
