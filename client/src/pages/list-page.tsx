import { useLocation } from 'react-router-dom';
import apiService from '../services/api-service';
import { CardInfo } from '../components/card';
import { makeStyles } from '@material-ui/core';
import CardListComponent from '../components/card-list';
import { useEffect, useState } from 'react';
import { Pagination } from '@mui/material';
import { DisplayableEntites } from '../enums/DisplayableEntites';

const useStyles = makeStyles((theme) => ({}));

export default function ListPage() {
  const classes = useStyles();

  const { state } = useLocation();
  const mountain = state.mountain;
  const entity: String = Object.entries(DisplayableEntites)[state.entity][1].toString();

  const [cardList, setCardList] = useState<CardInfo[]>([]);
  const [currentPage, setCurrentPage] = useState(1);
  const [totalPages, setTotalPages] = useState(1);
  useEffect(() => {
    const fetchCardInfo = async () => {
      try {
        const response = await apiService.get<{ data: CardInfo[]; totalPages: number }>(
          'getAll/' + entity + '/' + mountain + '?page=' + currentPage,
        );
        setCardList(response.data.data);
        setTotalPages(response.data.totalPages);
      } catch (error) {
        console.error('There was an error!', error);
      }
    };

    fetchCardInfo();
  }, [mountain, entity, currentPage]);

  const handlePageChange = (event: React.ChangeEvent<unknown>, value: number) => {
    setCurrentPage(value);
  };
  /* 
  [
    {
      title: 'Lorem Ipsum',
      description:
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut feugiat lorem eget gravida pretium. Etiam accumsan sapien eget nibh laoreet, quis condimentum orci bibendum. Vivamus et congue ex. Donec nibh arcu, ullamcorper eget placerat at, interdum quis dolor. Cras facilisis, leo et interdum laoreet, nisi sapien pretium justo, id dapibus libero urna at mauris. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut feugiat lorem eget gravida pretium. Etiam accumsan sapien eget nibh laoreet, quis condimentum orci bibendum. Vivamus et congue ex. Donec nibh arcu, ullamcorper eget placerat at, interdum quis dolor. Cras facilisis, leo et interdum laoreet, nisi sapien pretium justo, id dapibus libero urna at mauris. ',
      image: './../resources/hotel1.jpg',
      stars: 5,
    },
    {
      title: 'Lorem Ipsum',
      description:
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut feugiat lorem eget gravida pretium. Etiam accumsan sapien eget nibh laoreet, quis condimentum orci bibendum. Vivamus et congue ex. Donec nibh arcu, ullamcorper eget placerat at, interdum quis dolor. Cras facilisis, leo et interdum laoreet, nisi sapien pretium justo, id dapibus libero urna at mauris.',
      image: './../resources/hotel2.jpg',
      stars: 5,
    },
  ]
  */

  return (
    <>
      <CardListComponent cardList={cardList}></CardListComponent>
      <Pagination count={totalPages} page={currentPage} onChange={handlePageChange} />
    </>
  );
}
