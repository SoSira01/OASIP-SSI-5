<script setup>
defineEmits(['remove','details'])

defineProps({
    listBooking : {
        type : Array,
        require : true,
        default: []
    }
})

</script>


<template>
<div class="mt-8 text-center">
        <p class="text-4xl font-semibold">List Booking</p>
        <br>
        <!-- <p>{{noSchedule()}}</p> -->
        <p v-show="listBooking == '' ">No schedule event</p>
        <!-- <p v-if="listBooking == '' ">No schedule event</p> -->
        <div class="grid grid-cols-1 w-7/12 ml-auto mr-auto drop-shadow ">
        <div class="rounded-lg bg-neutral text-white m-10 p-8 drop-shadow-xl text-left" v-for="booking in listBooking" :key="listBooking.id">
    
            <p>Booking name : {{ booking.bookingName}}</p>
            <p>Event category name : {{booking.category.categoryName}}</p>
            <p>Event start time : {{ new Date(booking.startTime).toLocaleString()}}</p> 
            <p>duration : {{booking.category.duration}} minutes</p>
             
           <p class="my-2 flex-row btn btn-outline btn-warning btn-xs drop-shadow-xl mr-3">
                
             <router-link :to="{name: 'ListDetail' , 
               params:{ 
                BookingId: booking.id} 
                }">
                Details
            </router-link></p>
            <button @click="$emit('remove', booking.id)" class="my-2 flex-row btn btn-outline btn-error btn-xs drop-shadow-xl">DELETE</button>
            <br>
        </div>
    </div>

</div>
</template>

<style>
</style>