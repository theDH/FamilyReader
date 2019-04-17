<template>
  <div id="app">
    <v-app>
      <div id="top">
        <v-card
        title="Happy"
        overlay
        img-src="./components/FamilyPicture.jpg"
        text-variant="white"
        >
          <v-card-text>
            Remember<a target="_blank" href="https://www.bookitprogram.com/">Book-It</a>? This is like that but without Pizza Hut.
            <br>This application creates fun ways to manage and encourage reading within the family.Using Booknanza, parents are able to track both their own reading progress and that of their child.Books can be added by searching for the title, author or ISBN. Prizes can be set by the parents that can be accessed by the children upon completing a reading goal. In addition to individual reading activities, parents can set up family competitions to encourage group progress. Booknanza allows parents to track the activity of each child, add/delete goals and competitions, and create unique prizes.
          </v-card-text>
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
img {
opacity: 0.5;
filter: alpha(opacity=50);
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
  color:#4b86A6;
  padding:10px;
  font-size:24px;
  text-align: center;
  margin-bottom: 0px;
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
}
h3{
  background:paleturquoise;
  font-size: 40px;
}
</style>
