<script setup>
import { ref, onBeforeMount } from 'vue'
import ListDetailBooking from '../components/ListDetailBooking.vue'
const book = ref([])

//GET
const getListBookingById = async () => {
  const res = await fetch('http://10.4.56.116:8080/api/booking/'+ {id})
  if (res.status === 200) {
    book.value = await res.json()
    console.log(book.value)
  } else console.log('error, cannot get listNotesById')
}
onBeforeMount(() => {
  getListBooking();
})

</script>
 
<template>
  <ListDetailBooking 
  :listDetailBooking="book"/>
</template>
 
<style scoped></style>