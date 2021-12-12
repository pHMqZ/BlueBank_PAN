
import React from 'react';
import { Route , Routes} from 'react-router-dom';
import './App.css';
import UserHomePage from './pages/homepage-user/homepage-user-component';
import LoginPage from './pages/login/login-component';
import ErrorPage from './pages/error/error-component';
import MenuUserPage from './pages/menu-user/menu-user-component';
import MenuUserHistorico from './pages/menu-user-historico/menu-user-historico-component';
import MenuUserProfile from './pages/menu-user-profile/menu-user-profile-component';
import MenuAdminPage from './pages/menu-admin/menu-admin-component';
import MenuAdminHistoricoPage from './pages/menu-admin-historico/menu-admin-historico-component';

function App() {



  return (
    <div>
        <Routes>
          <Route  exact path = '/error' element = {<ErrorPage/>}/>
          <Route  exact path = '/' element = {<UserHomePage/>} /> 
          <Route  exact path = '/login' element = {<LoginPage/>}/>

          <Route  exact path = '/menu-user/:userId' element = {<MenuUserPage/>}/>
          <Route  exact path = '/menu-user-historico/:userId' element = {<MenuUserHistorico/>}/>
          <Route  exact path = '/menu-user-profile/:userId' element = {<MenuUserProfile/>}/>

          <Route  exact path = '/menu-admin' element = {<MenuAdminPage/>}/>
          <Route  exact path = '/menu-admin-historico' element = {<MenuAdminHistoricoPage/>}/>

        </Routes>       
    </div>
  );
}

export default App;
