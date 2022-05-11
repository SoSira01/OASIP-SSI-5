<script setup>
import { useRouter } from 'vue-router'
import {ref } from 'vue'
const appRouter = useRouter()
defineEmits(['remove','back','edit'])

defineProps({
    listDetailBooking : {
        type : Object,  
        require : true
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
<div>
    <p class="text-4xl font-semibold text-center p-5">Detail List Booking</p>
    <div class="grid grid-cols-1 w-7/12 ml-auto mr-auto drop-shadow ">
       <div class="rounded-lg bg-white text-base text-base-100 m-10 p-8 drop-shadow-xl text-left">
        <!--v-for-->
        <p><b>Booking ID :</b> {{listDetailBooking.id}}</p>
        <p><b>bookingName :</b>  {{listDetailBooking.bookingName}}</p>
        <p><b>Email :</b>  {{ listDetailBooking.email}}</p>
        <p><b>categoryName :</b> {{listDetailBooking.category}}</p>
        <p><b>startTime :</b> {{ new Date(listDetailBooking.startTime).toLocaleString('en-us',{day : 'numeric',month:'short', year:'numeric'})}}</p>        
        <p><b>duration :</b> {{listDetailBooking.categoryDuration}} minutes</p>
        <p><b>Note :</b> {{ listDetailBooking.note}}</p>     

        <router-link class="mt-5 flex-row btn btn-xs drop-shadow-xl mr-3" :to="{ name: 'List' }">BACK</router-link>
        <button @click="$emit('remove', confirmAction(listDetailBooking.id,listDetailBooking.bookingName))" class="mt-5 flex-row btn btn-error btn-xs drop-shadow-xl">DELETE</button>
        <button @click="$emit('edit', listDetailBooking.id)" class="mt-5 flex-row btn btn-error btn-xs drop-shadow-xl">EDIT</button>
       </div>
    </div>
    
</div>

</template>

<style>
</style>