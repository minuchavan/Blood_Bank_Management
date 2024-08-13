import React, { useEffect, useState } from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faContactCard,
  faHome,
  faUser,
  faUserPlus,
} from "@fortawesome/free-solid-svg-icons";
import "../Style/Header.css";
import http from "../axiosHandler";
import { useNavigate } from "react-router-dom";


const Header = ({userType}) => {
  
  const [data, setData]=useState(userType);
  const [html, setHtml] = useState(<></>);
  const [userid, setUserId] = useState(0);
  

  const signout =()=>{
    http.get("/signout").then(res=>{
      
      
    }).catch(error=>{
      console.error(error);
    })
  }

  useEffect(() => {
    // http
    //   .get("/user-usertype")
    //   .then((res) => {
    //     setUserType(res.data);
    //     console.log(res.data);
    //   })
    //   .catch((error) => {
    //     console.error(error.message);
    //   });

    http
      .get("/user-getid")
      .then((res) => {
        setUserId(res.data);
        console.log(res.data);
      })
      .catch((error) => {
        console.error(error.message);
      });
  }, []);

  useEffect(() => {
    if (userType === 0) {
      setHtml(
        <>
        
          <span className="header-span">
            <FontAwesomeIcon icon={faUser} />
            <a className="header-anchor" href="/Login">
              LogIn
            </a>
          </span>
          <span className="header-span">
            <FontAwesomeIcon icon={faUser} />
            <a className="header-anchor" href="/bloodbanksignup">
              Add Your Blood Bank
            </a>
          </span>
          <span className="header-span">
            <FontAwesomeIcon icon={faUserPlus} />
            <a className="header-anchor" href="/signup">
              SignUp
            </a>
          </span>
        </>
      );
    } else if (userType === 1) {
      setHtml(
        <>
          <span className="header-span">
            <FontAwesomeIcon icon={faHome} />
            <a className="header-anchor" href="/bloodbank">
              BloodBank
            </a>
          </span>
          <span className="header-span">
            <FontAwesomeIcon icon={faContactCard} />
            <a className="header-anchor" href={`/profile/${userid}`}>
              Profile
            </a>
          </span>
          <span className="header-span" onClick={signout}>
            <FontAwesomeIcon icon={faContactCard} />
            <a className="header-anchor" href="/"  >
              LogOut
            </a>
          </span>
        </>
      );
    }
    else{
      setHtml(
        <>
          <span className="header-span">
            <FontAwesomeIcon icon={faHome} />
            <a className="header-anchor" href="/updatebloodandbank">
              Manage Blood and Plasma
            </a>
          </span>
          <span className="header-span">
            <FontAwesomeIcon icon={faContactCard} />
            <a className="header-anchor" href={`/bloodbankprofile/${userid}`}>
              Profile
            </a>
          </span>
          <span className="header-span" onClick={signout}>
            <FontAwesomeIcon icon={faContactCard} />
            <a className="header-anchor" href="/"  >
              LogOut
            </a>
          </span>
        </>
      );

    }
  }, [userType]);

  return (
    <header className="header">
      <span>
        <img src="../Image/logo.png" alt="Logo" />
      </span>
      <span className="header-span">
        <FontAwesomeIcon icon={faHome} />
        <a className="header-anchor" href="/">
          Home
        </a>
      </span>
      <span className="header-span">
        <FontAwesomeIcon icon={faContactCard} />
        <a className="header-anchor" href="/contact">
          Contact
        </a>
      </span>
      {html}
    </header>
  );
};

export default Header;
