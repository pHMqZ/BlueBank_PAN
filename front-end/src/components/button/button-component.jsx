import React from "react";
import "./button-style.scss";
const Button = ({tipo,texto,tamanho}) => {

    return(
        <button style={{"width": `${tamanho}`}} className="botao"   type ={tipo}>{texto}  </button>
    );
}

export default Button;