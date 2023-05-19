<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<style>  
  table { border-collapse: collapse; margin-top: 5px; }
  th, td { border: 1px solid gray; padding: 4px; }
  div#msg { padding: 5px; font-size: 12pt; }
</style>
</head>
<body>

<div id="app">
  <form>  
    <textarea rows="10" cols="100" v-model="jpql"></textarea> <br />
    <button type="button" @click="search">JPQL 실행</button>
  </form>

  <div v-if="error" class="msg">
    {{ error }} <br />
    {{ error?.response?.data?.message }}
  </div>
    
  <table v-if="!error && (typeof list[0] == 'object')">
    <thead>
      <tr>
        <th v-for="(value, key) in list[0]">
          {{ key }}
        </th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="obj in list">
        <td v-for="value in obj">{{ value }}</td>
      </tr>
    </tbody>
  </table>
  
  <ul v-if="!error && (typeof list[0] != 'object')">
     <li v-for="value in list">{{ value }}</li>
  </ul>
  
</div>  

<script type="text/javascript">
  var app = new Vue({
    el: '#app',
    data: {
      jpql: "",
      list: [],
      error: null
    },
    methods: {
      search: function() {
        this.list = null;
        this.error = null;
        var params = { jpql: this.jpql };
        axios.get("execute", { params: params })
             .then( (response) => this.list = response.data )
             .catch( (error) => this.error = error );
      }
    }
  })
</script>
</html>
