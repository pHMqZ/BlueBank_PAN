<<<<<<< HEAD
import React, {useState} from "react";
=======
import React, {useState, useEffect} from "react";
>>>>>>> 63efb025571bc822625c02ee88a4448642df0ddb
import MenuLateral from "../../components/menu-lateral/menu-lateral-component";
import "./menu-user-profile-style.scss";
import {ReactComponent as ProfileCircle} from '../../assets/profile-circle.svg';
import {ReactComponent as InfoCircle} from '../../assets/casa-circle.svg';
import SignUpInput from "../../components/sign-up-input/sign-up-input-component";
import IconeLapis from "../../assets/icone-lapis.png";
import IconeCadeado from "../../assets/icone-cadeado.png";
<<<<<<< HEAD

const MenuUserProfile = () => {
    const [userCredentials, setUserCredentials] = useState({
=======
import axios from "axios";
import BASE_URL from "../../services/bases";
import { useParams, useNavigate  } from 'react-router-dom';
import Button from "../../components/button/button-component";


const MenuUserProfile = () => {
    let { userId } = useParams();

    const [userCredentials, setUserCredentials] = useState({
        id: userId,
>>>>>>> 63efb025571bc822625c02ee88a4448642df0ddb
        nome: "",
        conta: "",
        cpf: "",
        celular: "",
        email: "",
        bairro: "",
        complemento: "",
        rua: "",
        estado: "",
<<<<<<< HEAD
        cidade: ""

      });

      const {nome, conta, cpf, celular, email, bairro,complemento, rua,estado, cidade } = userCredentials;
=======
        cidade: "",

        

      });

      

      const {nome, conta, cpf, celular, email, bairro,complemento, rua,estado, cidade,id} = userCredentials;
      
>>>>>>> 63efb025571bc822625c02ee88a4448642df0ddb

    const handleChange =(event) => {
        const {name,value} = event.target;
        setUserCredentials({...userCredentials, [name]: value});
        
    };

<<<<<<< HEAD
    return(
        <div className="menu-user-page">
            <div className="menu-vertical">
                <MenuLateral/>
=======
    

    useEffect(  () =>{
        
       
        
        setarConta(id); 
       
       },[]);

    

    

       function setarConta(id){
        var contaAux = "";
        var nomeAux = "";

        axios.get(`${BASE_URL}usuario/cliente/conta/${id}`)
        .then(res => {contaAux = res.data.id});

        axios.get(`${BASE_URL}usuario/admin/listarUsuarioId/${id}`)
        .then(res => {nomeAux = res.data.nome });

        axios.get(`${BASE_URL}usuario/admin/listarUsuarioId/${id}`)
        .then(res => {
            console.log(res.data.dado_usuario);
            setUserCredentials({...userCredentials,
                cpf: res.data.dado_usuario.cpf,
                rua: res.data.dado_usuario.rua || "...",
                numero: res.data.dado_usuario.numero || "...",
                complemento: res.data.dado_usuario.complemento || "...",
                bairro: res.data.dado_usuario.bairro || "...",
                cidade: res.data.dado_usuario.cidade || "...",
                estado: res.data.dado_usuario.estado || "...",
                celular: res.data.dado_usuario.telefone,
                email: res.data.dado_usuario.email,
                conta: contaAux,
                nome: nomeAux
                }
                
            )
        })

        }

        function enviarDadosNovos(event){
            event.preventDefault();
            axios.put(`${BASE_URL}usuario/admin/editarUser/${id}`, {"telefone": celular,"email":email,
        "bairro":bairro, "complemento":complemento, "rua":rua,"estado":estado,"cidade":cidade})
        .then(res=>console.log(res))
        }
        

   

    return(
        <div className="menu-user-page">
            <div className="menu-vertical">
                <MenuLateral id={id}/>
>>>>>>> 63efb025571bc822625c02ee88a4448642df0ddb
            </div>

            <div className="info-menu">
                <div className="info-menu-texto">
                    <h4>Informações</h4>
                </div>

                <div className="container-profile">
                    <div className="profile-circle">
                        <ProfileCircle/>
                    </div>

<<<<<<< HEAD
                    <form>
=======
                    <form onSubmit={enviarDadosNovos}>
>>>>>>> 63efb025571bc822625c02ee88a4448642df0ddb
                    <div className="form-profile">
                    
                            <div className="lado-esquerdo">
                    
<<<<<<< HEAD
                                <SignUpInput  
                                onChange={handleChange}
                                titulo="Nome:"
                                icone={IconeLapis}
                                name="nome"
                                value={nome}
=======
                                <SignUpInput
                                readOnly  
                                onChange={handleChange}
                                titulo={"Nome:"}
                                icone={IconeCadeado}
                                name="nome"
                                value={nome}
                                
                                
>>>>>>> 63efb025571bc822625c02ee88a4448642df0ddb
                                ></SignUpInput>

                                <SignUpInput
                                onChange={handleChange}
<<<<<<< HEAD
                                titulo="Email:"
=======
                                titulo={"Email:"}
>>>>>>> 63efb025571bc822625c02ee88a4448642df0ddb
                                icone={IconeLapis}
                                name="email"
                                value={email}
                                ></SignUpInput>

                                <SignUpInput
<<<<<<< HEAD
                                onChange={handleChange}
                                titulo="CPF:"
                                icone={IconeCadeado}
                                name="cpf"
                                value={cpf}
                                disabled
=======
                                readOnly
                                titulo={"CPF:"}
                                icone={IconeCadeado}
                                name="cpf"
                                value={cpf}
                                
>>>>>>> 63efb025571bc822625c02ee88a4448642df0ddb
                                ></SignUpInput>
                            </div>
        
                            <div className="lado-direito">
                                <SignUpInput
<<<<<<< HEAD
                                titulo="Conta:"
                                icone={IconeCadeado}
                                name="conta"
                                value={conta}
                                disabled
=======
                                readOnly
                                titulo={"Conta:"}
                                icone={IconeCadeado}
                                name="conta"
                                value={conta}

                               
                               
>>>>>>> 63efb025571bc822625c02ee88a4448642df0ddb
                                ></SignUpInput>

                                <SignUpInput
                                onChange={handleChange}
<<<<<<< HEAD
                                titulo="Telefone:"
=======
                                titulo={"Telefone:"}
>>>>>>> 63efb025571bc822625c02ee88a4448642df0ddb
                                icone={IconeLapis}
                                value={celular}
                                name="celular"
                                ></SignUpInput>
<<<<<<< HEAD
=======

                            <div className="botao">
                                <Button
                                type="submit"
                                tipo="submit"
                                texto="ATUALIZAR DADOS"
                                tamanho="130px"
                                />
                            </div>
>>>>>>> 63efb025571bc822625c02ee88a4448642df0ddb
                            </div>
                    </div>
                    </form>
                </div>

                
                <div className="container-info">
                    <div className="profile-circle">
                        <InfoCircle/>
                    </div>

<<<<<<< HEAD
                    <form>
=======
                    <form onSubmit={enviarDadosNovos}>
>>>>>>> 63efb025571bc822625c02ee88a4448642df0ddb
                    <div className="form-profile">
                    
                            <div className="lado-esquerdo">
                    
                                <SignUpInput  
                                onChange={handleChange}
<<<<<<< HEAD
                                titulo="Bairro:"
                                icone={IconeLapis}
                                name="bairro"
                                value={bairro}
=======
                                titulo={"Bairro:"}
                                icone={IconeLapis}
                                name="bairro"
                                value={bairro}
                                
>>>>>>> 63efb025571bc822625c02ee88a4448642df0ddb
                                ></SignUpInput>

                                <SignUpInput
                                onChange={handleChange}
<<<<<<< HEAD
                                titulo="Rua:"
                                icone={IconeLapis}
                                name="rua"
                                value={rua}
=======
                                titulo={"Rua:"}
                                icone={IconeLapis}
                                name="rua"
                                value={rua}
                                
>>>>>>> 63efb025571bc822625c02ee88a4448642df0ddb
                                ></SignUpInput>

                                <SignUpInput
                                onChange={handleChange}
<<<<<<< HEAD
                                titulo="Complemento:"
                                icone={IconeLapis}
                                name="complemento"
                                value={complemento}
=======
                                titulo={"Complemento:"}
                                icone={IconeLapis}
                                name="complemento"
                                value={complemento}
                                
>>>>>>> 63efb025571bc822625c02ee88a4448642df0ddb
                                ></SignUpInput>
                            </div>
        
                            <div className="lado-direito">
                                <SignUpInput
<<<<<<< HEAD
                                titulo="Estado:"
                                icone={IconeLapis}
                                name="estado"
                                value={estado}
=======
                                titulo={"Estado:"}
                                icone={IconeLapis}
                                name="estado"
                                value={estado}
                               
>>>>>>> 63efb025571bc822625c02ee88a4448642df0ddb
                                ></SignUpInput>

                                <SignUpInput
                                onChange={handleChange}
<<<<<<< HEAD
                                titulo="Cidade:"
=======
                                titulo={"Cidade:"}
>>>>>>> 63efb025571bc822625c02ee88a4448642df0ddb
                                icone={IconeLapis}
                                value={cidade}
                                name="cidade"
                                ></SignUpInput>
<<<<<<< HEAD
=======

                            <div className="botao">
                                <Button
                                type="submit"
                                tipo="submit"
                                texto="ATUALIZAR DADOS"
                                tamanho="130px"
                                />
                            </div>
>>>>>>> 63efb025571bc822625c02ee88a4448642df0ddb
                            </div>
                    </div>
                    </form>

                </div>
                
        
            </div>

        </div>

    )
 

}

export default MenuUserProfile;