import React from "react";
import RegisterMenu from "../../components/register-menu/register-menu-component";
import './login-style.scss';
import SignIn from "../../components/sign-in/sigin-in-component";


const LoginPage = () => {


    return(
        <div className="login-container">
            <div className="register-menu">
                <RegisterMenu/>
            </div>


            <div className="textos-centro">
                <h1> Faça Login<span>.</span></h1>
                <div className="textozinho">Ainda não é cliente? <a href="/home">Cadastre-se</a></div>
            </div>


            <div className="forms">
                <SignIn/>
            </div>
            
        </div>

    );
}

export default LoginPage;