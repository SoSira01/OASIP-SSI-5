<script setup>
 defineProps({
    listBooking: {
        type: Array,
        default: []
    }
})

</script>
<template>
    <div>
       <p v-for="(b, i) in booking" :key="i">{{b}}</p>
        </div>

</template>

<style>
</style>