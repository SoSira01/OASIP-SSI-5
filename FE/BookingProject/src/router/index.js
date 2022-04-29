import {createRouter,createWebHistory} from 'vue-router'
import NotFound from '../views/NotFound.vue'
import Home from '../views/Home.vue'
import List from '../views/List.vue'

const history = createWebHistory()
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
        path: '/:catchNotMatchPath(.*)',
        name: 'NotFound',
        component: NotFound
    }
    ]

const router = createRouter({history, routes})
export default router
