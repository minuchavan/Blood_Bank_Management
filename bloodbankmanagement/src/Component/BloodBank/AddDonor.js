import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';

function AddDonor() {
    const [firstname,setfirstName]=useState('');
    const [email,setEmail]=useState('');
    const [address,setAddress]=useState('');
    const [numbers,setNumbers]=useState('');
    const navigate = useNavigate();

    function handlefirstname(e){
        setfirstName(e.target.value);
    }
    function handleEmail(e){
        setEmail(e.target.value);
    }
    function handleAddress(e){
          setAddress(e.target.value);
    }
    function handleNumber(e){
        setNumbers(e.target.value);
    }

   function saveDonor(e){
    e.preventDefault();
    const donor={firstname,email,address,numbers}
    console.log(donor);

    // Retrieve existing donors from localStorage or create a new array if none exist
    const donors = JSON.parse(localStorage.getItem('donors')) || [];

    // Add the new donor to the array
    donors.push(donor);

    // Save the updated array back to localStorage
    localStorage.setItem('donors', JSON.stringify(donors));
    navigate('/donor')
   }

    return (
        <div className='container'>
            <div className='row'>
                <div className='card'>
                    <h2 className='text-center'>Add Donors</h2>
                    <div className='card-body'>
                        <form>
                        <div className='form-group-mb-2'>
                            <label className='form-label'>Enter Your FirstName

                            </label>
                            <input 
                            type='text'
                            placeholder='Enter firstName'
                            value={firstname}
                            className='form-control'
                            onChange={handlefirstname}/>
                          

                        </div>
                        <div className='form-group-mb-2'>
                            <label className='form-label'>Enter Your EmailId

                            </label>
                            <input 
                            type='email'
                            placeholder='Enter EmailId'
                            value={email}
                            className='form-control'
                            onChange={handleEmail} />
                          

                        </div>
                        <div className='form-group-mb-2'>
                            <label className='form-label'>Enter Your Address

                            </label>
                            <input 
                            type='text'
                            placeholder='Enter Address'
                            value={address}
                            className='form-control'
                            onChange={handleAddress} />
                          

                        </div>
                        <div className='form-group-mb-2'>
                            <label className='form-label'>Enter Your How many Time you Donate Blood?

                            </label>
                            <input 
                            type='text'
                            placeholder=''
                            value={numbers}
                            className='form-control'
                            onChange={handleNumber} />
                          

                        </div>
                        <br></br>
                        <button type="submit" className="btn btn-info" onClick={saveDonor} style={{width:"10%"}}>Submit</button>


                        </form>

                    </div>

                </div>


            </div>
            
        </div>
    )
}

export default AddDonor