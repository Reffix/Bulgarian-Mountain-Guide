import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import './App.css';
import Background from './resources/background.svg';
import AppHeader from './components/app-header';
import { ThemeProvider, createTheme } from '@material-ui/core/styles';
import { CssBaseline } from '@material-ui/core';
import Home from './pages/home';
import Login from './pages/login';
import CardComponent from './components/card';
import Hotels from './pages/hotels';
import Cottages from './pages/cottages';
import MountainRoutes from './pages/routes';
import Flora from './pages/flora';
import Attractions from './pages/attractions';
import Landmarks from './pages/landmarks';
import Fauna from './pages/fauna';

const theme = createTheme({
  overrides: {
    MuiCssBaseline: {
      '@global': {
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
          },
        },
      },
    },
  },
});

function App() {
  return (
    <ThemeProvider theme={theme}>
      <CssBaseline />
      <Router>
        <AppHeader />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/login" element={<Login />} />
          <Route path="/hotels" element={<Hotels />} />
          <Route path="/cottages" element={<Cottages />} />
          <Route path="/routes" element={<MountainRoutes />} />
          <Route path="/flora" element={<Flora />} />
          <Route path="/fauna" element={<Fauna />} />
          <Route path="/attractions" element={<Attractions />} />
          <Route path="/landmarks" element={<Landmarks />} />
        </Routes>
      </Router>
    </ThemeProvider>
  );
}

export default App;
