<script setup>
import { ref } from 'vue'

defineEmits(['AddList'])

const newBooking = ref({id: 0, bookingName:'',startTime:'',email:'',note:'',category:{id:0}})

console.log(newBooking)
</script>
 

<template>
 <div> <!--eventCategory(dropdown), bookingName(tex), bookingEmail(text), eventStartTime(?), eventNotes(text)-->
        <div>
        <div class="pt-20 right-0 left-0 top-4 z-50 flex justify-center items-center md:inset-0">
            <form class="bg-white rounded-2xl px-6 pt-6 pb-8 w-1/2">
                <h3 class="text-3xl font-black text-gray-900"></h3>
                <p class="text-base font-medium text-gray-500"></p>
                <div class="flex">
                    <div class="flex-1 text-gray-700 pt-3">
                        <label class="block text-gray-700 text-sm font-bold mb-2" for="password">id</label>
                        <input type="number" name="id" id="id" placeholder="id"
                            v-model="newBooking.id"
                            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-2xl focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5">
                    </div>
                    <div class="flex-1 text-gray-700 pt-3 pl-5">
                        <label class="block text-gray-700 text-sm font-bold mb-2" for="password">name</label>
                        <input type="text" name="bookingName" id="bookingName" placeholder="name"
                            v-model="newBooking.bookingName"
                            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-2xl focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5">
                    </div>
                    <div class="flex-1 text-gray-700 pt-3 pl-5">
                        <label class="block text-gray-700 text-sm font-bold mb-2" for="password">startTime</label>
                        <input type="datetime-local" name="startTime" id="startTime" placeholder="startTime"
                            v-model="newBooking.startTime"
                            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-2xl focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5">
                    </div>
                    <div class="flex-1 text-gray-700 pt-3 pl-5">
                        <label class="block text-gray-700 text-sm font-bold mb-2" for="password">Email</label>
                        <input type="text" name="email" id="email" placeholder="email"
                            v-model="newBooking.email"
                            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-2xl focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5">
                    </div>
                    <div class="flex-1 text-gray-700 pt-3 pl-5">
                        <label class="block text-gray-700 text-sm font-bold mb-2" for="password">Note</label>
                        <input type="text" name="note" id="note" placeholder="note"
                            v-model="newBooking.note"
                            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-2xl focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5">
                    </div>
                    <div class="pt-3">
                    <label class="block text-gray-700 text-sm font-bold mb-2" for="category">category</label>
                    <select name="category" id="category" placeholder="category" v-model="newBooking.category.id"
                        class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-2xl focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5">
                        <option value="1">Project Management Clinic</option>
                        <option value="2">DevOps/Infra Clinic</option>
                        <option value="3">Database Clinic</option>
                    </select>
                    </div>
                    </div>
                    <button
                                class="w-full text-white bg-red-400 hover:bg-red-800 focus:ring-4 focus:ring-gray-200 font-medium rounded-lg text-sm px-5 py-2.5 text-center"
                                type="button" data-modal-toggle="add-form"
                                @click="$emit('AddList', newBooking)">
                                add new
                            </button>
                
                </form>
                </div>
  </div>
</div>
</template>
 
<style>

</style>