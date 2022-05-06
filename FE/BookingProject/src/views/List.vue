<script setup>
import { ref, onBeforeMount,computed } from 'vue'
import ListBooking from '../components/ListBooking.vue'
const book = ref([])
// const bookingComputed = computed(() => {
//   book.value
// })
// console.log(book)
// console.log(bookingComputed)


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

const removeEvent = async (deleteId) => {
  const res = await fetch(`http://10.4.56.116:8080/api/booking/${deleteId}` , {
    method: 'DELETE'
  })
  if(res.status === 200){   //ถ้าลบสำเร็จจะต้องให้ข้อมูลนั้นหายออกไปจากหน้าเว็บ
    book.value = book.value.filter((book) => { return book.id != deleteId })
    // router.push({name: 'List'})
    console.log("deleted success")
  }else {
    console.log("error, cannot delete data")
  }
}
</script>
 
<template>
  <ListBooking 
  :listBooking="book"
  @remove="removeEvent"
  />
</template>
 
<style scoped></style>