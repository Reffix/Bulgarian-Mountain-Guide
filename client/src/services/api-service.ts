import axios from 'axios';
import 'dotenv/config';
import authService from './auth-service';

class ApiService {
    private baseUrl: string;

    constructor(baseUrl: string) {
        this.baseUrl = baseUrl;
    }

    async get<T>(path: string) {
      const user = authService.storedUser;
      return axios.get<T>(`${this.baseUrl}/${path}`, {
        method: `GET`,
        headers: {
          'Authorization' : user ? `Bearer ${user.accessToken}` : null,
        }
      });
    }

    async post<T>(path: string, body: {[key: string]: any }) {
      const user = authService.storedUser;
      return axios.post<T>(`${this.baseUrl}/${path}`, {
        method: `POST`,
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
          'Authorization' : user ? `Bearer ${user.accessToken}` : null,
        },
        body: JSON.stringify(body),
      });
    }

    async delete<T>(path: string) {
      const user = authService.storedUser;
      return axios.delete<T>(`${this.baseUrl}/${path}`, {
        method: `DELETE`,
        headers: {
          'Authorization' : user ? `Bearer ${user.accessToken}` : null,
        }
      });
    }
}

const apiService = new ApiService(process.env.REACT_APP_BASE_URL);
export default apiService;