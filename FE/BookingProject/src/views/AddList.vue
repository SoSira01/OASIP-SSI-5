<script setup>
import newBooking from '../components/newBooking.vue'
import router from '../router'

// Fetch API POST สำหรับการเพิ่มข้อมูลผู้โกง
const addBooking = async (newBookingEvent) => {
    const res = await fetch('http://10.4.56.116:8080/api/booking', 
    {
        method: "POST",
        headers: { "content-type": "application/json" },
        body: JSON.stringify(newBookingEvent),
    })
    if (res.status === 201) {
        const added = await res.json()
        router.push({name: 'List'})
    } else console.log("cannot add new booking")
}
</script>
 
<template>
    <div>
        <newBooking @AddList="addBooking" />
    </div>
</template>
 
<style>

</style>