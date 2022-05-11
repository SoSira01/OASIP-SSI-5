import {createRouter,createWebHistory} from 'vue-router'
import NotFound from '../views/NotFound.vue'
import Home from '../views/Home.vue'
import List from '../views/List.vue'
import ListDetail from '../views/ListDetail.vue'
import AddList from '../views/AddList.vue'
import AboutUs from '../views/AboutUs.vue'
import Edit from '../views/Edit.vue'

const history = createWebHistory('/ssi5/')
const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/List',
        name: 'List',
        component: List
    },
    {
        path: '/List/:BookingId',
        name: 'ListDetail',
        component: ListDetail
    },
    {
        path: '/AddList',
        name: 'AddList',
        component: AddList
    },
    {
        path: '/edit/:BookingId',
        name: 'Edit',
        component: Edit
    },
    {
        path: '/AboutUs',
        name: 'AboutUs',
        component: AboutUs
    },
    {
        path: '/:catchNotMatchPath(.*)',
        name: 'NotFound',
        component: NotFound
    }
    ]

const router = createRouter({history, routes})
export default router
