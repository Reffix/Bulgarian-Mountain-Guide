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
import apiService from '../services/api-service';
import { useLocation } from 'react-router-dom';
import { DisplayableEntites } from '../enums/displayable-entities';

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
  },
}));

export interface CardInfo {
  title: string;
  description: string;
  image: string;
  id: number;
}

export default function CardComponent(params: { cardInfo: CardInfo }) {
  const classes = useStyles();
  const cardInfo = params.cardInfo;
  const user = useCurrentUser();

  const { state } = useLocation();
  const mountainst = state.mountain;
  const entity: String = Object.entries(DisplayableEntites)[state.entity][1].toString();

  const handleAddFavorite = async (cardInfo) => {
    await apiService.post(`/users/add-favourites/${user.id}`, {
        entity_id: cardInfo.id,
        type: entity
    })
  } 

  return (
    <Card sx={{ maxWidth: 345 }} className={classes.card}>
      <CardMedia
        component="img"
        height="194"
        src={new URL(cardInfo.image, import.meta.url).href}
        alt="hotel vitosha"
      />
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
            {!user && user.role == 'ROLE_ADMIN' && <EditIcon />}
          </IconButton>
        </CardActions>
        <CardActions disableSpacing>
          <IconButton aria-label="add to favorites"  onClick={handleAddFavorite}>
            {!user && <FavoriteIcon />}
          </IconButton>
        </CardActions>
      </div>
    </Card>
  );
}