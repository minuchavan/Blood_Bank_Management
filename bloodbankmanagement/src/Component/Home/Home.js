import React from 'react';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {  faHandHoldingHeart,  faTint,faClinicMedical, faInfoCircle } from '@fortawesome/free-solid-svg-icons';
import '../Style/HomePage.css'; // Ensure you import the CSS file

const HomePage = () => {
  return (
    <div className="home-page">
      <section className="main-content">
        <h1 style={{color:'red'}}>Welcome to the Blood Bank</h1>
        <p style={{fontFamily:'sans-serif' , color:'brown'}}>One Blood Donation Can Save Upto Three lives..</p>
        
        <div className="service-container">
          <div className="service-card">
            <FontAwesomeIcon  icon={faHandHoldingHeart}  style={{color:'red'}} size="3x" />
            <h2 style={{color:'red'}} >Donate Blood</h2>
            <p>Find out how you can donate blood and make a difference.</p>
           
          </div>
          <div className="service-card">
            <FontAwesomeIcon icon={faTint} style={{color:'red'}}  size="3x" />
            <h2 style={{color:'red'}} >Blood Types</h2>
            <p>Learn about different blood types and their importance.</p>
          
          </div>
          <div className="service-card">
            <FontAwesomeIcon icon={faClinicMedical} style={{color:'red'}}   size="3x" />
            <h2 style={{color:'red'}}>Find a Clinic</h2>
            <p>Locate the nearest blood donation clinic or hospital.</p>
           
          </div>
          
          <div className="service-card">
            <FontAwesomeIcon style={{color:'red'}} icon={faInfoCircle} size="3x" />
            <h2 style={{color:'red'}}>types Of Donation</h2>
            <p>The average Human body contains about five liters of blood, which is made of several cellular and non-cellular componenets such as RED BLOOD CELL , PLATELET and PLASMA.</p>
           
          </div>
          <div className="service-card">
            <FontAwesomeIcon style={{color:'red'}} icon={faInfoCircle} size="3x" />
            <h2 style={{color:'red'}}>What is it?</h2>
            <p>Blood collected straight from the donor into a blood bag and mixed an anticoagulant is called Whole Blood. This collected whole blood is then centrifuged and red cell,plasma and platelets are separated. </p>
           
          </div>

          <div className="service-card">
            <FontAwesomeIcon style={{color:'red'}} icon={faInfoCircle} size="3x" />
            <h2 style={{color:'red'}}>Get Information</h2>
            <p>Read about blood donation policies and safety guidelines.</p>
           
          </div>
          
        </div>
      </section>
    </div>
  );
};

export default HomePage;
