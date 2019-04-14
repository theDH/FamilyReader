import Vue from 'vue'
import Router from 'vue-router'
import LoginForm from '@/components/LoginForm'
import SignupForm from '@/components/SignupForm'
import FamilyList from '@/components/FamilyList'
import BookList from '@/components/BookList'
import Button from '@/components/Button'
import PrimaryButton from '@/components/PrimaryButton'
import CompetitionList from '@/components/CompetitionList'
import CompetitionDetail from '@/components/CompetitionDetail'
import GoalList from '@/components/GoalList'
import GoalDetail from '@/components/GoalDetail'
import BookDetail from '@/components/BookDetail'
import AddReadingActivity from '@/components/AddReadingActivity'
import Homepage from '@/components/Homepage'
import AddPerson from '@/components/addPerson'

Vue.use(Router)

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
      path: '/addperson',
      name: 'addperson',
      component: AddPerson
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
      path: '/booklistbyfamily',
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
    },
    {
      path: '/competitiondetail',
      name: 'competitiondetail',
      component: CompetitionDetail
    },
    {
      path: '/homepage',
      name: 'homepage',
      component: Homepage
    }
  ]
})
