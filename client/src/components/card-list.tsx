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

interface CardListCompProps {
  cardList:CardInfo[];
  mountain: string;
  entity:string;
}

export default function CardListComponent(props: CardListCompProps) {
  const classes = useStyles();

  let cardsList = props.cardList;
  const entity = props.entity;
  return (
    <div className={classes.cardList}>
      {cardsList && cardsList.map((card) => (
        <CardComponent cardInfo={card} entity={entity}></CardComponent>
      ))}
    </div>
  );
}