<template>
  <!-- <div id="app"> -->
    <div>
    <v-app>
      <div id="top">
        <v-card>
        <h1> Welcome to Booknanza!</h1>
          <div id="container">
            <img id="image" src="./components/FamilyPicture.jpg"/>
            <div id="overlay">
              Remember  <a target="_blank" href="https://www.bookitprogram.com/">Book-It</a>? This is like that but without Pizza Hut.
              <br>
              Here, parents are able to track reading progress for themselves and their children. Books can be added by searching for the title, author or ISBN. Booknanza allows parents to track the activity of each child, add/delete goals and family competitions, and create unique prizes.
            </div>
          </div>
        </v-card>
      </div>
      <v-spacer></v-spacer>
      <h3>You are currently viewing: {{ navigation }}</h3>
      <v-content>
        <router-view/>
        <reader-footer></reader-footer>
      </v-content>
    </v-app>
  </div>
</template>

<script>
import EventBus from './components/EventBus'
import ReaderFooter from './components/ReaderFooter'
export default {
  data () {
    return {
      navigation: 'Log In',
      quote: ''
    }
  },
  mounted () {
    EventBus.$on('navEvent', value => {
      this.navigation = value
    })
  },
  components: {
    ReaderFooter
  }
}
</script>

<style>
#image {
opacity: 0.3;
object-fit: cover;
height: 100%;
width: 100%;
}
#container {
position:relative;
height: 250px;
background-size: cover;
}
#overlay {
position: absolute;
top: 50px;
color: black;
padding: 0px 10% 0px 10%;
}
h1 {
padding: 20px;
background-color: white;
font-weight: bold;
}
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
#top{
  background:#f2f2f2;
  background-color:paleturquoise;
  color:black;
  padding:15px;
  font-size:24px;
  text-align: center;
  margin-bottom: 0px;
}
h3{
  background:paleturquoise;
  font-size: 40px;
}
</style>
