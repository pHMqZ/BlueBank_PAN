import axios from "axios";
import BASE_URL from "./bases";


 



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

    return idConsulta;

     
 
 }

 




 export default {createClient}


