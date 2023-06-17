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
import useCurrentUser from '../context/auth-context';

const useStyles = makeStyles((theme) => ({
  card: {
    maxWidth: 'none !important',
    width: '60%',
    height: '10%',
    display: 'flex',
    alignItems: 'center',    
    marginTop: '1em',
  },
  cardContent: {
    overflow: 'hidden',
    textOverflow: 'ellipsis',
    display: '-webkit-box',
    '-webkit-line-clamp': 4, // Show 3 lines of text before truncating
    '-webkit-box-orient': 'vertical',
  }
}));

interface CardInfo {
  title: string;
  description: string;
  image: string;
}

export default function CardComponent(params: {cardInfo: CardInfo}) {
  const classes = useStyles();
  const cardInfo = params.cardInfo;
  const user = useCurrentUser();

  return (
    <Card sx={{ maxWidth: 345 }} className={classes.card}>
      <CardMedia component="img" height="194" src={new URL(cardInfo.image, import.meta.url).href} alt="hotel vitosha" />
      <CardActionArea>
        <CardHeader title={cardInfo.title} subheader="4 stars" />
        <CardContent className={classes.cardContent}>
          <Typography variant="body2" color="text.secondary">
              {cardInfo.description}
          </Typography>
        </CardContent>
      </CardActionArea>
      <div className="buttons">
        <CardActions disableSpacing>
          <IconButton aria-label="settings">
            {!user /*&& user.isAdmin*/ && <EditIcon />}
          </IconButton>
        </CardActions>
        <CardActions disableSpacing>
          <IconButton aria-label="add to favorites">
            {!user && <FavoriteIcon />}
          </IconButton>
        </CardActions>
      </div>
    </Card>
  );
}
