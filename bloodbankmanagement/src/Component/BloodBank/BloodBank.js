import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';
import '../Style/BloodBank.css'
import http from '../axiosHandler';




export default function BloodBank() {

    const navigate = useNavigate();
    const [searchQuery, setSearchQuery] = useState("")
    const [bloodbankdata, setBloodBankData] = useState([
        {
            "address": "Solapur",
            "id": 2,
            "password": "bloodarchu@123",
            "contact": "1234555267",
            "emailID": "bloodarchu@gmail.com",
            "bloodBankName": "ArchuBloodBank"
        }
    ]);


    const dummyData=[
        {
            "address": "KarveNagar Pune",
            "id": 1,
            "password": "bank@123",
            "contact": "1234653267",
            "emailID": "bank@gmail.com",
            "bloodBankName": "Peoplesave"

        },
        {
            "address": "Solapur",
            "id": 2,
            "password": "bloodarchu@123",
            "contact": "1234555267",
            "emailID": "bloodarchu@gmail.com",
            "bloodBankName": "ArchuBloodBank"
        }


    ]

     function addNewBloodBank(){
        navigate('/addBloodBank')

     }
     function updateBloodBank(id){
      navigate(`/editBloodBank/${id}`)

     }
     function BloodInBloodBank(id){
        navigate(`/bloodbankdetail/${id}`);
     }
     
     const filteredData = bloodbankdata.filter(bloodbank =>
        bloodbank.bloodBankName.toLowerCase().includes(searchQuery.toLowerCase()) ||
        bloodbank.emailID.toLowerCase().includes(searchQuery.toLowerCase()) ||
        bloodbank.address.toLowerCase().includes(searchQuery.toLowerCase())
    );

    useEffect(()=>{
        http.get("bloodbank").then(res=>{
            setBloodBankData(res.data);
        }).catch(error=>{
            console.error(error.message);
        })
     
    } ,[])

    return (
        <div className='container'>
           

            <h2 className="text-center">List Of Blood Bank</h2>
            <br></br>
            
            <span className='span-search'>
            <input
                type="text"
                className="form-control mb-3 "
                placeholder="Search"
                style={{width:"50%", margin:'20px'}}
                value={searchQuery}
                onChange={(e) => setSearchQuery(e.target.value)}
            />
            </span>
          
       
            <table className="table table table-striped table-Bordered table-hover">
              <thead >
                <tr  >
                <th>Blood Bank Id</th>
                <th>Blood Bank Name</th>
                <th>Email</th>
                <th>Contact</th>
                <th>Address</th>
                
                </tr>
              </thead>
              <tbody >
              {filteredData.map(bloodbank =>
                        <tr key={bloodbank.id} onClick={() => BloodInBloodBank(bloodbank.id)}>
                            <td>{bloodbank.id}</td>
                            <td>{bloodbank.bloodBankName}</td>
                            <td>{bloodbank.emailID}</td>
                            <td>{bloodbank.contact}</td>
                            <td>{bloodbank.address}</td>
                            
                        </tr>
                    )}
              </tbody>
              

            </table>
            
        </div>
    )
}