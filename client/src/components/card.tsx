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
import axios, { AxiosHeaders } from 'axios';

const useStyles = makeStyles((theme) => ({
  card: {
    width: '100%',
    display: 'flex',
    alignItems: 'center',
    marginTop: '1em',
    color: "#E7FEF7",
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

interface CardComponentProps {
  cardInfo: CardInfo;
  entity: string;
}

export default function CardComponent(props:CardComponentProps) {
  const classes = useStyles();
  const cardInfo = props.cardInfo;
  const user = useCurrentUser();

  const { state } = useLocation();

  const handleAddFavorite = async () => {
    console.log(JSON.stringify(
      {
        entity_id: cardInfo.id,
        type: props.entity.slice(0, props.entity.length - 1),
      }));
    await axios({url: `http://localhost:8080/users/add-favourites/${user.id}`,
    method: 'PUT', 
    data : JSON.stringify(
    {
      entity_id: cardInfo.id,
      type: props.entity.slice(0, props.entity.length - 1),
    }),
    headers : { 'Content-Type': 'application/json' ,
      Authorization: user ? `Bearer ${user.accessToken}` : null,
    }
  });
    
  } 

  return (
    <Card className={classes.card}>
      <CardMedia
        component="img"
        height="194"
        src={new URL(`../resources/${cardInfo.image}`, import.meta.url).href}
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
            {user && user.role === 'ROLE_ADMIN' && <EditIcon />}
          </IconButton>
        </CardActions>
        <CardActions disableSpacing>
          <IconButton aria-label="add to favorites"  onClick={handleAddFavorite}>
            {user && <FavoriteIcon />}
          </IconButton>
        </CardActions>
      </div>
    </Card>
  );
}