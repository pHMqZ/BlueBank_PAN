import React, {useState} from "react";
import MenuLateral from "../../components/menu-lateral/menu-lateral-component";
import "./menu-user-profile-style.scss";
import {ReactComponent as ProfileCircle} from '../../assets/profile-circle.svg';
import {ReactComponent as InfoCircle} from '../../assets/casa-circle.svg';
import SignUpInput from "../../components/sign-up-input/sign-up-input-component";
import IconeLapis from "../../assets/icone-lapis.png";
import IconeCadeado from "../../assets/icone-cadeado.png";

const MenuUserProfile = () => {
    const [userCredentials, setUserCredentials] = useState({
        nome: "",
        conta: "",
        cpf: "",
        celular: "",
        email: "",
        bairro: "",
        complemento: "",
        rua: "",
        estado: "",
        cidade: ""

      });

      const {nome, conta, cpf, celular, email, bairro,complemento, rua,estado, cidade } = userCredentials;

    const handleChange =(event) => {
        const {name,value} = event.target;
        setUserCredentials({...userCredentials, [name]: value});
        
    };

    return(
        <div className="menu-user-page">
            <div className="menu-vertical">
                <MenuLateral/>
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
                                onChange={handleChange}
                                titulo="Nome:"
                                icone={IconeLapis}
                                name="nome"
                                value={nome}
                                ></SignUpInput>

                                <SignUpInput
                                onChange={handleChange}
                                titulo="Email:"
                                icone={IconeLapis}
                                name="email"
                                value={email}
                                ></SignUpInput>

                                <SignUpInput
                                onChange={handleChange}
                                titulo="CPF:"
                                icone={IconeCadeado}
                                name="cpf"
                                value={cpf}
                                disabled
                                ></SignUpInput>
                            </div>
        
                            <div className="lado-direito">
                                <SignUpInput
                                titulo="Conta:"
                                icone={IconeCadeado}
                                name="conta"
                                value={conta}
                                disabled
                                ></SignUpInput>

                                <SignUpInput
                                onChange={handleChange}
                                titulo="Telefone:"
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
                                titulo="Bairro:"
                                icone={IconeLapis}
                                name="bairro"
                                value={bairro}
                                ></SignUpInput>

                                <SignUpInput
                                onChange={handleChange}
                                titulo="Rua:"
                                icone={IconeLapis}
                                name="rua"
                                value={rua}
                                ></SignUpInput>

                                <SignUpInput
                                onChange={handleChange}
                                titulo="Complemento:"
                                icone={IconeLapis}
                                name="complemento"
                                value={complemento}
                                ></SignUpInput>
                            </div>
        
                            <div className="lado-direito">
                                <SignUpInput
                                titulo="Estado:"
                                icone={IconeLapis}
                                name="estado"
                                value={estado}
                                ></SignUpInput>

                                <SignUpInput
                                onChange={handleChange}
                                titulo="Cidade:"
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