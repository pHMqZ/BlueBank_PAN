import axios from "axios";
import BASE_URL from "./bases";


 function showClients (){
      axios.get(`${BASE_URL}usuario/admin/listarUsuarios`)
          .then(res =>console.log(res))
 }



 function  createClient (user, password)  {
     axios.post(`${BASE_URL}usuario/cliente/salvar`, {"nome":user,"senha":password})
     .then(res =>console.log(res))
    
 }

 function getSaldoCliente(id){
     axios.get(`${BASE_URL}usuario/cliente/conta/${id}`)
     .then(res => console.log(res))
 }

function getHistorico(id){
    axios.get(`${BASE_URL}usuario/cliente/historico/${id}`)
    .then(res => console.log(res))
}




 export default {showClients,createClient,getSaldoCliente, getHistorico }


