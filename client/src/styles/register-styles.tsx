import { makeStyles } from '@material-ui/core';

const registerStyles = makeStyles((theme) => ({
  welcome: {
    marginTop: theme.spacing(6),
  },
  multilineColor: {
    color: 'black',
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
  question: {
    fontSize: '1px',
    justifyContent: 'center',
    display: 'flex',
    gap: '5px',
    marginTop: '25px',
  },
  page: {
    marginTop: '30px',
    display: 'flex',
    flexDirection: 'column',
    justifyContent: 'center',
    alignItems: 'center',
  },
  form: {
    marginTop: '-0.5rem',
    display: 'flex',
  },
  text: {
    [theme.breakpoints.up('xs')]: {
      fontSize: '16px',
    },
    [theme.breakpoints.up('sm')]: {
      fontSize: '20px',
    },
    [theme.breakpoints.up('md')]: {
      fontSize: '24x',
    },
    [theme.breakpoints.up('lg')]: {
      fontSize: '28px',
    },
    marginTop: '10px',
    textAlign: 'center',
    letterSpacing: '0px',
    opacity: '1',
    fontSize: '24px',
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
    marginBottom: '5px',
  },
  becomeText: {
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
    marginTop: '15px',
  },
  signup: {
    height: '50px',
    border: '1px solid #707070',
    fontSize: '26px',
    fontFamily: 'Goldan, Regular',
    textAlign: 'center',
    textTransform: 'none',
    marginTop: '20px',
  },
}));

export default registerStyles;
