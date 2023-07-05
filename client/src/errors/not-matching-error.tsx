import BaseError from './base-error';

export default class NotMatchError extends BaseError {
  name: string;

  constructor(body?: any) {
    const message = `Passwords doesn't match`;

    super(message);
    this.name = body?.error.name || 'NotMatchError';
  }
}
