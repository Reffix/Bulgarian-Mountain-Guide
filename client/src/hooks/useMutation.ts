import { useState } from 'react';

import HttpError from '../errors/http-error';

export default function useMutation<T>(action: () => Promise<T>) {
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState<string | null>(null);

  function unsetError() {
    setError(null);
  }

  async function submit() {
    setLoading(true);
    setError(null);
    try {
      await action();
      setLoading(false);
    } catch (err) {
      setLoading(false);

      if (err instanceof HttpError && err.name === 'InvalidInput') {
        setError(err.message);
        throw err;
      }

      if (err instanceof HttpError && err.name === 'IncorrectPassword') {
        setError(err.message);
        throw err;
      }

      if (err instanceof HttpError && err.name === 'EmptyForm') {
        setError(err.message);
        throw err;
      }

      if (err instanceof HttpError && err.name === 'ForbiddenAction') {
        setError(err.message);
        throw err;
      }

      setError("Something happened, we're working on it");
      throw err;
    }
  }

  return {
    loading,
    error,
    submit,
    unsetError,
  };
}
