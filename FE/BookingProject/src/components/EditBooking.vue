<script setup>
import {computed } from "vue";
defineEmits(['edit'])

const props = defineProps({
    editBook: {
        type: Object,
        require: true
    }
})

const confirmAction = (editBooking, startTime, note) => {
    let confirmAction = confirm(`Do you want to Edit: startTime: ${startTime} Note: ${note}`)
    if (confirmAction) {
        return editBooking
    }
}

const editBooking = computed(() => {return {startTime: String(props.editBook.startTime).substring(0, 16) , note: props.editBook.note}})


</script>
 
<template>
    <div>
    <div
        class="mt-20 pt-1 ml-auto mr-auto right-0 left-0 top-4 z-50 flex justify-center items-center md:inset-0 drop-shadow-xl">
        <form class="bg-white rounded-lg px-10 pt-10 pb-8">
            <img src="/images/edit.png" alt="online schedule" class="max-w-sm float-left m-5 mt-20">
            <div class="float-right mt-5">
                <h3 class="text-4xl font-semibold text-base-100 mb-1">Edit Event</h3>
                <p class="text-sm text-neutral pl-3">You can edit booking clinic that you want.</p>
                <!-- editBook : {{editBook}} -->
                <br>
                <!-- editBooking : {{editBooking}} -->
                <div class=" flex">
                    <div class="flex-1 text-neutral pt-2 pl-5">
                        <p class="block text-base-100 text-sm font-bold mb-3">bookingName :
                            <span>{{ editBook.bookingName }}</span>
                        </p>
                    </div>
                </div>
                    <div class="flex-1 text-neutral pt-2 pl-5">
                        <p class="block text-base-100 text-sm font-bold mb-3">email : 
                            <span>{{ editBook.email }}</span>
                        </p>
                    </div>
                    
                    <div class="flex-1 text-neutral pt-2 pl-5">
                        <p class="block text-base-100 text-sm font-bold mb-3">categoryDescription :
                            <textarea class="w-full mt-2 rounded-lg indent-6" disabled="disabled" rows="3" cols="50">{{ editBook.categoryDescription }}</textarea>
                        </p>
                    </div>
                    <div class="flex-1 text-neutral pt-2 pl-5">
                        <p class="block text-base-100 text-sm font-bold mb-3">categoryDuration :
                            <span>{{ editBook.categoryDuration }}</span></p>
                    </div>

                    <div class="flex-1 text-neutral pt-2 pl-5">
                        <label class="block text-base-100 text-sm font-bold mb-3" for="password">Event start time</label>
                        <input type="datetime-local" name="startTime" id="startTime" v-model="editBooking.startTime"
                            class="bg-gray-50 border border-gray-300 text-sm rounded-lg  block w-full p-2.5">
                    </div>
                
                <div class="flex-1 text-neutral pt-2 pl-5">
                    <label class="block text-base-100 text-sm font-bold mb-3" for="password">Note</label>
                    <span class="block text-xs text-warning">You cannot add more than 500 characters</span>
                    <textarea class="bg-gray-50 border border-gray-300 w-full rounded-lg mt-1 p-2.5" rows="auto" cols="50" name="note" id="note" maxlength="500"
                     v-model="editBooking.note"></textarea>
                </div>

                <br>
                <button
                    @click="$emit('edit', confirmAction(editBooking, editBooking.startTime, editBooking.note), $event)"
                    class="pt-2 pl-5 w-full rounded-lg text-sm px-10 py-2.5 text-center mt-2 btn btn-warning drop-shadow-xl">confirm
                    edit</button>


            </div>
        </form>
    </div>
</div>
</template>
 
<style>
</style>