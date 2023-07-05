import BungalowIcon from '@mui/icons-material/Bungalow';
import HotelIcon from '@mui/icons-material/Hotel';
import DirectionsWalkIcon from '@mui/icons-material/DirectionsWalk';
import AttractionsIcon from '@mui/icons-material/Attractions';
import PetsIcon from '@mui/icons-material/Pets';
import ParkIcon from '@mui/icons-material/Park';
import TerrainIcon from '@mui/icons-material/Terrain';

export enum DisplayableEntites {
  hotels = 'Хотели' as any,
  cottages = 'Хижи' as any,
  routes = 'Пътеки' as any,
  attractions = 'Атракции' as any,
  landmarks = 'Забележителности' as any,
  flora = 'Флора' as any,
  fauna = 'Фауна' as any,
}

export function GetIcon(entity: DisplayableEntites) {
  switch (entity) {
    case DisplayableEntites.hotels:
      return <HotelIcon />;
    case DisplayableEntites.cottages:
      return <BungalowIcon />;
    case DisplayableEntites.routes:
      return <DirectionsWalkIcon />;
    case DisplayableEntites.attractions:
      return <AttractionsIcon />;
    case DisplayableEntites.landmarks:
      return <TerrainIcon />;
    case DisplayableEntites.flora:
      return <ParkIcon />;
    case DisplayableEntites.fauna:
      return <PetsIcon />;
  }
}