import { makeStyles, AppBar, Toolbar, Box, Typography, IconButton, Avatar, Menu, MenuItem, Button, } from '@material-ui/core';
import React, { useState } from 'react';
import { useLocation, Link } from 'react-router-dom';
import useCurrentUser from '../context/auth-context';
import authService from '../services/auth-service';
import { Mountains } from '../enums/Mountains';
import Logo from '../resources/logo.svg';
import HeaderButton from './header-button';

const useStyles = makeStyles((theme) => ({
  login: {
    [theme.breakpoints.up('xs')]: {
      height: '30px',
    },
    [theme.breakpoints.up('sm')]: {
      height: '50px',
    },
  },
  bar: {
    underline: 'none',
    [theme.breakpoints.up('xs')]: {
      height: '40px',
    },
    [theme.breakpoints.up('sm')]: {
      height: '50px',
    },
    [theme.breakpoints.up('md')]: {
      height: '60px',
    },
    [theme.breakpoints.up('lg')]: {
      height: '70px',
    },
  },
  header: {
    [theme.breakpoints.up('xs')]: {
      height: '60px',
      minHeight: '10px',
    },
    [theme.breakpoints.up('sm')]: {
      height: '60px',
      minHeight: '20px',
    },
    [theme.breakpoints.up('md')]: {
      height: '60px',
      minHeight: '20px',
    },
    [theme.breakpoints.up('lg')]: {
      height: '70px',
    },
    display: 'flex',
    justifyContent: 'space-between',
  },
  logo: {
    zIndex: 0,
    [theme.breakpoints.up('xs')]: {
      width: '40px',
      height: '40px',
    },
    [theme.breakpoints.up('sm')]: {
      width: '50px',
      height: '50px',
    },
    [theme.breakpoints.up('md')]: {
      width: '60px',
      height: '60px',
    },
    [theme.breakpoints.up('lg')]: {
      width: '90px',
      height: '70px',
    },
  },
}));

export default function AppHeader() {
  const classes = useStyles();

  const [anchorEl, setAnchorEl] = useState<Element | null>(null);
  const user = useCurrentUser();

  const location = useLocation();
  const mountainInfoOpen = Boolean(anchorEl);
  const mountains = Object.entries(Mountains);

  function logout() {
    setAnchorEl(null);
    authService.logout();
  }

  function showUserProfile() {
    setAnchorEl(null);
  }

  function showMountainMenu(event: React.MouseEvent<HTMLElement>) {
    setAnchorEl(event.currentTarget);
  }

  return (
    <AppBar position="static" className={classes.bar}>
      <Toolbar className={classes.header}>
        <Link to="/" className={classes.bar}>
          <img src={Logo} className={classes.logo} />
        </Link>
        {mountains.map((mountain) => (
          <HeaderButton mountain={mountain[0]} mountainInBg={mountain[1].toString()}></HeaderButton>
        ))}
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
          <Button color="inherit" component={Link} to="/login" className={classes.login}>
            Login
          </Button>
        )}
      </Toolbar>
    </AppBar>
  );
}
