<script setup>
import {useRoute} from 'vue-router'
import {ref} from 'vue'
import EditBooking from '../components/EditBooking.vue' 
import router from "../router";

//const url = 'http://intproj21.sit.kmutt.ac.th:80/ssi5/api'
const url = '  http://202.44.9.103:8080/ssi5/api'
// //EDIT
const editdetails = ref({});           
// const toEditMode = (editNote) => {    
//  console.log(editNote)
//  editingNote.value = editNote
// }

let {params} = useRoute() 
console.log(params.BookingIdEdit)  

const id = ref(params.BookingIdEdit) 

//PUT (edit)
const editBooking = async (newedit, e) => {   
  e.preventDefault();
  console.log(newedit) 
  const res = await fetch(`${url}/booking/${id.value}` , {
    method : 'PUT', 
    headers : {
      'content-type' : 'application/json'
    },
    body: JSON.stringify({
      id : id.value,
      startTime: new Date(newedit.startTime).toISOString(),
      note: newedit.note,
    }) 
  })
if (res.status === 200) {
    alert('edited success')
    router.push({ name: 'ListDetail' })
  } else console.log("error, cannot be edited");
}

//GETById
const getListBookingById = async () => {
  const res = await fetch(`${url}/booking/${id.value}`);
  if (res.status === 200) {
    editdetails.value = await res.json()
    console.log(editdetails.value)
  } else console.log('error, cannot get editdetails')
}

  getListBookingById();
  
</script>
 
<template>
 <EditBooking
 :editBook="editdetails"
    @edit ="editBooking"
  />
</template>
 
<style>

</style>