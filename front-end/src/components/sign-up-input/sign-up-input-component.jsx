import React from "react";
import './sign-up-input-style.scss';


<<<<<<< HEAD
const SignUpInput = ({onChange,titulo, icone, tipo, ...otherProps }) => {
=======
const SignUpInput = ({onChange,titulo, icone, tipo,...otherProps }) => {
>>>>>>> 63efb025571bc822625c02ee88a4448642df0ddb

    
    return(
        <div className="input-container">
                
                <div className="titulo">
                    {titulo}
                </div>
        
                <div className="uniao-container" >
                    <div className="input-field"  >
<<<<<<< HEAD
                        <input onChange={onChange} type={tipo} {...otherProps}  />
=======
                        <input autoComplete="off" onChange={onChange} type={tipo} {...otherProps}  />
>>>>>>> 63efb025571bc822625c02ee88a4448642df0ddb
                        <img src={icone} className="image" />
                    </div>
                    
                </div>
                
                
            </div>
            )

};

export default SignUpInput;