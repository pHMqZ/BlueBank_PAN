<<<<<<< HEAD
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
=======
import React, {useState, useEffect} from "react";
import "./menu-admin-historico-style.scss";
import MenuLateralAdmin from "../../components/menu-lateral-admin/menu-lateral-admin-component";
import axios from "axios";
import BASE_URL from "../../services/bases";

const MenuAdminHistoricoPage = () => {

    const [dadosTabela, setDadosTabela] = useState({
        tableData: [],
    });

    const {tableData} = dadosTabela;

    const columnNames = ['Data', 'Tipo', "Valor", "Quem"];

    useEffect( () =>{
        
        mapeiaDadosTable();
        
        
       
       },[] );



    function mapeiaDadosTable(){
        axios.get(`${BASE_URL}usuario/admin/historicoGeral`)
        .then(res => {
            const resposta = [];
            var size = res.data.length - 1;
            for(let i = size; i >= 0; i--){
                const item = {"data_origem":"", "tipo":"", "valor":"", "quem":""};
                item.data_origem = res.data[i].data_movimento;
                item.tipo = res.data[i].tipo_movimento;
                item.valor =  res.data[i].valor ;
                item.quem = res.data[i].nome_conta;
                resposta.push(item)
              
            }
            setDadosTabela({ tableData: resposta });
        });
    }
>>>>>>> 63efb025571bc822625c02ee88a4448642df0ddb


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
<<<<<<< HEAD
            <Table list={list} colNames={columnNames} width="800px"/>
=======
            <Table list={tableData} colNames={columnNames} width="800px"/>
>>>>>>> 63efb025571bc822625c02ee88a4448642df0ddb
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