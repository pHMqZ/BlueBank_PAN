
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
<<<<<<< HEAD
                <a href="/home">Home</a>
=======
                <a href="/">Home</a>
>>>>>>> 63efb025571bc822625c02ee88a4448642df0ddb
            </div>

            <div className="option">
                <a href="/login">Login</a>
            </div>
        </div>
    </div>
    



   
);

export default RegisterMenu;