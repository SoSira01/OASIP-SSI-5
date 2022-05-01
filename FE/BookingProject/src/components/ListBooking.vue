<script>
 defineProps({
    listBooking: {
        type: Array,
        default: []
    }
})
</script>

<template>

<div class="mt-8">
    <ul>
      <li v-for="(book, index) in booking" :key="index">
        <p class="font-bold text-xl">{{ book.id }} {{ book.bookingName }}</p>
      </li>
    </ul>
</div>
</template>

<style>
</style>