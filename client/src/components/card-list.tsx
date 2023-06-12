import * as React from 'react';
import { makeStyles } from '@material-ui/core';
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
  let cardsList = [];
  return (
    <CardComponent></CardComponent>
  );
}