import * as React from 'react';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select, { SelectChangeEvent } from '@mui/material/Select';
import { Mountains } from '../enums/mountains';
import { useState } from 'react';
import { DisplayableEntites } from '../enums/displayable-entities';
import { Button, CircularProgress, Container, FormGroup, TextField } from '@material-ui/core';
import useMutation from '../hooks/useMutation';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import loginStyles from '../styles/login-styles';
import apiService from '../services/api-service';



export default function AddEntity() {

  function getKeyByValueEntity(value: string) {
    const indexOfS = Object.values(DisplayableEntites).indexOf(value as unknown as DisplayableEntites);
  
    const key = Object.keys(DisplayableEntites)[indexOfS];
  
    return key;
  }

  function getKeyByValueMountain(value: string) {
    const indexOfS = Object.values(Mountains).indexOf(value as unknown as Mountains);
  
    const key = Object.keys(Mountains)[indexOfS];
  
    return key;
  }

    const classes = loginStyles();

    const history = useNavigate();

    const {
        error,
        loading,
        submit: submitAdd,
      } = useMutation(async () => await apiService.post(`${getKeyByValueEntity(entityType).toString()}`, {
        name: name,
        description: description,
        mountain: getKeyByValueMountain(mountain).toString().toUpperCase(),
      }));
    
      async function submit(event: React.FormEvent) {
        event.preventDefault();
    
        await submitAdd();
    
        history('/');
      }

  const handleSetMountain = event => {
    setMountain(event.target.value as string);
  }
  const handleSetEntity = event => {
    setEntityType(event.target.value as string);
  }

  const [entityType, setEntityType] = useState('');
  const [name, setName] = useState('');
  const [description, setDescription]  = useState('');
  const [mountain, setMountain] = useState('');

  const entities = Object.values(DisplayableEntites);
  const mountains = Object.values(Mountains);

  return (
    <Container maxWidth="sm" className={classes.page}>
    <form onSubmit={submit}>
      <FormGroup>
        <TextField
        label="Име на тип"
        variant="filled"
        type="string"
        value={name}
        onChange={(event) => setName(event.target.value as string)}
        size="medium"
        InputProps={{
          className: classes.multilineColor,
        }}
        InputLabelProps={{
          className: classes.multilineColor,
        }}
        required
        className={classes.textField}
        />
        </FormGroup>
        <FormGroup>
        <InputLabel id="demo-simple-select-autowidth-label">Тип</InputLabel>
        <Select
          labelId="demo-simple-select-autowidth-label1"
          id="demo-simple-select-autowidth1"
          value={entityType}
          onChange={handleSetEntity}
          autoWidth
          label=""
        >
          {entities.map(entity => (
            <MenuItem value={entity}>
                {entity}
            </MenuItem>
          ))}
        </Select>
        </FormGroup>
        <FormGroup>
        <TextField
        label="Описание"
        variant="filled"
        type="string"
        multiline
        maxRows={25}
        value={description}
        onChange={(event) => setDescription(event.target.value as string)}
        size="medium"
        InputProps={{
          className: classes.multilineColor,
        }}
        InputLabelProps={{
          className: classes.multilineColor,
        }}
        required
        className={classes.textField}
        />
        </FormGroup>
        <FormGroup>
        <Select
          labelId="demo-simple-select-autowidth-label2"
          id="demo-simple-select-autowidth2"
          value={mountain}
          onChange={handleSetMountain}
          autoWidth
          label=""
        >
          {mountains.map(mountain => (
            <MenuItem value={mountain}>
                {mountain}
            </MenuItem>
          ))}
        </Select>
        </FormGroup>
        <Button
            color="primary"
            variant="contained"
            type="submit"
            disabled={loading}
            className={classes.login}
          >
            {loading ? <CircularProgress color="inherit" /> : <>Submit</>}
          </Button>
      </form>
      </Container>
    );
}