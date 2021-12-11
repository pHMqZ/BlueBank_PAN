import React,{useState, useEffect} from "react";
import MenuLateral from "../../components/menu-lateral/menu-lateral-component";
import "./menu-user-historico-style.scss";
import axios from "axios";
import BASE_URL from "../../services/bases";
import { useParams, useNavigate  } from 'react-router-dom';


const MenuUserHistorico = () =>{
    let { userId } = useParams();
    const columnNames = ['Tipo', 'Terceiro', "Data", "Valor"];

    const [dados, setDados] = useState({
        id:userId

    });

    const [dadosTabela, setDadosTabela] = useState({
        tableData: [],
    });

    const {tableData} = dadosTabela;
    const {id} = dados;

    useEffect( () =>{
        
        mapeiaDadosTable(id)
        
        
       
       },[] );


    function mapeiaDadosTable(id){
        axios.get(`${BASE_URL}usuario/cliente/historico/${id}`)
        .then(res => {
            const resposta = [];
            var size = res.data.length-1;
            parseInt(size);
            for(let i = size; i >= 0; i--){
                const item = {"tipo":"", "nome_conta":"", "data_origem":"", "valor":""};
                item.data_origem = res.data[i].data_movimento;
                item.tipo = res.data[i].tipo_movimento;
                item.valor =  res.data[i].valor ;
                item.nome_conta = res.data[i].nome_conta;
                resposta.push(item)
              
            }
            setDadosTabela({ tableData: resposta });
        });
    }

    return (
        <div className="menu-user-page">
        <div className="menu-vertical">
            <MenuLateral id={id}/>
        </div>

        <div className="info-menu">

        <div className="info-menu-texto">
                <h4>Histórico</h4>
                
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

export default MenuUserHistorico;