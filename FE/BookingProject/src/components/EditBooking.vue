<script setup>
import { computed} from "vue"
defineEmits(['edit'])

const props = defineProps({
    editBook : {
        type : Object,
        default: {}
    }
})

const confirmAction = (editBooking,startTime,note) => {
    let confirmAction =  confirm( `Do you want to Edit: startTime: ${startTime} Note: ${note}`)
    if(confirmAction) {
        return editBooking
    }
}

const editBooking = computed(() => {return {startTime:new Date( props.editBook.startTime).toISOString().substring(0, 16), note: props.editBook.note}})
// console.log(editBooking.value)

</script>
 
<template>
<div class="pt-10 ml-auto mr-auto right-0 left-0 top-4 z-50 flex justify-center items-center md:inset-0 drop-shadow-xl">
    <form class="bg-white rounded-lg px-10 pt-10 pb-8">
        <img src="/images/edit.png" alt="online schedule" class="max-w-lg float-left m-5">
        <div class="float-right mt-12">
            <h3 class="text-4xl font-semibold text-base-100 mb-2">Edit Event</h3>
            <p class="text-sm text-neutral pl-3 mb-7">You can edit booking clinic that you want.</p>
            <div class=" flex">
                    <div class="flex-1 text-neutral pt-3 pl-5">
                        <label class="block text-base-100 text-sm font-bold mb-3" for="password">Event start time</label>
                        <input type="datetime-local"
                            name="startTime" id="startTime" 
                            v-model="editBooking.startTime"
                            class="bg-gray-50 border border-gray-300 text-sm rounded-lg  block w-full p-2.5">
                    </div>
            </div>
                    <div class="text-neutral pt-3 pl-5">
                        <label class="block text-base-100 text-sm font-bold mb-3" for="password">Note</label>
                        <input type="text" name="note" id="note" v-model="editBooking.note"
                            class="bg-gray-50 border border-gray-300  text-sm rounded-lg block w-full p-2.5">
                    </div>
            
                    <br>
                    <button @click="$emit('edit',confirmAction(editBooking,editBooking.startTime,editBooking.note), $event)" class="pt-3 pl-5 w-full rounded-lg text-sm px-10 py-2.5 text-center mt-5 btn btn-warning drop-shadow-xl">confirm edit</button>

                    
        </div>
    </form>
</div>
</template>
 
<style>

</style>