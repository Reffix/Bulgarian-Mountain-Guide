import { createContext, ReactNode, useState } from 'react';

export interface User {
  id: number;
  username: string;
  email: string;
  accessToken?: string;
  refreshToken?: string;
}

interface AuthProps {
  user: User | null;
  setUser: (user: User | null) => void;
  persist: boolean | null;
  setPersist: (persist: boolean | null) => void;
}

const AuthContext = createContext<AuthProps>({
  user: null,
  setUser: () => {}, // eslint-disable-line
  persist: null,
  setPersist: () => false, // eslint-disable-line
});

interface CurrentUserProviderProps {
  children: ReactNode;
}

export const AuthProvider = ({ children }: CurrentUserProviderProps) => {
  const [user, setUser] = useState<User | null>(null);
  const [persist, setPersist] = useState(
    JSON.parse(localStorage.getItem('persist')) || false,
  );

  return (
    <AuthContext.Provider value={{ user, setUser, persist, setPersist }}>
      {children}
    </AuthContext.Provider>
  );
};

export default AuthContext;
