import './App.css';

import { CssBaseline } from '@material-ui/core';
import { createTheme, ThemeProvider } from '@material-ui/core/styles';
import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter as Router, Navigate, Route, Routes } from 'react-router-dom';

import AppHeader from './components/app-header';
import Home from './pages/home';
import Login from './pages/login';
import SignUp from './pages/register';
import { AuthProvider } from './context/auth-context';
import PrivateRoute from './components/routes/private-route';
import AddEntity from './pages/add-entity';
import ListPage from './pages/list-page';
import { Mountains } from './enums/mountains';
import { DisplayableEntites } from './enums/displayable-entities';

const theme = createTheme({


  // overrides: {
  //   MuiCssBaseline: {
  //     '@global': {
  //       body: {
  //         '&::before': {
  //           content: '""',
  //           display: 'block',
  //           position: 'absolute',
  //           left: '0',
  //           top: '0',
  //           width: '100%',
  //           height: '100%',
  //           opacity: '0.6',
  //           backgroundImage: `url(${Background})`,
  //           backgroundSize: 'cover',
  //           backgroundPosition: 'top',
  //           backgroundRepeat: 'no-repeat',
  //           zIndex: '-1',
  //         },
  //       },
  //     },
  //   },
  // },
  palette: {
    background : {
      default: '#E7FEF7',
    },
    primary: {
        main: '#54B39A',
      },
    secondary: {
        main: '#00A982',
      },
  },
});

const mountains = Object.entries(Mountains);
const entities = Object.entries(DisplayableEntites);

function App() {
  return (
    <AuthProvider>
      <ThemeProvider theme={theme}>
        <CssBaseline />
        <Router>
          <AppHeader />
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/login" element={<Login />} />
            <Route path="/register" element={<SignUp />} />
            {mountains.map((mountain) => (
              entities.map(entity => (
                <Route path={`/${entity[0]}/${mountain[0]}/1/10`} element={<ListPage mountain={mountain[0]} entity={entity[0]}/>} />
              )))
            )}
            <Route element={<PrivateRoute/>}/>
              <Route path='/new-entity/' element={<AddEntity/>}/>
            </Routes>
        </Router>
      </ThemeProvider>
    </AuthProvider>
  );
}

export default App;
