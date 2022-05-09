<script setup>
import {useRoute} from 'vue-router'
import { ref } from 'vue'
import ListDetailBooking from '../components/ListDetailBooking.vue'
import router from "../router";
// const url = 'http://intproj21.sit.kmutt.ac.th:80/ssi5/api'
const url = 'http://202.44.9.103:8080/ssi5/api'

const bookdetails = ref({})

let {params} = useRoute() 
console.log(params.BookingId)  

const id = ref(params.BookingId) 

//GET
const getListBookingById = async () => {
  const res = await fetch(`${url}/booking/${id.value}`);
  if (res.status === 200) {
    bookdetails.value = await res.json()
    console.log(bookdetails.value)
  } else console.log('error, cannot get listNotesById')
}

  getListBookingById();

//DELETE
const removeEvent = async (deleteId) => {
  const res = await fetch(`${url}/api/booking/${deleteId}` , {
    method: 'DELETE'
  })
  if(res.status === 200){   
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