import Vue from 'vue'
import Router from 'vue-router'
import LoginForm from '@/components/LoginForm'
import SignupForm from '@/components/SignupForm'
import FamilyList from '@/components/FamilyList'
import BookList from '@/components/BookList'
import Button from '@/components/Button'
import PrimaryButton from '@/components/PrimaryButton'
import CompetitionList from '@/components/CompetitionList'
import GoalList from '@/components/GoalList'
import BookDetail from '@/components/BookDetail'
import GoalDetail from '@/components/GoalDetail'
import Vuetify from 'vuetify'
import AddReadingActivity from '@/components/AddReadingActivity'
import 'vuetify/dist/vuetify.min.css'

Vue.use(Router)
Vue.use(Vuetify)

export default new Router({
  routes: [
    {
      path: '/', redirect: '/login'
    },
    {
      path: '/login',
      name: 'Login',
      component: LoginForm
    },
    {
      path: '/signup',
      name: 'Signup',
      component: SignupForm
    },
    {
      path: '/familylist',
      name: 'familylist',
      component: FamilyList
    },
    {
      path: '/bookList',
      name: 'bookList',
      component: BookList
    },
    {
      path: '/bookListByFamily',
      name: 'bookList',
      component: BookList
    },
    {
      path: '/button',
      name: 'button',
      component: Button
    },
    {
      path: '/primarybutton',
      name: 'primarybutton',
      component: PrimaryButton
    },
    {
      path: '/competitionlist',
      name: 'competitionlist',
      component: CompetitionList
    },
    {
      path: '/goallist',
      name: 'goallist',
      component: GoalList
    },
    {
      path: '/addreadingactivity',
      name: 'addreadingactivity',
      component: AddReadingActivity
    },
    {
      path: '/bookdetail',
      name: 'bookdetail',
      component: BookDetail
    },
    {
      path: '/goaldetail',
      name: 'goaldetail',
      component: GoalDetail
    }
  ]
})
