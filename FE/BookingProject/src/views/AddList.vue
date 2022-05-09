<script setup>
import NewBooking from '../components/NewBooking.vue'
import router from '../router'
// const url = 'http://intproj21.sit.kmutt.ac.th:80/ssi5/api'
const url = '  http://202.44.9.103:8080/ssi5/api'
// POST 
const addBooking = async (newBookingEvent) => {
    console.log(newBookingEvent)
    const res = await fetch(`${url}/booking`,
        {
            method: "POST",
            headers: { "content-type": "application/json" },
            body: JSON.stringify({
                bookingName: newBookingEvent.bookingName,
                startTime: new Date(newBookingEvent.startTime).toISOString(),
                email: newBookingEvent.email,
                note: newBookingEvent.category,
                category: {
                    id: newBookingEvent.categoryid
                }
            })
        })
    console.log(await res.json())

    if (res.status === 200) {
        alert('add new booking complete')
        router.push({ name: 'List' })
    } else console.log("cannot add new booking")
}

</script>
 
<template>
    <div>
        <NewBooking @AddList="addBooking" />
    </div>
</template>
 
<style>
</style>