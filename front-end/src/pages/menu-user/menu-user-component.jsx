import React, {useEffect, useState} from "react";
import "./menu-user-style.scss";
import {ReactComponent as LogoBlue} from '../../assets/logoBlue.svg';
import {ReactComponent as CartaoCredito} from '../../assets/cartao-credito.svg';
import MenuLateral from "../../components/menu-lateral/menu-lateral-component";
import StepFormTransfer from "../../components/step-form/step-form-component";
import MiniTable from "../../components/mini-table/mini-table-component";


import axios from "axios";
import BASE_URL from "../../services/bases";
import { useParams, useNavigate  } from 'react-router-dom';

const MenuUserPage = () => {
    
    let { userId } = useParams();
    
    const [dados, setDados] = useState({
        id: userId,
        nome: "",
        saldo: "",
        data: "",
        valor: "",
        tipo: "",
    });

    const [dadosTabela, setDadosTabela] = useState({
        tableData: [],
    });

    const {id,nome,saldo,data,valor,para} = dados;
    const {tableData} = dadosTabela;

    // function getHistorico(id){
    //     axios.get(`${BASE_URL}usuario/cliente/historico/${id}`)
    //     .then(res => console.log(res.data))
    // }

       useEffect( () =>{
        axios.get(`${BASE_URL}usuario/cliente/conta/${id}`)
        .then(res => 
            setDados({...dados, saldo:  res.data.saldo, nome: res.data.nome }));

        
        mapeiaDadosTabela(id);
        
        




       },[] );

      
   

         function mapeiaDadosTabela(identificacao){
            axios.get(`${BASE_URL}usuario/cliente/historico/${identificacao}`)        
            .then(res => {
                const resposta = [];    
            if(res.data.length >= 1){
                var size = res.data.length-1;
                parseInt(size);
                for(let i = size; i > size-3; i--){
                    const item = {"data_origem": "", "valor":"", "tipo":""};
                    item.data_origem = res.data[i].data_movimento;
                    item.tipo = res.data[i].tipo_movimento;
                    item.valor =  res.data[i].valor ;
                    resposta.push(item)
                  
                }
            }
            
            
            

           
            setDadosTabela({ tableData: resposta });
                 
        })
              
                
             
        }
        
        

        

    return(
<div className="menu-user-page">
        <div className="menu-vertical">
            <MenuLateral id={id}/>
        </div>

        <div className="info-menu">
            <div className="info-menu-texto">
                <h4>Bem vindo, </h4>
                <h4 className="titulo-azul">{nome}</h4>  
            </div>

            <div className="cartao-credito">
                <CartaoCredito/>  

                <div className="texto-saldo">
                    <h6>saldo</h6>
                    <h3>{saldo}</h3>  
                </div>
                
            </div>

            <div className="transferencia">
                <StepFormTransfer id={id} />  
            </div>

            <div className="info-menu-table">
                
                <MiniTable list={tableData} id={id} />   
            </div>

        </div>

        

        


    </div>
    )
    


};

export default MenuUserPage;