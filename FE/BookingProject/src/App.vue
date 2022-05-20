<script setup>

</script>
 
<template>

  <div>
    <div class="navbar p-2 mt-0 fixed w-full z-10 top-0 bg-base-100">
      <div class="flex-1">
        <p class="text-primary normal-case pl-5 font-bold text-2xl">
          <router-link :to="{ name: 'Home' }">- CLINIC | <span class="text-white">booking -</span></router-link>
        </p>
      </div>
      <div class="flex-none">
        <ul class="menu menu-horizontal p-0 mr-8 text-lg text-white space-x-3">
          <li>
            <router-link :to="{ name: 'Home' }">Home</router-link>
          </li>
          <li>
            <router-link :to="{ name: 'List' }">Show All Event</router-link>
          </li>
          <li>
            <router-link :to="{ name: 'AddList' }">Add Event</router-link>
          </li>
          <li>
            <router-link :to="{ name: 'CategoryList' }">CategoryList</router-link>
          </li>
          <li>
            <router-link :to="{ name: 'AboutUs' }">AboutUs</router-link>
          </li>
        </ul>
      </div>
    </div>
  </div>
  <div>
    <router-view></router-view>
  </div>

</template>
 
<style scoped>
</style>