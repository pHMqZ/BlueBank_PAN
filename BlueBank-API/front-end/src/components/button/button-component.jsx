import React from "react";
import "./button-style.scss";
const Button = ({tipo}) => {

    return(
        <button className="botao"   type ={tipo}>CRIAR CONTA</button>
    );
}

export default Button;