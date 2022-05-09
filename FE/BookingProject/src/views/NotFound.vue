<script setup>
import { useRouter } from 'vue-router'
const appRouter = useRouter();
const goHome = () => appRouter.push({ name: 'Home' });
</script>

<template>
   <div class="w-7/12 ml-auto mr-auto drop-shadow ">
       <div class="rounded-lg bg-error text-base text-white m-10 p-8 drop-shadow-xl text-center">
        <div  class="mt-5 text-5xl">Page Not Found</div>
        <div class="m-10 text-3xl">Please try again!</div>
        <div>
          <button class="mt-5 flex-row btn btn-xs drop-shadow-xl mr-3" @click="goHome">Back to Home</button>
        </div>
      </div>
  </div>
</template>
<style scoped>
</style>