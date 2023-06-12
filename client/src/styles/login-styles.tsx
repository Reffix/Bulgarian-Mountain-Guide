import { makeStyles } from '@material-ui/core';

const loginStyles = makeStyles((theme) => ({
  multilineColor: {
    [theme.breakpoints.up('xs')]: {
      fontSize: '12px',
    },
    [theme.breakpoints.up('sm')]: {
      fontSize: '12px',
    },
    [theme.breakpoints.up('md')]: {
      fontSize: '16px',
    },
    [theme.breakpoints.up('lg')]: {
      fontSize: '16px',
    },
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
    [theme.breakpoints.up('xs')]: {
      fontSize: '12px',
    },
    [theme.breakpoints.up('sm')]: {
      fontSize: '16px',
    },
    [theme.breakpoints.up('md')]: {
      fontSize: '20px',
    },
    [theme.breakpoints.up('lg')]: {
      fontSize: '24px',
    },
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
    [theme.breakpoints.up('xs')]: {
      width: '14rem',
    },
    [theme.breakpoints.up('sm')]: {
      width: '24rem',
    },
    [theme.breakpoints.up('md')]: {
      width: '30rem',
    },
    [theme.breakpoints.up('lg')]: {
      width: '40rem',
    },
    backgroundColor: '#FFFFFF',
    margin: '10px 10px 10px 10px',
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
    [theme.breakpoints.up('xs')]: {
      fontSize: '28px',
    },
    [theme.breakpoints.up('sm')]: {
      fontSize: '32px',
    },
    [theme.breakpoints.up('md')]: {
      fontSize: '36px',
    },
    [theme.breakpoints.up('lg')]: {
      fontSize: '40px',
    },
    textAlign: 'center',
    fontFamily: 'Goldman',
    width: '520px',
    height: '50px',
    overflowWrap: 'break-word',
  },
}));

export default loginStyles;
