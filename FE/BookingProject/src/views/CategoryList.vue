<script setup>
import AllCategory from '../components/AllCategory.vue';
import { ref, onBeforeMount } from 'vue'
const url = 'http://intproj21.sit.kmutt.ac.th:80/ssi5/api'
// const url = ' http://202.44.9.103:8080/ssi5/api'
const cat = ref([])

//GET ALL
const getAllListCategory = async () => {
  const res = await fetch(`${url}/category`)
  if (res.status === 200) {
    cat.value = await res.json()
    console.log(cat.value)
  } else console.log('error, cannot get Category List')
}

  getAllListCategory();

</script>
 
<template>
  <AllCategory 
  :allcategory="cat" />
</template>
 
<style>
</style>