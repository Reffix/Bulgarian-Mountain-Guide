import {
  Box,
  Button,
  CircularProgress,
  Container,
  TextField,
  Typography,
} from '@material-ui/core';
import React, { FormEvent, useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';

import LoginError from '../components/login-error';
import useMutation from '../hooks/useMutation';
import authService from '../services/auth-service';
import loginStyles from '../styles/login-styles';

export default function Login() {
  const classes = loginStyles();

  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const history = useNavigate();
  const {
    error,
    loading,
    submit: submitLogin,
  } = useMutation(() => authService.login(username, password));

  async function submit(event: FormEvent) {
    event.preventDefault();

    await submitLogin();

    history('/');
  }

  return (
    <Container maxWidth="sm" className={classes.page}>
      <Typography variant="h3" align="center" className={classes.text}>
        Welcome back!
      </Typography>
      <Typography variant="h3" align="center" className={classes.text}>
        Ready to find your favourite mountain place?
      </Typography>
      <Typography
        variant="h3"
        align="center"
        noWrap={false}
        className={classes.loginText}
      >
        Login and prepare yourself!
      </Typography>
      <form onSubmit={submit} className={classes.form}>
        <Box display="grid" marginTop={10} gridGap={10}>
          <TextField
            label="Username"
            variant="filled"
            type="username"
            value={username}
            onChange={(event) => setUsername(event.target.value)}
            size="medium"
            InputProps={{
              className: classes.multilineColor,
            }}
            InputLabelProps={{
              className: classes.multilineColor,
            }}
            required
            className={classes.textField}
          />
          <TextField
            label="Password"
            variant="filled"
            type="password"
            value={password}
            onChange={(event) => setPassword(event.target.value)}
            size="medium"
            InputProps={{
              classes: {
                input: classes.multilineColor,
              },
            }}
            InputLabelProps={{
              className: classes.multilineColor,
            }}
            className={classes.textField}
            required
          />
          <Button
            color="primary"
            variant="contained"
            type="submit"
            disabled={loading}
            className={classes.login}
          >
            {loading ? <CircularProgress color="inherit" /> : <>Login</>}
          </Button>
          <LoginError message={error} />
        </Box>
      </form>
      <Box
        display="grid"
        gridTemplateColumns="1fr 100px"
        marginTop={2}
        justifyItems="start"
        alignItems="center"
      />
      <Container maxWidth="xl" className={classes.question}>
        <Typography>This is your first time? </Typography>
        <Typography component={Link} to="/register" color="inherit">
          Register here
        </Typography>
      </Container>
    </Container>
  );
}
