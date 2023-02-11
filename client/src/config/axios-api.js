import axios from 'axios';

const axios_api = axios.create();

axios_api.interceptors.request.use(config => {
    const username = localStorage.getItem('username');
    const password = localStorage.getItem('password');
    if (username && password) {
        config.headers.Authorization = `Basic ${btoa(`${username}:${password}`)}`;
    }
    return config;
});

export default axios_api;
