
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
import BloodInBloodBank from './Component/BloodBank/BloodInBloodBank';
import { useEffect, useState } from 'react';
import http from './Component/axiosHandler';
import BloodBankProfile from './Component/BloodBankProfile';
import { BloodBankSignUp } from './Component/SignUpAndSignOut/BloodBankSignUp';
import AddDonor from './Component/BloodBank/AddDonor';
import UpdateBloodandPlasma from './Component/BloodBank/UpdateBloodandPlasma';



function App() {

  const [userType,setUserType]=useState(0);
  useEffect(()=>{
    http.get("/user-usertype")
      .then((res) => {
        setUserType(res.data);
        console.log(res.data);
      })
      .catch((error) => {
        console.error(error.message);
      });
  },[])
  return (
    <div>
      <Header userType={userType}/>
      <Router>
      <div className="App">
        <Routes>
          <Route path="/" element={<HomePage/>} />
          <Route path="/Login" element={<Login/>} />
          <Route path="/Contact" element={<ContactPage/>} />
          <Route path="/signup" element={<Signup/>} />
          <Route path="/bloodbanksignup" element={< BloodBankSignUp/>}/>
          <Route path='/Profile/:id' element={<Profile/>}/> 
          {/* <Route path='/bloodbankProfile/:ID' element={<BloodBankProfile/>}/>  */}
          <Route path="/dashboard" element={ <DashBoard/>} />
          <Route path="/about" element={<About/>} />
          <Route path="/adddonor" element={<AddDonor/>} />
          <Route path="/bloodbank" element={<BloodBank/>} />
          <Route path="/updatebloodandbank" element={<UpdateBloodandPlasma/>} />
          <Route path="/bloodbankprofile/:ID" element={<BloodBankProfile/>} />
          <Route path="/bloodbankdetail/:id" element={<BloodInBloodBank/>} />
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
