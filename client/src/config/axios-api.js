import axios from 'axios';

const axios_api = axios.create();

axios_api.interceptors.request.use(config => {
    const loginTime = localStorage.getItem('loginTime');
    const currentTime = new Date().getTime();
    const sessionTimeout = 15 * 60 * 1000; // 15 minutes in milliseconds
    console.log(loginTime)
    if (loginTime && currentTime - loginTime > sessionTimeout) {
        // Log out the user if the session has expired
        localStorage.clear();
        window.location.href = '/logout';
    }
    const username = localStorage.getItem('username');
    const password = localStorage.getItem('password');
    if (username && password) {
        config.headers.Authorization = `Basic ${btoa(`${username}:${password}`)}`;
    }
    return config;
});

export default axios_api;
