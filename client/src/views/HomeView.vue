<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <p>{{username}}</p>
  </div>
</template>

<script>
// @ is an alias to /src

export default {
  name: 'HomeView',
  data() {
    return {
      username: '',
    };
  },
  mounted() {
    this.username = localStorage.getItem("username");
  }
}
</script>
