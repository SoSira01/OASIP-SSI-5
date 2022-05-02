<script setup>
import { ref, onBeforeMount } from 'vue'
import ListBooking from '../components/ListBooking.vue'
const book = ref([])
//GET
const getListBooking = async () => {
  const res = await fetch('http://10.4.56.116:8080/api/booking')
  if (res.status === 200) {
    book.value = await res.json()
    console.log(book.value)
  } else console.log('error, cannot get listNotes')
}
onBeforeMount(() => {
  getListBooking();
})
</script>
 
<template>
  <ListBooking 
  :ListBooking="book"/>
</template>
 
<style scoped></style>