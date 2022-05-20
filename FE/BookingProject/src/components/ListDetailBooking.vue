<script setup>

defineEmits(['remove', 'back', 'edit'])

defineProps({
    listDetailBooking: {
        type: Object,
        require: true
    }
})

const confirmAction = (bookingId, bookingName) => {
    let confirmAction = confirm(`Do you want to delete booking: ${bookingName}`)
    if (confirmAction) {
        return bookingId
    }
}

</script>

<template>
    <div class="mt-20">
        <p class="text-4xl font-semibold text-center text-white mt-8">Detail List Booking</p>
        <div class="grid grid-cols-1 w-7/12 ml-auto mr-auto drop-shadow ">
            <div class="rounded-lg bg-gray-50 text-neutral m-10 p-8 drop-shadow-xl text-left">
                <p><span class="font-bold text-lg text-base-100">Booking name :
                    </span>{{ listDetailBooking.bookingName }} </p>
                <p><span class="font-bold text-lg text-base-100">Email : 
                    </span>{{ listDetailBooking.email }}</p>
                <p><span class="font-bold text-lg text-base-100">Event category name :
                    </span>{{ listDetailBooking.categoryName }} </p>
                <p><span class="font-bold text-lg text-base-100">Event start time : 
                    </span>{{ new Date(listDetailBooking.startTime).toLocaleString('en-US', 
                    { dateStyle: 'full', timeStyle: 'medium' }) }} </p>
                <p><span class="font-bold text-lg text-base-100">Duration :
                    </span>{{ listDetailBooking.categoryDuration }} minutes </p>

                <p v-if = "listDetailBooking.note != null">
                    <p class="font-bold text-lg text-base-100">Note : </p>
                    <textarea class="w-full ml-3 rounded-lg" disabled="disabled" rows="5" cols="50">{{ listDetailBooking.note }}</textarea></p>
                <p v-else><span class="font-bold text-lg text-base-100">Note : </span>No note</p>

                <router-link class="mt-5 btn btn-xs drop-shadow-xl mr-3" :to="{ name: 'List' }">BACK</router-link>
                <router-link class="mt-5 flex-row btn btn-base-100 btn-xs drop-shadow-xl mr-3" :to="{
                    name: 'Edit',
                    params: {
                        BookingIdEdit: listDetailBooking.id
                    }
                }">
                    Edit
                </router-link>
                <button @click="$emit('remove', confirmAction(listDetailBooking.id, listDetailBooking.bookingName))"
                    class="mt-5 flex-row btn btn-outline btn-error btn-xs drop-shadow-xl">DELETE</button>

            </div>
        </div>
    </div>

</template>

<style>
</style>