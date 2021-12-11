import React from 'react';
import {ReactComponent as LogoIcone} from '../../assets/logo-icone.svg';
import {ReactComponent as Casinha} from '../../assets/casinha.svg';
import {ReactComponent as Clock} from '../../assets/relogio.svg';
import {ReactComponent as Profile} from '../../assets/profilezinho.svg';
import "./menu-lateral-style.scss";





const MenuLateral = () => (

    <div className="menu-lateral">
        <div className="menu-lateral_espaco_logo">
            <div className="menu-lateral_logo">
                <LogoIcone/>
            </div>
        </div>

        <div className="menu-lateral_opcoes">
            <div className="menu-lateral_opcoes_3">
                <div className="menu-lateral_opcoes_3_individual"><a href="/menu-user"><Casinha/></a></div>
                <div className="menu-lateral_opcoes_3_individual"><a href="/menu-user-historico"><Clock/></a></div>
                <div className="menu-lateral_opcoes_3_individual"><a href="/menu-user-profile"><Profile/></a></div>
                <div className="menu-lateral_opcoes_3_individual"><a><span>sair</span></a></div>
            </div>
        </div>
    </div>


);

export default MenuLateral;