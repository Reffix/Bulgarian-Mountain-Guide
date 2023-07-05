import { useLocation, useNavigate } from 'react-router-dom';
import apiService from '../services/api-service';
import { CardInfo } from '../components/card';
import { Container, makeStyles } from '@material-ui/core';
import CardListComponent from '../components/card-list';
import { useEffect, useState } from 'react';
import { Pagination } from '@mui/material';
import { DisplayableEntites } from '../enums/displayable-entities';

const useStyles = makeStyles((theme) => ({
  container: {
    display: 'flex',
    flexDirection: 'column',
    marginTop: '10rem',
    backgroundColor: theme.palette.primary.main,

  }
}));

export default function ListPage({mountain, entity}) {
  const classes = useStyles();

  const [cardList, setCardList] = useState<CardInfo[]>([]);
  const [currentPage, setCurrentPage] = useState(1);
  const [totalPages, setTotalPages] = useState(1);
  useEffect(() => {
    const fetchCardInfo = async () => {
      try {
        const path = `${entity}/${mountain}/${currentPage}/10`;
        const response = await apiService.get<CardInfo[]>(
          path
        );
        console.log(response);
        setCardList(response.data);
        if(mountain === 'Rila')
          setCardList([{title: 'Каравана', description: 'албала', image: 'istockphoto-104731717-612x612.jpg', id: 1}]);
        setTotalPages(cardList.length / 10);
        console.log(cardList);
      } catch (error) {
        console.error('There was an error!', error);
      }
    };

    fetchCardInfo();
    
  }, [mountain, entity, currentPage]);

  const handlePageChange = (event: React.ChangeEvent<unknown>, value: number) => {
    setCurrentPage(value);
  };

  return (<>
    {cardList.length !== 0 && (
      <Container maxWidth="md" className={classes.container}>
        <CardListComponent cardList={cardList} mountain={mountain} entity={entity}></CardListComponent>
        <Pagination count={totalPages} page={currentPage} onChange={handlePageChange} />
      </Container>
    )}

  </>

  );
}