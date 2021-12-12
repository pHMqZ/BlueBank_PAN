import React from "react";
import "./mini-table-style.scss";

const MiniTable = ({list, id}) => {
    
    const columnNames = ['Data', 'Valor', "Tipo"];
    

    return(
        <div className="mini-table" >
            <h5>Histórico</h5>
            <div className="mini-table-conteudo" style={{"width": "310px"}}>
                <Table list={list} colNames={columnNames} width="310px" height="180px"/>
                <div className="ver-historico">
                    <a href={`/menu-user-historico/${id}`}>Ver histórico completo </a>
                </div>
            </div>   
        </div>

    )



    function Table({list, colNames, width = 'auto', height = 'auto'}){
     
       
        return(
            <div>
                <table cellSpacing="0" style={{"width" :width, "height":height}} className="table-historico">
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
                                        
                                       {value } 
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



export default MiniTable;