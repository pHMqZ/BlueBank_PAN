import React, {useState, useEffect} from "react";
import MenuLateral from "../../components/menu-lateral/menu-lateral-component";
import "./menu-user-profile-style.scss";
import {ReactComponent as ProfileCircle} from '../../assets/profile-circle.svg';
import {ReactComponent as InfoCircle} from '../../assets/casa-circle.svg';
import SignUpInput from "../../components/sign-up-input/sign-up-input-component";
import IconeLapis from "../../assets/icone-lapis.png";
import IconeCadeado from "../../assets/icone-cadeado.png";
import axios from "axios";
import BASE_URL from "../../services/bases";
import { useParams, useNavigate  } from 'react-router-dom';


const MenuUserProfile = () => {
    let { userId } = useParams();

    const [userCredentials, setUserCredentials] = useState({
        id: userId,
        nome: "",
        conta: "",
        cpf: "",
        celular: "",
        email: "",
        bairro: "",
        complemento: "",
        rua: "",
        estado: "",
        cidade: "",

        

      });

      

      const {nome, conta, cpf, celular, email, bairro,complemento, rua,estado, cidade,id} = userCredentials;
      

    const handleChange =(event) => {
        const {name,value} = event.target;
        setUserCredentials({...userCredentials, [name]: value});
        
    };

    

    useEffect(  () =>{
        
        //setarNome(id);
        setarConta(id); 
        //setarDadosPessoais(id);
       },[]);

    useEffect(async ()=>{
        await axios.put(`${BASE_URL}usuario/admin/editarUser/${id}`, {"telefone": celular,"email":email,
        "bairro":bairro, "complemento":complemento, "rua":rua,"estado":estado,"cidade":cidade})
        .then(res=>console.log(res)
    )
       
    },[celular,email,bairro,complemento,rua,estado,cidade]) ;

    

       function setarConta(id){
        var contaAux = "";
        var nomeAux = "";

        axios.get(`${BASE_URL}usuario/cliente/conta/${id}`)
        .then(res => {contaAux = res.data.id});

        axios.get(`${BASE_URL}usuario/admin/listarUsuarioId/${id}`)
        .then(res => {nomeAux = res.data.nome });

        axios.get(`${BASE_URL}usuario/admin/listarUsuarioId/${id}`)
        .then(res =>
            
            setUserCredentials({...userCredentials,
                cpf: res.data.dado_usuario.cpf ? res.data.dado_usuario.cpf : "...",
                rua: res.data.dado_usuario.rua ? res.data.dado_usuario.rua: "...",
                numero: res.data.dado_usuario.numero ? res.data.dado_usuario.numero : "...",
                complemento: res.data.dado_usuario.complemento ? res.data.dado_usuario.complemento : "...",
                bairro: res.data.dado_usuario.bairro ? res.data.dado_usuario.bairro : "...",
                cidade: res.data.dado_usuario.cidade ? res.data.dado_usuario.cidade : "...",
                estado: res.data.dado_usuario.estado ? res.data.dado_usuario.estado : "...",
                celular: res.data.dado_usuario.telefone ? res.data.dado_usuario.telefone : "...",
                email: res.data.dado_usuario.email ? res.data.dado_usuario.email : "...",
                conta: contaAux,
                nome: nomeAux
                }
                
            ))

        

            //setUserCredentials({...userCredentials, conta:  res.data.id })); 
        }
        

   

    return(
        <div className="menu-user-page">
            <div className="menu-vertical">
                <MenuLateral id={id}/>
            </div>

            <div className="info-menu">
                <div className="info-menu-texto">
                    <h4>Informações</h4>
                </div>

                <div className="container-profile">
                    <div className="profile-circle">
                        <ProfileCircle/>
                    </div>

                    <form>
                    <div className="form-profile">
                    
                            <div className="lado-esquerdo">
                    
                                <SignUpInput
                                readOnly  
                                onChange={handleChange}
                                titulo={"Nome:"}
                                icone={IconeCadeado}
                                name="nome"
                                value={nome}
                                
                                
                                ></SignUpInput>

                                <SignUpInput
                                onChange={handleChange}
                                titulo={"Email:"}
                                icone={IconeLapis}
                                name="email"
                                value={email}
                                ></SignUpInput>

                                <SignUpInput
                                readOnly
                                titulo={"CPF:"}
                                icone={IconeCadeado}
                                name="cpf"
                                value={cpf}
                                
                                ></SignUpInput>
                            </div>
        
                            <div className="lado-direito">
                                <SignUpInput
                                readOnly
                                titulo={"Conta:"}
                                icone={IconeCadeado}
                                name="conta"
                                value={conta}

                               
                               
                                ></SignUpInput>

                                <SignUpInput
                                onChange={handleChange}
                                titulo={"Telefone:"}
                                icone={IconeLapis}
                                value={celular}
                                name="celular"
                                ></SignUpInput>
                            </div>
                    </div>
                    </form>
                </div>

                
                <div className="container-info">
                    <div className="profile-circle">
                        <InfoCircle/>
                    </div>

                    <form>
                    <div className="form-profile">
                    
                            <div className="lado-esquerdo">
                    
                                <SignUpInput  
                                onChange={handleChange}
                                titulo={"Bairro:"}
                                icone={IconeLapis}
                                name="bairro"
                                value={bairro}
                                
                                ></SignUpInput>

                                <SignUpInput
                                onChange={handleChange}
                                titulo={"Rua:"}
                                icone={IconeLapis}
                                name="rua"
                                value={rua}
                                
                                ></SignUpInput>

                                <SignUpInput
                                onChange={handleChange}
                                titulo={"Complemento:"}
                                icone={IconeLapis}
                                name="complemento"
                                value={complemento}
                                
                                ></SignUpInput>
                            </div>
        
                            <div className="lado-direito">
                                <SignUpInput
                                titulo={"Estado:"}
                                icone={IconeLapis}
                                name="estado"
                                value={estado}
                               
                                ></SignUpInput>

                                <SignUpInput
                                onChange={handleChange}
                                titulo={"Cidade:"}
                                icone={IconeLapis}
                                value={cidade}
                                name="cidade"
                                ></SignUpInput>
                            </div>
                    </div>
                    </form>

                </div>
                
        
            </div>

        </div>

    )
 

}

export default MenuUserProfile;