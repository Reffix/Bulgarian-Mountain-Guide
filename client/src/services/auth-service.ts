import { JwtPayload } from 'jwt-decode';
import apiService from './api-service';
import jwtDecode from 'jwt-decode';

export interface UserAuth {
  id: number;
  username: string;
  email?: string;
  role: string;
  accessToken?: string;
}

interface Payload extends JwtPayload {
  id: number,
  authorities: Array<string>;
}

export enum Roles {
  admin = 'ADMIN',
  user = 'USER',
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

  async login(username: string, password: string) {
    const authResult = await apiService.post<string>('users/login', { username:username, password:password });

    const auth : Payload =  jwtDecode(authResult.data);
    let user : UserAuth = {
      id:auth.id,
      username: auth.sub,
      role: auth.authorities[0],
      accessToken: authResult.data
    }

    console.log(user);

    this.setCurrentUser(user);
  }

  logout() {
    this.setCurrentUser(null);
  }

  async register(username: string, email: string, password: string, role: string) {
    return apiService.post('users/register/', {
      userRole: role,
      username: username,
      password: password,
      email: email,
    });
  }
}

const authService = new AuthService();
export default authService;
