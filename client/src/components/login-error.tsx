import { Typography } from '@material-ui/core';
import React from 'react';

interface ErrorProps {
  message: string | null;
}

export default function LoginError(props: ErrorProps) {
  return (
    <>
      {props.message && <Typography color="error">{props.message}</Typography>}
    </>
  );
}