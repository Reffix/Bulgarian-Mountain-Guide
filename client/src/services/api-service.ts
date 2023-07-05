import axios from 'axios';

//import 'dotenv/config';
import authService from './auth-service';

class ApiService {
  private baseUrl: string;

  constructor(baseUrl: string) {
    this.baseUrl = baseUrl;
  }

  async get<T>(path: string, body?:  { [key: string]: any }) {
    const user = authService.storedUser;
    return axios.get<T>(`${this.baseUrl}/${path}`, {
      method: `GET`,
      headers: {
        Authorization: user ? `Bearer ${user.accessToken}` : null,
      },
      data: JSON.stringify(body),
    });
  }

  async post<T>(path: string, body: { [key: string]: any } ) {
    const user = authService.storedUser;
    // return axios.post<T>(`${this.baseUrl}/${path}`, {
    //   method: `POST`,
    //   headers: {
    //     'Accept': '*/*',
    //     'Content-Type': 'application/json',
    //     'Access-Control-Allow-Origin': '*',
    //     'Access-Control-Allow-Methods:' : '*',
    //     'Access-Control-Allow-Headers': '*',
    //     'Connection':'keep-alive',
    //     //Authorization: user ? `Bearer ${user.accessToken}` : null,
    //   },
    //   data: JSON.stringify(body),
    // });

    return axios({
      url: `${this.baseUrl}/${path}`,
      method: 'POST',
      data: JSON.stringify(body),
      headers: { 'Content-Type': 'application/json' ,
      Authorization: user ? `Bearer ${user.accessToken}` : null,
    }
      
    })
  }

  async delete<T>(path: string, body?:  { [key: string]: any }) {
    const user = authService.storedUser;
    return axios({
      url:`${this.baseUrl}/${path}`, 
      method: `DELETE`,
      headers: {
        Authorization: user ? `Bearer ${user.accessToken}` : null,
      },
      data: JSON.stringify(body), 
  });
  }
}

const apiService = new ApiService('http://localhost:8080');
//process.env.REACT_APP_BASE_URL
export default apiService;
