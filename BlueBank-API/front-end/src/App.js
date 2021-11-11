
import React from 'react';
import { Route , Routes} from 'react-router-dom';
import './App.css';
import UserHomePage from './pages/homepage-user/homepage-user-component';



function App() {
  return (
    <div>
        <Routes>
          <Route  exact path = '/home' element = {<UserHomePage/>} /> 
        </Routes>       
    </div>
  );
}

export default App;
