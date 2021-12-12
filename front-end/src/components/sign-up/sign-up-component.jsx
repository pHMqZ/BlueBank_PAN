import React, { useState } from "react";
import SignUpInput from "../sign-up-input/sign-up-input-component";
import "./sign-up-style.scss";
import axios from "axios";
import BASE_URL from "../../services/bases";


import Profile from "../../assets/perfil.png";
import Email from "../../assets/Email.png";
import Senha from "../../assets/senha.png";
import Celular from "../../assets/celular.png";
import CPF from "../../assets/cpf.png";
import Button from "../button/button-component";
import funcao from "../../services/urls";
import { useParams, useNavigate  } from 'react-router-dom';

const SignUp = () => {
  const navigate = useNavigate();
  const [userCredentials, setUserCredentials] = useState({
    nome: "",
    email: "",
    password: "",
    confirmPassword: "",
    celular: "",
    cpf: "",
  });

  const {nome, email, password, confirmPassword, celular, cpf } = userCredentials;

  function handleSubmit(event) {
    event.preventDefault();
    funcao.createClient(nome, password, email, celular,cpf)
    .then( resp => {
      
      axios.get(`${BASE_URL}addInscricao/${email}`)
      .then(
          res => {alert(res.data)}
      )

      setUserCredentials({nome: "", email: "", password:"", confirmPassword:"", celular:"", cpf:""})

      navigate(`/menu-user/${resp.data}`);
      
    });
    
     


    

  }

  const handleChange =(event) => {
      const {name,value} = event.target;
      setUserCredentials({...userCredentials, [name]: value});
      
    };

                
  return (
    <form onSubmit={handleSubmit}>
      <div className="form-register">
        <div className="lado-esquerdo">
                
          <SignUpInput
            required
            onChange={handleChange}
            titulo="Nome:"
            icone={Profile}
            name="nome"
            value={nome}
          ></SignUpInput>
          <SignUpInput
            required
            onChange={handleChange}
            titulo="Email:"
            icone={Email}
            name="email"
            value={email}
          ></SignUpInput>
          <SignUpInput
            required
            onChange={handleChange}
            titulo="Senha:"
            icone={Senha}
            name="password"
            tipo="password"
            value={password}
          ></SignUpInput>
        </div>

        <div className="lado-direito">
          <SignUpInput
            required
            onChange={handleChange}
            titulo="Celular:"
            icone={Celular}
            name="celular"
            value={celular}
          ></SignUpInput>
          <SignUpInput
            required
            onChange={handleChange}
            titulo="CPF:"
            icone={CPF}
            value={cpf}
            name="cpf"
          ></SignUpInput>
          <SignUpInput
            required
            onChange={handleChange}
            titulo="Confirmar senha:"
            icone={Senha}
            tipo="password"
            name="confirmPassword"
            value={confirmPassword}
          ></SignUpInput>
        </div>
      </div>
      <div className="botao">
        <Button
          type="submit"
          tipo="submit"
          texto="CRIAR CONTA"
          tamanho="560px"
        />
      </div>
    </form>
  );
};

export default SignUp;
