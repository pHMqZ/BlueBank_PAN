
import {ReactComponent as Logo} from '../../assets/logo.svg';



import React from 'react';
import './register-menu-style.scss';


const RegisterMenu = () => (
    <div className="header-component">
        <div className='logo-container'>
            <div>
                <Logo/>
            </div>
        </div>

        <div className="options-controller">
            <div className="option">
                <a href="/home">Home</a>
            </div>

            <div className="option">
                <a href="/login">Login</a>
            </div>
        </div>
    </div>
    



   
);

export default RegisterMenu;