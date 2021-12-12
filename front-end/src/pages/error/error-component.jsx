import React from "react";
import './error-style.scss';
import {ReactComponent as LogoBlue} from '../../assets/logoBlue.svg';

const ErrorPage = () => {

    return(
        <div className="background-cinza">
            
            <LogoBlue className="logo-error"/>

            
            <h1 className="aumentar">404</h1>

            <h3>Alguma coisa deu errado.</h3>
            <h5>Aqui fica a mensagem de erro sobre o que pode ter acontecido</h5>
            <button className="button-error"><span>VOLTAR</span></button>

        </div>
    );
}

export default ErrorPage;