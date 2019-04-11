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
<<<<<<< HEAD
import Vuetify from 'vuetify'
=======
import AddReadingActivity from '@/components/AddReadingActivity'
>>>>>>> 927efb70c7209775a2cb58b403859b5545f42d8a

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
      path: '/booklist',
      name: 'booklist',
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
    }
  ]
})
