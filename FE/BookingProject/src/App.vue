<script setup>

</script>
 
<template>
<div class="navbar bg-base-100 font-mono">
  <div class="flex-1">  
    <span class="normal-case pl-10 font-bold text-2xl">Booking_Clinic</span>
  </div>
  <div class="flex-none">
    <ul class="menu menu-horizontal p-0 pr-10 text-lg">
      <li class="pr-5"><router-link :to="{ name: 'Home' }">Add Event</router-link></li>
      <li><router-link :to="{ name: 'List' }">View Event All</router-link></li>
      
    </ul>
  </div>
</div>

  <div>
    <router-view></router-view>
  </div>

</template>
 
<style scoped>

</style>