import axios from "axios";
import BASE_URL from "./bases";
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


