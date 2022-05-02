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
       <p v-for="(b, i) in listBooking" :key="i">{{b.id}}</p>
        </div>

</template>

<style>
</style>