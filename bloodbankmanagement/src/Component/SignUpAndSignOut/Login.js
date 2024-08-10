import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';
import '../Style/Login.css';
import http from '../axiosHandler';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faUserCircle, faKey, faEye, faEyeSlash, faUserPlus } from '@fortawesome/free-solid-svg-icons';


function Login() {
   
    const [email,setEmail]=useState('')
    const [password, setPassword] = useState('');
    const [pshow,setPshow] = useState(false);

    const navigate = useNavigate();
   
  //   const handleLogin = async (e) => {
  //   e.preventDefault();
  //   try {
  //    navigate('/dashboard');
  //   } catch (err) {
  //     setError('Invalid email or password');
  //   }

  // };
    
  const handelSignupRedirect =()=>{
        navigate('/Signup');
    }

    const togglePasswordVisibility = () =>{
      setPshow(!pshow);
    }
    useEffect(() => {
      http.get('/bloodbank')
      .then(response => {console.log(response
        
        
        )})
      .catch(error => console.error('Error fetching users:', error));
  }, []);
    const userLogin=()=>{
      http.post("/login",{emailId:email,password:password})
      .then(res=>{

        console.log(res.data);
      }).catch(error=>{
        console.error(error.message)
      })
    }
    

    return (
        
      <div   className="overlay">
        <form >
          <div   className="con">
            <div className='head-form'>
              <h2>Log In</h2>
              <p>Login here using your username and password</p>
            </div>
            <br/>
           <div className='field-set'>
            <span className='input-item'>
            <FontAwesomeIcon icon={faUserCircle} />
            </span>
            <input className='form-input' placeholder='EmailId'
              type="email"
              id="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required/>
              <br/>

            <span className='input-item'>
            <FontAwesomeIcon icon={faKey} />
            </span>
            <input className='form-input' placeholder='Password'
              type={pshow ? 'text' : "password"}
              id="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required />

            <span onClick={togglePasswordVisibility} style={{cursor : 'pointer'}}>
            <FontAwesomeIcon icon={pshow ? faEyeSlash : faEye} aria-hidden='true' type='button' id='eye' />

            </span>
            <br/>
            
            <button className='log-in' type="button" onClick={userLogin}>Log In</button>
            </div>
            <div className='other'>
              <button className='btn submits frgt-pass '>Forget Password</button>
              <button className='btn submits sign-up' onClick={handelSignupRedirect}>Sign Up
              <FontAwesomeIcon icon={faUserPlus} aria-hidden="true" />
              </button>
            </div>
        </div>
     </form>
  </div>
  );
}

export default Login