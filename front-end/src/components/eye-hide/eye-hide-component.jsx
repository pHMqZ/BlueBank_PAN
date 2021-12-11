import React, {useState} from "react";
import "./eye-hide-style.scss";
import {ReactComponent as EyeWhite} from '../../assets/eye-white.svg';
import {ReactComponent as EyeGrey} from '../../assets/eye-grey.svg';


const EyeHide = ({ handleChange, conta}) => {
    const [eyeState, setEyeState] = useState({
        show: 0,
        
      });

      const {show} = eyeState;

      
      function funcao(){
        
        show === 1 ? setEyeState({...eyeState,"show": 0})  : setEyeState({...eyeState,"show": 1});
        }

        function funcao2(){   
           handleChange(conta)
           console.log();
       } 

       


      return (

        <div onClick={()=>{ funcao();funcao2()}} >
            {show === 0 && EyeGreyHide()}
            {show === 1 && EyeWhiteShow()}
        </div>
      )



      function EyeWhiteShow(){ return( 
        <div style={{"cursor": "pointer"}}> 
        <EyeWhite/>
        </div> )}


      function EyeGreyHide(){ return( <div style={{"cursor": "pointer"}} > <EyeGrey/> </div> )}
    
      

      
}

export default EyeHide;