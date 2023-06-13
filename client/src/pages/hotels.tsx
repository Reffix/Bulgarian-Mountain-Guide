import { Mountains } from '../enums/Mountains';
import apiService from '../services/api-service';

export interface Hotel {
  title: string; //name
  description: string;
  stars: any;
}

export default function Hotels(mountain: string) {
  //const hotels = apiService.get(mountain + '/hotels');
  const str: string = mountain;

  return <div>{str + '/hotels'}</div>;
}
