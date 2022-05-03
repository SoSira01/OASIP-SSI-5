<script setup>
defineEmits(['remove','back'])

defineProps({
    listDetailBooking : {
        type : Object,  
        require : true
    }
})

</script>


<template>
<div>
    <p class="text-4xl font-semibold text-center p-5">Detail List Booking</p>
    <div class="grid grid-cols-1 w-7/12 ml-auto mr-auto drop-shadow ">
       <div class="rounded-lg bg-neutral text-white m-10 p-8 drop-shadow-xl text-left">
        <!--v-for-->
        <p>Booking ID : {{listDetailBooking.id}}</p>
        <p>bookingName : {{listDetailBooking.bookingName}}</p>
        <p>Email : {{ listDetailBooking.email}}</p>
        <p>categoryName : {{listDetailBooking.categoryName}}</p>
        <p>startTime : {{ new Date(listDetailBooking.startTime).toLocaleString()}}</p>
        <p>duration : {{listDetailBooking.categoryDuration}} minutes</p>
        <p>Note : {{ listDetailBooking.note}}</p>     

        <router-link class="my-2 flex-row btn btn-outline btn-warning btn-xs drop-shadow-xl mr-3" :to="{ name: 'List' }">BACK</router-link>
        <button @click="$emit('remove', listDetailBooking.id)" class="my-2 flex-row btn btn-outline btn-error btn-xs drop-shadow-xl">DELETE</button>
       </div>
    </div>
    
</div>

</template>

<style>
</style>