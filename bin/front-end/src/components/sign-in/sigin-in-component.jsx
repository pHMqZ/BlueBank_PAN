import React from "react";
import CPF from '../../assets/cpf.png';
import Senha from '../../assets/senha.png';
import Button from "../button/button-component";
import SignUpInput from "../sign-up-input/sign-up-input-component";
import './sign-in-style.scss';

const SignIn = () => {


    return(

        <form>
            <div className="form-login">
        
            <SignUpInput titulo="CPF:" icone={CPF} tamanho="310px"></SignUpInput>
            <SignUpInput titulo="Senha:" icone={Senha} tipo="password" tamanho="310px"></SignUpInput>            
            
                
                <div className="botao">
                    <Button tipo ="submit" texto="ENTRAR" tamanho="264px"/>
                </div>
            </div>
        </form>
    );
}

export default SignIn;

