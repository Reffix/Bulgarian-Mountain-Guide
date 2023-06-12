import { Box, Button, CircularProgress, Container, makeStyles, TextField, Typography } from '@material-ui/core';
import React, { useState, FormEvent } from 'react';
import { useNavigate, Link } from 'react-router-dom';
import useMutation from '../hooks/useMutation'
import LoginError from '../components/login-error';
import authService from '../services/auth-service';

const useStyles = makeStyles((theme) => ({
    multilineColor: {
        color: 'black',
    },
    page: {
        marginTop: '50px',
        display: 'flex',
        flexDirection: 'column',
        justifyContent: 'center',
        alignItems: 'center',
    },
    text: {
        marginTop: theme.spacing(2),
        textAlign: 'center',
        font: 'Montserrat',
        letterSpacing: '0px',
        opacity: '1',
        fontSize: '24px',
    },
    question: {
        fontFamily: 'Montserrat',
        fontSize: '1px',
        justifyContent: 'center',
        display: 'flex',
        gap: '5px',
        marginTop: '15px',
    },
    textField: {
        backgroundColor: '#FFFFFF',
        width: '400px',
        height: '50px',
        marginBottom: '8px',
    },
    form: {
        display: 'flex',
    },
    login: {
        height: '50px',
        border: '1px solid #707070',
        fontSize: '26px',
        fontFamily: 'Goldan, Regular',
        textAlign: 'center',
        textTransform: 'none',
        marginTop: '35px',
    },
    loginText: {
        marginTop: '50px',
        fontSize: '40px',
        textAlign: 'center',
        fontFamily: 'Goldman',
        width: '520px',
        height: '50px',
    },

}));

export default function Login() {
    const classes = useStyles();

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const history = useNavigate();
    const {
        error, loading, submit: submitLogin,
    } = useMutation(() => authService.login(email, password));

    async function submit(event: FormEvent) {
        event.preventDefault();

        await submitLogin();

        history('/');
    }

    return (
        <Container maxWidth="sm" className={classes.page}>
            <Typography variant="h3" align="center" className={classes.text}>Welcome back!</Typography>
            <Typography variant="h3" align="center" className={classes.text}>Ready to find your favourite mountain place?</Typography>
            <Typography variant="h3" align="center" className={classes.loginText}>Login and prepare yourself!</Typography>
            <form onSubmit={submit} className={classes.form}>
                <Box display="grid" marginTop={10} gridGap={10}>
                    <TextField
                        label="Email"
                        variant="filled"
                        type="email"
                        value={email}
                        onChange={(event) => setEmail(event.target.value)}
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
                <Typography component={Link} to="/signup" color="inherit">
                    Register here
          </Typography>
            </Container>
        </Container>
    );
}