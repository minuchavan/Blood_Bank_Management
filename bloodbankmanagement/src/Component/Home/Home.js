import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faHeartbeat,  faTint,faClinicMedical, faInfoCircle } from '@fortawesome/free-solid-svg-icons';
import '../Style/HomePage.css'; // Ensure you import the CSS file

const HomePage = () => {
  return (
    <div className="home-page">
      <section className="main-content">
        <h1>Welcome to the Blood Bank</h1>
        <p>Your donation can save lives!</p>
        
        <div className="service-container">
          <div className="service-card">
            <FontAwesomeIcon icon={faHeartbeat} size="3x" />
            <h2>Donate Blood</h2>
            <p>Find out how you can donate blood and make a difference.</p>
            <a href="#">Learn More</a>
          </div>
          <div className="service-card">
            <FontAwesomeIcon icon={faTint} size="3x" />
            <h2>Blood Types</h2>
            <p>Learn about different blood types and their importance.</p>
            <a href="#">Learn More</a>
          </div>
          <div className="service-card">
            <FontAwesomeIcon icon={faClinicMedical} size="3x" />
            <h2>Find a Clinic</h2>
            <p>Locate the nearest blood donation clinic or hospital.</p>
            <a href="#">Find Clinics</a>
          </div>
          <div className="service-card">
            <FontAwesomeIcon icon={faInfoCircle} size="3x" />
            <h2>Get Information</h2>
            <p>Read about blood donation policies and safety guidelines.</p>
            <a href="#">Read More</a>
          </div>
        </div>
      </section>
    </div>
  );
};

export default HomePage;
