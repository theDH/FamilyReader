// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import './plugins/vuetify'
import App from './App'
import LoginForm from './components/LoginForm'
import './session.js'
import Vuetify from 'vuetify'
import router from './router'
import axios from 'axios'
import 'vuetify/dist/vuetify.min.css'

Vue.use(Vuetify)

// const VueSessionStorage = require('vue-sessionstorage')
Vue.config.productionTip = false
Vue.prototype.$http = axios

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App, LoginForm },
  template: '<App/>'
})
