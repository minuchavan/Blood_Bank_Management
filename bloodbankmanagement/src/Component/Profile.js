import React, { useEffect, useState } from 'react'
import './Style/Profile.css';
import http from './axiosHandler';
import { useParams } from 'react-router-dom';

const Profile = () => {

    const [userInfo, SetUserInfo] = useState({
        bloodgroups:{
            id:1,
            bloodGroupName:"A+"
        },
        id:1,
        emailId:"",
        password:"",
        lastDonationDate:"",
        phoneNumber:"",
        birth_Date:"",
        firstName:"",
        lastName:""
    });
    const {id} =useParams();
    const [backupuserInfo, SetBackUpUserInfo] = useState({});
    const [editable, SetEditable] = useState(false);
    const [save, SetSave] = useState(false);
    useEffect(()=>{
        http.get(`/user/${id}`)
        .then(res=>{
            console.log(res.data);
            SetUserInfo(res.data);  
        })
    },[]);

    const setSaveOrEdit = () => {
        SetEditable(!editable);
        SetBackUpUserInfo(userInfo);
        SetSave(!save);
        if(save){
            http.post("/user-update",userInfo)
            .then(res=>{
                alert("user updated")
                SetUserInfo(res.data)
            })
            .catch(error=>{
                console.error(error.message)
            })
        }
    }
    const clickedCancel = () => {
        SetUserInfo(backupuserInfo);
        SetSave(!save)
        SetEditable(!editable);
    }
    const handleChange = (e) => {
        const { name, value } = e.target;
        SetUserInfo({
            ...userInfo,
            [name]: value
        });
    };

    return (
        <div className="profile-container">
            <h1>Profile Information</h1>
            <table className="profile-table">
                <tbody>
                    <tr>
                        <th>First Name:</th>
                        <td><input
                            type='text'
                            style={{ borderStyle: 'none' }}
                            value={userInfo["firstName"]}
                            name="firstName"
                            disabled={!editable}


                            onChange={handleChange}
                        /></td>
                    </tr>
                    <tr>
                        <th>Last Name:</th>
                        <td> <input
                            type='text'
                            style={{ borderStyle: 'none' }}
                            value={userInfo["lastName"]}
                            name="lastName"
                            disabled={!editable}
                            onChange={handleChange}
                        /></td>
                    </tr>
                    <tr>
                        <th>Birth Date:</th>
                        <td><input
                            type='date'
                            style={{ borderStyle: 'none' }}
                            value={userInfo["birth_Date"]}
                            name="birth_Date"
                            disabled={!editable}
                            onChange={handleChange}
                        /></td>
                    </tr>
                    <tr>
                        <th>Mobile Number:</th>
                        <td><input
                            type='tel'
                            style={{ borderStyle: 'none' }}
                            value={userInfo["phoneNumber"]}
                            name="phoneNumber"
                            disabled={!editable}
                            onChange={handleChange}
                        /></td>
                    </tr>
                    <tr>
                        <th>Email ID:</th>
                        <td><input
                            type='email'
                            style={{ borderStyle: 'none' }}
                            value={userInfo["emailId"]}
                            name="emailId"
                            disabled={!editable}

                            onChange={handleChange}
                        /></td>
                    </tr>
                    <tr>
                        <th>Last Donation Date:</th>
                        <td><input
                            type='date'
                            style={{ borderStyle: 'none' }}
                            value={userInfo["lastDonationDate"]}
                            name="lastDonationDate"
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

export default Profile
