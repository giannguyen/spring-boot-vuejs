<template>
  <div>
    <table>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
      </tr>
      <tr v-for="person in people" :key="person.id">
        <td>{{person.id}}</td>
        <td>{{person.name}}</td>
        <td>{{person.age}}</td>
      </tr>
    </table>
  </div>
</template>

<script>

import {getAllPeople} from "@/service/PeopleService";

export default {
  data () {
    return {
      people: []
    }
  },
   created() {
     getAllPeople().then(res=>{
       this.people = res
     })
  }
}
</script>
