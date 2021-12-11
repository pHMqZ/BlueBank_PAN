<<<<<<< HEAD
import React from 'react';
=======
import React, {useState} from 'react';
>>>>>>> 63efb025571bc822625c02ee88a4448642df0ddb
import {ReactComponent as LogoIcone} from '../../assets/logo-icone.svg';
import {ReactComponent as Casinha} from '../../assets/casinha.svg';
import {ReactComponent as Clock} from '../../assets/relogio.svg';
import {ReactComponent as Profile} from '../../assets/profilezinho.svg';
import "./menu-lateral-style.scss";





<<<<<<< HEAD
const MenuLateral = () => (

    <div className="menu-lateral">
=======


const MenuLateral = ({id}) => {
    
    const [dadoId, setDadoId] = useState({
        idAtual: id
    })

    const {idAtual} = dadoId;

    return(

        <div className="menu-lateral">
>>>>>>> 63efb025571bc822625c02ee88a4448642df0ddb
        <div className="menu-lateral_espaco_logo">
            <div className="menu-lateral_logo">
                <LogoIcone/>
            </div>
        </div>

        <div className="menu-lateral_opcoes">
            <div className="menu-lateral_opcoes_3">
<<<<<<< HEAD
                <div className="menu-lateral_opcoes_3_individual"><a href="/menu-user"><Casinha/></a></div>
                <div className="menu-lateral_opcoes_3_individual"><a href="/menu-user-historico"><Clock/></a></div>
                <div className="menu-lateral_opcoes_3_individual"><a href="/menu-user-profile"><Profile/></a></div>
                <div className="menu-lateral_opcoes_3_individual"><a><span>sair</span></a></div>
            </div>
        </div>
    </div>


);
=======
                <div className="menu-lateral_opcoes_3_individual"><a href={`/menu-user/${idAtual}`}><Casinha/></a></div>
                <div className="menu-lateral_opcoes_3_individual"><a href= {`/menu-user-historico/${idAtual}`}><Clock/></a></div>
                <div className="menu-lateral_opcoes_3_individual"><a href={`/menu-user-profile/${idAtual}`}><Profile/></a></div>
                <div className="menu-lateral_opcoes_3_individual"><a href={`/`}><span>sair</span></a></div>
            </div>
        </div>
    </div>
    )
    


};
>>>>>>> 63efb025571bc822625c02ee88a4448642df0ddb

export default MenuLateral;