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
import { DisplayableEntites, GetIcon } from '../enums/DisplayableEntites';

export default function HeaderButton({ mountain, mountainInBg }) {
  const [anchorEl, setAnchorEl] = useState<Element | null>(null);
  const selectedMountain = useNavigate();

  const entities = Object.entries(DisplayableEntites);

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
        {entities.map((entity) => (
          <MenuItem
            onClick={() => {
              selectedMountain('/listPage', {
                state: { mountain: mountain, entity: entity[0] },
              });
              setAnchorEl(null);
            }}
          >
            {GetIcon(entity[1])} {entity[1].toString()}
          </MenuItem>
        ))}
      </Menu>
    </div>
  );
}
