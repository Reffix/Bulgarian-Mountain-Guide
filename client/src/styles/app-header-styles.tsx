import { makeStyles } from "@material-ui/core";

const appHeaderStyles = makeStyles((theme) => ({
    login: {
      [theme.breakpoints.up('xs')]: {
        height: '30px',
      },
      [theme.breakpoints.up('sm')]: {
        height: '40px',
      }, 
      marginRight: '10px',
      '&:hover': {
        backgroundColor: '#FFA17A',
      },
      color:'#E7FEF7',
    },
    bar: {
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
    menuText: {
        color: '#E7FEF7',
    }
  }));

  export default appHeaderStyles;