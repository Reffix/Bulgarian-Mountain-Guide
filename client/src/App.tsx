import React from "react";
import ReactDOM from "react-dom";
import {
  BrowserRouter as Router,
  Routes,
  Route,
  Navigate 
} from "react-router-dom";
import './App.css';
import Background from './resources/background.svg';
import AppHeader from './components/app-header';
import { ThemeProvider, createTheme } from "@material-ui/core/styles";
import { CssBaseline } from '@material-ui/core';
import Home from './pages/home';
import Login from "./pages/login";
import CardComponent from "./components/card";

const theme = createTheme({
  overrides: {
    MuiCssBaseline: {
      "@global": {
        body: {
          '&::before': {
            content: '""',
            display: 'block',
            position: 'absolute',
            left: '0',
            top: '0',
            width: '100%',
            height: '100%',
            opacity: '0.6',
            backgroundImage: `url(${Background})`,
            backgroundSize: 'cover',
            backgroundPosition: 'top',
            backgroundRepeat: 'no-repeat',
            zIndex: '-1',
          }
        }
      }
    }
  }
})

function App() {
  
  return (
    <ThemeProvider theme={theme}>
      <CssBaseline/>
      <Router>
        <AppHeader />
        <Routes>
            <Route path="/" element={<Home/>}/>
            <Route path="/login" element={<Login/>}/>
            <Route path="/card" element={<CardComponent/>}/>
          </Routes>
      </Router>
    </ThemeProvider>
  )
    
}

export default App;
