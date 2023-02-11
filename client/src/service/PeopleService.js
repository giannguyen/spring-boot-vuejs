import axios_api from "@/config/axios-api";

export async function getAllPeople() {

    const response = await axios_api.get('/api/people');
    return await response.data;
}