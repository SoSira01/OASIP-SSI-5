<script setup>
defineEmits(['remove','details'])

defineProps({
    listBooking : {
        type : Array,
        require : true,
        default: []
    }
})

const confirmAction = (bookingId,bookingName) => {
    let confirmAction =  confirm(`Do you want to delete booking: ${bookingName}`)
    if(confirmAction) {
        return bookingId
    }
}

</script>

<template>
<div class="mt-8 text-center">
        <p class="text-4xl font-semibold">List Booking</p>
        <br>
        <!-- <p>{{noSchedule()}}</p> -->
        <p v-show="listBooking == ''">No schedule event</p>
        <!-- <p v-if="listBooking == '' ">No schedule event</p> -->
    <div class="grid grid-cols-1 w-7/12 ml-auto mr-auto">
        <div class="rounded-lg bg-warning text-neutral m-10 p-8 drop-shadow-xl text-left text-base" v-for="booking in listBooking" :key="listBooking.id">
    
            <p><b>Booking name : </b> {{ booking.bookingName}}</p>
            <p><b>Event category name :</b>  {{booking.category.categoryName}}</p>
            <p><b>Event start time : </b> {{ new Date(booking.startTime).toLocaleString()}}</p> 
            <p><b>duration : </b> {{booking.category.duration}} minutes</p>
             
           <p class="my-2 flex-row btn btn-xs drop-shadow-xl mr-3">
                
             <router-link :to="{name: 'ListDetail' , 
               params:{ 
                BookingId: booking.id} 
                }">
                Details
            </router-link></p>
            <button @click="$emit('remove', confirmAction(booking.id,booking.bookingName))" class="my-2 flex-row btn btn-outline btn-error btn-xs drop-shadow-xl">DELETE</button>
            <br>
        </div>
    </div>

</div>
</template>

<style>
</style>