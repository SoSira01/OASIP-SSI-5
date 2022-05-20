<script setup>
import {ref} from "vue"
defineEmits(['remove', 'details','filter'])

 const prop = defineProps({
    listBooking: {
        type: Array,
        require: true,
        default: []
    },
   categoryList:{
        type: Array,
        require: true,
        default: []
    }
 })

const confirmAction = (bookingId, bookingName) => {
    let confirmAction = confirm(`Do you want to delete booking: ${bookingName}`)
    if (confirmAction) {
        return bookingId
    }
}

const filterCategory = ref({})

</script>

<template>
    <div class="mt-20">
        <p class="text-4xl font-semibold text-white text-center">List Booking</p>
        <br>
        <!--filter category-->
        <div class="flex-1 text-neutral pt-3 pl-5 w-64 float-left ml-10">
            <label class="block text-white text-sm font-bold mb-3 w-64 float-left" for="category">Find by category</label>

            <select name="category" id="category" v-model="filterCategory"
                class=" select bg-gray-50 border border-gray-300 text-sm rounded-lg block w-full p-2.5 ">
                <option :value="cat" v-for= "(cat, index) in categoryList" :key="index">
                {{ cat.categoryName }}  </option>
            </select>
            <button @click="$emit('filter',filterCategory.id == 0)" class="my-2 flex-row btn btn-outline btn-warning btn-xs drop-shadow-xl mr-3 mt-5"> Reset</button>
            <button @click="$emit('filter',filterCategory.id)" class="my-2 flex-row btn btn-outline btn-white btn-xs drop-shadow-xl mt-5">Search</button>

        </div>

        <div class="grid grid-cols-1 w-7/12 ml-auto mr-auto">
            <div v-if="listBooking == ''" class="text-center mt-4 ">
                <span class="text-sm">No Scheduled Events</span>
            </div>
            <div v-else class=" rounded-lg bg-gray-50 text-neutral m-5 p-8 drop-shadow-xl text-left"
                v-for="(booking, index) in listBooking" :key="index">
                <p><span class="font-bold text-lg m-2 text-base-100">Booking name : </span>{{ booking.bookingName }}</p>
                <p><span class="font-bold text-lg m-2 text-base-100">Event category name :
                    </span>{{ booking.categoryName }}</p>
                <p><span class="font-bold text-lg m-2 text-base-100">Event start time : </span>{{ new
                        Date(booking.startTime).toLocaleString('en-US', { dateStyle: 'full', timeStyle: 'medium' })
                }}</p>
                <p><span class="font-bold text-lg m-2 text-base-100">Duration : </span>{{ booking.categoryDuration }}
                    minutes</p>
                <p class="mt-5 flex-row btn btn-neutral btn-xs drop-shadow-xl mr-3 ml-2">

                    <router-link :to="{
                        name: 'ListDetail',
                        params: {
                            BookingId: booking.id
                        }
                    }">
                        Details
                    </router-link>
                </p>
                <button @click="$emit('remove', confirmAction(booking.id, booking.bookingName))"
                    class="my-2 flex-row btn btn-outline btn-error btn-xs drop-shadow-xl">DELETE</button>
                <br>
            </div>
        </div>

    </div>
</template>

<style>
</style>