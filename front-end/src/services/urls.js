import axios from "axios";
import BASE_URL from "./bases";
<<<<<<< HEAD
// export default function showClients (){
//     axios.get(`${BASE_URL}usuario/admin/listarUsuarios`)
//         .then(res =>console.log(res))
// }



export default function  createClient (user, password)  {
    axios.post(`${BASE_URL}usuario/cliente/salvar`, {"nome":user,"senha":password})
    .then(res =>console.log(res))
    
}

// export{
//     createClient
// }
=======


 



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
>>>>>>> 63efb025571bc822625c02ee88a4448642df0ddb


