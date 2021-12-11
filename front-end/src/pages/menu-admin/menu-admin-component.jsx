import React, {useState, useEffect} from "react";
import MenuLateralAdmin from "../../components/menu-lateral-admin/menu-lateral-admin-component";
import "./menu-admin-style.scss";
import EyeHide from "../../components/eye-hide/eye-hide-component";
import EyeWhite from "../../assets/eye-white.png";
import MaterialTable from "material-table";
import tableIcons from "./icon-provider";
import Switch from "@material-ui/core/Switch";
import IconeLapis from "../../assets/icone-lapis.png";
import IconeCadeado from "../../assets/icone-cadeado.png";
import SignUpInput from "../../components/sign-up-input/sign-up-input-component";
import {ReactComponent as ProfileCircle} from '../../assets/profile-circle.svg';
import {ReactComponent as InfoCircle} from '../../assets/casa-circle.svg';


import {ReactComponent as EyeWhites} from '../../assets/eye-white.svg';
import {ReactComponent as EyeGreys} from '../../assets/eye-grey.svg';



const MenuAdminPage = () => {
    const dadosTabela = [
    
        {index:0, nome: "Vinicius Ribeiro", conta: "12", dados: 0, bloqueado: 1},
        {index:1,nome: "Vinicius Ribeiro", conta: "13", dados: 0, bloqueado: 0},
        {index:2,nome: "Vinicius Ribeiro", conta: "14", dados: 0, bloqueado: 0},
        {index:3,nome: "Vinicius Ribeiro", conta: "15", dados: 0, bloqueado: 0},
        {index:4,nome: "Vinicius Ribeiro", conta: "16", dados: 0, bloqueado: 0},
        {index:5,nome: "Vinicius Ribeiro", conta: "17", dados: 0, bloqueado: 0},
        {index:6,nome: "Vinicius Ribeiro", conta: "18", dados: 0, bloqueado: 0},  
        ]
    
    const list = [//
            {tipo: "Recebimento", para: "Vitor Ribeiro", data: "08/11/2021", valor: "R$ 10,00", Saldo: "R$ 3815,00" },
            {tipo: "Transferência", para: "Renato Junior", data: "08/11/2021", valor: "R$ 300,00", Saldo: "R$ 3805,00" },
            {tipo: "Recebimento", para: "Vitor Ribeiro", data: "08/11/2021", valor: "R$ 10,00", Saldo: "R$ 3815,00" },
            {tipo: "Transferência", para: "Renato Junior", data: "08/11/2021", valor: "R$ 300,00", Saldo: "R$ 3805,00" },
            {tipo: "Recebimento", para: "Vitor Ribeiro", data: "08/11/2021", valor: "R$ 10,00", Saldo: "R$ 3815,00" },
            {tipo: "Transferência", para: "Renato Junior", data: "08/11/2021", valor: "R$ 300,00", Saldo: "R$ 3805,00" },
            {tipo: "Recebimento", para: "Vitor Ribeiro", data: "08/11/2021", valor: "R$ 10,00", Saldo: "R$ 3815,00" },
            {tipo: "Transferência", para: "Renato Junior", data: "08/11/2021", valor: "R$ 300,00", Saldo: "R$ 3805,00" },
            
            
    ]
        
        
    const nomeColunas = ['Tipo', 'Para', "Data", "Valor", "Saldo"];
        


   const [hideStatus, setHideStatus] = useState({
       hide: 0,
       conta: "",
       //o hide precisa estar 1 para o id da conta mostrar algo nos compoenntes
       contaBloq: "",
        //fala a conta que esta sendo selecionada
        nome: "",
        contaNum: "",
        cpf: "",
        celular: "",
        email: "",
        bairro: "",
        complemento: "",
        rua: "",
        estado: "",
        cidade: ""

       

   })

   


   const {hide,conta,contaBloq,nome, contaNum, cpf, celular, email, bairro,complemento, rua,estado, cidade } = hideStatus;

   const handleChanges =(event) => {
    const {name,value} = event.target;
    setHideStatus({...hideStatus, [name]: value});
    
};

   useEffect(() =>{
    
    dadosTabela.map(userInfo => {
        if(userInfo.conta === conta){
            userInfo.dados = hide;
        }   
        })
     
    
    dadosTabela.forEach((obj)=>{
        
        if(obj.conta === contaBloq){
            
            if(obj.bloqueado ===1){
                obj.bloqueado = 0;
                
            }else if(obj.bloqueado === 0){
                obj.bloqueado = 1;
               
            }
        }
        
    })

       

       
    });

   const handleChange =(conta) => {
        hide ? setHideStatus({...hideStatus, "hide": 0 , "conta": conta}) : setHideStatus({...hideStatus, "hide": 1 , "conta": conta});
        
    };


    function bloquear(){
            //setHideStatus({...hideStatus, "contaStatusAux": "1"});     
    }

    function desbloquear(){
        //setHideStatus({...hideStatus, "contaStatusAux": "0"});
    }



    const  bloqueio = (event) =>{
        event.target.checked ? bloquear() : desbloquear();
    }

    function  mandarConta(conta){
        setHideStatus({...hideStatus, "contaBloq": conta})
    } 
        
   

    
    

   


    
    const colunas = [
        {title: "Nome", field: "nome"},
        {title: "Conta", field: "conta"},
        {title: "Dados", field: "dados", render: (row) => {  return <> 
        
        <div onClick = {()=>{handleChange(row.conta)}}>      
                {row.dados === 0 && EyeGreyHide()}
                {row.dados === 1 && EyeWhiteShow()}
        </div>
         
        </>}},
        {title: "Bloqueado", field: "bloqueado", render: (row) => {
            return <>
                <div  onClick={() =>{mandarConta(row.conta)}}>
                    <Switch  checked={row.bloqueado} onChange={bloqueio}  />
                </div>
                
            </>
        }}
    
    ]
    
    
    const BasicTable = () => {
        return <MaterialTable  title="Clientes" icons={tableIcons} columns={colunas} data={dadosTabela} />
    }
    


    return(
        
        <div className="menu-admin-page">
            
            <div className="menu-vertical">
                <MenuLateralAdmin/>
            </div>

            <div className="info-admin">
                <div className="info-admin-texto">
                    <h4>Clientes</h4>
                    
                </div>

                <div className="info-menu-table-historico" style={{"width": "800px", "height": "390px" }}>
                    <BasicTable />
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
                                    icone={IconeLapis}
                                    name="nome"
                                    value={nome}
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
                    <Table list={list} colNames={nomeColunas} width="800px"/>
                </div>

            
            </div>

            
        </div>


    );

    function EyeWhiteShow(){ return( 
        <div style={{"cursor": "pointer"}}> 
        <EyeWhites/>
        </div> )}


    function EyeGreyHide(){ return( <div style={{"cursor": "pointer"}} > <EyeGreys/> </div> )}
     
    

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

