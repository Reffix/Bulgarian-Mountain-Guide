import BungalowIcon from '@mui/icons-material/Bungalow';
import HotelIcon from '@mui/icons-material/Hotel';
import DirectionsWalkIcon from '@mui/icons-material/DirectionsWalk';
import AttractionsIcon from '@mui/icons-material/Attractions';
import PetsIcon from '@mui/icons-material/Pets';
import ParkIcon from '@mui/icons-material/Park';
import TerrainIcon from '@mui/icons-material/Terrain';
import KeyboardArrowDownIcon from '@mui/icons-material/KeyboardArrowDown';

export enum DisplayableEntites {
  Hotel = 'Хотели',
  Cottage = 'Хижи',
  Route = 'Пътеки',
  Attraction = 'Атракции',
  Landmark = 'Забележителности',
  Flora = 'Флора',
  Fauna = 'Фауна',
}

export function GetIcon(entity: DisplayableEntites) {
  switch (entity) {
    case DisplayableEntites.Hotel:
      return <HotelIcon />;
    case DisplayableEntites.Cottage:
      return <BungalowIcon />;
    case DisplayableEntites.Route:
      return <DirectionsWalkIcon />;
    case DisplayableEntites.Attraction:
      return <AttractionsIcon />;
    case DisplayableEntites.Landmark:
      return <TerrainIcon />;
    case DisplayableEntites.Flora:
      return <ParkIcon />;
    case DisplayableEntites.Fauna:
      return <PetsIcon />;
  }
}
