
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle';
import { Signup } from './Component/SignUpAndSignOut/Signup';

import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Login from './Component/SignUpAndSignOut/Login';
import DashBoard from './Component/DashBoard/DashBoard';
import About from './Component/Navigation/About';
import BloodBank from './Component/BloodBank/BloodBank';
import Profile from './Component/Profile';
import Header from './Component/Navigation/Header';
import HomePage from './Component/Home/Home';
import ContactPage from './Component/Home/ContactPage';


function App() {
  return (
    <div>
      <Header/>
      <Router>
      <div className="App">
        <Routes>
          <Route path="/" element={<HomePage/>} />
          <Route path="/Login" element={<Login/>} />
          <Route path="/Contact" element={<ContactPage/>} />
          <Route path="/signup" element={<Signup/>} />
          <Route path='/Profile/:id' element={<Profile/>}/> 
          <Route path="/dashboard" element={ <DashBoard/>} />
          <Route path="/about" element={<About/>} />
          <Route path="/bloodbank" element={<BloodBank/>} />
          {/* <Route path="/editBloodBank/:id" element={<BloodBankList/>} />
          <Route path="/addBloodBank" element={<BloodBankList/>} /> */}

        </Routes>
        
        </div>
        </Router>
        #footerhere

    </div>

  );
}

export default App;
