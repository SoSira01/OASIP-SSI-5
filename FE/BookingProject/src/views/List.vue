<script setup>
import { ref } from 'vue'
import ListBooking from '../components/ListBooking.vue'

//const url = 'http://intproj21.sit.kmutt.ac.th:80/ssi5/api'
const url = '  http://202.44.9.103:8080/ssi5/api'
const book = ref([])
const category =ref([])
//GET AllBooking
const getListBooking = async () => {
  const res = await fetch(`${url}/booking`)
  if (res.status === 200) {
    book.value = await res.json()
    console.log(book.value)
  } else console.log('error, cannot get listNotes')
}

//DELETE booking
const removeEvent = async (deleteId) => {
  const res = await fetch(`${url}/booking/${deleteId}`, {
    method: 'DELETE'
  })
  if (res.status === 200) {
    book.value = book.value.filter((book) => { return book.id != deleteId })
    // router.push({name: 'List'})
    //console.log("deleted success")
  } else {
    console.log("error, cannot delete data")
  }
}

//GET category
const getAllListCategory = async () => {
  const res = await fetch(`${url}/category`)    
  if (res.status === 200) {
    category.value = await res.json()
    console.log(category.value)
  } else console.log('error, cannot get Category List')
}

//Filter by categoryId
const getFilterCategory = async (filterId) => {
  console.log(filterId)
  if(filterId > 0 ){
      const res = await fetch(`${url}/booking/filter/${filterId}`)

  if (res.status === 200) {
    book.value = await res.json()
    book.value = book.value.filter((book) => {return book.categoryId == filterId})
    console.log(book.value)
  } else console.log('error, cannot get Category List')

  } else getListBooking();
}

getFilterCategory()
getAllListCategory()

</script>
 
<template>
  <ListBooking 
  :listBooking="book"
  :categoryList="category"
  @filter="getFilterCategory"
  @remove="removeEvent" />
</template>
 
<style scoped>
</style>