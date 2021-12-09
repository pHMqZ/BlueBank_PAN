import React, {useEffect, useState} from "react";
import "./menu-user-style.scss";
import {ReactComponent as LogoBlue} from '../../assets/logoBlue.svg';
import {ReactComponent as CartaoCredito} from '../../assets/cartao-credito.svg';
import MenuLateral from "../../components/menu-lateral/menu-lateral-component";
import StepFormTransfer from "../../components/step-form/step-form-component";
import MiniTable from "../../components/mini-table/mini-table-component";
import funcao from "../../services/urls";
import { MenuItem } from "@material-ui/core";
import axios from "axios";
import BASE_URL from "../../services/bases";

const MenuUserPage = () => {
    
    
    
    const [dados, setDados] = useState({
        id: 2,
        dadosTabela: "",
        nome: "",
        saldo: "",
        data: "",
        valor: "",
        para: "",



    });

    const {id,nome,saldo,data,valor,para, dadosTabela} = dados;

    function getHistorico(id){
        axios.get(`${BASE_URL}usuario/cliente/historico/${id}`)
        .then(res => console.log(res.data))
    }

    //   useEffect(async () =>{
    //      const dadosConta = await getSaldoCliente(id);
    //      const saldoAtual = dadosConta["saldo"];
    //      setDados({...dados, saldo:  saldoAtual });
    //   });


    //  async function pegaSaldo(){
    //      const dadosConta = await getSaldoCliente(id);
    //      console.log(dadosConta);
    //      const saldoAtual = dadosConta["saldo"];
    //      setDados({...dados, saldo:saldoAtual });
    //  }

        function mapeiaDadosTabela(){
            const respostaTabela = getHistorico(id);
            console.log(respostaTabela);
        }

        mapeiaDadosTabela();

    return(
<div className="menu-user-page">
        <div className="menu-vertical">
            <MenuLateral/>
        </div>

        <div className="info-menu">
            <div className="info-menu-texto">
                <h4>Bem vindo, </h4>
                <h4 className="titulo-azul">Vinicius Trindade!</h4>  
            </div>

            <div className="cartao-credito">
                <CartaoCredito/>  

                <div className="texto-saldo">
                    <h6>saldo</h6>
                    <h3>3900</h3>  
                </div>
                
            </div>

            <div className="transferencia">
                <StepFormTransfer/>  
            </div>

            <div className="info-menu-table">
                <MiniTable list={dadosTabela} />   
            </div>

        </div>

        

        


    </div>
    )
    


};

export default MenuUserPage;