import {
    Box, Button, Typography,
  } from '@material-ui/core';
  import React from 'react';
  import { Link } from 'react-router-dom';
  
  export default function Home() {
    return (
      <Box>
        <Typography>Test</Typography>
        <Button component={Link} to="/login" color="primary" variant="contained">Login</Button>
      </Box>
    );
  }