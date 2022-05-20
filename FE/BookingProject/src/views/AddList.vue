<script setup>
import { ref } from 'vue'
import NewBooking from '../components/NewBooking.vue'
import router from '../router'

//const url = 'http://intproj21.sit.kmutt.ac.th:80/ssi5/api'
const url = '  http://202.44.9.103:8080/ssi5/api'

const Categorydetails = ref([])

 function validEmail(email) {
      var re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
      return re.test(email)
    }
// POST 
const addBooking = async (newBookingEvent) => {
    console.log(newBookingEvent)

    if(!validEmail(newBookingEvent.email)){
        alert("Valid email required")
    }

    const res = await fetch(`${url}/booking`,
        {
            method: "POST",
            headers: { "content-type": "application/json" },
            body: JSON.stringify({
                bookingName: newBookingEvent.bookingName,
                startTime: new Date(newBookingEvent.startTime).toISOString(),
                email: newBookingEvent.email,
                note: newBookingEvent.note,
                categoryId: newBookingEvent.category.id
            })
        })
    console.log(await res.json())

    if (res.status === 200) {
        //alert('add new booking complete')
        router.push({ name: 'List' })
    } else {
        alert('Error To Add, Please try again')
        console.log("cannot add new booking")
    }

}
  
const getListCategory = async () => {
    const res = await fetch(`${url}/category`);
    if (res.status === 200) {
        Categorydetails.value = await res.json()
        console.log(Categorydetails.value)
    } else console.log('error, cannot get Categorydetails')
}

getListCategory();

</script>
 
<template>
    <div>
        <NewBooking :categoryDetails="Categorydetails" @AddList="addBooking" />
    </div>
</template>
 
<style>
</style>