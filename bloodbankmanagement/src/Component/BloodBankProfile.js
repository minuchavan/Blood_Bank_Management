 import React, { useEffect, useState } from 'react'
 import './Style/Profile.css';
 import http from './axiosHandler';
 import { useParams } from 'react-router-dom';

 const BloodBankProfile = () => {

     const [bloodbankInfo, SetBloodBankInfo] = useState({
       
        id:1,
         address:"",
        password:"",
        bloodBankName:"",
        contact:"",
        emailID:"",
       
    });
    const {ID} =useParams();
    const [backupbloodbankInfo, SetBackUpbloodbankInfo] = useState({});
    const [editable, SetEditable] = useState(false);
    const [save, SetSave] = useState(false);
    useEffect(()=>{
        http.get(`/bloodbank/${ID}`)
        .then(res=>{
            console.log(res.data);
            SetBloodBankInfo(res.data);  
        })
    },[]);

    const setSaveOrEdit = () => {
        SetEditable(!editable);
        SetBackUpbloodbankInfo(bloodbankInfo);
        SetSave(!save);
        if(save){
            http.post("/update-bloodbank",bloodbankInfo)
            .then(res=>{
                alert("BloodBank updated")
                SetBloodBankInfo(res.data)
            })
            .catch(error=>{
                console.error(error.message)
            })
        }
    }
    const clickedCancel = () => {
        SetBloodBankInfo(SetBackUpbloodbankInfo);
        SetSave(!save)
        SetEditable(!editable);
    }
    const handleChange = (e) => {
        const { name, value } = e.target;
        SetBloodBankInfo({
            ...bloodbankInfo,
            [name]: value
        });
    };

    return (
        <div className="profile-container">
            <h1>Profile Information</h1>
            <table className="profile-table">
                <tbody>
                    <tr>
                        <th>Blood Bank Name:</th>
                        <td><input
                            type='text'
                            style={{ borderStyle: 'none' }}
                            value={bloodbankInfo["bloodBankName"]}
                            name="bloodBankName"
                            disabled={!editable}


                            onChange={handleChange}
                        /></td>
                    </tr>
                    <tr>
                        <th>Address:</th>
                        <td> <input
                            type='text'
                            style={{ borderStyle: 'none' }}
                            value={bloodbankInfo["address"]}
                            name="address"
                            disabled={!editable}
                            onChange={handleChange}
                        /></td>
                    </tr>
                    <tr>
                        <th>Contact Number:</th>
                        <td><input
                            type='text'
                            style={{ borderStyle: 'none' }}
                            value={bloodbankInfo["contact"]}
                            name="contact"
                            disabled={!editable}
                            onChange={handleChange}
                        /></td>
                    </tr>
                   
                    <tr>
                        <th>Email ID:</th>
                        <td><input
                            type='email'
                            style={{ borderStyle: 'none' }}
                            value={bloodbankInfo["emailID"]}
                            name="emailID"
                            disabled={!editable}

                            onChange={handleChange}
                        /></td>
                    </tr>
                   
                    <tr>
                        <th> </th>
                        <td>
                            <button style={{ width: 130, color: 'black', backgroundColor: '	#fca9fd', position: 'relative', left: 30 }} type='submit' onClick={setSaveOrEdit}> {save ? "Save" : "Edit"}</button>
                            {save && <button style={{ width: 130, color: 'black', backgroundColor: '	#fca9fd', position: 'relative', left: 75 }} type='submit' onClick={clickedCancel}>  Cancel</button>}
                        </td>

                    </tr>
                </tbody>
            </table>
        </div>
    );

}

export default BloodBankProfile
