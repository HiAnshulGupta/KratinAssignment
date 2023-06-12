import './App.css';
import React from 'react'
import SignIn from './Component/Login'
import Signup from './Component/Register';
import ProfilePage from './Component/ProfilePage';
import { BrowserRouter as Router, Routes, Route,useLocation } from "react-router-dom";

function App() {
  const ScrollToTop = () => {
    const { pathname } = useLocation();

    React.useEffect(() => {
      window.scrollTo(0, 0);
    }, [pathname]);

    return null;
  };

  return (
    <Router>
      <div className="App">


        <Routes>
          <Route exact path="/" element={<SignIn />}></Route>
          <Route exact path="/User" element={<Signup />}></Route>
          <Route path="/profile/:userId" element={<ProfilePage/>} />

        </Routes>

      </div>
    </Router>
  );
}

export default App;
