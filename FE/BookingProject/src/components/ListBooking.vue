<script setup>
defineEmits(['remove'])

defineProps({
    listBooking : {
        type : Array,
        require : true,
        default: []
    }
})
/* list-all : date starttime duration catagoryname bookingName
   detail : date starttime duration catagoryName bookingName email notes */
</script>


<template>
<div class="mt-8 text-center">
        <h2>List Booking</h2>
        <div class="grid grid-cols-1 w-7/12 ml-auto mr-auto drop-shadow">
        <div class="rounded-lg bg-neutral text-white text-center m-10 p-5 drop-shadow-xl" v-for="booking in listBooking" :key="listBooking.id">
            <p>Booking name : {{ booking.bookingName}}</p>
            <p>Event category name : {{booking.category.categoryName}}</p>
            <p>Event start time : {{ booking.startTime}}</p> 
            <p>duration : {{booking.category.duration}} minutes</p>
            <button class="my-2 flex-row btn btn-outline btn-warning btn-xs drop-shadow-xl mr-3">Details...</button>
            <button @click="$emit('remove', { bookingId : booking.id, categoriesId : categories.id})" class="my-2 flex-row btn btn-outline btn-error btn-xs drop-shadow-xl">DELETE</button>
            <br>
        </div>
    </div>
</div>
</template>

<style>
</style>