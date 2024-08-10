import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';
import Header from '../Navigation/Header.js';




export default function BloodBank() {

    const navigate = useNavigate();
    const [searchQuery, setSearchQuery] = useState("")


    const dummyData=[
        {
            "id":1,
            "bloodBankName":"savelife",
            "email":"save@123",
            "address":"Pune",

        },
        {
            "id":2,
            "bloodBankName":"saveJivan",
            "email":"Jivan@123",
            "address":"Solapur",

        }


    ]

     function addNewBloodBank(){
        navigate('/addBloodBank')

     }
     function updateBloodBank(id){
      navigate(`/editBloodBank/${id}`)

     }
     
     const filteredData = dummyData.filter(bloodbank =>
        bloodbank.bloodBankName.toLowerCase().includes(searchQuery.toLowerCase()) ||
        bloodbank.email.toLowerCase().includes(searchQuery.toLowerCase()) ||
        bloodbank.address.toLowerCase().includes(searchQuery.toLowerCase())
    );




    return (
        <div className='container'>
             <Header />

            <h2 className="text-center">List Of Blood Bank</h2>
            <br></br>

            <input
                type="text"
                className="form-control mb-3"
                placeholder="Search"
                style={{width:"100px"}}
                value={searchQuery}
                onChange={(e) => setSearchQuery(e.target.value)}
            />
            <button className="btn btn-outline-secondary" onClick={()=>addNewBloodBank()} style={{width:'100px'}}>Add BloodBank</button>
            <table className="table table table-striped table-Bordered table-hover">
              <thead>
                <tr>
                <th>Blood Bank Id</th>
                <th>Blood Bank Name</th>
                <th>Email</th>
                <th>Address</th>
                <th>ActionS</th>
                </tr>
              </thead>
              <tbody>
              {
                filteredData.map(bloodbank =>
                    <tr key={bloodbank.id}>
                        <td>{bloodbank.id}</td>
                        <td>{bloodbank.bloodBankName}</td>
                        <td>{bloodbank.email}</td>
                        <td>{bloodbank.address}</td>
                        <td><button className='btn btn-info' onClick={()=>updateBloodBank(bloodbank.id)}>update</button></td>
                    </tr>
                )
              }
              </tbody>

            </table>
            
        </div>
    )
}