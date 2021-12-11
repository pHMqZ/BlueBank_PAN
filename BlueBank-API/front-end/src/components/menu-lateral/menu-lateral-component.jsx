import React, {useState} from 'react';
import {ReactComponent as LogoIcone} from '../../assets/logo-icone.svg';
import {ReactComponent as Casinha} from '../../assets/casinha.svg';
import {ReactComponent as Clock} from '../../assets/relogio.svg';
import {ReactComponent as Profile} from '../../assets/profilezinho.svg';
import "./menu-lateral-style.scss";







const MenuLateral = ({id}) => {
    
    const [dadoId, setDadoId] = useState({
        idAtual: id
    })

    const {idAtual} = dadoId;

    return(

        <div className="menu-lateral">
        <div className="menu-lateral_espaco_logo">
            <div className="menu-lateral_logo">
                <LogoIcone/>
            </div>
        </div>

        <div className="menu-lateral_opcoes">
            <div className="menu-lateral_opcoes_3">
                <div className="menu-lateral_opcoes_3_individual"><a href={`/menu-user/${idAtual}`}><Casinha/></a></div>
                <div className="menu-lateral_opcoes_3_individual"><a href= {`/menu-user-historico/${idAtual}`}><Clock/></a></div>
                <div className="menu-lateral_opcoes_3_individual"><a href={`/menu-user-profile/${idAtual}`}><Profile/></a></div>
                <div className="menu-lateral_opcoes_3_individual"><a href={`/`}><span>sair</span></a></div>
            </div>
        </div>
    </div>
    )
    


};

export default MenuLateral;