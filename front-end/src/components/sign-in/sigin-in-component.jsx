<<<<<<< HEAD
import React from "react";
=======
import React, {useState} from "react";
>>>>>>> 63efb025571bc822625c02ee88a4448642df0ddb
import CPF from '../../assets/cpf.png';
import Senha from '../../assets/senha.png';
import Button from "../button/button-component";
import SignUpInput from "../sign-up-input/sign-up-input-component";
import './sign-in-style.scss';
<<<<<<< HEAD

const SignIn = () => {


    return(

        <form>
            <div className="form-login">
        
            <SignUpInput titulo="CPF:" icone={CPF} tamanho="310px"></SignUpInput>
            <SignUpInput titulo="Senha:" icone={Senha} tipo="password" tamanho="310px"></SignUpInput>            
=======
import axios from "axios";
import BASE_URL from "../../services/bases";
import { useParams, useNavigate  } from 'react-router-dom';




const SignIn = () => {
    const navigate = useNavigate();
    let { userId } = useParams();
   
    const[credentials, setCredentials] = useState({
        conta:"",
        senha: ""

    });

    const {conta,senha} = credentials;

    const handleChange =(event) => {
        const {name,value} = event.target;
        setCredentials({...credentials, [name]: value});
        
    };

    function handleSubmit(event) {
         event.preventDefault();
         if(conta==="12345" && senha==="admin"){
            navigate(`/menu-admin`);
        }else{
            axios.get(`${BASE_URL}usuario/cliente/pegarSenha/${conta}`)
            .then(res => {
               if(res.data === senha){
                   
                   navigate(`/menu-user/${conta}`);
                   
                  
               }  else{
                   alert("Senha incorreta!")
               } 
            })
        }
       
      }

      

    return(

        <form onSubmit={handleSubmit}>
            <div className="form-login">
        
            <SignUpInput  onChange={handleChange} titulo="Conta:" icone={CPF} tamanho="310px" name="conta" value={conta}></SignUpInput>
            <SignUpInput onChange={handleChange} titulo="Senha:" icone={Senha} tipo="password" tamanho="310px" name="senha" value={senha}></SignUpInput>            
>>>>>>> 63efb025571bc822625c02ee88a4448642df0ddb
            
                
                <div className="botao">
                    <Button tipo ="submit" texto="ENTRAR" tamanho="264px"/>
                </div>
            </div>
        </form>
    );
}

export default SignIn;

