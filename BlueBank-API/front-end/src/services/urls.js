import axios from "axios";
import BASE_URL from "./bases";


 function showClients (){
      axios.get(`${BASE_URL}usuario/admin/listarUsuarios`)
          .then(res =>console.log(res))
 }



 async function  createClient (user, password, email,celular,cpf)  {
     var idConsulta;
     await axios.post(`${BASE_URL}usuario/cliente/salvar`, {"nome":user,"senha":password})
     .then(res =>console.log(res));

    await axios.get(`${BASE_URL}usuario/cliente/pegarIds`)
    .then(res => {
        idConsulta = res
    });

    
     await axios.put(`${BASE_URL}usuario/admin/editarUser/${idConsulta.data}`, {"telefone": celular,"email":email,
     "cpf":cpf})
     .then(res =>console.log(res));

     //DadoUsuario(String, String, int, String, String, String, String, int, String)
 
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


