import React, {useEffect, useState} from "react";
import './step-form-style.scss';
import {ReactComponent as ImagemUm} from '../../assets/imagem1-form.svg';
import {ReactComponent as ImagemDois} from '../../assets/imagem2-form.svg';
import {ReactComponent as ImagemTres} from '../../assets/imagem-form3.svg';
import IconeConta from '../../assets/icone-conta.png'
import IconeValor from '../../assets/icone-valor.png'
import SignUpInput from "../sign-up-input/sign-up-input-component";
import Button from "../button/button-component";
import Senha from "../../assets/senha.png";
import axios from "axios";
import BASE_URL from "../../services/bases";


const StepFormTransfer = ({id}) =>{
    const [page, setPage] = useState({
        "pagina": 1,
        "conta": "",
        "valor": "",
        "senha": "",
        "confirmarSenha": "",
        "nomeDestino": "",
    });

    const {pagina, conta, valor, senha, confirmarSenha,nomeDestino} = page;


    function handleSubmit(event) {
        event.preventDefault();
        axios.get(`${BASE_URL}usuario/cliente/conta/${conta}`)
        .then(res => 
            setPage({...page, "pagina": pagina + 1, nomeDestino: res.data.nome }));

        //setPage({...page, "pagina": pagina + 1});   
      }
    

    const handleChange =(event) => {
        const {name,value} = event.target;
        setPage({...page, [name]: value});
      };

      function voltar() {
        setPage({...page, "pagina": pagina - 1});   
      }

      useEffect(()=>{
        
      })

      function transferirDinheiro(event){
        event.preventDefault();
        console.log("cheguei aqui");
        
          if(confirmarSenha === senha){
            axios.get(`${BASE_URL}usuario/cliente/pegarSenha/${id}`)
            .then(res => {
                
                if(res.data === senha){
                    
                    var valorEmDouble =  parseFloat(valor);
                    axios.post(`${BASE_URL}usuario/cliente/transferir/${id}/${conta}/${valorEmDouble}`).
                    then( resp => setPage({...page,"pagina": 1, "conta": "", "valor": "", "senha":"", "confirmarSenha": "", "nomeDestino": "" }))   
                }
            })

            setTimeout( ()=>{window.location.reload()}, 1000);
            
          }else{
              alert("Senhas não batem!")
          }
      }

    


    return (
        <div className="step-form-transferir">
            <h5>Transferir</h5>
            <div className="imagem-formulario">
                {pagina === 1 && <ImagemFormUm/>}
                {pagina === 2 && <ImagemFormDois/>}
                {pagina === 3 && <ImagemFormTres/>}
            </div>

            <div className="campos-form">
                {pagina === 1 && DadosBasicos(handleChange)}
                {pagina === 2 && ConfirmacaoDeDados(handleChange)}
                {pagina === 3 && ConfirmarSenha(handleChange)}  
                
            </div>
        </div>
    );

    function ImagemFormUm(){ return( <div> <ImagemUm/> </div> )}

    function ImagemFormDois(){ return( <div> <ImagemDois/> </div> )}

    function ImagemFormTres(){ return( <div> <ImagemTres/> </div> )}

    function DadosBasicos(handleChange){
        return(
            <form onSubmit={handleSubmit}>
                <div className="campo-input-step">
                <SignUpInput
                    
                    onChange={handleChange}
                    value={conta}
                    titulo="Conta:"
                    icone={IconeConta}
                    name="conta"
                    className="ajuste-margin"
                    ></SignUpInput>

                <SignUpInput
                    
                    onChange={handleChange}
                    titulo="Valor:"
                    icone={IconeValor}
                    name="valor"
                    value={valor}
                    className="ajuste-margin"
                    ></SignUpInput>


                    <div className="botao">
                        <Button tipo ="submit" texto="PRÓXIMO" tamanho="264px"/>
                    </div>
                
                </div>
            </form>
            
        )
    }

    function ConfirmacaoDeDados(handleChange){
        return(
            <div className="campo-input-step">
                <div className="titulo-dados-recebedor">
                    <span>Dados do recebedor</span>
                </div>

                <div className="conjunto-dados-confirmacao">
                    <div className="quadrado-azul"><div>{nomeDestino}</div></div>
                    <div className="quadrado-azul"><div>{conta}</div></div>
                    <div className="quadrado-azul"><div>{valor}</div></div>
                </div>

                <form  onSubmit={handleSubmit} > 
                    <div className="botoes-step">
                        <div className="botao-voltar-step">
                            <button onClick={voltar}>VOLTAR</button>  
                        </div>
                        <div className="botao">
                            <Button onClick={voltar} tipo ="submit" texto="PRÓXIMO" tamanho="160px"/>
                        </div>

                    </div>
                </form> 
            </div>
        )
    }

    function ConfirmarSenha(handleChange){
        return(

            <form onSubmit={transferirDinheiro}>
                <div className="campo-input-step">
                    <SignUpInput
                        onChange={handleChange}
                        titulo="Senha:"
                        icone={Senha}
                        name="senha"
                        type="password"
                        value={senha}
                        className="ajuste-margin"
                    ></SignUpInput>

                    <SignUpInput
                        onChange={handleChange}
                        titulo="Confirmar senha:"
                        icone={Senha}
                        type="password"
                        name="confirmarSenha"
                        value={confirmarSenha}
                        className="ajuste-margin"
                    ></SignUpInput>

                    <div className="botoes-step">
                        <div className="botao-voltar-step">
                            <button onClick={voltar}>VOLTAR</button>  
                        </div>
                        <div className="botao">
                            <Button  tipo ="submit" texto="FINALIZAR" tamanho="160px"/>
                        </div>

                    </div>
                </div>

                
            </form>

        )
    }
}


export default StepFormTransfer;
