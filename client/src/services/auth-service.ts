import apiService from './api-service';

export interface UserAuth {
  id: number;
  username: string;
  email: string;
  accessToken?: string;
}

type UserChangeHandler = (user: UserAuth | null) => void;

class AuthService {
  private handler: UserChangeHandler | null = null;

  set changeHandler(handler: UserChangeHandler | null) {
    this.handler = handler;
  }

  get storedUser(): UserAuth | null {
    const auth = localStorage.getItem('authentication');

    if (!auth) {
      return null;
    }

    return JSON.parse(auth);
  }

  private setCurrentUser(user: UserAuth | null) {
    if (user) {
      localStorage.setItem('authentication', JSON.stringify(user));
    } else {
      localStorage.removeItem('authentication');
    }
    this.handler?.(user);
  }

  async login(email: string, password: string) {
    const authResult = await apiService.post<UserAuth>('auth/login', { email, password });

    this.setCurrentUser(authResult.data);
  }

  logout() {
    this.setCurrentUser(null);
  }

  async register(username: string, email: string, password: string) {
    return apiService.post<UserAuth>('users', { username, email, password });
  }
}

const authService = new AuthService();
export default authService;
