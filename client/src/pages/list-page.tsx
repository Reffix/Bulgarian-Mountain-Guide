import { useLocation, useNavigate } from 'react-router-dom';
import apiService from '../services/api-service';
import { CardInfo } from '../components/card';
import { makeStyles } from '@material-ui/core';
import CardListComponent from '../components/card-list';
import { useEffect, useState } from 'react';
import { Pagination } from '@mui/material';
import { DisplayableEntites } from '../enums/displayable-entities';

const useStyles = makeStyles((theme) => ({}));

export default function ListPage({mountain, entity}) {
  const classes = useStyles();

  const [cardList, setCardList] = useState<CardInfo[]>([]);
  const [currentPage, setCurrentPage] = useState(1);
  const [totalPages, setTotalPages] = useState(1);
  useEffect(() => {
    const fetchCardInfo = async () => {
      try {
        const path = `${entity}/${mountain}/${currentPage}/10`;
        console.log(path);
        const response = await apiService.get<{ data: CardInfo[]; totalPages: number }>(
          path
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

  return (
    <>
      <CardListComponent cardList={cardList}></CardListComponent>
      <Pagination count={totalPages} page={currentPage} onChange={handlePageChange} />
    </>
  );
}