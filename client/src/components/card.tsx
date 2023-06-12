import * as React from 'react';
import { CardActionArea, IconButton, makeStyles } from '@material-ui/core';
import Card from '@mui/material/Card';
import CardHeader from '@mui/material/CardHeader';
import CardMedia from '@mui/material/CardMedia';
import CardContent from '@mui/material/CardContent';
import CardActions from '@mui/material/CardActions';
import Typography from '@mui/material/Typography';
import FavoriteIcon from '@mui/icons-material/Favorite';
import EditIcon from '@mui/icons-material/Edit';
import hotel_vitosha from '../resources/hotel_vitosha.jpg'
import useCurrentUser from "../context/auth-context";

const useStyles = makeStyles((theme) => ({
  card: {
    maxWidth: 'none !important',
    width:'60%',
    height: '10%',
    display: 'flex',
    alignItems: 'center'  
  }}))

export default function CardComponent() {
  const classes = useStyles();
  
  const user = useCurrentUser();

  return (
    <Card sx={{ maxWidth: 345 }} className={classes.card}>
      <CardMedia
        component="img"
        height="194"
        alt="hotel vitosha"
        src={hotel_vitosha}
        />
      <CardActionArea>
        <CardHeader
          title="Hotel Vitosha"
          subheader="4 stars"
        />
        <CardContent>
          <Typography variant="body2" color="text.secondary">
            This impressive paella is a perfect party dish and a fun meal to cook
            together with your guests. Add 1 cup of frozen peas along with the mussels,
            if you like.
          </Typography>
        </CardContent>
      </CardActionArea>
      <div className="buttons">
        <CardActions disableSpacing>
          <IconButton aria-label="settings">
            {!user /*&& user.isAdmin*/ && (<EditIcon />)}
          </IconButton>
        </CardActions>
        <CardActions disableSpacing>
          <IconButton aria-label="add to favorites">
            {!user && (<FavoriteIcon />)}
          </IconButton>
        </CardActions>
      </div>
    </Card>
  );
}