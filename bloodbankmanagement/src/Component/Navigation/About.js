import React from 'react'
import Header from './Header';
import img from '../Image/bb3.jpg'
import '../Style/About.css';

function About() {
    return (
        <div className="container">
            <Header />
            <h2>ABOUT BLOOD BANK SYSTEM</h2>
            <p>The first blood bank in the United States was established in 1937 by Dr.<br></br> Bernard Fantus at Cook County Hospital in Chicago. 
            <br></br>At the time, it was not possible to store blood for more than a few days.<br></br> 
            Most transfusions were person-to-person, a dangerous process which made it hard to find donors.<br></br>
                Blood banking is the process that takes place in the lab to make sure that donated blood,<br></br> 
                or blood products, are safe before they are used in blood transfusions and other medical<br></br> procedures. 
                Blood banking includes typing the blood for transfusion and testing for infectious <br></br>diseases.</p>

                <h4>Blood Bank Management</h4>
                A blood bank is center where blood gatherd as a result of blood donation<br>
                </br>
                
                <h4>Donar And User Management System</h4>
                <div className="dropdown text-end">
                  <img src={img} alt='About'/>
          </div>
                
            
        </div>
    )
}

export default About