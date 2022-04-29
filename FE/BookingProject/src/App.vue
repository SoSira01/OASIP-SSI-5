<script setup>

</script>
 
<template>
<div>
   <router-link :to="{ name: 'Home' }">Home</router-link>
   <router-link :to="{ name: 'List' }">List</router-link>
</div>
  <div>
    <router-view></router-view>
  </div>
</template>
 
<style scoped>

</style>