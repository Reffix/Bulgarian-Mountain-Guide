import { Box, Grid, Typography } from '@material-ui/core';
import Image from 'mui-image';
import Background from '../resources/pexels-oziel-gómez-868097.jpg';
import CardButton from '../components/card-button';
import { Mountains } from '../enums/mountains';
import mountainPictureMan from '../resources/pexels-amine-m\'siouri-2108845.jpg'
import mountainHike from '../resources/pexels-vishal-amin-910307.jpg'
import homeStyles from '../styles/home-styles';


export default function Home() {

  const classes = homeStyles();

  const mountains = Object.entries(Mountains);

  return (
    <Box>
      <Grid wrap='wrap' container direction="column" className={classes.container}>
        <Grid item xs className={classes.headerText}>
          <Typography align='center' variant="h2">ОПОЗНАЙ ПЛАНИНИТЕ В БЪЛГАРИЯ</Typography>
        </Grid>
        <Grid item xs={10}>
          <Image fit='cover' src={Background} />
        </Grid>
        <Grid item className={classes.text}> 
          <Typography align='right' variant="overline">Нашата държава е пълна с планини, над 30% от нейната територия е покрита с тях. Планините могат да съществуват поотделно, но често са и част от големи планински масиви. Повечето хора знаят по-известните като: Рила, Пирин, Родопи, Стара планина и още няколко. В България има 39 планини. Те са характерни със своята красота и интересни гледки – предлагат уникален релеф, фауна и флора. По-голямата част от тях са разположени в южната и югозападната част на държавата. Често са посещавани от любители туристи и напреднали алпинисти, тъй като предлагат многобройни маршрути – от малки леки разходки и красиви езера, до големи преходи и високи върхове.</Typography>
        </Grid>
        <Grid item className={classes.buttons}> 
          <Box display='flex' justifyContent="space-between">
            {mountains.map((mountain) => (
            <CardButton mountain={mountain[0]} mountainInBg={mountain[1].toString()}></CardButton>
            ))}
          </Box>
        </Grid>
        <Grid item className={classes.mountainMan}>
          <Image src={mountainPictureMan} className={classes.mountainManImage}/>
        </Grid>
        <Grid item className={classes.mountainHike}>
          <Image src={mountainHike} className={classes.mountainHikeImage}/>
        </Grid>
      </Grid>
    </Box>
  );
}
