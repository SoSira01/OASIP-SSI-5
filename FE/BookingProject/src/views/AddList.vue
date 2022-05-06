<script setup>
import NewBooking from '../components/NewBooking.vue'
import router from '../router'

// Fetch API POST สำหรับการเพิ่มข้อมูลผู้โกง
const addBooking = async (newBookingEvent) => {
    console.log(newBookingEvent)
    const res = await fetch('http://10.4.56.116:8080/api/booking', 
    {
        method: "POST",
        headers: { "content-type": "application/json" },
        body: JSON.stringify({
            id: newBookingEvent.id,
            bookingName: newBookingEvent.bookingName,
            startTime: newBookingEvent.startTime, 
            email: newBookingEvent.email, 
            note:  newBookingEvent.note,
            category: {
                id: newBookingEvent.category.id
                }
            })
    })
    console.log(await res.json())
    if (res.status === 201) {
        // const added = await res.json()
        alert('add new booking complete')
        router.push({name: 'List'})
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