import { useLocation } from 'react-router-dom';
import apiService from '../services/api-service';
import CardComponent from '../components/card';
import { makeStyles } from '@material-ui/core';

interface Hotel {
  title: string; //name
  description: string;
  image: string,
  stars: any;
}
const useStyles = makeStyles((theme) => ({
  hotels: {
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
    flexWrap: 'wrap',
    justifyContent: 'center',
  },
}));

export default function Hotels() {
  
  const classes = useStyles();

  const {state} = useLocation();
  const mountain = state.mountain;
  //const hotels = apiService.get('/hotels/' + mountain);
  const hotels:  Hotel[] = [
    {
      title: "Lorem Ipsum",
      description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut feugiat lorem eget gravida pretium. Etiam accumsan sapien eget nibh laoreet, quis condimentum orci bibendum. Vivamus et congue ex. Donec nibh arcu, ullamcorper eget placerat at, interdum quis dolor. Cras facilisis, leo et interdum laoreet, nisi sapien pretium justo, id dapibus libero urna at mauris. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut feugiat lorem eget gravida pretium. Etiam accumsan sapien eget nibh laoreet, quis condimentum orci bibendum. Vivamus et congue ex. Donec nibh arcu, ullamcorper eget placerat at, interdum quis dolor. Cras facilisis, leo et interdum laoreet, nisi sapien pretium justo, id dapibus libero urna at mauris. ",
      image: "./../resources/hotel1.jpg",
      stars: 5
    },
    {
      title: "Lorem Ipsum",
      description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut feugiat lorem eget gravida pretium. Etiam accumsan sapien eget nibh laoreet, quis condimentum orci bibendum. Vivamus et congue ex. Donec nibh arcu, ullamcorper eget placerat at, interdum quis dolor. Cras facilisis, leo et interdum laoreet, nisi sapien pretium justo, id dapibus libero urna at mauris.",
      image: "./../resources/hotel2.jpg",
      stars: 5
    }
  ]
  return (
  <div className={classes.hotels}>
    {hotels.map((hotel)=>(
        <CardComponent cardInfo={hotel}></CardComponent>
    ))}
  </div>
  );
}
