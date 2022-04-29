<script setup>

</script>
 
<template>
<div>
    <div>
      <h1>hi</h1>
      <router-link :to = "{ name: 'Home' }">Home</router-link> |       
      <router-link :to = "{ name: 'AllList' }">show list</router-link> 
    </div>
    <div>
      <router-view></router-view>
    </div>
</div>
</template>
 
<style>

</style>