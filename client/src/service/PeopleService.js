import axios from "axios";

export async function getAllPeople() {

    const response = await axios.get('/api/people');
    return await response.data;
}