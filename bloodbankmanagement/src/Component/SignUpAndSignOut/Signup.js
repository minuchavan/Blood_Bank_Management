import React, { useState } from 'react'
import '../Style/Signup.css'

export const Signup = () => {
    
    const data={
        firstname:"",
        lastname:"",
        birthdate:"",
        mobilenumber:"",
        emailid:"",
        password:"",
        bloodgrouptype:"",
        lastdonationdate:""
    }
    const [inputData,setInputData] = useState(data);
    const [msg, setMsg] = useState(false);
    
    const handleInputs = (event) =>{
        console.log(event.target.value);
        setInputData({...inputData, [event.target.name]:event.target.value})
    }

    const submit = (event) => {
        event.preventDefault();
        if(!inputData.firstname || !inputData.lastname || !inputData.birthdate || !inputData.mobilenumber || !inputData.emailid || !inputData.password || !inputData.bloodgrouptype || !inputData.lastdonationdate){
            alert("All Fields are Mandatory...")
        }else{
            setMsg(true)
            setTimeout(() => {
                setMsg(false)
            }, 4000);
        }

    }

    return (
      <form onSubmit={submit} className='container-signup'>
        <h3>
        {msg ? alert("Signup suceesfull..") : null}
        </h3>
       
        <h1>Sign Up</h1>
        
        <div className='input'>
           
            <label>Enter Your First Name :</label>
            <input type='text' placeholder='First Name ' name='firstname' value={inputData.firstname}  onChange={handleInputs} required/>
             
             <label >Enter Your Last Name :</label>
            <input type='text' placeholder='Last Name 'name='lastname'  value={inputData.lastname} onChange={handleInputs} required/>
             
            <label>Enter Your Birth Date :</label>
            <input type='date' placeholder='Birth Date'name='birthdate'  value={inputData.birthdate} onChange={handleInputs} required/>
           
            <label> Enter Mobile Number :</label>
            <input type='text' placeholder='Mobile Number'name='mobilenumber' value={inputData.mobilenumber}  onChange={handleInputs} required/>
           
            <label>Enter Your Email_Id :</label>
            <input type='email' placeholder='Email ID' name='emailid' value={inputData.emailid} onChange={handleInputs} required/>
           
           <label>Enter Your Password :</label>
           <input type='password'placeholder='Password' name='password' value={inputData.password} onChange={handleInputs} required/>
        
            <label>Blood Group Name : </label>
            <input type='text' placeholder='Blood Group Type 'name='bloodgrouptype'  value={inputData.bloodgrouptype} onChange={handleInputs} required/>
           
            <label>Last Donation Date  : </label>
            <input type='date' placeholder='Last Donation Date ' name='lastdonationdate' value={inputData.lastdonationdate} onChange={handleInputs} required/>
            
          </div>
        <button>Signup</button>
        <div className='account'>
        <p>Already have an account? <a href="/login">Login here</a></p>
        </div>
       

      </form>
    )
}
