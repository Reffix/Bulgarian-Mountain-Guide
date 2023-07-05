import { Link, Navigate, useNavigate } from 'react-router-dom';
import { Box, Button, ButtonBase, Card, CardActionArea, CardContent, CardMedia, Menu, MenuItem, Paper, Typography, makeStyles } from '@material-ui/core';
import { useState } from 'react';
import KeyboardArrowDownIcon from '@mui/icons-material/KeyboardArrowDown';
import { DisplayableEntites, GetIcon } from '../enums/displayable-entities';
import mountainIcon from '../resources/mountain-15.svg';
import Image from 'mui-image';
import cardButtonStyles from '../styles/card-button-styles';
import EntityMenu from './entity-menu';



export default function CardButton({ mountain }) {
  const [anchorEl, setAnchorEl] = useState<Element | null>(null);

  function showMountainMenu(event: React.MouseEvent<HTMLElement>) {
    setAnchorEl(event.currentTarget);
  }

  const classes = cardButtonStyles();

  return (
    <>
      <Card className={classes.card} raised>
        <CardActionArea className={classes.buttonBase}
        aria-controls={open ? 'basic-menu' : undefined}
        aria-haspopup="true"
        aria-expanded={open ? 'true' : undefined}
        onClick={showMountainMenu}>
            <Image className={classes.cardImage}src={mountainIcon}/>
            <Typography className={classes.cardText}>{mountain[1].toString()}</Typography>
        </CardActionArea>
      </Card>
      <EntityMenu mountain={mountain} anchorEl={anchorEl} setAnchorEl={setAnchorEl} handleMainClose={null}/>
    </>
  );
}