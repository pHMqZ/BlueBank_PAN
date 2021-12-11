import React from "react";
import './sign-up-input-style.scss';


const SignUpInput = ({onChange,titulo, icone, tipo, ...otherProps }) => {

    
    return(
        <div className="input-container">
                
                <div className="titulo">
                    {titulo}
                </div>
        
                <div className="uniao-container" >
                    <div className="input-field"  >
                        <input onChange={onChange} type={tipo} {...otherProps}  />
                        <img src={icone} className="image" />
                    </div>
                    
                </div>
                
                
            </div>
            )

};

export default SignUpInput;