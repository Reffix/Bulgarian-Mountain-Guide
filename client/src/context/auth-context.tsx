import { 
    createContext, ReactNode, useEffect, useState, useContext
} from 'react';
import authService, { UserAuth } from '../services/auth-service';


const AuthContext = createContext<UserAuth | null>(null);

interface CurrentUserProviderProps {
  children: ReactNode;
}

export const AuthProvider = ({ children }: CurrentUserProviderProps) => {
    const [user, setUser] = useState<UserAuth | null>(authService.storedUser);
  
    useEffect(() => {
      authService.changeHandler = setUser;
      return () => { authService.changeHandler = null; };
    });
  
    return (
      <AuthContext.Provider value={user}>
        {children}
      </AuthContext.Provider>
    );
  }
  
  export default function useCurrentUser() {
    return useContext(AuthContext);
  }