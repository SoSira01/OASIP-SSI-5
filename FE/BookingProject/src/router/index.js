import {createRouter,createWebHistory} from 'vue-router'

import AllList from '../views/AllList.vue'
import Home from '../views/Home.vue'

//import Detail from '../views/Detail.vue'

const history = createWebHistory()

const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/AllList',
        name: 'AllList',
        component: AllList
    }
    // ,{
    //     path: '/Detail',
    //     name: 'Detail',
    //     component: Detail
    // }
    ]

const router = createRouter({history, routes})
export default router
