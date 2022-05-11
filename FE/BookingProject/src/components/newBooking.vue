<script setup>

import { ref,computed} from 'vue'

defineEmits(['AddList'])

const props = defineProps({
    categoryDetails : {
        type : Array,
        default: []
    }
})

const newBooking = ref({})

// const forDuration = computed(() => {
//     return newBooking.value
// })
console.log(props.categoryDetails)
// console.log(categoryDetails.category.categoryDuration)
</script>

<template>
    <div>
        <div>
            <div class="pt-10 ml-auto mr-auto right-0 left-0 top-4 z-50 flex justify-center items-center md:inset-0 drop-shadow-xl">
                <img src="/images/add.png" alt="online schedule" class="max-w-2xl">
                <form class="bg-white rounded-lg px-10 pt-10 pb-8 ">
                    <h3 class="text-4xl font-semibold text-base-100 mb-2">Add Event</h3>
                    <p class="text-sm text-neutral pl-3 mb-7">You can book the clinic that you want. </p>
                    
                    <div class=" flex">
                        <div class="flex-1 text-neutral pt-3 pl-5">
                            <label class="block text-base-100 text-sm font-bold mb-3" for="password">Bookingname</label>
                            <input type="text" name="bookingName" id="bookingName" v-model="newBooking.bookingName"
                                class="bg-gray-50 border border-gray-300  text-sm rounded-lg block w-full p-2.5">
                        </div>
                    </div>
                    <div class=" flex">
                    <div class="flex-1 text-neutral pt-3 pl-5">
                        <label class="block text-base-100 text-sm font-bold mb-3" for="category">Event category name</label>
                        <select name="category" id="category" v-model="newBooking.category"
                            class=" select bg-gray-50 border border-gray-300 text-sm rounded-lg block w-full p-2.5 ">
                            <option :value="categoryDetail" v-for="(categoryDetail, index) in categoryDetails" :key="index">
                                {{categoryDetail.categoryName}}
                            </option>
                        </select>
                    </div> 
                                   
                    <div class="flex-1 block text-base-100 text-sm font-bold mb-3">
                        <p v-if="!newBooking.category" class="text-error ml-3 mt-14">* Select a category</p>
                        <p v-else class="ml-3 mt-14 " >Duration : {{newBooking.category.duration}} minutes</p>
                    </div>

                    <div class="flex-1 text-neutral pt-3 pl-5">
                        <label class="block text-base-100 text-sm font-bold mb-3" for="password">Event start time</label>
                        <input type="datetime-local"
                            name="startTime" id="startTime" 
                            v-model="newBooking.startTime"
                            class="bg-gray-50 border border-gray-300 text-sm rounded-lg  block w-full p-2.5">
                    </div>
                    </div>

                    <div class="text-neutral pt-3 pl-5">
                        <label class="block text-base-100 text-sm font-bold mb-3" for="password">Email</label>
                        <input type="text" name="email" id="email" v-model="newBooking.email"
                            class="bg-gray-50 border border-gray-300  text-sm rounded-lg block w-full p-2.5">
                    </div>

                    <div class="text-neutral pt-3 pl-5">
                        <label class="block text-base-100 text-sm font-bold mb-3" for="password">Note</label>
                        <input type="text" name="note" id="note" v-model="newBooking.note"
                            class="bg-gray-50 border border-gray-300  text-sm rounded-lg block w-full p-2.5">
                    </div>
                    
                    <button
                        class="pt-3 pl-5 w-full rounded-lg text-sm px-10 py-2.5 text-center mt-5 btn btn-warning drop-shadow-xl"
                        type="button" data-modal-toggle="add-form" @click="$emit('AddList', newBooking)">
                        Add
                    </button>

                </form>
            </div>
        </div>
    </div>
</template>
 
<style></style>