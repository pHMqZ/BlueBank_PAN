import React from "react";
import './sign-up-input-style.scss';


const SignUpInput = ({titulo, icone, tipo}) => {

    
    return(
        <div className="input-container">
                
                <div className="titulo">
                    {titulo}
                </div>
        
                <div className="uniao-container" >
                    <div className="input-field"  >
                        <input type={tipo}  />
                        <img src={icone} className="image" />
                    </div>
                    
                </div>
                
                
            </div>
            )

};

export default SignUpInput;