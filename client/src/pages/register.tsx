import {
  Box,
  Button,
  CircularProgress,
  Container,
  TextField,
  Typography,
} from '@material-ui/core';
import { SHA256 } from 'crypto-ts';
import React, { FormEvent, useState } from 'react';
import { Link, useLocation, useNavigate } from 'react-router-dom';

import useMutation from '../hooks/useMutation';
import apiService from '../services/api-service';
import registerStyles from '../styles/register-styles';

export default function SignUp() {
  const classes = registerStyles();

  const [username, setUsername] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');

  const history = useNavigate();
  const location = useLocation();

  const { error, loading, submit } = useMutation(async () => {
    const hashedPassword = SHA256(password);
    const hashedConfirmedPassword = SHA256(confirmPassword);

    apiService.post('users', {
      username,
      email,
      hashedPassword,
      hashedConfirmedPassword,
    });
  });

  async function submitForm(event: FormEvent) {
    event.preventDefault();

    await submit();

    history(location.state?.data || '/');
  }

  return (
    <Container maxWidth="sm" className={classes.page}>
      <Typography variant="h3" align="center" className={classes.text}>
        Don&apos;t have an account?
      </Typography>
      <Typography variant="h5" align="center" className={classes.text}>
        Just make one.
      </Typography>
      <Typography variant="h5" align="center" className={classes.becomeText}>
        Become the best explorer!
      </Typography>
      <form onSubmit={submitForm} className={classes.form}>
        <Box display="grid" marginTop={10} gridGap={10}>
          <TextField
            label="Your name"
            variant="filled"
            size="medium"
            type="text"
            value={username}
            onChange={(event) => setUsername(event.target.value)}
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
            label="Your email"
            variant="filled"
            size="medium"
            type="email"
            value={email}
            onChange={(event) => setEmail(event.target.value)}
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
            size="medium"
            type="password"
            value={password}
            onChange={(event) => setPassword(event.target.value)}
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
            label="Confirm password"
            variant="filled"
            size="medium"
            type="password"
            value={confirmPassword}
            onChange={(event) => setConfirmPassword(event.target.value)}
            InputProps={{
              className: classes.multilineColor,
            }}
            InputLabelProps={{
              className: classes.multilineColor,
            }}
            required
            className={classes.textField}
          />
          <Button
            color="primary"
            variant="contained"
            type="submit"
            disabled={loading}
            className={classes.signup}
          >
            {loading ? <CircularProgress color="inherit" /> : <>Sign up</>}
          </Button>
          {error && <Typography color="secondary">{error}</Typography>}
        </Box>
      </form>
      <Container maxWidth="xl" className={classes.question}>
        <Typography color="inherit">This is not your fist war?</Typography>
        <Typography component={Link} to="/login" color="inherit">
          Login
        </Typography>
      </Container>
    </Container>
  );
}
