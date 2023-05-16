import axios from 'axios';
import useAuth from '../hooks/useAuth';
import 'dotenv/config';

class ApiService {
    private baseUrl: string;

    constructor(baseUrl: string) {
        this.baseUrl = baseUrl;
    }

    async get<T>(path: string) {
      const user = useAuth().user;
      return axios.get<T>(`${this.baseUrl}/${path}`, {
        method: `GET`,
        headers: {
          'Authorization' : user ? `Bearer ${user.accessToken}` : null,
        }
      });
    }

    async post<T>(path: string) {
      const user = useAuth().user;
      return axios.post<T>(`${this.baseUrl}/${path}`, {
        method: `POST`,
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json',
          'Authorization' : user ? `Bearer ${user.accessToken}` : null,
        }
      });
    }

    async delete<T>(path: string) {
      const user = useAuth().user;
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