import React, { useState } from 'react'
import '../Style/BloodBankSignUp.css'
import http from '../axiosHandler';
import { useNavigate } from 'react-router-dom';

export const BloodBankSignUp = () => {
    
    const data={
     
        bloodBankName:"",
         address:"",
        password:"",
       
        contact:"",
        emailID:"",
    }
    const [inputData,setInputData] = useState(data);
    const [msg, setMsg] = useState(false);
    
    const handleInputs = (event) =>{
        console.log(event.target.value);
        setInputData({...inputData, [event.target.name]:event.target.value})
    }

    const submit = (event) => {
        event.preventDefault();
        if(!inputData.  bloodBankName || !inputData.address || !inputData.password || !inputData.contact || !inputData.emailID ){
            alert("All Fields are Mandatory...")
        }else{
           http.post("/signup-BloodBank",inputData).then(res=>{
            http.get(`/createblood?blood_bank_id=${res.data.ID}`);

            http.get(`/createplasma?blood_bank_id=${res.data.ID}`);
            alert("signup successfully...")
            
           })
        }

    }

    return (

        
      <form onSubmit={submit} className='container-signupbloodbank'>
        <h3>
        {msg ? alert("Signup suceesfull..") : null}
        </h3>
       <div className='bloodbankheading'>
        <h1 >Sign Up</h1>
        </div>
        <div className='form-left'>
        <div className='input-bloodbank'>
           
            <label>Enter Your Blood Bank Name :</label>
            <input className='bloodbankinput' type='text' placeholder='Blood Bank Name ' name='bloodBankName' value={inputData.bloodBankName}  onChange={handleInputs} required/>
        </div>
        <div className='input-bloodbank'>
             <label >Enter Blood Bank Address :</label>
            <input className='bloodbankinput' type='text' placeholder='Address 'name='address'  value={inputData.address} onChange={handleInputs} required/>
        </div>
        <div className='input-bloodbank'>   
            <label>Enter Your Contact Number :</label>
            <input className='bloodbankinput' type='text' placeholder='contact number 'name='contact'  value={inputData.contact} onChange={handleInputs} required/>
        </div>
        </div>

        <div className='form-right'>
         <div className='input-bloodbank'>
            <label>Enter Your Email_Id :</label>
            <input className='bloodbankinput' type='email' placeholder='Email ID' name='emailID' value={inputData.emailID} onChange={handleInputs} required/>
          </div>
          <div className='input-bloodbank'> 
           <label>Enter Your Password :</label>
           <input className='bloodbankinput' type='password'placeholder='Password' name='password' value={inputData.password} onChange={handleInputs} required/>
         </div>
       
        <a href='/'>
        <button>Signup</button></a>
        <div className='account'>
        <p>Already have an account? <a href="/login">Login here</a></p>
        </div>
        </div>

      </form>
    )
}
