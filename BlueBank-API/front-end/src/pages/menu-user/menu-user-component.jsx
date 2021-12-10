import React from "react";
import "./menu-user-style.scss";
import {ReactComponent as LogoBlue} from '../../assets/logoBlue.svg';
import {ReactComponent as CartaoCredito} from '../../assets/cartao-credito.svg';
import MenuLateral from "../../components/menu-lateral/menu-lateral-component";
import StepFormTransfer from "../../components/step-form/step-form-component";
import MiniTable from "../../components/mini-table/mini-table-component";

const MenuUserPage = () => (
    <div className="menu-user-page">
        <div className="menu-vertical">
            <MenuLateral/>
        </div>

        <div className="info-menu">
            <div className="info-menu-texto">
                <h4>Bem vindo, </h4>
                <h4 className="titulo-azul">Vinicius Trindade!</h4>
            </div>

            <div className="cartao-credito">
                <CartaoCredito/>

                <div className="texto-saldo">
                    <h6>saldo</h6>
                    <h3>R$ 3900,00</h3>
                </div>
                
            </div>

            <div className="transferencia">
                <StepFormTransfer/>
            </div>

            <div className="info-menu-table">
                <MiniTable/>
            </div>

        </div>

        

        


    </div>


);

export default MenuUserPage;