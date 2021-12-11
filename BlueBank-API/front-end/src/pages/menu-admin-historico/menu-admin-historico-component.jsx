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
            <Table list={tableData} colNames={columnNames} width="800px"/>
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