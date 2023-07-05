import * as React from 'react';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select, { SelectChangeEvent } from '@mui/material/Select';
import { Mountains } from '../enums/mountains';
import { useState } from 'react';
import { DisplayableEntites } from '../enums/displayable-entities';
import { Button, FormGroup, TextField } from '@material-ui/core';
import useMutation from '../hooks/useMutation';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import loginStyles from '../styles/login-styles';
import apiService from '../services/api-service';



export default function AddEntity() {

    const classes = loginStyles();

    const history = useNavigate();

    const {
        error,
        loading,
        submit: submitAdd,
      } = useMutation(async () => await apiService.post(`/${DisplayableEntites[entityType]}`, {
        name: name,
        description: description,
        mountain: Mountains[mountain],
      }));
    
      async function submit(event: React.FormEvent) {
        event.preventDefault();
    
        await submitAdd();
    
        history('/');
      }



  const [entityType, setEntityType] = useState('');
  const [name, setName] = useState('');
  const [description, setDescription]  = useState('');
  const [mountain, setMountain] = useState('');

  const entities = Object.values(DisplayableEntites);
  const mountains = Object.values(Mountains);

  return (
    <div>
      <FormControl sx={{ m: 1, minWidth: 80 }}>
      <FormGroup>
        <TextField
        label="Име на тип"
        variant="filled"
        type="email"
        value={name}
        onChange={(event) => setName(event.target.value)}
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
          onChange={(event) => setEntityType(event.target.value)}
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
        onChange={(event) => setDescription(event.target.value)}
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
          onChange={(event) => setMountain(event.target.value)}
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
      </FormControl>
      <Button onClick= {submit}> Submit</Button>
    </div>
  );
}