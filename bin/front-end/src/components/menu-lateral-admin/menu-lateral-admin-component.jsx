import React from "react";
import "./menu-lateral-admin-style.scss";
import {ReactComponent as LogoIcone} from '../../assets/logo-icone.svg';
import {ReactComponent as Casinha} from '../../assets/casinha.svg';
import {ReactComponent as Clock} from '../../assets/relogio.svg'; 

const MenuLateralAdmin = () => (

    <div className="menu-lateral" >
        <div className="menu-lateral_espaco_logo">
            <div className="menu-lateral_logo">
                <LogoIcone/>
            </div>
        </div>

        <div className="menu-lateral_opcoes">
            <div className="menu-lateral_opcoes_3">
                <div className="menu-lateral_opcoes_3_individual"><a href="/menu-admin"><Casinha/></a></div>
                <div className="menu-lateral_opcoes_3_individual"><a href="/menu-admin-historico"><Clock/></a></div>
<<<<<<< HEAD
                <div className="menu-lateral_opcoes_3_individual"><a><span>sair</span></a></div>
=======
                <div className="menu-lateral_opcoes_3_individual"><a href={`/`}><span>sair</span></a></div>
>>>>>>> 63efb025571bc822625c02ee88a4448642df0ddb
            </div>
        </div>
    </div>


);

export default MenuLateralAdmin;