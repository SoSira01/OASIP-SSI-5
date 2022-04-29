<script setup>
import { useRouter } from 'vue-router'

const appRouter = useRouter();

const goHome = () => appRouter.push({ name: 'Home' });
</script>

<template>
  <div class="fixed z-9998 top-0 left-0 w-full h-full bg-slate-900 table ease opacity-30 ">
    <div class="table-cell align-middle">
      <div class="w-300 m-auto px-20 py-30 bg-white rounded-sm shadow">
        <div class="mt-0 text-rose-700"><h3>Page Not Found</h3></div>
        <div class="m-20">Please try again!</div>
        <div class="flex-end">
          <button @click="goHome">Back to Home</button>
        </div>
      </div>
    </div>
  </div>
</template>
<style scoped>
</style>