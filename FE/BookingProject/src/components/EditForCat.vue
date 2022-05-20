<script setup>
import { computed } from "vue"

defineEmits(['edit'])

const props = defineProps({
    editCategory: {
        type: Object,
        default: {}
    }
})



const confirmAction = (editCat, categoryName, duration,categoryDescription) => {
    let confirmAction = confirm(`Do you want to Edit: Name: ${categoryName}  duration: ${duration} Description${categoryDescription}`)
    if (confirmAction) {
        return editCat
    }
}

const editCat = computed(() => { return {categoryName: props.editCategory.categoryName ,categoryDescription: props.editCategory.categoryDescription, duration: props.editCategory.duration} })
console.log(editCat.value)

</script>
 
<template>
<div
        class="mt-20 pt-10 ml-auto mr-auto right-0 left-0 top-4 z-50 flex justify-center items-center md:inset-0 drop-shadow-xl">
        <form class="bg-white rounded-lg px-10 pt-3 pb-8">
            <div class="float-right mt-12">
                <h3 class="text-4xl font-semibold text-base-100 mb-2">Edit Category</h3>
                <p class="text-sm text-neutral pl-3 mb-7">You can edit any category feild that you want.</p>

                <!--Category name-->
                <div class="text-neutral pt-3 pl-5">
                    <label class="block text-base-100 text-sm font-bold mb-3" for="password">Name</label>
                    <input type="text" name="note" id="note" v-model="editCat.categoryName"
                        class="bg-gray-50 border border-gray-300  text-sm rounded-lg block w-full p-2.5">
                </div>

                <!--duration-->
                <div class="text-neutral pt-3 pl-5">
                    <label class="block text-base-100 text-sm font-bold mb-3" for="password">duration</label>
        
                    <input type="number" name="duration" id="duration" v-model="editCat.duration"
                        class="bg-gray-50 border border-gray-300  text-sm rounded-lg block w-full p-2.5" >
                </div>

                <!--description-->
                <div class="text-neutral pt-3 pl-5">
                    <label class="block text-base-100 text-sm font-bold mb-3" for="password">description</label>
                    <input type="text" name="description" id="description" v-model="editCat.categoryDescription"
                        class="bg-gray-50 border border-gray-300 text-sm rounded-lg block w-full p-2.5">
                </div>

                <br>
                <button @click="$emit('edit', confirmAction(editCat, editCategory.categoryName, editCategory.categoryDescription,editCategory.duration), $event)"
                    class="pt-3 pl-5 w-full rounded-lg text-sm px-10 py-2.5 text-center mt-5 btn btn-warning drop-shadow-xl">confirm
                    edit</button>


            </div>
        </form>
    </div>
</template>
 
<style>

</style>