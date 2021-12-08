import React from "react";
import MenuLateral from "../../components/menu-lateral/menu-lateral-component";
import "./menu-user-historico-style.scss";


const MenuUserHistorico = () =>{

    const columnNames = ['Tipo', 'Para', "Data", "Valor", "Saldo"];

    const list = [//
        {tipo: "Recebimento", para: "Vitor Ribeiro", data: "08/11/2021", valor: "R$ 10,00", Saldo: "R$ 3815,00" },
        {tipo: "Transferência", para: "Renato Junior", data: "08/11/2021", valor: "R$ 300,00", Saldo: "R$ 3805,00" },
        {tipo: "Recebimento", para: "Vitor Ribeiro", data: "08/11/2021", valor: "R$ 10,00", Saldo: "R$ 3815,00" },
        {tipo: "Transferência", para: "Renato Junior", data: "08/11/2021", valor: "R$ 300,00", Saldo: "R$ 3805,00" },
        {tipo: "Recebimento", para: "Vitor Ribeiro", data: "08/11/2021", valor: "R$ 10,00", Saldo: "R$ 3815,00" },
        {tipo: "Transferência", para: "Renato Junior", data: "08/11/2021", valor: "R$ 300,00", Saldo: "R$ 3805,00" },
        {tipo: "Recebimento", para: "Vitor Ribeiro", data: "08/11/2021", valor: "R$ 10,00", Saldo: "R$ 3815,00" },
        {tipo: "Transferência", para: "Renato Junior", data: "08/11/2021", valor: "R$ 300,00", Saldo: "R$ 3805,00" },
        
        
    ]



    return (
        <div className="menu-user-page">
        <div className="menu-vertical">
            <MenuLateral/>
        </div>

        <div className="info-menu">

        <div className="info-menu-texto">
                <h4>Histórico</h4>
                
        </div>

        <div className="info-menu-table-historico" style={{"width": "800px", "height": "390px", "overflow-y": "scroll", "overflow-x": "hidden"}}>
            <Table list={list} colNames={columnNames} width="800px"/>
        </div>
        
        </div>
    </div>

    )







    function Table({list, colNames, width = 'auto', height = 'auto'}){
        return(
            <div>
                <table cellSpacing="0" style={{"width" :width, "height":height}} className="table-historico-2">
                    <thead>
                        <tr>
                            {colNames.map((headerItem, index) => (
                                <th key={index}>
                                    {headerItem}
                                </th>    
                            ))}
                        </tr>
                    </thead>
                    
                    

                        <tbody>
                            {Object.values(list).map((obj, index) => (
                                <tr key={index}>
                                    {Object.values(obj).map((value, index2) => (
                                        <td key={index2}>
                                        {value} 
                                        </td>
                                    ))}
                                </tr>    
                            ))}
                        </tbody>
                    
                    

                </table>
            </div>
        )

    }
  

}

export default MenuUserHistorico;