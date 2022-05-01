<!-- <script setup>
import { ref, onBeforeMount } from 'vue'
import ListBooking from '../components/ListBooking.vue'
const book = ref([])
//GET
const getListBooking = async () => {
  const res = await fetch('http://localhost:8080/api/booking')
  if (res.status === 200) {
    book.value = await res.json()
    console.log(book.value)
  } else console.log('error, cannot get booking')
}
onBeforeMount(() => {
  getListBooking();
})
</script>
 
<template>
  <ListBooking 
  :ListBooking="book"/>

  <p>This is List</p>
</template>
 
<style scoped>

</style> -->

<script>
import BookingDataService from '../service/BookingService.js'
export default {
    name: 'booking',
    data() {
        return {
            booking: []
        }
    },
    methods: {
        retrieveBooking() {
            BookingDataService.retrieveAllBooking()
                .then(response => {
                    this.booking = response.data
                })
                .catch(e => {
                    alert(e)
                })
        }
    },
    mounted() {
        this.retrieveBooking()
    }
}

</script>

<template>
    <div>
        <table class="table">
            <thead>
                <tr>
                <th scope="col"> id</th>
                <th scope="col">bookingName</th>
                <th scope="col">startTime</th>
                <th scope="col">email</th>
                <th scope="col">note</th>
                </tr>
            </thead>
            <tbody v-for="(book, index) in booking" :key="index">
                <tr>
                    <td>{{book.id}}</td>
                    <td>{{book.bookingName}}</td>
                    <td>{{book.startTime}}</td>
                    <td>{{book.email}}</td>
                    <td>{{book.note}}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>
<style>
</style>