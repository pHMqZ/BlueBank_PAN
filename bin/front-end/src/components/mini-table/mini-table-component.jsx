import React from "react";
import "./mini-table-style.scss";

<<<<<<< HEAD
const MiniTable = () => {

    const columnNames = ['Data', 'Valor', "Para"];

    const list = [
        {data: "05/11/2021", valor: "R$ 29,90", para: "Rubens" },
        {data: "02/10/2021", valor: "R$ 490,90", para: "Alexandre"},
        {data: "09/09/2021", valor: "R$ 19,50", para: "Ana"},

    ]
=======
const MiniTable = ({list, id}) => {
    
    const columnNames = ['Data', 'Valor', "Tipo"];
    
>>>>>>> 63efb025571bc822625c02ee88a4448642df0ddb

    return(
        <div className="mini-table">
            <h5>Histórico</h5>
            <div className="mini-table-conteudo" style={{"width": "310px"}}>
                <Table list={list} colNames={columnNames} width="310px" height="180px"/>
                <div className="ver-historico">
<<<<<<< HEAD
                    <a href="/menu-user-historico">Ver histórico completo </a>
=======
                    <a href={`/menu-user-historico/${id}`}>Ver histórico completo </a>
>>>>>>> 63efb025571bc822625c02ee88a4448642df0ddb
                </div>
            </div>   
        </div>

    )



    function Table({list, colNames, width = 'auto', height = 'auto'}){
<<<<<<< HEAD
=======
     
       
>>>>>>> 63efb025571bc822625c02ee88a4448642df0ddb
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
<<<<<<< HEAD
                        {Object.values(list).map((obj, index) => (
                            <tr key={index}>
                                {Object.values(obj).map((value, index2) => (
                                    <td key={index2}>
                                       {value} 
=======
                    
                        {Object.values(list).map((obj, index) => (
                            <tr key={index}>
                                
                                {Object.values(obj).map((value, index2) => (
                                   
                                    <td key={index2}>
                                        
                                       {value } 
>>>>>>> 63efb025571bc822625c02ee88a4448642df0ddb
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