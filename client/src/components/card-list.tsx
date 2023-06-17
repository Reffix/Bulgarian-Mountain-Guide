import * as React from 'react';
import { makeStyles } from '@material-ui/core';
import useCurrentUser from '../context/auth-context';
import CardComponent, { CardInfo } from './card';

const useStyles = makeStyles((theme) => ({
  cardList: {
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
    flexWrap: 'wrap',
    justifyContent: 'center',
  },
}));

export default function CardListComponent(params: { cardList: CardInfo[] }) {
  const classes = useStyles();

  const user = useCurrentUser();
  let cardsList = params.cardList;

  return (
    <div className={classes.cardList}>
      {cardsList.map((card) => (
        <CardComponent cardInfo={card}></CardComponent>
      ))}
    </div>
  );
}
