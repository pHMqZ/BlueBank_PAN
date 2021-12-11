

import React from 'react';
import RegisterMenu from '../../components/register-menu/register-menu-component';
import './homepage-user-style.scss';
import SignUp from '../../components/sign-up/sign-up-component';
import {ReactComponent as LogoBlue} from '../../assets/logoBlue.svg';


const UserHomePage = () => (
    <div className="container">

        <div className="register-menu">
            <RegisterMenu/>
        </div>
        
        
        <div className="textos-centro">
            <h3>COMECE DE GRAÇA</h3>
            <h1> Abra agora a sua conta<span>.</span></h1>
            <div className="textozinho">Já é cliente? Faça <a href="/login">Log In</a></div>
        </div>

        <div className="forms">
            <SignUp/>
        </div>

        <LogoBlue className="logo-banco"/>
        
    </div>


);

export default UserHomePage;
    





