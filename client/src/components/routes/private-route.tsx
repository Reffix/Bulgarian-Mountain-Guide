import React from "react";
import { Navigate, Outlet, Route } from "react-router-dom";
import useCurrentUser from "../../context/auth-context";

const PrivateRoute = () => {
  const user = useCurrentUser();

    return user ? <Outlet /> : <Navigate to="/login" />;
};
export default PrivateRoute;