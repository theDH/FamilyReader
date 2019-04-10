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
    }
  ]
})
