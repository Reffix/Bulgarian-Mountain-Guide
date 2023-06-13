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
      title: "title",
      description: "desc",
      image: "https://www.google.com/imgres?imgurl=https%3A%2F%2Flirp.cdn-website.com%2F11191c87%2Fdms3rep%2Fmulti%2Fopt%2Fbuilding1-feded8e1-640w.jpg&tbnid=bNbFd6Q4Gz8XpM&vet=12ahUKEwj6rNzXtMD_AhVIhqQKHZopAPkQMygAegUIARDfAQ..i&imgrefurl=https%3A%2F%2Fwww.limakhotels.com%2Fskopje&docid=FRYXmVxACV1WkM&w=640&h=598&q=hotel&ved=2ahUKEwj6rNzXtMD_AhVIhqQKHZopAPkQMygAegUIARDfAQ",
      stars: 5
    },
    {
      title: "title",
      description: "desc",
      image: "./../resources/hotel2",
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
