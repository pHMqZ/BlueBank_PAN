import React from "react";
import SignUpInput from "../sign-up-input/sign-up-input-component";
import './sign-up-style.scss';

import Profile from '../../assets/perfil.png';
import Email from '../../assets/Email.png';
import Senha from '../../assets/senha.png';
import Celular from '../../assets/celular.png';
import CPF from '../../assets/cpf.png';
import Button from "../button/button-component";




const SignUp = () => (
    <form>
    <div className="form-register">
        
            
                <div className="lado-esquerdo">
                        <SignUpInput titulo="Nome:" icone={Profile} ></SignUpInput>
                        <SignUpInput titulo="Email:" icone={Email} ></SignUpInput>
                        <SignUpInput titulo="Senha:" icone={Senha} tipo="password"></SignUpInput>
                </div>

                <div className="lado-direito">
                        <SignUpInput titulo="Celular:" icone={Celular} ></SignUpInput>
                        <SignUpInput titulo="CPF:" icone={CPF} ></SignUpInput>
                        <SignUpInput titulo="Confirmar senha:" icone={Senha} tipo="password"></SignUpInput>
                </div>

                
    </div>
                <div className="botao">
                        <Button tipo ="submit" texto="CRIAR CONTA" tamanho="560px"/>
                </div>
    </form>
);

export default SignUp;