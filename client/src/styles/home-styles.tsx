import { makeStyles } from '@material-ui/core';

const homeStyles = makeStyles((theme) => ({
    container: {
      display: 'grid',
      gridGap: '10px',
      gridTemplateColumns: 'repeat(2, 1fr)',
      alignItems: 'center',
      width: '83%',
      marginLeft: '10rem',
      marginTop: '1rem',
    },
    headerText: {
      margin: '3rem',
      gridColumn: '1/-1',
    },
    buttons: {
      gridColumn: '1/-1',
      marginTop: '5rem',
    },
    text: {
      textAlign: 'right',
    },
    mountainMan: {
      marginTop: '5rem',
      marginBottom: '8rem',
      marginRight: '2rem',
      alignSelf: 'start',
    },
    mountainManImage:{
      objectFit: 'fill',
      maxHeight: '700px',
    },
    mountainHike: {
      marginTop: '5rem',
      gridColumn: '2/2',
      alignSelf: 'start',
      marginBottom: '8rem',
      marginLeft: '2rem',
    },
    mountainHikeImage: {
      maxHeight: '700px',
      objectFit: 'fill',
    }
  }));

  export default homeStyles;