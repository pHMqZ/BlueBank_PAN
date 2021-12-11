import React from "react";
import "./menu-admin-historico-style.scss";
import MenuLateralAdmin from "../../components/menu-lateral-admin/menu-lateral-admin-component";

const MenuAdminHistoricoPage = () => {
    const columnNames = ['De', 'Para', "Data", "Valor"];

    const list = [//
        {de: "Vitor Ribeiro", para: "Vitor Ribeiro", data: "08/11/2021", valor: "R$ 10,00"},
        {de: "Vitor Ribeiro", para: "Renato Junior", data: "08/11/2021", valor: "R$ 300,00"},
        {de: "Vitor Ribeiro", para: "Vitor Ribeiro", data: "08/11/2021", valor: "R$ 10,00"},
        {de: "Vitor Ribeiro", para: "Renato Junior", data: "08/11/2021", valor: "R$ 300,00"},
        {de: "Vitor Ribeiro", para: "Vitor Ribeiro", data: "08/11/2021", valor: "R$ 10,00"},
        {de: "Vitor Ribeiro", para: "Renato Junior", data: "08/11/2021", valor: "R$ 300,00"},
        {de: "Vitor Ribeiro", para: "Vitor Ribeiro", data: "08/11/2021", valor: "R$ 10,00"},
        {de: "Vitor Ribeiro", para: "Renato Junior", data: "08/11/2021", valor: "R$ 300,00"},  
    ]


    return(
    <div className="menu-user-page">
        <div className="menu-vertical">
            <MenuLateralAdmin/>
        </div>

        <div className="info-menu">

        <div className="info-menu-texto">
                <h4>Histórico Geral</h4>
                
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

export default MenuAdminHistoricoPage;