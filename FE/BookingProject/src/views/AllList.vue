<!-- <script setup>
import { ref, onBeforeMount } from 'vue'


const Book = ref([])

//GET
const getBookingList = async () => {
  const res = await fetch('http://localhost:8080/api/booking')
  if (res.status === 200) {
    Notes.value = await res.json()
    console.log(Book.value)
  } else console.log('error, cannot get getBookingList')
}

onBeforeMount(() => {
  getBookingList();
})

//GETAllbyid
const getAllBookingList = async () => {
  const res = await fetch('http://localhost:8080/api/booking/'+id)
  if (res.status === 200) {
    Book.value = await res.json()
    console.log(Book.value)
  } else console.log('error, cannot get getBookingList')
}

//DELETE
const removeListBooking = async (id) => {
  const res = await fetch(`http://localhost:5000/booking/${id}`, {
    method: 'DELETE'
  })
  if (res.status === 200) {
    Book.value = Book.value.filter((Booking) => Booking.id !== id)
    console.log('deleted successfullly')
  } else console.log('error, cannot delete')
}
</script>
 
<template>

</template>
 
<style>

</style> -->
<script setup>

</script>
 
<template>

</template>
 
<style scoped>

</style>