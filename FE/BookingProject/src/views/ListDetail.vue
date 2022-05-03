<script setup>
import {useRoute} from 'vue-router'
import {ref } from 'vue'
import ListDetailBooking from '../components/ListDetailBooking.vue'
import { computed } from '@vue/reactivity';
import router from "../router";
const bookdetails = ref({})

let {params} = useRoute() 
console.log(params.BookingId)  

const id = computed(() => params.BookingId)
// const id = ref(params.BookingId) 
console.log(id) 
//GET
const getListBookingById = async () => {
  const res = await fetch(`http://10.4.56.116:8080/api/booking/${id.value}`);
  if (res.status === 200) {
    bookdetails.value = await res.json()
    console.log(bookdetails.value)
  } else console.log('error, cannot get listNotesById')
}

  getListBookingById();

// const deleteId = computed(() => params.deleteBookingId)
//DELETE
const removeEvent = async (deleteId) => {
  const res = await fetch(`http://10.4.56.116:8080/api/booking/${deleteId}` , {
    method: 'DELETE'
  })
  if(res.status === 200){   //ถ้าลบสำเร็จจะต้องให้ข้อมูลนั้นหายออกไปจากหน้าเว็บ
    // bookdetails.value = bookdetails.value.filter((bookdetail) => {
    //   bookdetail.id !== deleteId.value
    //   })
    router.push({name: 'List'})
    console.log("deleted success")
  }else {
    console.log("error, cannot delete data")
  }
}

</script>
 
<template>
  <ListDetailBooking 
  :listDetailBooking="bookdetails"
  @remove="removeEvent"
  />



</template>
 
<style scoped></style>