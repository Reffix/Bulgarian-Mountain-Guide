import { makeStyles } from "@material-ui/core";

const cardButtonStyles = makeStyles((theme) => ({
    card: {
        margin: '1rem',
        backgroundColor: theme.palette.primary.main,
        maxHeight: '400px',
        width: '20%',
    },
    buttonBase:{
        display: 'flex',
        flexDirection: 'column',
        '&:hover': {
            backgroundColor: '#FFA17A',
        },
        color: '#E7FEF7',
    },
    cardImage: {
        maxHeight: '250px',
        objectFit:'contain',
        stroke: '#E7FEF7',
    },
    cardText: {
        marginBottom:'0.5rem',
        fontWeight: 'bold',
        fontSize: '20px',
        letterSpacing: '2px',
    }
}));

export default cardButtonStyles;