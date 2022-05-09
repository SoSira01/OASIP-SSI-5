<script setup>
import { useRouter } from 'vue-router'
const appRouter = useRouter()
const goBack = () => appRouter.go(-1)
defineEmits(['remove','back'])

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
       <div class="rounded-lg bg-warning text-base text-base-100 m-10 p-8 drop-shadow-xl text-left">
        <!--v-for-->
        <p><b>Booking ID :</b> {{listDetailBooking.id}}</p>
        <p><b>bookingName :</b>  {{listDetailBooking.bookingName}}</p>
        <p><b>Email :</b>  {{ listDetailBooking.email}}</p>
        <p><b>categoryName :</b> {{listDetailBooking.categoryName}}</p>
        <p><b>startTime :</b> {{ new Date(listDetailBooking.startTime).toLocaleString()}}</p>
        <p><b>duration :</b> {{listDetailBooking.categoryDuration}} minutes</p>
        <p><b>Note :</b> {{ listDetailBooking.note}}</p>     

        <router-link class="mt-5 flex-row btn btn-xs drop-shadow-xl mr-3" :to="{ name: 'List' }">BACK</router-link>
        <button @click="$emit('remove', listDetailBooking.id)" class="mt-5 flex-row btn btn-error btn-xs drop-shadow-xl">DELETE</button>
       </div>
    </div>
    
</div>


</template>

<style>
</style>