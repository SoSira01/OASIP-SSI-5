import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/  // base:'/ssi5/'
export default defineConfig({
  plugins: [vue()],
   base: 'http://intproj21.sit.kmutt.ac.th/ssi5/'
 
})
