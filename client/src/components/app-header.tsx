import {
  AppBar,
  Avatar,
  Box,
  Button,
  Grid,
  IconButton,
  Menu,
  MenuItem,
  ThemeProvider,
  Toolbar,
  Typography,
} from '@material-ui/core';
import LandscapeOutlinedIcon from '@mui/icons-material/LandscapeOutlined';
import React, { useState } from 'react';
import { Link, useLocation } from 'react-router-dom';

import useCurrentUser from '../context/auth-context';
import Logo from '../resources/logo.svg';
import authService from '../services/auth-service';

import appHeaderStyles from '../styles/app-header-styles';
import { Mountains } from '../enums/mountains';
import EntityMenu from './entity-menu';
import { NestedMenuItem } from 'mui-nested-menu';

export default function AppHeader() {
  const classes = appHeaderStyles();

  const [anchorEl, setAnchorEl] = useState<Element | null>(null);
  const [anchorElNested, setAnchorElNested] = useState<Element | null>(null);
  const [anchorElNestedMenu, setAnchorElNestedMenu] = useState<Element | null>(null);
  const mountains = Object.entries(Mountains);
  const mountainInfoOpenNested = Boolean(anchorElNested);
  const user = useCurrentUser();
  const handleClose = () => {
    setAnchorElNested(null);
  }
  const location = useLocation();

  function logout() {
    setAnchorEl(null);
    authService.logout();
  }

  function showUserProfile() {
    setAnchorEl(null);
  }

  return (
    <AppBar position="static" className={classes.bar}>
      <Toolbar className={classes.header}>
        <Link to="/" className={classes.bar}>
          <img
            src={Logo}
            alt={LandscapeOutlinedIcon.toString()}
            className={classes.logo}
          />
        </Link>
        <Box display='flex' justifyContent="space-between">
          <Button component={Link} to="/">
            <Typography className={classes.menuText}>
              НАЧАЛО
            </Typography>
          </Button>
          <Button onClick={(event) => setAnchorElNested(event.currentTarget)}>
            <Typography className={classes.menuText} >
              ПЛАНИНИ
            </Typography>
          </Button>
          <Menu anchorEl={anchorElNested} open={mountainInfoOpenNested} onClose={handleClose} >
            {mountains.map((mountain) => (
              <NestedMenuItem label={mountain[1]} parentMenuOpen={mountainInfoOpenNested} onClick={(event) => setAnchorElNestedMenu(event.currentTarget)} >
                <EntityMenu mountain={mountain} anchorEl={anchorElNestedMenu} setAnchorEl={setAnchorElNestedMenu} handleMainClose={handleClose}/>
              </NestedMenuItem>  
            ))}
        </Menu>
          <Button>
            <Typography className={classes.menuText}>
              КОНТАКТИ
            </Typography>
          </Button>
          
        </Box>
        {user && (
          <>
            <Box>
              <Typography component="span">Hello, {user.username}!</Typography>
              <IconButton onClick={(event) => setAnchorEl(event.currentTarget)}>
                <Avatar>{user.username[0].toUpperCase()}</Avatar>
              </IconButton>
            </Box>
            <Menu
              anchorEl={anchorEl}
              anchorOrigin={{
                vertical: 'top',
                horizontal: 'right',
              }}
              keepMounted
              transformOrigin={{
                vertical: 'top',
                horizontal: 'right',
              }}
              open={!!anchorEl}
              onClose={() => setAnchorEl(null)}
            >
              <MenuItem onClick={showUserProfile}>User Profile</MenuItem>
              <MenuItem onClick={logout}>Logout</MenuItem>
            </Menu>
          </>
        )}
        {!user && location.pathname !== '/login' && location.pathname !== '/signup' && (
          <Box display='flex'>
            <Button color="inherit" 
            variant="outlined" component={Link} to="/login" className={classes.login}>
              Sing In
            </Button>
            <Button color="inherit" variant="outlined" component={Link} to="/register" className={classes.login}>
              Sing Up
            </Button>
          </Box>
        )}
      </Toolbar>
    </AppBar>
  );
}
