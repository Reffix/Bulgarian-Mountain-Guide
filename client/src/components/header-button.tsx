import { Link } from 'react-router-dom';
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

export default function HeaderButton({mountain, mountainInBg}) {
  const [anchorEl, setAnchorEl] = useState<Element | null>(null);

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
            onMouseEnter={showMountainMenu}
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
            <MenuItem component={Link} to={mountain + "/hotels"} onClick={() => setAnchorEl(null)}><HotelIcon /> Хотели </MenuItem>
            <MenuItem component={Link} to={mountain + "/cottages"} onClick={() => setAnchorEl(null)}><BungalowIcon /> Хижи </MenuItem>
            <MenuItem component={Link} to={mountain + "/routes"} onClick={() => setAnchorEl(null)}><DirectionsWalkIcon /> Пътеки </MenuItem>
            <MenuItem component={Link} to={mountain + "/flora"} onClick={() => setAnchorEl(null)}><ParkIcon /> Растителност </MenuItem>
            <MenuItem component={Link} to={mountain + "/fauna"} onClick={() => setAnchorEl(null)}><PetsIcon /> Животни </MenuItem>
            <MenuItem component={Link} to={mountain + "/landmarks"} onClick={() => setAnchorEl(null)}><TerrainIcon /> Забележителности </MenuItem>
            <MenuItem component={Link} to={mountain + "/attractions"} onClick={() => setAnchorEl(null)}><AttractionsIcon /> Атракции </MenuItem>
        </Menu>
    </div>
  );
}

