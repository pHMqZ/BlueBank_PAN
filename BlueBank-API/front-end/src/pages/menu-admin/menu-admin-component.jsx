import React, {useState, useEffect} from "react";
import MenuLateralAdmin from "../../components/menu-lateral-admin/menu-lateral-admin-component";
import "./menu-admin-style.scss";
import IconeLapis from "../../assets/icone-lapis.png";
import IconeCadeado from "../../assets/icone-cadeado.png";
import SignUpInput from "../../components/sign-up-input/sign-up-input-component";
import {ReactComponent as ProfileCircle} from '../../assets/profile-circle.svg';
import {ReactComponent as InfoCircle} from '../../assets/casa-circle.svg';
import CPF from "../../assets/cpf.png";
import axios from "axios";
import BASE_URL from "../../services/bases";


import {ReactComponent as EyeWhites} from '../../assets/eye-white.svg';
import {ReactComponent as EyeGreys} from '../../assets/eye-grey.svg';
import Button from "../../components/button/button-component";



const MenuAdminPage = () => {
    
    
    
        
        
    const nomeColunas = ['Tipo', 'De/Para', "Data", "Valor"];
    

   const [hideStatus, setHideStatus] = useState({
     
        contaPesquisa:"",
        nome: "",
        contaNum: "",
        cpf: "",
        celular: "",
        email: "",
        bairro: "",
        complemento: "",
        rua: "",
        estado: "",
        cidade: "",
        tableData: [],

       

   });



   


   const {nome, contaNum, cpf, celular, email, bairro,complemento, rua,estado, cidade,contaPesquisa,tableData } = hideStatus;

   useEffect(()=>{
    var auxContaPesquisa ;
    contaPesquisa ? auxContaPesquisa = contaPesquisa : auxContaPesquisa = 1;
    setarConta(auxContaPesquisa);
   
   },[contaPesquisa])

   useEffect(async ()=>{
    var auxContaPesquisa ;
    contaPesquisa ? auxContaPesquisa = contaPesquisa : auxContaPesquisa = 1;
    await axios.put(`${BASE_URL}usuario/admin/editarUser/${auxContaPesquisa}`, {"telefone": celular,"email":email,
    "bairro":bairro, "complemento":complemento, "rua":rua,"estado":estado,"cidade":cidade})
    .then(res=>console.log(res)
    )
   
   },[celular,email,bairro,complemento,rua,estado,cidade])

   


   function setarConta(id){
    var contaAux = "";
    var nomeAux = "";
    const resposta = [];
    
    axios.get(`${BASE_URL}usuario/cliente/historico/${id}`)
        .then(res => {   
            var size = res.data.length-1;
            parseInt(size);
            for(let i = size; i >= 0; i--){
                const item = {"tipo":"", "nome_conta":"", "data_origem":"", "valor":""};
                item.data_origem = res.data[i].data_movimento;
                item.tipo = res.data[i].tipo_movimento;
                item.valor =  res.data[i].valor ;
                item.nome_conta = res.data[i].nome_conta;
                resposta.push(item)
              
            } });

    axios.get(`${BASE_URL}usuario/cliente/conta/${id}`)
    .then(res => {contaAux = res.data.id});

    axios.get(`${BASE_URL}usuario/admin/listarUsuarioId/${id}`)
    .then(res => {nomeAux = res.data.nome });

    axios.get(`${BASE_URL}usuario/admin/listarUsuarioId/${id}`)
    .then(res =>
        
        setHideStatus({...hideStatus,
            cpf: res.data.dado_usuario.cpf ? res.data.dado_usuario.cpf : "...",
            rua: res.data.dado_usuario.rua ? res.data.dado_usuario.rua: "...",
            numero: res.data.dado_usuario.numero ? res.data.dado_usuario.numero : "...",
            complemento: res.data.dado_usuario.complemento ? res.data.dado_usuario.complemento : "...",
            bairro: res.data.dado_usuario.bairro ? res.data.dado_usuario.bairro : "...",
            cidade: res.data.dado_usuario.cidade ? res.data.dado_usuario.cidade : "...",
            estado: res.data.dado_usuario.estado ? res.data.dado_usuario.estado : "...",
            celular: res.data.dado_usuario.telefone ? res.data.dado_usuario.telefone : "...",
            email: res.data.dado_usuario.email ? res.data.dado_usuario.email : "...",
            contaNum: contaAux,
            nome: nomeAux,
            tableData: resposta,

            }
            
        ))
    }


   const handleChanges =(event) => {
    const {name,value} = event.target;
    setHideStatus({...hideStatus, [name]: value});
    
    };

    const handleChangesPesquisa =(event) => {
        const {name,value} = event.target;
        setHideStatus({...hideStatus, [name]: value});
        
        
    };

    

    return(
        
        <div className="menu-admin-page">
            
            <div className="menu-vertical">
                <MenuLateralAdmin/>
            </div>

            <div className="info-admin">
                <div className="info-admin-texto">
                    <h4>Clientes</h4>
                    
                </div>

                <div style={{"marginLeft": "45px"}}>
                    
                        <SignUpInput  
                            onChange={handleChangesPesquisa}
                            titulo="Número de conta:"
                            icone={CPF}
                            name="contaPesquisa"
                            value={contaPesquisa}
                        ></SignUpInput>


                   
                </div>

                <div className="info-admin-dados-pessoais">
                    <div className="container-profile">
                        <div className="profile-circle">
                            <ProfileCircle/>
                        </div>

                        <form>
                        <div className="form-profile">
                        
                                <div className="lado-esquerdo">
                        
                                    <SignUpInput  
                                    onChange={handleChanges}
                                    titulo="Nome:"
                                    icone={IconeCadeado}
                                    name="nome"
                                    value={nome}
                                    disabled
                                    ></SignUpInput>

                                    <SignUpInput
                                    onChange={handleChanges}
                                    titulo="Email:"
                                    icone={IconeLapis}
                                    name="email"
                                    value={email}
                                    ></SignUpInput>

                                    <SignUpInput
                                    onChange={handleChanges}
                                    titulo="CPF:"
                                    icone={IconeCadeado}
                                    name="cpf"
                                    value={cpf}
                                    disabled
                                    ></SignUpInput>
                                </div>
            
                                <div className="lado-direito">
                                    <SignUpInput
                                    titulo="Conta:"
                                    icone={IconeCadeado}
                                    name="contaNum"
                                    value={contaNum}
                                    disabled
                                    ></SignUpInput>

                                    <SignUpInput
                                    onChange={handleChanges}
                                    titulo="Telefone:"
                                    icone={IconeLapis}
                                    value={celular}
                                    name="celular"
                                    ></SignUpInput>
                                </div>
                        </div>
                        </form>
                    </div>

                    
                    <div className="container-info">
                        <div className="profile-circle">
                            <InfoCircle/>
                        </div>

                        <form>
                        <div className="form-profile">
                        
                                <div className="lado-esquerdo">
                        
                                    <SignUpInput  
                                    onChange={handleChanges}
                                    titulo="Bairro:"
                                    icone={IconeLapis}
                                    name="bairro"
                                    value={bairro}
                                    ></SignUpInput>

                                    <SignUpInput
                                    onChange={handleChanges}
                                    titulo="Rua:"
                                    icone={IconeLapis}
                                    name="rua"
                                    value={rua}
                                    ></SignUpInput>

                                    <SignUpInput
                                    onChange={handleChanges}
                                    titulo="Complemento:"
                                    icone={IconeLapis}
                                    name="complemento"
                                    value={complemento}
                                    ></SignUpInput>
                                </div>
            
                                <div className="lado-direito">
                                    <SignUpInput
                                    titulo="Estado:"
                                    icone={IconeLapis}
                                    name="estado"
                                    value={estado}
                                    ></SignUpInput>

                                    <SignUpInput
                                    onChange={handleChanges}
                                    titulo="Cidade:"
                                    icone={IconeLapis}
                                    value={cidade}
                                    name="cidade"
                                    ></SignUpInput>
                                </div>
                        </div>
                        </form>

                    </div>

                </div>

                <div className="info-menu-table-historico" style={{"width": "800px", "height": "390px", "overflow-y": "scroll", "overflow-x": "hidden", "margin-top":"60px","margin-bottom":"60px"}}>
                    <Table list={tableData} colNames={nomeColunas} width="800px"/>
                </div>

            
            </div>

            
        </div>


    );

    

    
     
    

    }

    function Table({list, colNames, width = 'auto', height = 'auto'}){
        return(
            <div>
                <table cellSpacing="0" style={{"width" :width, "height":height}} className="table-historico-2">
                    <thead>
                        <tr>
                            {colNames.map((headerItem, index) => (
                                <th key={index}>
                                    {headerItem}
                                </th>    
                            ))}
                        </tr>
                    </thead>
                    
                    

                        <tbody>
                            {Object.values(list).map((obj, index) => (
                                <tr key={index}>
                                    {Object.values(obj).map((value, index2) => (
                                        <td key={index2}>
                                        {value} 
                                        </td>
                                    ))}
                                </tr>    
                            ))}
                        </tbody>
                    
                    

                </table>
            </div>
        )

    }
  







export default MenuAdminPage;

