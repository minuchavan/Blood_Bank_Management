import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import "../Style/Login.css";
import http from "../axiosHandler";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faUserCircle,
  faKey,
  faEye,
  faEyeSlash,
  faUserPlus,
  faHeartbeat,
} from "@fortawesome/free-solid-svg-icons";



function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [pshow, setPshow] = useState(false);

  const navigate = useNavigate();

  const handelSignupRedirect = () => {
    navigate("/Signup");
  };

  const togglePasswordVisibility = () => {
    setPshow(!pshow);
  };

  const userLogin = () => {
    http
      .post("/login", { emailId: email, password: password })
      .then((res) => {
        navigate("/");
        console.log(res.data);
      })
      .catch((error) => {
        console.error(error.message);
        alert("Something went Wrong..Please try Again !");
        setEmail("");
        setPassword("");
      });
  };

  return (
    <div className="overlay">
      <form>
        <div className="con">
          <div className="head-form">
          <FontAwesomeIcon icon={faHeartbeat} style={{color:'red', width:'30px', height : '30px' ,padding:'5px'}}></FontAwesomeIcon>
            <h2>Log In</h2>
            <p>Login here using your username and password</p>
          </div>
          <br />
          <div className="field-set">
            <span className="input-item">
              <FontAwesomeIcon icon={faUserCircle} />
            </span>
            <input
              className="form-input"
              placeholder="EmailId"
              type="email"
              id="email"
              value={email}
              onChange={(e) => setEmail(e.target.value)}
              required
            />
            <br />

            <span className="input-item">
              <FontAwesomeIcon icon={faKey} />
            </span>
            <input
              className="form-input"
              placeholder="Password"
              type={pshow ? "text" : "password"}
              id="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />

            <span
              onClick={togglePasswordVisibility}
              style={{ cursor: "pointer" }}
            >
              <FontAwesomeIcon
                icon={pshow ? faEyeSlash : faEye}
                aria-hidden="true"
                type="button"
                id="eye"
              />
            </span>
            <br />

            <a href="/">
              {" "}
              <button className="log-in" type="button" onClick={userLogin}>
                {" "}
                Log In
              </button>
            </a>
          </div>
          <div className="other">
            <button className="btn submits frgt-pass ">Forget Password</button>
            <button
              className="btn submits sign-up"
              onClick={handelSignupRedirect}
            >
              Sign Up
              <FontAwesomeIcon icon={faUserPlus} aria-hidden="true" />
            </button>
          </div>
        </div>
      </form>
    </div>
  );
}

export default Login;
