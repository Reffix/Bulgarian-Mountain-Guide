import { Link, Navigate, useNavigate } from 'react-router-dom';
import { Button, Menu, MenuItem } from '@material-ui/core';
import { useState } from 'react';
import BungalowIcon from '@mui/icons-material/Bungalow';
import HotelIcon from '@mui/icons-material/Hotel';
import DirectionsWalkIcon from '@mui/icons-material/DirectionsWalk';
import AttractionsIcon from '@mui/icons-material/Attractions';
import PetsIcon from '@mui/icons-material/Pets';
import ParkIcon from '@mui/icons-material/Park';
import TerrainIcon from '@mui/icons-material/Terrain';
import KeyboardArrowDownIcon from '@mui/icons-material/KeyboardArrowDown';
import { DisplayableEntites } from '../enums/DisplayableEntites';

export default function HeaderButton({ mountain, mountainInBg }) {
  const [anchorEl, setAnchorEl] = useState<Element | null>(null);
  const selectedMountain = useNavigate();

  //
  const mountainInfoOpen = Boolean(anchorEl);

  function showMountainMenu(event: React.MouseEvent<HTMLElement>) {
    setAnchorEl(event.currentTarget);
  }

  return (
    <div>
      <Button
        color="inherit"
        aria-controls={open ? 'basic-menu' : undefined}
        aria-haspopup="true"
        aria-expanded={open ? 'true' : undefined}
        onClick={showMountainMenu}
      >
        {mountainInBg.toString()} <KeyboardArrowDownIcon />
      </Button>
      <Menu
        id="basic-menu"
        aria-labelledby="demo-positioned-button"
        anchorEl={anchorEl}
        open={mountainInfoOpen}
        onClose={() => setAnchorEl(null)}
        onMouseLeave={() => setAnchorEl(null)}
      >
        <MenuItem
          onClick={() => {
            selectedMountain('/listPage', {
              state: { mountain: mountain, entity: DisplayableEntites.Hotel },
            });
            setAnchorEl(null);
          }}
        >
          <HotelIcon /> Хотели{' '}
        </MenuItem>
        <MenuItem
          onClick={() => {
            selectedMountain('/cottages', {
              state: { mountain: mountain, entity: DisplayableEntites.Cottage },
            });
            setAnchorEl(null);
          }}
        >
          <BungalowIcon /> Хижи{' '}
        </MenuItem>
        <MenuItem
          onClick={() => {
            selectedMountain('/routes', {
              state: { mountain: mountain, entity: DisplayableEntites.Route },
            });
            setAnchorEl(null);
          }}
        >
          <DirectionsWalkIcon /> Пътеки{' '}
        </MenuItem>
        <MenuItem
          onClick={() => {
            selectedMountain('/flora', {
              state: { mountain: mountain, entity: DisplayableEntites.Flora },
            });
            setAnchorEl(null);
          }}
        >
          <ParkIcon /> Растителност{' '}
        </MenuItem>
        <MenuItem
          onClick={() => {
            selectedMountain('/fauna', {
              state: { mountain: mountain, entity: DisplayableEntites.Fauna },
            });
            setAnchorEl(null);
          }}
        >
          <PetsIcon /> Животни{' '}
        </MenuItem>
        <MenuItem
          onClick={() => {
            selectedMountain('/landmarks', {
              state: { mountain: mountain, entity: DisplayableEntites.Landmark },
            });
            setAnchorEl(null);
          }}
        >
          <TerrainIcon /> Забележителности{' '}
        </MenuItem>
        <MenuItem
          onClick={() => {
            selectedMountain('/attractions', {
              state: { mountain: mountain, entity: DisplayableEntites.Attraction },
            });
            setAnchorEl(null);
          }}
        >
          <AttractionsIcon /> Атракции{' '}
        </MenuItem>
      </Menu>
    </div>
  );
}
