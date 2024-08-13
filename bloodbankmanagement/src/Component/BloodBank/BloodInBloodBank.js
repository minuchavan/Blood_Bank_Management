import React, { useState, useEffect } from 'react';
import http from '../axiosHandler';
import { useParams } from 'react-router-dom';


const BloodInBloodBank = () => {
  // State to hold the blood data
  const [bloodData, setBloodData] = useState([
    {
      "blood_banks": {
          "address": "KarveNagar Pune",
          "id": 1,
          "password": "bank@123",
          "emailID": "bank@gmail.com",
          "contact": "1234653267",
          "bloodBankName": "Peoplesave"
      },
      "bloodgroups": {
          "id": 4,
          "bloodGroupName": "O+"
      },
      "number": 6,
      "id": 2
  }
  ]);
  const {id} =useParams();
  const [plasmaData,setPlasmaData]=useState([
    {
      "blood_banks": {
          "address": "KarveNagar Pune",
          "id": 1,
          "password": "bank@123",
          "emailID": "bank@gmail.com",
          "contact": "1234653267",
          "bloodBankName": "Peoplesave"
      },
      "bloodgroups": {
          "id": 4,
          "bloodGroupName": "O+"
      },
      "number": 6,
      "id": 2
  }
  ]);
  // Fetch data from an API or some data source
  useEffect(() => {
   http.get(`/plasmainbloodbankbyid/${id}`).then(res=>{
    setPlasmaData(res.data);
   }).catch(error=>{
console.error(error.message);
   })
  
   http.get(`/bloodinbloodbankbyid/${id}`).then(res=>{
    setBloodData(res.data);
   }).catch(error=>{
    console.error(error.message);
   })
  }, []);

  // Optionally filter data based on some criteria
  // const filteredData = bloodData.filter(item => item.quantity > 0);

  return (
    <div>
      <h2>{bloodData[0].blood_banks.bloodBankName}</h2>
      <hr/>
      <h2>Blood Inventory</h2>
      <table className="table table table-striped table-Bordered table-hover">
        <thead>
          <tr>
            <th>Blood Type</th>
            <th>Quantity</th>
           
          </tr>
        </thead>
        <tbody>
          {bloodData.map((item, index) => (
            <tr key={index}>
              <td>{item.bloodgroups.bloodGroupName}</td>
              <td>{item.number}</td>
             
            </tr>
          ))}
        </tbody>
      </table>

      <h2>Plasma Inventory</h2>
      <table className="table table table-striped table-Bordered table-hover">
        <thead>
          <tr>
            <th>Plasma Type</th>
            <th>Quantity</th>
           
          </tr>
        </thead>
        <tbody>
          {plasmaData.map((item, index) => (
            <tr key={index}>
              <td>{item.bloodgroups.bloodGroupName}</td>
              <td>{item.number}</td>
              
            </tr>
          ))}
        </tbody>
      </table>
     
    </div>
    
  );
};

export default BloodInBloodBank;