<template>
  <div>
    <form @submit.prevent="login">
      <div>
        <label for="username">Username:</label>
        <input id="username" v-model="username" />
      </div>
      <div>
        <label for="password">Password:</label>
        <input id="password" v-model="password" type="password" />
      </div>
      <button type="submit">Login</button>
    </form>
  </div>
</template>

<script>
import axios from "axios";
import router from "@/router";
export default {
  data() {
    return {
      username: '',
      password: ''
    };
  },
  methods: {
    async login() {
      try {
        const response = await axios.post('/api/public/users/login', {
          username: this.username,
          password: this.password
        });
        localStorage.setItem('username', response.data.username);
        localStorage.setItem('password', this.password);
        localStorage.setItem('role', response.data.role.toLowerCase());
        await router.push({name: 'home'});
        console.log(response.data);
      } catch (error) {
        console.error(error);
      }
    }
  }
};
</script>
